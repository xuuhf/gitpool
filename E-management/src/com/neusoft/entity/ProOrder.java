package com.neusoft.entity;

import java.util.List;

/**
 * ��Ʒ ��ҵ�ַ ���� ��Ϣ�ݴ���
 * @author Administrator
 *
 */
public class ProOrder {
	private OrderInfo oi;
	private Consumer_addr cad;
	private List<PrOd> pd;
	public OrderInfo getOi() {
		return oi;
	}
	public void setOi(OrderInfo oi) {
		this.oi = oi;
	}
	public Consumer_addr getCad() {
		return cad;
	}
	public void setCad(Consumer_addr cad) {
		this.cad = cad;
	}
	public List<PrOd> getPd() {
		return pd;
	}
	public void setPd(List<PrOd> pd) {
		this.pd = pd;
	}
	@Override
	public String toString() {
		return "ProOrder [oi=" + oi + ", cad=" + cad + ", pd=" + pd + "]";
	}
	
}
