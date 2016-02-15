import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Date;

import net.nishat.vc.AppConnection;

import oracle.adf.model.BindingContext;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.event.DialogEvent;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

public class PeerFormListener {
    Connection connection;
    private RichInputText formID;

    public PeerFormListener() {
    }

    public void submitListener(DialogEvent dialogEvent) {
        // Add event code here...
        if (dialogEvent.getOutcome() == DialogEvent.Outcome.yes) {
            System.out.println("in the dialog method");
            BindingContainer bindings = getBindings();
            OperationBinding operationBinding1 =
                bindings.getOperationBinding("Commit");
            operationBinding1.execute();
            try {
                
                DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                Date date = new Date();
                String date1 = new Date().toGMTString();
                String token[] = date1.split(" ");
                String actuallDate =
                    token[0] + "-" + token[1] + "-" + token[2];
                
                Class.forName("oracle.jdbc.driver.OracleDriver");
                //CREATING THE CONNECTION
                connection = AppConnection.getConnection();
                if (connection == null) {
                    return;
                }
                PreparedStatement preparedStatement = 
                    connection.prepareStatement("update xx_peer_ap_form set posted = ? , SUBMITION_DATE = ? where PEER_FORM_ID = ?");
                preparedStatement.setString(1, "YES");
                preparedStatement.setString(2, actuallDate);
                preparedStatement.setInt(3,
                                         Integer.parseInt(formID.getValue().toString()));
                int id = preparedStatement.executeUpdate();
                OperationBinding operationBinding =
                    bindings.getOperationBinding("refreshPeerFormData");
                Object result = operationBinding.execute();


                System.out.println("id : " + id);
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

    public BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }

    public void setFormID(RichInputText formID) {
        this.formID = formID;
    }

    public RichInputText getFormID() {
        return formID;
    }
}
