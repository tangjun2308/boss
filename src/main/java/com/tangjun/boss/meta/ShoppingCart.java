package com.tangjun.boss.meta;

import java.sql.Timestamp;

public class ShoppingCart {
	private int id;
	private int userId;
	private String goodsIds;          //��Ʒid��������������
	private String goodsNums;         //����������������������
	private Timestamp createTime; //����ʱ��
	private Timestamp updateTime;
	
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
	public String getGoodsIds() {
		return goodsIds;
	}
	public void setGoodsIds(String goodsIds) {
		this.goodsIds = goodsIds;
	}
	public String getGoodsNums() {
		return goodsNums;
	}
	public void setGoodsNums(String goodsNums) {
		this.goodsNums = goodsNums;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public Timestamp getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
	@Override
	public String toString() {
		return "ShoppingCart [id=" + id + ", userId=" + userId + ", goodsIds=" + goodsIds + ", goodsNums=" + goodsNums
				+ ", createTime=" + createTime + ", updateTime=" + updateTime + "]";
	}

}
