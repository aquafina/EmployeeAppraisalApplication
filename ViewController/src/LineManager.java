import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Date;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;

import net.nishat.vc.AppConnection;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCIteratorBinding;

import oracle.adf.view.rich.component.rich.input.RichInputText;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

public class LineManager {
    Connection connection;
    private RichInputText formID;

    public LineManager() {
    }
    public void beforePhase(PhaseEvent phaseEvent) {
        if (phaseEvent.getPhaseId() == PhaseId.RENDER_RESPONSE) {
            DCIteratorBinding iterBind =
                (DCIteratorBinding)getBindings().get("VO_XxLmApFormView1Iterator");

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
                return;
            }
                   
            PreparedStatement preparedStatement =
                connection.prepareStatement("update XX_EMP_LM_AP_FORM set posted = ? , SUBMITION_DATE = ? where LM_AP_FORM_ID = ?");
            preparedStatement.setString(1, "YES");
            preparedStatement.setString(2, actuallDate);
            preparedStatement.setInt(3,
                                     Integer.parseInt(formID.getValue().toString()));
            int id = preparedStatement.executeUpdate();

            OperationBinding operationBinding1 =
                bindings.getOperationBinding("refreshLMFormData");
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

    public void setFormID(RichInputText formID) {
        this.formID = formID;
    }

    public RichInputText getFormID() {
        return formID;
    }
}
