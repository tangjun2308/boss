package com.tangjun.boss.meta;

import java.sql.Timestamp;

public class Goods {
	private int id;
	private String name;
	private String summary;    //商品摘要信息
	private Double price;
	private String picUrl;     //商品图片地址
	private String detail;     //商品详细信息
	private Timestamp createTime;
	private Timestamp updateTime;
	private int status;        //商品状态，1表示在售，0表示不在
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getPicUrl() {
		return picUrl;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
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
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "Goods [id=" + id + ", name=" + name + ", summary=" + summary + ", price=" + price + ", picUrl=" + picUrl
				+ ", detail=" + detail + ", createTime=" + createTime + ", updateTime=" + updateTime + ", status="
				+ status + "]";
	}

}
