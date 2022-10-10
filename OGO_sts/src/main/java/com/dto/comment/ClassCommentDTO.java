package com.dto.comment;

import org.apache.ibatis.type.Alias;

@Alias("ClassCommentDTO")
public class ClassCommentDTO {

	String comment_no;
	String comment_notice;
	String comment_date;
	String userid;
	int classnum;
	public ClassCommentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ClassCommentDTO(String comment_no, String comment_notice, String comment_date, String userid, int classnum) {
		super();
		this.comment_no = comment_no;
		this.comment_notice = comment_notice;
		this.comment_date = comment_date;
		this.userid = userid;
		this.classnum = classnum;
	}
	public String getComment_no() {
		return comment_no;
	}
	public void setComment_no(String comment_no) {
		this.comment_no = comment_no;
	}
	public String getComment_notice() {
		return comment_notice;
	}
	public void setComment_notice(String comment_notice) {
		this.comment_notice = comment_notice;
	}
	public String getComment_date() {
		return comment_date;
	}
	public void setComment_date(String comment_date) {
		this.comment_date = comment_date;
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
	@Override
	public String toString() {
		return "ClassCommentDTO [comment_no=" + comment_no + ", comment_notice=" + comment_notice + ", comment_date="
				+ comment_date + ", userid=" + userid + ", classnum=" + classnum + "]";
	}
	
	
	
}//end class
