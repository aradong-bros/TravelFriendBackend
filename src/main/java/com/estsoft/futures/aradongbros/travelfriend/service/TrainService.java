package com.estsoft.futures.aradongbros.travelfriend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estsoft.futures.aradongbros.travelfriend.dao.TrainDao;
import com.estsoft.futures.aradongbros.travelfriend.vo.TrainInfoVo;
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

	public void insertTrainStationData(TrainStationVo trainStationVo) 
	{
		trainDao.insertTrainStationData(trainStationVo);
	}

	public void deleteTrainStationData(int no) 
	{
		trainDao.deleteTrainStationData(no);
	}

	public TrainStationVo selectTrainStationByNo(int no) 
	{
		TrainStationVo trainStationVo = trainDao.selectTrainStationByNo(no);
		
		return trainStationVo;
	}

	public void modifyTrainStationData(TrainStationVo trainStationVo, int no) {
		trainDao.modifyTrainStationData(trainStationVo, no);
	}
}