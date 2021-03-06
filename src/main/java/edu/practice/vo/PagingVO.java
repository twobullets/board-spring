package edu.practice.vo;

public class PagingVO 
{
	
	private int nowPage;	//현재페이지
	private int startPage;	//시작페이지	
	private int endPage;	//끝페이지
	private int total;		//게시글총개수
	private int cntPerPage;	//페이지당 글 개수
	private int lastPage;	//마지막페이지
	private int start;		//SQL쿼리에 쓸 start
	private int end;		//end

	public PagingVO() {
		
	}
	
	

	public PagingVO(int nowPage, int total, int cntPerPage) {
		this.nowPage = nowPage;
		this.total = total;
		this.cntPerPage = cntPerPage;
		
		calcLastPage(total, cntPerPage);
		calcStartEndPage(nowPage,cntPerPage);
		calcStartEnd(nowPage,cntPerPage);
		
	}
	//제일 마지막 페이지 계산
	public void calcLastPage(int total, int cntPerPage)
	{
		setLastPage((int)Math.ceil((double)total / (double)cntPerPage));
	}
	//시작, 끝 페이지 계산
	public void calcStartEndPage(int nowPage, int cntPerPage)
	{
		//Math.ceil => 올림
		setEndPage(((int)Math.ceil((double)nowPage / (double)cntPerPage)) * cntPerPage);
		if(getLastPage() < getEndPage())
		{
			setEndPage(getLastPage());
		}
		setStartPage(getEndPage() - cntPerPage + 1);
		if(getStartPage() < 1)
		{
			setStartPage(1);
		}
	}
	//DB 쿼리에서 사용할  start, end값 계산
	public void calcStartEnd(int nowPage, int cntPerPage)
	{
		setEnd(nowPage * cntPerPage);
		setStart(getEnd() - cntPerPage);
	}

	


	public int getNowPage() {
		return nowPage;
	}

	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getCntPerPage() {
		return cntPerPage;
	}

	public void setCntPerPage(int cntPerPage) {
		this.cntPerPage = cntPerPage;
	}

	public int getLastPage() {
		return lastPage;
	}

	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}
	
	
}