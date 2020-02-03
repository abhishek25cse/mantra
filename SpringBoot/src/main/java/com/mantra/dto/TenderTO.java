package com.mantra.dto;

import java.io.Serializable;

public class TenderTO implements Serializable {
	
	private static final long serialVersionUID = 3153923238733181995L;
	private String nitNo;
	private String poNo;
	private String totalOrderQty;
	private String head;
	private String penalityLd;
	private String panalityParam;
	private String rebate;
	private String gauranteeMonth;
	private String status;
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
	@Override
	public String toString() {
		return "TenderTO [nitNo=" + nitNo + ", poNo=" + poNo + ", totalOrderQty=" + totalOrderQty + ", head=" + head
				+ ", penalityLd=" + penalityLd + ", panalityParam=" + panalityParam + ", rebate=" + rebate
				+ ", gauranteeMonth=" + gauranteeMonth + ", status=" + status + "]";
	}

}
