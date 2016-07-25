package com.estsoft.futures.aradongbros.travelfriend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.estsoft.futures.aradongbros.travelfriend.service.AttractionService;
import com.estsoft.futures.aradongbros.travelfriend.vo.AttractionVo;

@Controller
@RequestMapping("/attraction")
public class AttractionController 
{
	@Autowired
	private AttractionService atrService;
	
	// 메인 페이지로 간다
	@RequestMapping("/atrMain")
	public String getAttractionMain()
	{
		return "/attraction/attractionMain";
	}
	
	// 각 지역 관광지 정보 리스트 가져온다.
	@RequestMapping("/atrList/{cityList_no}")
	public String getList(@PathVariable("cityList_no")int cityList_no,
						  Model model)
	{
		List<AttractionVo> atrList = atrService.selectListByCityNo(cityList_no);
		model.addAttribute("atrList", atrList);
		
		return "/attraction/attractionListByCityNo";
	}
	
	// 관광지 전체정보 리스트 가져온다.
	@RequestMapping("/atrAllList")
	public String getAttractionList(Model model)
	{
		List<AttractionVo> atrList = atrService.selectList();
		model.addAttribute("atrList", atrList);
		
		return "/attraction/attractionList";
	}
	
	// 관광지 정보 삽입 jsp 가져온다
	@RequestMapping("/atrInsertform")
	public String getAttractionInsertForm()
	{	
		return "/attraction/attractionInsert";
	}
	
	// 관광지 정보가 실제 삽입되는 코드
	@RequestMapping("/atrInsert")
	public String insertAttaractionData(@ModelAttribute AttractionVo atrVo)
	{
		atrService.insert(atrVo);
		
		//return "redirect:atrList"; // 상대경로
		return "redirect:/attraction/atrAllList"; // 절대경로
	}
	
	// 관광지 정보 삭제 jsp 가져온다
	@RequestMapping("/atrDeleteform/{postList_no}")
	public String getAttractionDeleteForm(@PathVariable("postList_no")int postList_no,
										  Model model)
	{
		AttractionVo atrVo = atrService.selectByPostNo(postList_no);
		model.addAttribute("atrVo", atrVo);
		
		return "attraction/attractionDelete";
	}
	
	// 관광지 정보가 실제 삽입되는 코드
	@RequestMapping("/atrDelete/{postList_no}")
	public String DeleteAttaractionData(@PathVariable("postList_no")int postList_no,
										Model model)
	{
		atrService.delete(postList_no);
		
		return "redirect:/attraction/atrAllList"; // 절대경로
	}
	
	// 관광지 정보 수정 jsp 가져온다
	@RequestMapping("/atrModifyform/{postList_no}")
	public String getAttractionModifyForm(@PathVariable("postList_no")int postList_no,
										  Model model)
	{
		AttractionVo atrVo = atrService.selectByPostNo(postList_no);
		model.addAttribute("atrVo", atrVo);
		
		return "attraction/attractionModify";
	}
	
	@RequestMapping("/atrModify/{postList_no}")
	public String ModifyAttractionData(@PathVariable("postList_no")int postList_no,
									   @ModelAttribute AttractionVo atrVo)
	{
		atrService.modify(postList_no, atrVo);
		
		return "redirect:/attraction/atrAllList";
	}
}
