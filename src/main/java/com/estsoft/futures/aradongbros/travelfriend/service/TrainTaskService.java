package com.estsoft.futures.aradongbros.travelfriend.service;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estsoft.futures.aradongbros.travelfriend.dao.TrainDao;
import com.estsoft.futures.aradongbros.travelfriend.dao.TrainTaskDao;
import com.estsoft.futures.aradongbros.travelfriend.vo.TrainInfoVo;
import com.estsoft.futures.aradongbros.travelfriend.vo.TrainOperationRouteVo;

@Service
public class TrainTaskService 
{
	@Autowired
	private TrainTaskDao trainTaskDao;
	@Autowired
	private TrainDao trainDao;

	public List<Map<String, Object>> getTrainTimeList(String startStation, String endStation, Date goDate) 
	{
		int startStationNo = getStationNo(startStation);
		int endStationNo = getStationNo(endStation);
		int weekdayNo = getCategoryNo(goDate);
		
		List<TrainOperationRouteVo> trainTimeList = trainTaskDao.getTrainTimeList(startStationNo, endStationNo, 1);
		
		switch (weekdayNo) {
		case 6:
		case 7:
		case 1:
		case 2:
			trainTimeList.addAll(trainTaskDao.getTrainTimeList(startStationNo, endStationNo, 2));
			break;
		case 3:
			trainTimeList.addAll(trainTaskDao.getTrainTimeList(startStationNo, endStationNo, 2));
			trainTimeList.addAll(trainTaskDao.getTrainTimeList(startStationNo, endStationNo, 3));
			trainTimeList.addAll(trainTaskDao.getTrainTimeList(startStationNo, endStationNo, 4));
			break;
		case 4:
			trainTimeList.addAll(trainTaskDao.getTrainTimeList(startStationNo, endStationNo, 3));
			trainTimeList.addAll(trainTaskDao.getTrainTimeList(startStationNo, endStationNo, 4));
			trainTimeList.addAll(trainTaskDao.getTrainTimeList(startStationNo, endStationNo, 5));
			trainTimeList.addAll(trainTaskDao.getTrainTimeList(startStationNo, endStationNo, 6));
			break;
		case 5:
			trainTimeList.addAll(trainTaskDao.getTrainTimeList(startStationNo, endStationNo, 3));
			trainTimeList.addAll(trainTaskDao.getTrainTimeList(startStationNo, endStationNo, 5));
			trainTimeList.addAll(trainTaskDao.getTrainTimeList(startStationNo, endStationNo, 7));
			break;
		default:
			break;
		}
		
		if(trainTimeList.size()==0 || trainTimeList == null) return null;
		
		List<Map<String, Object>> mappedTrainTimeList = new ArrayList<>();
		
		for(int i=0; i<trainTimeList.size(); i+=2){
			TrainOperationRouteVo startVo = trainTimeList.get(i);
			TrainOperationRouteVo endVo = trainTimeList.get(i+1);
			TrainInfoVo trainInfoVo = trainDao.selectTrainInfoByNo(startVo.getTrainInfo_no());
			
			if(startVo.getTrainInfo_no() != endVo.getTrainInfo_no()) return null;
			if(startVo.getTrainStation_no() != startStationNo) continue;
			
			Map<String, Object> map = new HashMap<>();
			map.put("startStationName", trainTaskDao.getStationName(startVo.getTrainStation_no()));
			map.put("endStationName", trainTaskDao.getStationName(endVo.getTrainStation_no()));
			map.put("departureTime", startVo.getDepartureTime());
			map.put("arrivalTime", endVo.getDepartureTime());
			map.put("trainNum", trainInfoVo.getTrainNum());
			map.put("trainModel", trainInfoVo.getTrainModel());
			
			int startHour = startVo.getDepartureTime().getHours();
			int startMinut = startVo.getDepartureTime().getMinutes();
			int endHour = endVo.getDepartureTime().getHours();
			int endMinut = endVo.getDepartureTime().getMinutes();
			int startTime = (startHour*60) + startMinut;
			int endTime = (endHour*60) + endMinut;
			if(startTime > endTime) endTime += (24*60);
			int operationTime = endTime - startTime;
			map.put("operationTime", new Time(operationTime/60, operationTime%60, 0));
			
			mappedTrainTimeList.add(map);
		}
		
		return mappedTrainTimeList;
	}
	
	public Integer getStationNo(String stationName)
	{
		Integer no = trainTaskDao.getStationNo(stationName);
		
		if(no == null || no == 0) return 0;
		else return no;
	}
	
	public Integer getCategoryNo(Date goDate)
	{
		Calendar c = Calendar.getInstance();
		c.setTime(goDate);
		Integer dayOfWeek = c.get(Calendar.DAY_OF_WEEK); //수요일부터 1, 목2, 금3, 토4, 일5, 월6, 화7
		return dayOfWeek;
	}
}
