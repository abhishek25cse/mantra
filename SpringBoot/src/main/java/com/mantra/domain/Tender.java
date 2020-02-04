package com.mantra.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="TENDER_DETAIL")
public class Tender {
	
	public Tender() {
		super();
	}
	private static final long serialVersionUID = 3153923238733181995L;
	@Id
	@Field(value="id")
	private String  id;	
	
	@PersistenceConstructor
	public Tender(String id, String nitNo, String poNo, String totalOrderQty, String head, String penalityLd,
			String panalityParam, String rebate, String gauranteeMonth, String status) {
		super();
		this.id = id;
		this.nitNo = nitNo;
		this.poNo = poNo;
		this.totalOrderQty = totalOrderQty;
		this.head = head;
		this.penalityLd = penalityLd;
		this.panalityParam = panalityParam;
		this.rebate = rebate;
		this.gauranteeMonth = gauranteeMonth;
		this.status = status;
	}
	@Field(value="NIT_NO")
	private String nitNo;
	@Field(value="PO_NO")
	private String poNo;
	
	@Field(value="TOTAL_ORDER_QTY")
	private String totalOrderQty;
	@Field(value="HEAD")
	private String head;
	@Field(value="PENALITY_LD")
	private String penalityLd;
	@Field(value="PENALTY_PARAM")
	private String panalityParam;
	@Field(value="REBATE")
	private String rebate;
	@Field(value="GAURANTEE_MONTH")
	private String gauranteeMonth;
	@Field(value="STATUS")
	private String status;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNitNo() {
		return nitNo;
	}
	public void setNitNo(String nitNo) {
		this.nitNo = nitNo;
	}
	public String getPoNo() {
		return poNo;
	}
	public void setPoNo(String poNo) {
		this.poNo = poNo;
	}
	public String getTotalOrderQty() {
		return totalOrderQty;
	}
	public void setTotalOrderQty(String totalOrderQty) {
		this.totalOrderQty = totalOrderQty;
	}
	public String getHead() {
		return head;
	}
	public void setHead(String head) {
		this.head = head;
	}
	public String getPenalityLd() {
		return penalityLd;
	}
	public void setPenalityLd(String penalityLd) {
		this.penalityLd = penalityLd;
	}
	public String getPanalityParam() {
		return panalityParam;
	}
	public void setPanalityParam(String panalityParam) {
		this.panalityParam = panalityParam;
	}
	public String getRebate() {
		return rebate;
	}
	public void setRebate(String rebate) {
		this.rebate = rebate;
	}
	public String getGauranteeMonth() {
		return gauranteeMonth;
	}
	public void setGauranteeMonth(String gauranteeMonth) {
		this.gauranteeMonth = gauranteeMonth;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
