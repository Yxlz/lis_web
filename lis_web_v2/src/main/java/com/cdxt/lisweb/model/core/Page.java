package com.cdxt.lisweb.model.core;

import java.util.List;

/**
 * 分页数据
 * Title: Page.java    
 * Description: 描述
 * @author hezheng       
 * @created 2017-5-16 下午3:46:56 
 * @param <T>
 */
public class Page<T> {
	//数据开始索引
    private int start;  
	//每页显示数量 
    private int limit;  
    //总记录数 
    private int total;  
    //当前页 
    private int pageNo;  
    
    private List<T> datas;
    
    public Page(){}
    
	public Page(int start, int limit, int total, List<T> datas) {
		super();
		this.start = start;
		this.limit = limit;
		this.total = total;
		this.datas = datas;
	}
	
	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getTotalPage() {
		if(this.total%limit==0){
			return this.total/limit;
		}
		return this.total/limit+1;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public List<T> getDatas() {
		return datas;
	}

	public void setDatas(List<T> datas) {
		this.datas = datas;
	}
}
