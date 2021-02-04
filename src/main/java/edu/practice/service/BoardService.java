package edu.practice.service;

import java.util.List;

import edu.practice.vo.BoardVO;
import edu.practice.vo.SearchVO;



public interface BoardService 
{
	public List<BoardVO> listBoard(SearchVO searchVO) throws Exception;
	public BoardVO detailBoard(int no) throws Exception;//��Ʈ�ѷ����� �� no
	public int countBoard(SearchVO vo) throws Exception;
	public int writeBoard(BoardVO vo) throws Exception;
	public int modifyBoard(BoardVO vo) throws Exception;
	public int deleteBoard(BoardVO vo) throws Exception;
}
