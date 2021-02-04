package edu.practice.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import edu.practice.dao.BoardDAO;
import edu.practice.vo.BoardVO;
import edu.practice.vo.SearchVO;




@Service
public class BoardServiceImpl implements BoardService {
	
	@Inject
	BoardDAO boardDAO;
	
	@Override
	public List<BoardVO> listBoard(SearchVO searchVO) throws Exception
	{
		return boardDAO.listBoard(searchVO);
	}
	
	@Override
	public int countBoard(SearchVO vo) throws Exception
	{
		return boardDAO.countBoard(vo);
	}
	
	@Override
	public BoardVO detailBoard(int no) throws Exception
	{
		return boardDAO.detailBoard(no);
	}
	
	@Override
	public int writeBoard(BoardVO vo)throws Exception
	{	
		return boardDAO.writeBoard(vo);
	}
	
	@Override
	public int modifyBoard(BoardVO vo)throws Exception
	{	
		return boardDAO.modifyBoard(vo);
	}
	
	@Override
	public int deleteBoard(BoardVO vo)throws Exception
	{	
		return boardDAO.deleteBoard(vo);
	}
	
}
