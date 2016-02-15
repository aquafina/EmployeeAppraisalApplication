
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;

import java.text.DateFormat;

import java.text.SimpleDateFormat;

import java.util.Date;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.component.UIComponent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.faces.event.ActionEvent;

import javax.faces.event.ValueChangeEvent;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

import net.nishat.vc.AppConnection;

import oracle.adf.model.BindingContext;

import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.context.AdfFacesContext;


import oracle.adf.view.rich.event.DialogEvent;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;


public class EmpAprsieFormListener {
    private RichInputText emp_name;
    private RichInputText formID;
    Connection connection;

    public EmpAprsieFormListener() {
    }

    public void beforePhase(PhaseEvent phaseEvent) {
        if (phaseEvent.getPhaseId() == PhaseId.RENDER_RESPONSE) {
            DCIteratorBinding iterBind =
                (DCIteratorBinding)getBindings().get("VO_XxEmpApForm1Iterator");

            // Get all the rows of a iterator
            int length = iterBind.getAllRowsInRange().length;
            if (length <= 0) {
                System.out.println("EmpApraiseFormListener.java: length is less then 0");
                BindingContainer bindings = getBindings();
                OperationBinding operationBinding =
                    bindings.getOperationBinding("Create");
                Object result = operationBinding.execute();
            }


        }
    }


    public BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }


    public void setEmp_name(RichInputText emp_name) {
        this.emp_name = emp_name;
    }

    public RichInputText getEmp_name() {
        return emp_name;
    }

    public void getMethod(PhaseEvent phaseEvent) {
        // Add event code here...
    }

    public void submitDialogListener(DialogEvent dialogEvent) {
        if (dialogEvent.getOutcome() == DialogEvent.Outcome.yes) {
            BindingContainer bindings = getBindings();
            
//            OperationBinding operationBinding =
//                bindings.getOperationBinding("Commit");
//            Object result = operationBinding.execute();
//            if (!operationBinding.getErrors().isEmpty()) {
//                
//            }
            execute();
            saveAll();
            
            
        }


    }

    public void setFormID(RichInputText formID) {
        this.formID = formID;
    }

    public RichInputText getFormID() {
        return formID;
    }

    public String cb1_action() {
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding =
            bindings.getOperationBinding("Commit");
        Object result = operationBinding.execute();
        if (!operationBinding.getErrors().isEmpty()) {
            return null;
        }
        return null;
    }

    public String saveAll() {
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = bindings.getOperationBinding("Commit");
        Object result = operationBinding.execute();
        if (!operationBinding.getErrors().isEmpty()) {
            return null;
        }else{
            System.out.println("hellooooo");
        }
        return null;
    }

    public String execute() {
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = bindings.getOperationBinding("Execute");
        Object result = operationBinding.execute();
        if (!operationBinding.getErrors().isEmpty()) {
            return null;
        }
        return null;
    }

    public String whatever() {
        // Add event code here...
        saveAll();
        updateFlag();
        return null;
    }
    
    private void updateFlag(){
        try {

            BindingContainer bindings = getBindings();
            DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            String date1 = new Date().toGMTString();
            String token[] = date1.split(" ");
            String actuallDate =
                token[0] + "-" + token[1] + "-" + token[2];


           
            //CREATING THE CONNECTION
            connection = AppConnection.getConnection();
            if (connection == null) {
                return ;
            }
                    
            PreparedStatement preparedStatement =
                connection.prepareStatement("update xx_emp_ap_form set posted = ? , SUBMITION_DATE = ? where EMP_AP_FORM_ID = ?");
            preparedStatement.setString(1, "YES");
            preparedStatement.setString(2, actuallDate);
            preparedStatement.setInt(3,
                                     Integer.parseInt(formID.getValue().toString()));
            int id = preparedStatement.executeUpdate();

            OperationBinding operationBinding1 =
                bindings.getOperationBinding("refreshEmpFormData");
            Object result1 = operationBinding1.execute();
            System.out.println("updated with id: " + id);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
