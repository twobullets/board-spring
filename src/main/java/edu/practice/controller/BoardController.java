package edu.practice.controller;


import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.practice.service.BoardService;
import edu.practice.vo.BoardVO;
import edu.practice.vo.PagingVO;
import edu.practice.vo.SearchVO;


@Controller
@RequestMapping(value="/board")
public class BoardController 
{	
	@Inject
	private BoardService boardService;
	
	@RequestMapping(value = "/list")//uri
	public String list(Locale locale, Model model,SearchVO searchVO, PagingVO vo) throws Exception {
	
		int total = boardService.countBoard(searchVO);
		
		if(vo.getNowPage() == 0 && vo.getCntPerPage() == 0)
		{
			vo.setNowPage(1);
			vo.setCntPerPage(5);
			
		}else if(vo.getNowPage() == 0)
		{
			vo.setNowPage(1);
		}else if(vo.getCntPerPage() == 0)
		{
			vo.setCntPerPage(5);
		}
		vo = new PagingVO(vo.getNowPage(), total, vo.getCntPerPage());
		
		searchVO.setStart(vo.getStart());
		searchVO.setEnd(5);
		
		
		List<BoardVO> list = boardService.listBoard(searchVO);
		model.addAttribute("list", list);
		
		System.out.println("list::"+list.size());
		return "board/list";//jsp파일
	}
	
	@RequestMapping(value = "/detail")//uri
	public String detail(Locale locale, Model model, int no) throws Exception {
		
		BoardVO vo = boardService.detailBoard(no);
		model.addAttribute("vo", vo);
		return "board/detail";//jsp파일
	}
	
	@RequestMapping(value = "/write")//uri
	public String write(Locale locale, Model model, String no) throws Exception {
		
		BoardVO vo = new BoardVO();
		System.out.println("no::"+no);
		if(no != null)
		{
			System.out.println("??");
			vo = boardService.detailBoard(Integer.parseInt(no));
		}
		System.out.println("vo::"+vo.toString());
		model.addAttribute("vo",vo);
		
		return "board/write";//jsp파일
	}
	
	@RequestMapping(value = "/writeok", method = RequestMethod.POST)//uri
	public String modify(Locale locale, Model model, BoardVO boardVO ) throws Exception {
	
		System.out.println("boardVO::"+boardVO.toString());
		
		int result = 0;
		// 받아온 no가 없으면 즉 작성을 누르면 write로, no가 있으면 수정으로 인식 modify로
		if(boardVO.getNo() == 0)
		{
			result = boardService.writeBoard(boardVO);
		}else
		{
			result = boardService.modifyBoard(boardVO);			
		}
		System.out.println("no::"+boardVO.getNo());
		return "redirect:/board/list";//jsp파일
	}
	
	@RequestMapping(value = "/delete")//uri
	public String delete(Locale locale, Model model, BoardVO boardVO ) throws Exception {
	
		System.out.println("boardVO::"+boardVO.toString());
		
		boardService.deleteBoard(boardVO);
		
		return "redirect:/board/list";//jsp파일
	}
}
