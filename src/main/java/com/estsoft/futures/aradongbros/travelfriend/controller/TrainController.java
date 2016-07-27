package com.estsoft.futures.aradongbros.travelfriend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.estsoft.futures.aradongbros.travelfriend.service.TrainService;
import com.estsoft.futures.aradongbros.travelfriend.vo.TrainCategoryVo;
import com.estsoft.futures.aradongbros.travelfriend.vo.TrainInfoVo;
import com.estsoft.futures.aradongbros.travelfriend.vo.TrainLineVo;
import com.estsoft.futures.aradongbros.travelfriend.vo.TrainStationVo;

@Controller
@RequestMapping("/train")
public class TrainController 
{
	@Autowired
	private TrainService trainService;
	
	//역 조회 페이지
	@RequestMapping(value = {"", "/trainStation"})
	public String getTrainStationList(Model model)
	{
		List<TrainStationVo> trainStationList = trainService.getTrainStationList();
		model.addAttribute("trainStationList", trainStationList);
		return "/train/trainStationList";
	}
	
	//기차 조회 페이지
	@RequestMapping("/trainInfo")
	public String getTrainInfo(Model model)
	{
		List<TrainInfoVo> trainInfoList = trainService.getTrainInfoList();
		model.addAttribute("trainInfoList", trainInfoList);
		return "/train/trainInfoList";
	}
	
	//노선 조회 페이지
	@RequestMapping("/trainLine")
	public String getTrainLine(Model model)
	{
		List<TrainLineVo> trainLineList = trainService.getTrainLineList();
		model.addAttribute("trainLineList", trainLineList);
		return "/train/trainLineList";
	}
	
	//카테고리 조회 페이지
	@RequestMapping("/trainCategory")
	public String getTrainCategory(Model model)
	{
		List<TrainCategoryVo> trainCategoryList = trainService.getTrainCategoryList();
		model.addAttribute("trainCategoryList", trainCategoryList);
		return "/train/trainCategoryList";
	}
	
	//역 추가 페이지
	@RequestMapping("/trainStationInsertform")
	public String getTrainStationInsertForm()
	{
		return "/train/trainStationInsert";
	}
	
	//기차 추가 페이지
	@RequestMapping("/trainInfoInsertform")
	public String getTrainInfoInsertForm()
	{
		return "/train/trainInfoInsert";
	}
	
	//노선 추가 페이지
	@RequestMapping("/trainLineInsertform")
	public String getTrainLineInsertForm()
	{
		return "/train/trainLineInsert";
	}
	
	//카테고리 추가 페이지
	@RequestMapping("/trainCategoryInsertform")
	public String getTrainCategoryInsertForm()
	{
		return "/train/trainCategoryInsert";
	}
	
	//역 추가 처리
	@RequestMapping("/trainStationInsert")
	public String insertTrainStationData(@ModelAttribute TrainStationVo trainStationVo)
	{
		trainService.insertTrainStationData(trainStationVo);
		
		return "redirect:/train";
	}
	
	//기차 추가 처리
	@RequestMapping("/trainInfoInsert")
	public String insertTrainInfoData(@ModelAttribute TrainInfoVo trainInfoVo)
	{
		trainService.insertTrainInfoData(trainInfoVo);
		
		return "redirect:/train/trainInfo";
	}
	
	//노선 추가 처리
	@RequestMapping("/trainLineInsert")
	public String insertTrainLineData(@ModelAttribute TrainLineVo trainLineVo)
	{
		trainService.insertTrainInfoData(trainLineVo);
		
		return "redirect:/train/trainLine";
	}
	
	//카테고리 추가 처리
	@RequestMapping("/trainCategoryInsert")
	public String insertTrainCategoryData(@ModelAttribute TrainCategoryVo trainCategoryVo)
	{
		trainService.insertTrainCategoryData(trainCategoryVo);
		
		return "redirect:/train/trainCategory";
	}
	
	//역 삭제 처리
	@RequestMapping("/trainStationDelete/{no}")
	public String deleteTrainStationData(@PathVariable("no")int no)
	{
		trainService.deleteTrainStationData(no);
		
		return "redirect:/train";
	}
	
	//기차 삭제 처리
	@RequestMapping("/trainInfoDelete/{no}")
	public String deleteTrainInfoData(@PathVariable("no")int no)
	{
		trainService.deleteTrainInfoData(no);
		
		return "redirect:/train/trainInfo";
	}
	
	//노선 삭제 처리
	@RequestMapping("/trainLineDelete/{no}")
	public String deleteTrainLineData(@PathVariable("no")int no)
	{
		trainService.deleteTrainLineData(no);
		
		return "redirect:/train/trainLine";
	}
	
	//카테고리 삭제 처리
	@RequestMapping("/trainCategoryDelete/{no}")
	public String deleteTrainCategoryData(@PathVariable("no")int no)
	{
		trainService.deleteTrainCategoryData(no);
		
		return "redirect:/train/trainCategory";
	}
	
	//역 수정 페이지
	@RequestMapping("/trainStationModifyform/{no}")
	public String getTrainStationModifyForm(@PathVariable("no")int no, Model model)
	{
		TrainStationVo trainStationVo = trainService.selectTrainStationByNo(no);
		model.addAttribute("trainStationVo", trainStationVo);
		
		return "train/trainStationModify";
	}
	
	//기차 수정 페이지
	@RequestMapping("/trainInfoModifyform/{no}")
	public String getTrainInfoModifyForm(@PathVariable("no")int no, Model model)
	{
		TrainInfoVo trainInfoVo = trainService.selectTrainInfoByNo(no);
		model.addAttribute("trainInfoVo", trainInfoVo);
		
		return "train/trainInfoModify";
	}
	
	//노선 수정 페이지
	@RequestMapping("/trainLineModifyform/{no}")
	public String getTrainLineModifyForm(@PathVariable("no")int no, Model model)
	{
		TrainLineVo trainLineVo = trainService.selectTrainLineByNo(no);
		model.addAttribute("trainLineVo", trainLineVo);
		
		return "train/trainLineModify";
	}
	
	//카테고리 수정 페이지
	@RequestMapping("/trainCategoryModifyform/{no}")
	public String getTrainCategoryModifyForm(@PathVariable("no")int no, Model model)
	{
		TrainCategoryVo trainCategoryVo = trainService.selectTrainCategoryByNo(no);
		model.addAttribute("trainCategoryVo", trainCategoryVo);
		
		return "train/trainCategoryModify";
	}
	
	//역 수정 처리
	@RequestMapping("/trainStationModify/{no}")
	public String modifyTrainStationData(@PathVariable("no")int no, 
									   @ModelAttribute TrainStationVo trainStationVo)
	{
		trainService.modifyTrainStationData(trainStationVo, no);
		
		return "redirect:/train";
	}
	
	//기차 수정 처리
	@RequestMapping("/trainInfoModify/{no}")
	public String modifyTrainInfoData(@PathVariable("no")int no,
									@ModelAttribute TrainInfoVo trainInfoVo)
	{
		trainService.modifyTrainInfoData(trainInfoVo, no);
		
		return "redirect:/train/trainInfo";
	}
	
	//노선 수정 처리
	@RequestMapping("/trainLineModify/{no}")
	public String modifyTrainLineData(@PathVariable("no")int no,
									@ModelAttribute TrainLineVo trainLineVo)
	{
		trainService.modifyTrainLineData(trainLineVo, no);
		
		return "redirect:/train/trainLine";
	}
	
	//카테고리 수정 처리
	@RequestMapping("/trainCategoryModify/{no}")
	public String modifyTrainCategoryData(@PathVariable("no")int no,
										@ModelAttribute TrainCategoryVo trainCategoryVo)
	{
		trainService.modifyTrainCategoryData(trainCategoryVo, no);
		
		return "redirect:/train/trainCategory";
	}
}
