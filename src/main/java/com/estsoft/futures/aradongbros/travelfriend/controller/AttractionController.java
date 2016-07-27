package com.estsoft.futures.aradongbros.travelfriend.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.plaf.synth.SynthSeparatorUI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.estsoft.futures.aradongbros.travelfriend.service.AttractionService;
import com.estsoft.futures.aradongbros.travelfriend.vo.AttractionVo;
import com.estsoft.futures.aradongbros.travelfriend.vo.CityListVo;

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
		//@PathVariable 은 URL 경로  맨 마지막 /뒤에 붙는 파라미터를 맡는 어노테이션
		
		List<AttractionVo> atrList = atrService.selectListByCityNo(cityList_no);
		CityListVo clVo = atrService.selectCLListByCityNo(cityList_no);
		
		model.addAttribute("atrList", atrList);
		model.addAttribute("clVo", clVo);
		
		return "/attraction/attractionListByCityNo";
	}
	
	// 관광지 전체정보 리스트 가져온다.
	@RequestMapping("/atrAllList")
	public String getAttractionList(Model model)
	{
		Map<String, Object> map = atrService.selectList();
		
		model.addAttribute("map", map);
		
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
		//@ModelAttribute 는 form 태그에서 sumit되는 값들의 name을 해당 객체vo와 비교하여 일치하는 이름에 값 넣어줌. 즉 객체를 받는 어노테이션
		
		atrService.insert(atrVo);
		
		//return "redirect:atrList"; // 상대경로
		return "redirect:/attraction/atrMain"; // 절대경로
	}
	
	// 관광지 정보 삭제 jsp 가져온다
	@RequestMapping("/atrDeleteform/{no}")
	public String getAttractionDeleteForm(@PathVariable("no") int no,
										  Model model)
	{
		AttractionVo atrVo = atrService.selectByPostNo(no);
		CityListVo clVo = atrService.selectCLListByCityNo(atrVo.getCityList_no());
		model.addAttribute("atrVo", atrVo);
		model.addAttribute("clVo", clVo);
		
		return "attraction/attractionDelete";
	}
	
	// 관광지 정보가 실제 삭제되는 코드
	@RequestMapping("/atrDelete/{no}")
	public String DeleteAttaractionData(@PathVariable("no") int no)
	{
		atrService.delete(no);
		
		return "redirect:/attraction/atrMain"; // 절대경로
	}
	
	// 관광지 정보 수정 jsp 가져온다
	@RequestMapping("/atrModifyform/{no}")
	public String getAttractionModifyForm(@PathVariable("no") int no,
										  Model model)
	{
		AttractionVo atrVo = atrService.selectByPostNo(no);
		CityListVo clVo = atrService.selectCLListByCityNo(atrVo.getCityList_no());
		model.addAttribute("clVo", clVo);
		model.addAttribute("atrVo", atrVo);
		
		return "attraction/attractionModify";
	}
	
	@RequestMapping("/atrModify/{no}")
	public String ModifyAttractionData(@PathVariable("no") int no,
									   @ModelAttribute AttractionVo atrVo)
	{
		atrService.modify(no, atrVo);
		
		return "redirect:/attraction/atrMain";
	}
	
	// 기본 데이터 삽입JSP 가져온다 
	@RequestMapping("/atrBasicInsertform")
	public String getBasicDataInsertForm()
	{		
		return "attraction/attractionBasicInsert";
	}
	
	// 기존 데이터가 가 실제 삽입되는 코드
	@RequestMapping("/atrBasicInsert")
	public String insertBasicData(@RequestParam(value="FilePath", required=true, defaultValue="" ) String FilePath)
	{
		// @RequestParam 은 form에서 sumit된 객체가 아닌 변수 하나를 받는 어노테이션, 이때  input태그의 name으로 submit 되므로 이름을 일치 시켜야 한다.
		FilePath.replaceAll("'\'", "/");
		atrService.insertBasic(FilePath);
			
		return "redirect:/attraction/atrMain"; // 절대경로
	}
	
	// 안드로이드 컨트롤러 용
	/*	@RequestMapping("/test")
	@ResponseBody
	public Map<String, Object> afsdfsfd(Model model)
	{
		List<AttractionVo> atrList = atrService.selectList();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", atrList);
		
		return map;
	}*/
}
