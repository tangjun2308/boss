package com.tangjun.boss.meta;

import java.sql.Timestamp;

public class Order {
	private int id;
	private int userId;
	private int goodsId;    
	private int num;         //��������
	private Double goodsPrice;  //����ʱ��Ʒ�۸�
	private Double totalPrice;  //�����ܶ�
	private Timestamp createTime; //����ʱ��
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public Double getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(Double goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	
	@Override
	public String toString() {
		return "Order [id=" + id + ", userId=" + userId + ", goodsId=" + goodsId + ", num=" + num + ", goodsPrice="
				+ goodsPrice + ", totalPrice=" + totalPrice + ", createTime=" + createTime + "]";
	}

}
