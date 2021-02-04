package edu.practice.vo;

public class PagingVO 
{
	
	private int nowPage;	//����������
	private int startPage;	//����������	
	private int endPage;	//��������
	private int total;		//�Խñ��Ѱ���
	private int cntPerPage;	//�������� �� ����
	private int lastPage;	//������������
	private int start;		//SQL������ �� start
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
	//���� ������ ������ ���
	public void calcLastPage(int total, int cntPerPage)
	{
		setLastPage((int)Math.ceil((double)total / (double)cntPerPage));
	}
	//����, �� ������ ���
	public void calcStartEndPage(int nowPage, int cntPerPage)
	{
		//Math.ceil => �ø�
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
	//DB �������� �����  start, end�� ���
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