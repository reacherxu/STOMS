package com.stoms.model;



/**
 * Expenditure entity. @author MyEclipse Persistence Tools
 */

public class Expenditure  implements java.io.Serializable {


    // Fields    

     private Integer expenditurePk;
     private String certificateDate;
     private String type;
     private String certificateId;
     private String abstract_;
     private String subjectId;
     private String sector;
     private String projectId;
     private Float expenditure;
     private Float loan;


    // Constructors

    /** default constructor */
    public Expenditure() {
    }

	/** minimal constructor */
    public Expenditure(String subjectId, String projectId) {
        this.subjectId = subjectId;
        this.projectId = projectId;
    }
    
    /** full constructor */
    public Expenditure(String certificateDate, String type, String certificateId, String abstract_, String subjectId, String sector, String projectId, Float expenditure, Float loan) {
        this.certificateDate = certificateDate;
        this.type = type;
        this.certificateId = certificateId;
        this.abstract_ = abstract_;
        this.subjectId = subjectId;
        this.sector = sector;
        this.projectId = projectId;
        this.expenditure = expenditure;
        this.loan = loan;
    }

   
    // Property accessors

    public Integer getExpenditurePk() {
        return this.expenditurePk;
    }
    
    public void setExpenditurePk(Integer expenditurePk) {
        this.expenditurePk = expenditurePk;
    }

    public String getCertificateDate() {
        return this.certificateDate;
    }
    
    public void setCertificateDate(String certificateDate) {
        this.certificateDate = certificateDate;
    }

    public String getType() {
        return this.type;
    }
    
    public void setType(String type) {
        this.type = type;
    }

    public String getCertificateId() {
        return this.certificateId;
    }
    
    public void setCertificateId(String certificateId) {
        this.certificateId = certificateId;
    }

    public String getAbstract_() {
        return this.abstract_;
    }
    
    public void setAbstract_(String abstract_) {
        this.abstract_ = abstract_;
    }

    public String getSubjectId() {
        return this.subjectId;
    }
    
    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getSector() {
        return this.sector;
    }
    
    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getProjectId() {
        return this.projectId;
    }
    
    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public Float getExpenditure() {
        return this.expenditure;
    }
    
    public void setExpenditure(Float expenditure) {
        this.expenditure = expenditure;
    }

    public Float getLoan() {
        return this.loan;
    }
    
    public void setLoan(Float loan) {
        this.loan = loan;
    }
   








}