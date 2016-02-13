package net.nishat.model.VO;

import javax.faces.context.FacesContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.nishat.model.EO.EO_XxPeerApFormImpl;

import oracle.jbo.AttributeList;
import oracle.jbo.RowSet;
import oracle.jbo.domain.Date;
import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Wed Feb 25 15:02:17 PKT 2015
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class VO_XxPeerApFormRowImpl extends ViewRowImpl {
    @Override
    protected void create(AttributeList attributeList) {
        FacesContext fctx = FacesContext.getCurrentInstance();
        HttpServletRequest req =
            (HttpServletRequest)fctx.getExternalContext().getRequest();
        HttpSession session = req.getSession();
        
        this.setEvaluatedBy((String)session.getAttribute("user_id"));
        this.setEvaluatorDpt((String)session.getAttribute("user_dpt"));
        this.setEvaluatorEmployeeNo((String)session.getAttribute("user_no"));
        super.create(attributeList);
    }

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        EvaluatedBy {
            public Object get(VO_XxPeerApFormRowImpl obj) {
                return obj.getEvaluatedBy();
            }

            public void put(VO_XxPeerApFormRowImpl obj, Object value) {
                obj.setEvaluatedBy((String)value);
            }
        }
        ,
        EvaluatorDpt {
            public Object get(VO_XxPeerApFormRowImpl obj) {
                return obj.getEvaluatorDpt();
            }

            public void put(VO_XxPeerApFormRowImpl obj, Object value) {
                obj.setEvaluatorDpt((String)value);
            }
        }
        ,
        EvaluatorEmployeeNo {
            public Object get(VO_XxPeerApFormRowImpl obj) {
                return obj.getEvaluatorEmployeeNo();
            }

            public void put(VO_XxPeerApFormRowImpl obj, Object value) {
                obj.setEvaluatorEmployeeNo((String)value);
            }
        }
        ,
        PCooperates {
            public Object get(VO_XxPeerApFormRowImpl obj) {
                return obj.getPCooperates();
            }

            public void put(VO_XxPeerApFormRowImpl obj, Object value) {
                obj.setPCooperates((String)value);
            }
        }
        ,
        PDpt {
            public Object get(VO_XxPeerApFormRowImpl obj) {
                return obj.getPDpt();
            }

            public void put(VO_XxPeerApFormRowImpl obj, Object value) {
                obj.setPDpt((String)value);
            }
        }
        ,
        PEasyToWork {
            public Object get(VO_XxPeerApFormRowImpl obj) {
                return obj.getPEasyToWork();
            }

            public void put(VO_XxPeerApFormRowImpl obj, Object value) {
                obj.setPEasyToWork((String)value);
            }
        }
        ,
        PEmployeeNo {
            public Object get(VO_XxPeerApFormRowImpl obj) {
                return obj.getPEmployeeNo();
            }

            public void put(VO_XxPeerApFormRowImpl obj, Object value) {
                obj.setPEmployeeNo((String)value);
            }
        }
        ,
        PId {
            public Object get(VO_XxPeerApFormRowImpl obj) {
                return obj.getPId();
            }

            public void put(VO_XxPeerApFormRowImpl obj, Object value) {
                obj.setPId((String)value);
            }
        }
        ,
        PName {
            public Object get(VO_XxPeerApFormRowImpl obj) {
                return obj.getPName();
            }

            public void put(VO_XxPeerApFormRowImpl obj, Object value) {
                obj.setPName((String)value);
            }
        }
        ,
        PRepectfulPoliteInConvo {
            public Object get(VO_XxPeerApFormRowImpl obj) {
                return obj.getPRepectfulPoliteInConvo();
            }

            public void put(VO_XxPeerApFormRowImpl obj, Object value) {
                obj.setPRepectfulPoliteInConvo((String)value);
            }
        }
        ,
        PResponsible {
            public Object get(VO_XxPeerApFormRowImpl obj) {
                return obj.getPResponsible();
            }

            public void put(VO_XxPeerApFormRowImpl obj, Object value) {
                obj.setPResponsible((String)value);
            }
        }
        ,
        PSharesInfo {
            public Object get(VO_XxPeerApFormRowImpl obj) {
                return obj.getPSharesInfo();
            }

            public void put(VO_XxPeerApFormRowImpl obj, Object value) {
                obj.setPSharesInfo((String)value);
            }
        }
        ,
        PeerFormId {
            public Object get(VO_XxPeerApFormRowImpl obj) {
                return obj.getPeerFormId();
            }

            public void put(VO_XxPeerApFormRowImpl obj, Object value) {
                obj.setPeerFormId((Number)value);
            }
        }
        ,
        PeerComments {
            public Object get(VO_XxPeerApFormRowImpl obj) {
                return obj.getPeerComments();
            }

            public void put(VO_XxPeerApFormRowImpl obj, Object value) {
                obj.setPeerComments((String)value);
            }
        }
        ,
        Posted {
            public Object get(VO_XxPeerApFormRowImpl obj) {
                return obj.getPosted();
            }

            public void put(VO_XxPeerApFormRowImpl obj, Object value) {
                obj.setPosted((String)value);
            }
        }
        ,
        SubmitionDate {
            public Object get(VO_XxPeerApFormRowImpl obj) {
                return obj.getSubmitionDate();
            }

            public void put(VO_XxPeerApFormRowImpl obj, Object value) {
                obj.setSubmitionDate((Date)value);
            }
        }
        ,
        VO_SearchPeers1 {
            public Object get(VO_XxPeerApFormRowImpl obj) {
                return obj.getVO_SearchPeers1();
            }

            public void put(VO_XxPeerApFormRowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        public abstract Object get(VO_XxPeerApFormRowImpl object);

        public abstract void put(VO_XxPeerApFormRowImpl object, Object value);

        public int index() {
            return AttributesEnum.firstIndex() + ordinal();
        }

        public static final int firstIndex() {
            return firstIndex;
        }

        public static int count() {
            return AttributesEnum.firstIndex() + AttributesEnum.staticValues().length;
        }

        public static final AttributesEnum[] staticValues() {
            if (vals == null) {
                vals = AttributesEnum.values();
            }
            return vals;
        }
    }


    public static final int EVALUATEDBY = AttributesEnum.EvaluatedBy.index();
    public static final int EVALUATORDPT = AttributesEnum.EvaluatorDpt.index();
    public static final int EVALUATOREMPLOYEENO = AttributesEnum.EvaluatorEmployeeNo.index();
    public static final int PCOOPERATES = AttributesEnum.PCooperates.index();
    public static final int PDPT = AttributesEnum.PDpt.index();
    public static final int PEASYTOWORK = AttributesEnum.PEasyToWork.index();
    public static final int PEMPLOYEENO = AttributesEnum.PEmployeeNo.index();
    public static final int PID = AttributesEnum.PId.index();
    public static final int PNAME = AttributesEnum.PName.index();
    public static final int PREPECTFULPOLITEINCONVO = AttributesEnum.PRepectfulPoliteInConvo.index();
    public static final int PRESPONSIBLE = AttributesEnum.PResponsible.index();
    public static final int PSHARESINFO = AttributesEnum.PSharesInfo.index();
    public static final int PEERFORMID = AttributesEnum.PeerFormId.index();
    public static final int PEERCOMMENTS = AttributesEnum.PeerComments.index();
    public static final int POSTED = AttributesEnum.Posted.index();
    public static final int SUBMITIONDATE = AttributesEnum.SubmitionDate.index();
    public static final int VO_SEARCHPEERS1 = AttributesEnum.VO_SearchPeers1.index();

    /**
     * This is the default constructor (do not remove).
     */
    public VO_XxPeerApFormRowImpl() {
    }

    /**
     * Gets EO_XxPeerApForm entity object.
     * @return the EO_XxPeerApForm
     */
    public EO_XxPeerApFormImpl getEO_XxPeerApForm() {
        return (EO_XxPeerApFormImpl)getEntity(0);
    }

    /**
     * Gets the attribute value for EVALUATED_BY using the alias name EvaluatedBy.
     * @return the EVALUATED_BY
     */
    public String getEvaluatedBy() {
        return (String) getAttributeInternal(EVALUATEDBY);
    }

    /**
     * Sets <code>value</code> as attribute value for EVALUATED_BY using the alias name EvaluatedBy.
     * @param value value to set the EVALUATED_BY
     */
    public void setEvaluatedBy(String value) {
        setAttributeInternal(EVALUATEDBY, value);
    }

    /**
     * Gets the attribute value for EVALUATOR_DPT using the alias name EvaluatorDpt.
     * @return the EVALUATOR_DPT
     */
    public String getEvaluatorDpt() {
        return (String) getAttributeInternal(EVALUATORDPT);
    }

    /**
     * Sets <code>value</code> as attribute value for EVALUATOR_DPT using the alias name EvaluatorDpt.
     * @param value value to set the EVALUATOR_DPT
     */
    public void setEvaluatorDpt(String value) {
        setAttributeInternal(EVALUATORDPT, value);
    }

    /**
     * Gets the attribute value for EVALUATOR_EMPLOYEE_NO using the alias name EvaluatorEmployeeNo.
     * @return the EVALUATOR_EMPLOYEE_NO
     */
    public String getEvaluatorEmployeeNo() {
        return (String) getAttributeInternal(EVALUATOREMPLOYEENO);
    }

    /**
     * Sets <code>value</code> as attribute value for EVALUATOR_EMPLOYEE_NO using the alias name EvaluatorEmployeeNo.
     * @param value value to set the EVALUATOR_EMPLOYEE_NO
     */
    public void setEvaluatorEmployeeNo(String value) {
        setAttributeInternal(EVALUATOREMPLOYEENO, value);
    }

    /**
     * Gets the attribute value for P_COOPERATES using the alias name PCooperates.
     * @return the P_COOPERATES
     */
    public String getPCooperates() {
        return (String) getAttributeInternal(PCOOPERATES);
    }

    /**
     * Sets <code>value</code> as attribute value for P_COOPERATES using the alias name PCooperates.
     * @param value value to set the P_COOPERATES
     */
    public void setPCooperates(String value) {
        setAttributeInternal(PCOOPERATES, value);
    }

    /**
     * Gets the attribute value for P_DPT using the alias name PDpt.
     * @return the P_DPT
     */
    public String getPDpt() {
        return (String) getAttributeInternal(PDPT);
    }

    /**
     * Sets <code>value</code> as attribute value for P_DPT using the alias name PDpt.
     * @param value value to set the P_DPT
     */
    public void setPDpt(String value) {
        setAttributeInternal(PDPT, value);
    }

    /**
     * Gets the attribute value for P_EASY_TO_WORK using the alias name PEasyToWork.
     * @return the P_EASY_TO_WORK
     */
    public String getPEasyToWork() {
        return (String) getAttributeInternal(PEASYTOWORK);
    }

    /**
     * Sets <code>value</code> as attribute value for P_EASY_TO_WORK using the alias name PEasyToWork.
     * @param value value to set the P_EASY_TO_WORK
     */
    public void setPEasyToWork(String value) {
        setAttributeInternal(PEASYTOWORK, value);
    }

    /**
     * Gets the attribute value for P_EMPLOYEE_NO using the alias name PEmployeeNo.
     * @return the P_EMPLOYEE_NO
     */
    public String getPEmployeeNo() {
        return (String) getAttributeInternal(PEMPLOYEENO);
    }

    /**
     * Sets <code>value</code> as attribute value for P_EMPLOYEE_NO using the alias name PEmployeeNo.
     * @param value value to set the P_EMPLOYEE_NO
     */
    public void setPEmployeeNo(String value) {
        setAttributeInternal(PEMPLOYEENO, value);
    }

    /**
     * Gets the attribute value for P_ID using the alias name PId.
     * @return the P_ID
     */
    public String getPId() {
        return (String) getAttributeInternal(PID);
    }

    /**
     * Sets <code>value</code> as attribute value for P_ID using the alias name PId.
     * @param value value to set the P_ID
     */
    public void setPId(String value) {
        setAttributeInternal(PID, value);
    }

    /**
     * Gets the attribute value for P_NAME using the alias name PName.
     * @return the P_NAME
     */
    public String getPName() {
        return (String) getAttributeInternal(PNAME);
    }

    /**
     * Sets <code>value</code> as attribute value for P_NAME using the alias name PName.
     * @param value value to set the P_NAME
     */
    public void setPName(String value) {
        setAttributeInternal(PNAME, value);
    }

    /**
     * Gets the attribute value for P_REPECTFUL_POLITE_IN_CONVO using the alias name PRepectfulPoliteInConvo.
     * @return the P_REPECTFUL_POLITE_IN_CONVO
     */
    public String getPRepectfulPoliteInConvo() {
        return (String) getAttributeInternal(PREPECTFULPOLITEINCONVO);
    }

    /**
     * Sets <code>value</code> as attribute value for P_REPECTFUL_POLITE_IN_CONVO using the alias name PRepectfulPoliteInConvo.
     * @param value value to set the P_REPECTFUL_POLITE_IN_CONVO
     */
    public void setPRepectfulPoliteInConvo(String value) {
        setAttributeInternal(PREPECTFULPOLITEINCONVO, value);
    }

    /**
     * Gets the attribute value for P_RESPONSIBLE using the alias name PResponsible.
     * @return the P_RESPONSIBLE
     */
    public String getPResponsible() {
        return (String) getAttributeInternal(PRESPONSIBLE);
    }

    /**
     * Sets <code>value</code> as attribute value for P_RESPONSIBLE using the alias name PResponsible.
     * @param value value to set the P_RESPONSIBLE
     */
    public void setPResponsible(String value) {
        setAttributeInternal(PRESPONSIBLE, value);
    }

    /**
     * Gets the attribute value for P_SHARES_INFO using the alias name PSharesInfo.
     * @return the P_SHARES_INFO
     */
    public String getPSharesInfo() {
        return (String) getAttributeInternal(PSHARESINFO);
    }

    /**
     * Sets <code>value</code> as attribute value for P_SHARES_INFO using the alias name PSharesInfo.
     * @param value value to set the P_SHARES_INFO
     */
    public void setPSharesInfo(String value) {
        setAttributeInternal(PSHARESINFO, value);
    }

    /**
     * Gets the attribute value for PEER_FORM_ID using the alias name PeerFormId.
     * @return the PEER_FORM_ID
     */
    public Number getPeerFormId() {
        return (Number) getAttributeInternal(PEERFORMID);
    }

    /**
     * Sets <code>value</code> as attribute value for PEER_FORM_ID using the alias name PeerFormId.
     * @param value value to set the PEER_FORM_ID
     */
    public void setPeerFormId(Number value) {
        setAttributeInternal(PEERFORMID, value);
    }

    /**
     * Gets the attribute value for PEER_COMMENTS using the alias name PeerComments.
     * @return the PEER_COMMENTS
     */
    public String getPeerComments() {
        return (String) getAttributeInternal(PEERCOMMENTS);
    }

    /**
     * Sets <code>value</code> as attribute value for PEER_COMMENTS using the alias name PeerComments.
     * @param value value to set the PEER_COMMENTS
     */
    public void setPeerComments(String value) {
        setAttributeInternal(PEERCOMMENTS, value);
    }

    /**
     * Gets the attribute value for POSTED using the alias name Posted.
     * @return the POSTED
     */
    public String getPosted() {
        return (String) getAttributeInternal(POSTED);
    }

    /**
     * Sets <code>value</code> as attribute value for POSTED using the alias name Posted.
     * @param value value to set the POSTED
     */
    public void setPosted(String value) {
        setAttributeInternal(POSTED, value);
    }

    /**
     * Gets the attribute value for SUBMITION_DATE using the alias name SubmitionDate.
     * @return the SUBMITION_DATE
     */
    public Date getSubmitionDate() {
        return (Date) getAttributeInternal(SUBMITIONDATE);
    }

    /**
     * Sets <code>value</code> as attribute value for SUBMITION_DATE using the alias name SubmitionDate.
     * @param value value to set the SUBMITION_DATE
     */
    public void setSubmitionDate(Date value) {
        setAttributeInternal(SUBMITIONDATE, value);
    }

    /**
     * Gets the view accessor <code>RowSet</code> VO_SearchPeers1.
     */
    public RowSet getVO_SearchPeers1() {
        return (RowSet)getAttributeInternal(VO_SEARCHPEERS1);
    }

    /**
     * getAttrInvokeAccessor: generated method. Do not modify.
     * @param index the index identifying the attribute
     * @param attrDef the attribute

     * @return the attribute value
     * @throws Exception
     */
    protected Object getAttrInvokeAccessor(int index,
                                           AttributeDefImpl attrDef) throws Exception {
        if ((index >= AttributesEnum.firstIndex()) && (index < AttributesEnum.count())) {
            return AttributesEnum.staticValues()[index - AttributesEnum.firstIndex()].get(this);
        }
        return super.getAttrInvokeAccessor(index, attrDef);
    }

    /**
     * setAttrInvokeAccessor: generated method. Do not modify.
     * @param index the index identifying the attribute
     * @param value the value to assign to the attribute
     * @param attrDef the attribute

     * @throws Exception
     */
    protected void setAttrInvokeAccessor(int index, Object value,
                                         AttributeDefImpl attrDef) throws Exception {
        if ((index >= AttributesEnum.firstIndex()) && (index < AttributesEnum.count())) {
            AttributesEnum.staticValues()[index - AttributesEnum.firstIndex()].put(this, value);
            return;
        }
        super.setAttrInvokeAccessor(index, value, attrDef);
    }
}