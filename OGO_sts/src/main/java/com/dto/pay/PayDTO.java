package com.dto.pay;

import org.apache.ibatis.type.Alias;

@Alias("PayDTO")
public class PayDTO {
	
	String ordernum; 
	String userid;
	int classnum; 
	int price; 
	String orderdate; 
	
	String orderstatus; 
	String schedule1; 
	String schedule2;
	String schedule3;
	String schedule4;
	
	String schedule5;
	String schedule6;
	String schedule7;
	String schedule8;
	String schedule9;
	
	String schedule10;
	String place; 
	String classname; 
	String username; 
	String classphoto1; 
	
	String allschedule;

	public PayDTO(String ordernum, String userid, int classnum, int price, String orderdate, String orderstatus,
			String schedule1, String schedule2, String schedule3, String schedule4, String schedule5, String schedule6,
			String schedule7, String schedule8, String schedule9, String schedule10, String place, String classname,
			String username, String classphoto1, String allschedule) {
		super();
		this.ordernum = ordernum;
		this.userid = userid;
		this.classnum = classnum;
		this.price = price;
		this.orderdate = orderdate;
		this.orderstatus = orderstatus;
		this.schedule1 = schedule1;
		this.schedule2 = schedule2;
		this.schedule3 = schedule3;
		this.schedule4 = schedule4;
		this.schedule5 = schedule5;
		this.schedule6 = schedule6;
		this.schedule7 = schedule7;
		this.schedule8 = schedule8;
		this.schedule9 = schedule9;
		this.schedule10 = schedule10;
		this.place = place;
		this.classname = classname;
		this.username = username;
		this.classphoto1 = classphoto1;
		this.allschedule = allschedule;
	}

	public PayDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "PayDTO [ordernum=" + ordernum + ", userid=" + userid + ", classnum=" + classnum + ", price=" + price
				+ ", orderdate=" + orderdate + ", orderstatus=" + orderstatus + ", schedule1=" + schedule1
				+ ", schedule2=" + schedule2 + ", schedule3=" + schedule3 + ", schedule4=" + schedule4 + ", schedule5="
				+ schedule5 + ", schedule6=" + schedule6 + ", schedule7=" + schedule7 + ", schedule8=" + schedule8
				+ ", schedule9=" + schedule9 + ", schedule10=" + schedule10 + ", place=" + place + ", classname="
				+ classname + ", username=" + username + ", classphoto1=" + classphoto1 + ", allschedule=" + allschedule
				+ "]";
	}

	public String getOrdernum() {
		return ordernum;
	}

	public void setOrdernum(String ordernum) {
		this.ordernum = ordernum;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public int getClassnum() {
		return classnum;
	}

	public void setClassnum(int classnum) {
		this.classnum = classnum;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}

	public String getOrderstatus() {
		return orderstatus;
	}

	public void setOrderstatus(String orderstatus) {
		this.orderstatus = orderstatus;
	}

	public String getSchedule1() {
		return schedule1;
	}

	public void setSchedule1(String schedule1) {
		this.schedule1 = schedule1;
	}

	public String getSchedule2() {
		return schedule2;
	}

	public void setSchedule2(String schedule2) {
		this.schedule2 = schedule2;
	}

	public String getSchedule3() {
		return schedule3;
	}

	public void setSchedule3(String schedule3) {
		this.schedule3 = schedule3;
	}

	public String getSchedule4() {
		return schedule4;
	}

	public void setSchedule4(String schedule4) {
		this.schedule4 = schedule4;
	}

	public String getSchedule5() {
		return schedule5;
	}

	public void setSchedule5(String schedule5) {
		this.schedule5 = schedule5;
	}

	public String getSchedule6() {
		return schedule6;
	}

	public void setSchedule6(String schedule6) {
		this.schedule6 = schedule6;
	}

	public String getSchedule7() {
		return schedule7;
	}

	public void setSchedule7(String schedule7) {
		this.schedule7 = schedule7;
	}

	public String getSchedule8() {
		return schedule8;
	}

	public void setSchedule8(String schedule8) {
		this.schedule8 = schedule8;
	}

	public String getSchedule9() {
		return schedule9;
	}

	public void setSchedule9(String schedule9) {
		this.schedule9 = schedule9;
	}

	public String getSchedule10() {
		return schedule10;
	}

	public void setSchedule10(String schedule10) {
		this.schedule10 = schedule10;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getClassphoto1() {
		return classphoto1;
	}

	public void setClassphoto1(String classphoto1) {
		this.classphoto1 = classphoto1;
	}

	public String getAllschedule() {
		return allschedule;
	}

	public void setAllschedule(String allschedule) {
		this.allschedule = allschedule;
	} 

		
}
