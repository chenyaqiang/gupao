package com.gupao.statics.bean;

public class Tip {
	private int id;
	private String tipType;
	private int number;
	private String title;
	private String imageUrl;
	private String content;

	public Tip(){

	}
	public Tip(int id, String tipType, int number, String title, String imageUrl, String content) {
		this.id = id;
		this.tipType = tipType;
		this.number = number;
		this.title = title;
		this.imageUrl = imageUrl;
		this.content = content;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipType() {
		return tipType;
	}

	public void setTipType(String tipType) {
		this.tipType = tipType;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
