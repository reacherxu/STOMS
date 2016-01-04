package com.stoms.model;

/**
 * SocialScienceItem entity. @author MyEclipse Persistence Tools
 */

public class SocialScienceItem implements java.io.Serializable {

	// Fields

	private Long socialScienceItemPk;
	private Long itemPk;
	private String itemId;
	private String contractId;
	private String itemName;
	private String teacherName;
	private String cardId;

	// Constructors

	/** default constructor */
	public SocialScienceItem() {
	}

	/** minimal constructor */
	public SocialScienceItem(Long socialScienceItemPk) {
		this.socialScienceItemPk = socialScienceItemPk;
	}

	/** full constructor */
	public SocialScienceItem(Long socialScienceItemPk, Long itemPk,
			String itemId, String contractId, String itemName,
			String teacherName, String cardId) {
		this.socialScienceItemPk = socialScienceItemPk;
		this.itemPk = itemPk;
		this.itemId = itemId;
		this.contractId = contractId;
		this.itemName = itemName;
		this.teacherName = teacherName;
		this.cardId = cardId;
	}

	// Property accessors

	public Long getSocialScienceItemPk() {
		return this.socialScienceItemPk;
	}

	public void setSocialScienceItemPk(Long socialScienceItemPk) {
		this.socialScienceItemPk = socialScienceItemPk;
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

	public String getCardId() {
		return this.cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

}