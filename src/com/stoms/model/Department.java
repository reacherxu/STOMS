package com.stoms.model;



/**
 * Department entity. @author MyEclipse Persistence Tools
 */

public class Department  implements java.io.Serializable {


    // Fields    

     private Integer departmentPk;
     private String departmentId;
     private String departmentName;
     private String departmentType;
     private String assistanceId;
     private String directorId;
     private String assistanceTel;
     private String assistanceMobile;
     private String assistanceEmail;


    // Constructors

    /** default constructor */
    public Department() {
    }

	/** minimal constructor */
    public Department(Integer departmentPk, String departmentId, String departmentName) {
        this.departmentPk = departmentPk;
        this.departmentId = departmentId;
        this.departmentName = departmentName;
    }
    
    /** full constructor */
    public Department(Integer departmentPk, String departmentId, String departmentName, String departmentType, String assistanceId, String directorId, String assistanceTel, String assistanceMobile, String assistanceEmail) {
        this.departmentPk = departmentPk;
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.departmentType = departmentType;
        this.assistanceId = assistanceId;
        this.directorId = directorId;
        this.assistanceTel = assistanceTel;
        this.assistanceMobile = assistanceMobile;
        this.assistanceEmail = assistanceEmail;
    }

   
    // Property accessors

    public Integer getDepartmentPk() {
        return this.departmentPk;
    }
    
    public void setDepartmentPk(Integer departmentPk) {
        this.departmentPk = departmentPk;
    }

    public String getDepartmentId() {
        return this.departmentId;
    }
    
    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return this.departmentName;
    }
    
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentType() {
        return this.departmentType;
    }
    
    public void setDepartmentType(String departmentType) {
        this.departmentType = departmentType;
    }

    public String getAssistanceId() {
        return this.assistanceId;
    }
    
    public void setAssistanceId(String assistanceId) {
        this.assistanceId = assistanceId;
    }

    public String getDirectorId() {
        return this.directorId;
    }
    
    public void setDirectorId(String directorId) {
        this.directorId = directorId;
    }

    public String getAssistanceTel() {
        return this.assistanceTel;
    }
    
    public void setAssistanceTel(String assistanceTel) {
        this.assistanceTel = assistanceTel;
    }

    public String getAssistanceMobile() {
        return this.assistanceMobile;
    }
    
    public void setAssistanceMobile(String assistanceMobile) {
        this.assistanceMobile = assistanceMobile;
    }

    public String getAssistanceEmail() {
        return this.assistanceEmail;
    }
    
    public void setAssistanceEmail(String assistanceEmail) {
        this.assistanceEmail = assistanceEmail;
    }
   








}