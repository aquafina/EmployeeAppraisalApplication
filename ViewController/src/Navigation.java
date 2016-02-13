import java.io.IOException;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Navigation {
    FacesContext fctx;
    ExternalContext ec;
    HttpServletResponse response;
    HttpServletRequest request;

    public Navigation() {
        fctx = FacesContext.getCurrentInstance();
        ec = fctx.getExternalContext();
        response = (HttpServletResponse)ec.getResponse();
        request = (HttpServletRequest)ec.getRequest();
    }

    public String navigtateToEmpApform() {
        try {
            response.sendRedirect("emp_apraise_foem.jspx");
            fctx.responseComplete();
        } catch (IOException e) {
        }
        return null;
    }

    public String logout() {
        // Add event code here...
        try {
            destroyUserSession();
            response.sendRedirect("login.jspx");
            fctx.responseComplete();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return null;
    }
    private void destroyUserSession(){
        try{
        HttpSession userSession = (HttpSession)ec.getSession(true);
        userSession.invalidate();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
