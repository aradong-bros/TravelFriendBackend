package com.estsoft.futures.aradongbros.travelfriend.vo;

public class AttractionVo
{
	private int postList_no;
	private int cityList_no;
	private String postList_name;
	private String postList_location;
	private String postList_picture;
	private String postList_info;
	private Category postList_category;

	public int getPostList_no() {
		return postList_no;
	}

	public void setPostList_no(int postList_no) {
		this.postList_no = postList_no;
	}

	public int getCityList_no() {
		return cityList_no;
	}

	public void setCityList_no(int cityList_no) {
		this.cityList_no = cityList_no;
	}

	public String getPostList_name() {
		return postList_name;
	}

	public void setPostList_name(String postList_name) {
		this.postList_name = postList_name;
	}

	public String getPostList_location() {
		return postList_location;
	}

	public void setPostList_location(String postList_location) {
		this.postList_location = postList_location;
	}

	public String getPostList_picture() {
		return postList_picture;
	}

	public void setPostList_picture(String postList_picture) {
		this.postList_picture = postList_picture;
	}

	public String getPostList_info() {
		return postList_info;
	}

	public void setPostList_info(String postList_info) {
		this.postList_info = postList_info;
	}

	public Category getPostList_category() {
		return postList_category;
	}

	public void setPostList_category(Category postList_category) {
		this.postList_category = postList_category;
	}

	@Override
	public String toString() {
		return "Attraction [postList_no=" + postList_no + ", cityList_no=" + cityList_no + ", postList_name="
				+ postList_name + ", postList_location=" + postList_location + ", postList_picture=" + postList_picture
				+ ", postList_info=" + postList_info + ", postList_category=" + postList_category + "]";
	}

	
	
	
}
