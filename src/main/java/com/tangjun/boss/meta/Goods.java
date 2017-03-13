package com.tangjun.boss.meta;

import java.sql.Timestamp;

public class Goods {
	private int id;
	private String name;
	private String summary;    //��ƷժҪ��Ϣ
	private Double price;
	private String picUrl;     //��ƷͼƬ��ַ
	private String detail;     //��Ʒ��ϸ��Ϣ
	private Timestamp createTime;
	private Timestamp updateTime;
	private int status;        //��Ʒ״̬��1��ʾ���ۣ�0��ʾ����
	
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
