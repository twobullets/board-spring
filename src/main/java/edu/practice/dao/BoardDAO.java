package edu.practice.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import edu.practice.vo.BoardVO;
import edu.practice.vo.SearchVO;



@Repository
public class BoardDAO 
{
	@Inject
	private SqlSession sqlSession;
	private static final String Namespace = "edu.practice.mapper.boardMapper";
	
	public List<BoardVO> listBoard(SearchVO searchVO)
	{
		return sqlSession.selectList(Namespace+".listBoard",searchVO);
	}
	
	public BoardVO detailBoard(int no) throws Exception
	{
		return sqlSession.selectOne(Namespace+".detailBoard", no);//서비스에서 온 no
		//mapper로
	}
	
	public int countBoard(SearchVO vo)
	{
		return sqlSession.selectOne(Namespace+".countBoard",vo);
	}
	
	public int writeBoard(BoardVO vo) {
		
		return sqlSession.insert(Namespace+".writeBoard", vo);
	}
	
	public int modifyBoard(BoardVO vo) {
		
		return sqlSession.update(Namespace+".modifyBoard",vo);
	}
	
	public int deleteBoard(BoardVO vo) {
		
		return sqlSession.delete(Namespace+".deleteBoard",vo);
	}
	
}
