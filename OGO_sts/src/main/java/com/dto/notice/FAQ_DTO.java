package com.dto.notice;

import org.apache.ibatis.type.Alias;

@Alias("FAQ_DTO")
public class FAQ_DTO {

	String faqNum;
	String faqTitle;
	String faqContent;
	
	
	public FAQ_DTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FAQ_DTO(String faqNum, String faqTitle, String faqContent) {
		super();
		this.faqNum = faqNum;
		this.faqTitle = faqTitle;
		this.faqContent = faqContent;
	}
	@Override
	public String toString() {
		return "FAQ_DTO [faqNum=" + faqNum + ", faqTitle=" + faqTitle + ", faqContent=" + faqContent + "]";
	}
	public String getFaqNum() {
		return faqNum;
	}
	public void setFaqNum(String faqNum) {
		this.faqNum = faqNum;
	}
	public String getFaqTitle() {
		return faqTitle;
	}
	public void setFaqTitle(String faqTitle) {
		this.faqTitle = faqTitle;
	}
	public String getFaqContent() {
		return faqContent;
	}
	public void setFaqContent(String faqContent) {
		this.faqContent = faqContent;
	}
	
	
	}
