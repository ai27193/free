/**
 * 
 */
package com.Freerun.untilbean;

/**
 * @author wuzhiyong
 * @creation 2018年7月19日
 * @hqtj.java
 * @行情条件
 */
public class chaoshiCondition {
	private int id;
	//品牌
	private String pp ;
	
	//最大值
	private int max;
	//最小值
	private int min;
	//年份
	private int year;
	//生产工艺
	private String scgy;
	//类型
	private String lx;
	//排序方式
	private String order;
	
	//根据什么排序
	private int ordertypr;
	
	//根据获得零售类型
	private String lstype;
	
	
	
	/**
	 * @return the pp
	 */
	public String getPp() {
		return pp;
	}
	/**
	 * @param pp the pp to set
	 */
	public void setPp(String pp) {
		this.pp = pp;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the max
	 */
	public int getMax() {
		return max;
	}
	/**
	 * @param max the max to set
	 */
	public void setMax(int max) {
		this.max = max;
	}
	/**
	 * @return the min
	 */
	public int getMin() {
		return min;
	}
	/**
	 * @param min the min to set
	 */
	public void setMin(int min) {
		this.min = min;
	}
	
	
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getScgy() {
		return scgy;
	}
	public void setScgy(String scgy) {
		this.scgy = scgy;
	}
	public String getLx() {
		return lx;
	}
	public void setLx(String lx) {
		this.lx = lx;
	}
	/**
	 * @return the order
	 */
	public String getOrder() {
		return order;
	}
	/**
	 * @param order the order to set
	 */
	public void setOrder(String order) {
		this.order = order;
	}
	/**
	 * @return the ordertypr
	 */
	public int getOrdertypr() {
		return ordertypr;
	}
	/**
	 * @param ordertypr the ordertypr to set
	 */
	public void setOrdertypr(int ordertypr) {
		this.ordertypr = ordertypr;
	}
	/**
	 * @return the lstype
	 */
	public String getLstype() {
		return lstype;
	}
	/**
	 * @param lstype the lstype to set
	 */
	public void setLstype(String lstype) {
		this.lstype = lstype;
	}
	
	
	
	

}
