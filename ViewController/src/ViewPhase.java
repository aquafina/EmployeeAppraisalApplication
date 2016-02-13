import java.io.IOException;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;

import javax.faces.event.PhaseId;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import oracle.adf.controller.v2.lifecycle.Lifecycle;

public class ViewPhase {
    FacesContext fctx;
    ExternalContext ec;
    HttpServletResponse response;
    HttpServletRequest request;

    public ViewPhase() {
    }

    //THIS METHOD IS JUST FOR TESTING PURPOSE TO SEE IF CAN DO THE PHASE THING INDIVISUALLY
    //AND THIS METHOD IS WORKING JUST FINE
    public void beforePhase(PhaseEvent phaseEvent) {
        // Add event code here...
        if (phaseEvent.getPhaseId() == PhaseId.RENDER_RESPONSE) {
            System.out.println("It's before phase.");

            fctx = FacesContext.getCurrentInstance();
            ec = fctx.getExternalContext();
            HttpSession userSession = (HttpSession)ec.getSession(true);
            if (userSession.getAttribute("user_id") != null) {
                System.out.println("Take user to the application" +
                                   userSession.getAttribute("user_id"));
                response = (HttpServletResponse)ec.getResponse();
                request = (HttpServletRequest)ec.getRequest();

                try {
                    response.sendRedirect("http://127.0.0.1:7101/EmployeeApraisalApplication-ViewController-context-root/faces/emp_apraise_form.jspx");
                    //ec.redirect("http://127.0.0.1:7101/EmployeeApraisalApplication-ViewController-context-root/faces/emp_apraise_form.jspx");
                    
                    return;                                                                                                                                                  
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    fctx.responseComplete();
                }
            }
        }
    }


    //METHOD IS JUST FOR TESTING 
    public void emp_apraise_form_beforePhase(PhaseEvent phaseEvent) {
        // Add event code here...
        if (phaseEvent.getPhaseId() == PhaseId.RENDER_RESPONSE) {
            //            fctx = FacesContext.getCurrentInstance();
            //            ec = fctx.getExternalContext();
            //            HttpSession userSession = (HttpSession)ec.getSession(true);
            //            if (userSession.getAttribute("user_id") != null) {
            //               System.out.println("Take user to the login page" +
            //                                  userSession.getAttribute("user_id"));
            //                response =
            //                   (HttpServletResponse)ec.getResponse();
            //
            //               try {
            //                   //response.sendRedirect("http://127.0.0.1:7101/EmployeeApraisalApplication-ViewController-context-root/faces/emp_apraise_form.jspx");
            //                   ec.redirect("http://127.0.0.1:7101/EmployeeApraisalApplication-ViewController-context-root/faces/login.jspx");
            //                   fctx.responseComplete();
            //               } catch (IOException e) {
            //                   e.printStackTrace();
            //               } finally {
            //
            //               }
            //            }else{
            //                System.out.println("User is already login with userID: "+userSession.getAttribute("user_id"));
            //            }
        }
    }
}
