package net.nishat.model.Search;

import javax.faces.context.FacesContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import oracle.jbo.server.ViewObjectImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Wed Feb 18 10:36:29 PKT 2015
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class VO_SearchEmployeeAllUnderHODImpl extends ViewObjectImpl {
    /**
     * This is the default constructor (do not remove).
     */
    public VO_SearchEmployeeAllUnderHODImpl() {
    }

    /**
     * Returns the variable value for full_name_child.
     * @return variable value for full_name_child
     */
    public String getfull_name_child() {
        return (String)ensureVariableManager().getVariableValue("full_name_child");
    }

    /**
     * Sets <code>value</code> for variable full_name_child.
     * @param value value to bind as full_name_child
     */
    public void setfull_name_child(String value) {
        ensureVariableManager().setVariableValue("full_name_child", value);
    }

    /**
     * Returns the bind variable value for hod_dpt.
     * @return bind variable value for hod_dpt
     */
    public String gethod_dpt() {
        FacesContext fctx = FacesContext.getCurrentInstance();
        HttpServletRequest req =
            (HttpServletRequest)fctx.getExternalContext().getRequest();
        HttpSession session = req.getSession();
        String hod = ((String)session.getAttribute("user_dpt"));
        if (hod == null) {
        
            return "";
            
        }else{
        
            return hod.trim();
        }
    }

    /**
     * Sets <code>value</code> for bind variable hod_dpt.
     * @param value value to bind as hod_dpt
     */
    public void sethod_dpt(String value) {
        setNamedWhereClauseParam("hod_dpt", value);
    }
}