package com.dto.notice;

import java.util.List;

import org.apache.ibatis.type.Alias;

@Alias("NoticePageDTO")
public class NoticePageDTO {
	String curPage;
	int perPage = 6;
	int totalCount ;
	List<NoticeTableDTO> list;
	public NoticePageDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NoticePageDTO(String curPage, int perPage, int totalCount, List<NoticeTableDTO> list) {
		super();
		this.curPage = curPage;
		this.perPage = perPage;
		this.totalCount = totalCount;
		this.list = list;
	}
	@Override
	public String toString() {
		return "NoticePageDTO [curPage=" + curPage + ", perPage=" + perPage + ", totalCount=" + totalCount + ", list="
				+ list + "]";
	}
	public String getCurPage() {
		return curPage;
	}
	public void setCurPage(String curPage) {
		this.curPage = curPage;
	}
	public int getPerPage() {
		return perPage;
	}
	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public List<NoticeTableDTO> getList() {
		return list;
	}
	public void setList(List<NoticeTableDTO> list) {
		this.list = list;
	}
	
	
	
	
}
