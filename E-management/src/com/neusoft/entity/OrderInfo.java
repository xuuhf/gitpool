package com.neusoft.entity;

public class OrderInfo {
	private int id;
	private String orderno;
	private int orderstatus;
	private int paystatus; // 1：线上支付 2：货到付款
	private long ordertime; // 下单时间
	private long paytime; // 付款时间
	private int addrinto; // 收货人信息，引用自 cosumer_addr中的id
	private String mask;

	public OrderInfo() {
		super();
	}

	public OrderInfo(String orderno, int orderstatus, int paystatus, long ordertime, long paytime, int addrinto,
			String mask) {
		super();
		this.orderno = orderno;
		this.orderstatus = orderstatus;
		this.paystatus = paystatus;
		this.ordertime = ordertime;
		this.paytime = paytime;
		this.addrinto = addrinto;
		this.mask = mask;
	}

	public OrderInfo(int id, String orderno, int orderstatus, int paystatus, long ordertime, long paytime, int addrinto,
			String mask) {
		super();
		this.id = id;
		this.orderno = orderno;
		this.orderstatus = orderstatus;
		this.paystatus = paystatus;
		this.ordertime = ordertime;
		this.paytime = paytime;
		this.addrinto = addrinto;
		this.mask = mask;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrderno() {
		return orderno;
	}

	public void setOrderno(String orderno) {
		this.orderno = orderno;
	}

	public int getOrderstatus() {
		return orderstatus;
	}

	public void setOrderstatus(int orderstatus) {
		this.orderstatus = orderstatus;
	}

	public int getPaystatus() {
		return paystatus;
	}

	public void setPaystatus(int paystatus) {
		this.paystatus = paystatus;
	}

	public long getOrdertime() {
		return ordertime;
	}

	public void setOrdertime(long ordertime) {
		this.ordertime = ordertime;
	}

	public long getPaytime() {
		return paytime;
	}

	public void setPaytime(long paytime) {
		this.paytime = paytime;
	}

	public int getAddrinto() {
		return addrinto;
	}

	public void setAddrinto(int addrinto) {
		this.addrinto = addrinto;
	}

	public String getMask() {
		return mask;
	}

	public void setMask(String mask) {
		this.mask = mask;
	}

	@Override
	public String toString() {
		return "OrderInfo [id=" + id + ", orderno=" + orderno + ", orderstatus=" + orderstatus + ", paystatus="
				+ paystatus + ", ordertime=" + ordertime + ", paytime=" + paytime + ", addrinto=" + addrinto + ", mask="
				+ mask + "]";
	}

}
