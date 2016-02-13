package net.nishat.vc;

import java.io.IOException;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import oracle.adf.controller.v2.lifecycle.Lifecycle;
import oracle.adf.controller.v2.lifecycle.PagePhaseEvent;
import oracle.adf.controller.v2.lifecycle.PagePhaseListener;

public class PageListener implements PagePhaseListener {
    public PageListener() {
        super();
    }

    public void afterPhase(PagePhaseEvent pagePhaseEvent) {
    }

    public void beforePhase(PagePhaseEvent pagePhaseEvent) {
        if (pagePhaseEvent.getPhaseId() == Lifecycle.INIT_CONTEXT_ID) {
//            FacesContext fctx = FacesContext.getCurrentInstance();
//            ExternalContext ec = fctx.getExternalContext();
//            HttpSession userSession = (HttpSession)ec.getSession(true);
//            if (userSession.getAttribute("user_id") != null) {
//                System.out.println("Take user to the application" +
//                                   userSession.getAttribute("user_id"));
//                HttpServletResponse response =
//                    (HttpServletResponse)ec.getResponse();
//                try {
//                    response.sendRedirect("emp_apraise_form.jspx");
//                } catch (IOException e) {
//                    e.printStackTrace();
//                } finally {
//                    fctx.responseComplete();
//                }
//            } else {
//                System.out.println("Take use to login page");
//            }
        }
    }
}
