package com.dto.notice;

import org.apache.ibatis.type.Alias;

@Alias("NoticeTableDTO")
public class NoticeTableDTO {
	
	int nNum;
	String nickName;
	String nTitle;
	String nContent;
	String nDate;
	public NoticeTableDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NoticeTableDTO(int nNum, String nickName, String nTitle, String nContent, String nDate) {
		super();
		this.nNum = nNum;
		this.nickName = nickName;
		this.nTitle = nTitle;
		this.nContent = nContent;
		this.nDate = nDate;
	}
	@Override
	public String toString() {
		return "NoticeTableDTO [nNum=" + nNum + ", nickName=" + nickName + ", nTitle=" + nTitle + ", nContent="
				+ nContent + ", nDate=" + nDate + "]";
	}
	public int getnNum() {
		return nNum;
	}
	public void setnNum(int nNum) {
		this.nNum = nNum;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getnTitle() {
		return nTitle;
	}
	public void setnTitle(String nTitle) {
		this.nTitle = nTitle;
	}
	public String getnContent() {
		return nContent;
	}
	public void setnContent(String nContent) {
		this.nContent = nContent;
	}
	public String getnDate() {
		return nDate;
	}
	public void setnDate(String nDate) {
		this.nDate = nDate;
	}
	
	
	
	
	
	
}
