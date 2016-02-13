import java.io.IOException;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import oracle.adf.view.rich.component.rich.input.RichInputText;

public class AuthHandler {
    private RichInputText usernameField;
    private RichInputText passwordField;
    private Connection connection;
    FacesContext fctx;
    ExternalContext ec;
    HttpServletResponse response;
    HttpServletRequest request;

    public AuthHandler() {
        fctx = FacesContext.getCurrentInstance();
        ec = fctx.getExternalContext();
        response = (HttpServletResponse)ec.getResponse();
        request = (HttpServletRequest)ec.getRequest();
    }

    public String authenticateUser() {
        try {
            auth(usernameField.getValue().toString(),
                 passwordField.getValue().toString());

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    protected void auth(String username, String password) throws Exception {
        //LOADING THE DRIVERS TO CONNECT TO ORACLE DATABASE
        Class.forName("oracle.jdbc.driver.OracleDriver");
        //CREATING THE CONNECTION
        connection =
                DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.31:1522:prod",
                                            "apps", "mskiz145");
        //IF CONNECTED SUCCESSFULLY
        if (connection != null) {
            String selectSQL =
                "SELECT * FROM xx_employee_ap_users where upper(EMAIL) = ? and upper(trim(EMPLOYEE_ID)) = ?";
            PreparedStatement preparedStatement =
                connection.prepareStatement(selectSQL,
                                            ResultSet.TYPE_SCROLL_INSENSITIVE,
                                            ResultSet.CONCUR_UPDATABLE,
                                            ResultSet.HOLD_CURSORS_OVER_COMMIT);
            preparedStatement.setString(1, username.toUpperCase());
            preparedStatement.setString(2, password.toUpperCase().trim());
            ResultSet rs = preparedStatement.executeQuery();
            StringBuilder sb = new StringBuilder();
            while (rs.next()) {
                sb.append(rs.getString("DEPARTMENT"));
                if (rs.next()) {
                    sb.append(" and ");   
                    rs.previous();
                }
                
                
            }
            rs.beforeFirst();
            if (rs.next()) {
                System.out.println("Authentication Success.");
                String userName = rs.getString("FULL_NAME_CHILD");
                String userID = rs.getString("EMPLOYEE_ID");
                String userEmail = rs.getString("EMAIL");
                String userDpt = rs.getString("DEPARTMENT");

                //String userDpt = rs.getString("HIERARCHY");
                String userDesignation = rs.getString("DESIGNATION");
                String userDoj = rs.getString("DATE_OF_JOINING");
                String userEmpNo = rs.getString("EMPLOYEE_NUMBER");
                String userParent = rs.getString("SUPERVISOR_ID");
                String userParentName = rs.getString("FULL_NAME_PARENT");


                createUserSession(userName, userID, userEmail, sb.toString(),
                                  userDesignation, userDoj, userEmpNo,
                                  userParent,userParentName);
                try {
                    response.sendRedirect("application_menu.jspx");
                    return;
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    fctx.responseComplete();
                }

            } else {
                System.out.println("Failed.");
            }
        }
    }

    public void setUsernameField(RichInputText usernameField) {
        this.usernameField = usernameField;
    }

    public RichInputText getUsernameField() {
        return usernameField;
    }

    public void setPasswordField(RichInputText passwordField) {
        this.passwordField = passwordField;
    }

    public RichInputText getPasswordField() {
        return passwordField;
    }


    private void createUserSession(String userName, String userID,
                                   String userEmail, String userDpt,
                                   String userDes, String userDoj,
                                   String userNo, String userParent,String userParentName) {

        HttpSession userSession = (HttpSession)ec.getSession(true);
        userSession.setAttribute("user_name", userName);
        userSession.setAttribute("user_id", userID);
        userSession.setAttribute("user_email", userEmail);
        userSession.setAttribute("user_dpt", userDpt);
        userSession.setAttribute("user_des", userDes);
        userSession.setAttribute("user_doj", userDoj);
        userSession.setAttribute("user_no", userNo);
        userSession.setAttribute("user_parent", userParent);
        userSession.setAttribute("user_parent_name", userParentName);

        System.out.println("AuthHandler.java: " +
                           userSession.getAttribute("user_name") + " - " +
                           userSession.getAttribute("user_id") + "-" +
                           userSession.getAttribute("user_email") + "-" +
                           userSession.getAttribute("user_dpt") + "-" +
                           userSession.getAttribute("user_des") + "-" +
                           userSession.getAttribute("user_doj") + "-" +
                           userSession.getAttribute("user_no") + "-" +
                           userSession.getAttribute("user_parent")+" - "+
                           userSession.getAttribute("user_parent_name")+ " sdfsd "+userParentName);
    }

    private void getUserSession() {
        HttpSession userSession = (HttpSession)ec.getSession(true);
        System.out.println(userSession.getAttribute("user_id"));
    }

    private void destroyUserSession() {

        HttpSession userSession = (HttpSession)ec.getSession(true);
        userSession.invalidate();
    }

    public String takeUserToApplication() {
        // Add event code here...
        try {
            response.sendRedirect("application_menu.jspx");
            fctx.responseComplete();
        } catch (IOException e) {
        }
        return null;
    }
}
