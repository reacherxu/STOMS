package com.stoms.model;

/**
 * A863item entity. @author MyEclipse Persistence Tools
 */

public class A863item implements java.io.Serializable {

	// Fields

	private Long a863itemPk;
	private Long itemPk;
	private String itemId;
	private String contractId;
	private String itemName;
	private String teacherName;
	private String insideId;
	private String cardId;

	// Constructors

	/** default constructor */
	public A863item() {
	}

	/** minimal constructor */
	public A863item(Long a863itemPk) {
		this.a863itemPk = a863itemPk;
	}

	/** full constructor */
	public A863item(Long a863itemPk, Long itemPk, String itemId,
			String contractId, String itemName, String teacherName,
			String insideId, String cardId) {
		this.a863itemPk = a863itemPk;
		this.itemPk = itemPk;
		this.itemId = itemId;
		this.contractId = contractId;
		this.itemName = itemName;
		this.teacherName = teacherName;
		this.insideId = insideId;
		this.cardId = cardId;
	}

	// Property accessors

	public Long getA863itemPk() {
		return this.a863itemPk;
	}

	public void setA863itemPk(Long a863itemPk) {
		this.a863itemPk = a863itemPk;
	}

	public Long getItemPk() {
		return this.itemPk;
	}

	public void setItemPk(Long itemPk) {
		this.itemPk = itemPk;
	}

	public String getItemId() {
		return this.itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getContractId() {
		return this.contractId;
	}

	public void setContractId(String contractId) {
		this.contractId = contractId;
	}

	public String getItemName() {
		return this.itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getTeacherName() {
		return this.teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getInsideId() {
		return this.insideId;
	}

	public void setInsideId(String insideId) {
		this.insideId = insideId;
	}

	public String getCardId() {
		return this.cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

}