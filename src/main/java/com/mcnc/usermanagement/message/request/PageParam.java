package com.mcnc.usermanagement.message.request;

public class PageParam {

	private Integer page;
	private Integer size;
	private String sort;
	private String direction;

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}
	
	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public Integer getOffset() {
		return size * (page > 0 ? page - 1 : 0);
	}
}