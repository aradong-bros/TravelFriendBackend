package com.estsoft.futures.aradongbros.travelfriend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estsoft.futures.aradongbros.travelfriend.dao.TrainDao;
import com.estsoft.futures.aradongbros.travelfriend.vo.TrainCategoryVo;
import com.estsoft.futures.aradongbros.travelfriend.vo.TrainInfoVo;
import com.estsoft.futures.aradongbros.travelfriend.vo.TrainLineVo;
import com.estsoft.futures.aradongbros.travelfriend.vo.TrainStationVo;

@Service
public class TrainService
{
	@Autowired
	private TrainDao trainDao;

	public List<TrainStationVo> getTrainStationList() 
	{
		List<TrainStationVo> trainStationList = trainDao.selectTrainStationList();
		
		return trainStationList;
	}
	
	public List<TrainInfoVo> getTrainInfoList()
	{
		List<TrainInfoVo> trainInfoList = trainDao.selectTrainInfoList();
		
		return trainInfoList;
	}
	
	public List<TrainLineVo> getTrainLineList() 
	{
		List<TrainLineVo> trainLineList = trainDao.selectTrainLineList();
		
		return trainLineList;
	}
	
	public List<TrainCategoryVo> getTrainCategoryList() 
	{
		List<TrainCategoryVo> trainCategoryList = trainDao.selectTrainCategoryList();
		
		return trainCategoryList;
	}

	public void insertTrainStationData(TrainStationVo trainStationVo) 
	{
		trainDao.insertTrainStationData(trainStationVo);
	}
	
	public void insertTrainInfoData(TrainInfoVo trainInfoVo)
	{
		trainDao.insertTrainInfoData(trainInfoVo);
	}
	
	public void insertTrainInfoData(TrainLineVo trainLineVo) 
	{
		trainDao.insertTrainLineData(trainLineVo);
	}
	
	public void insertTrainCategoryData(TrainCategoryVo trainCategoryVo) 
	{
		trainDao.insertTrainCategoryData(trainCategoryVo);
	}

	public void deleteTrainStationData(int no) 
	{
		trainDao.deleteTrainStationData(no);
	}
	
	public void deleteTrainInfoData(int no) 
	{
		trainDao.deleteTrainInfoData(no);
	}
	
	public void deleteTrainLineData(int no) 
	{
		trainDao.deleteTrainLineData(no);
	}
	
	public void deleteTrainCategoryData(int no) 
	{
		trainDao.deleteTrainCategoryData(no);
	}

	public TrainStationVo selectTrainStationByNo(int no) 
	{
		TrainStationVo trainStationVo = trainDao.selectTrainStationByNo(no);
		
		return trainStationVo;
	}
	
	public TrainInfoVo selectTrainInfoByNo(int no)
	{
		TrainInfoVo trainInfoVo = trainDao.selectTrainInfoByNo(no);
		
		return trainInfoVo;
	}
	
	public TrainLineVo selectTrainLineByNo(int no) 
	{
		TrainLineVo trainLineVo = trainDao.selectTrainLineByNo(no);
		
		return trainLineVo;
	}
	
	public TrainCategoryVo selectTrainCategoryByNo(int no) 
	{
		TrainCategoryVo trainCategoryVo = trainDao.selectTrainCategoryByNo(no);
		
		return trainCategoryVo;
	}

	public void modifyTrainStationData(TrainStationVo trainStationVo, int no) 
	{
		trainDao.modifyTrainStationData(trainStationVo, no);
	}

	public void modifyTrainInfoData(TrainInfoVo trainInfoVo, int no) 
	{
		trainDao.modifyTrainInfoData(trainInfoVo, no);
	}

	public void modifyTrainLineData(TrainLineVo trainLineVo, int no) 
	{
		trainDao.modifyTrainLineData(trainLineVo, no);
	}

	public void modifyTrainCategoryData(TrainCategoryVo trainCategoryVo, int no) 
	{
		trainDao.modifyTrainCategoryData(trainCategoryVo, no);
	}
}