package com.estsoft.futures.aradongbros.travelfriend.service;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
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
		
		List<TrainOperationRouteVo> trainStartTimeList = trainTaskDao.getStartTrainTimeList(startStationNo, endStationNo, 1);
		List<TrainOperationRouteVo> trainEndTimeList = trainTaskDao.getEndTrainTimeList(startStationNo, endStationNo, 1);
		
		switch (weekdayNo) {
		case 6: //월요일
		case 7: //화요일
		case 1: //수요일
		case 2: //목요일
			trainStartTimeList.addAll(trainTaskDao.getStartTrainTimeList(startStationNo, endStationNo, 2));
			trainEndTimeList.addAll(trainTaskDao.getEndTrainTimeList(startStationNo, endStationNo, 2));
			break;
		case 3: //금요일
			trainStartTimeList.addAll(trainTaskDao.getStartTrainTimeList(startStationNo, endStationNo, 2));
			trainEndTimeList.addAll(trainTaskDao.getEndTrainTimeList(startStationNo, endStationNo, 2));
			
			trainStartTimeList.addAll(trainTaskDao.getStartTrainTimeList(startStationNo, endStationNo, 3));
			trainEndTimeList.addAll(trainTaskDao.getEndTrainTimeList(startStationNo, endStationNo, 3));
			
			trainStartTimeList.addAll(trainTaskDao.getStartTrainTimeList(startStationNo, endStationNo, 4));
			trainEndTimeList.addAll(trainTaskDao.getEndTrainTimeList(startStationNo, endStationNo, 4));
			break;
		case 4: //토요일
			trainStartTimeList.addAll(trainTaskDao.getStartTrainTimeList(startStationNo, endStationNo, 3));
			trainEndTimeList.addAll(trainTaskDao.getEndTrainTimeList(startStationNo, endStationNo, 3));
			
			trainStartTimeList.addAll(trainTaskDao.getStartTrainTimeList(startStationNo, endStationNo, 4));
			trainEndTimeList.addAll(trainTaskDao.getEndTrainTimeList(startStationNo, endStationNo, 4));
			
			trainStartTimeList.addAll(trainTaskDao.getStartTrainTimeList(startStationNo, endStationNo, 5));
			trainEndTimeList.addAll(trainTaskDao.getEndTrainTimeList(startStationNo, endStationNo, 5));
			
			trainStartTimeList.addAll(trainTaskDao.getStartTrainTimeList(startStationNo, endStationNo, 6));
			trainEndTimeList.addAll(trainTaskDao.getEndTrainTimeList(startStationNo, endStationNo, 6));
			break;
		case 5: //일요일
			trainStartTimeList.addAll(trainTaskDao.getStartTrainTimeList(startStationNo, endStationNo, 3));
			trainEndTimeList.addAll(trainTaskDao.getEndTrainTimeList(startStationNo, endStationNo, 3));
			
			trainStartTimeList.addAll(trainTaskDao.getStartTrainTimeList(startStationNo, endStationNo, 5));
			trainEndTimeList.addAll(trainTaskDao.getEndTrainTimeList(startStationNo, endStationNo, 5));
			
			trainStartTimeList.addAll(trainTaskDao.getStartTrainTimeList(startStationNo, endStationNo, 7));
			trainEndTimeList.addAll(trainTaskDao.getEndTrainTimeList(startStationNo, endStationNo, 7));
			break;
		default: //?
			break;
		}
		
		if(trainStartTimeList.size()==0 || 
				trainStartTimeList == null || 
				trainStartTimeList.size() != trainEndTimeList.size()){
			return null;
		}
		
		List<Map<String, Object>> mappedTrainTimeList = new ArrayList<>();
		
		for(int i=0; i<trainStartTimeList.size(); i++){
			TrainInfoVo trainInfoVo = trainDao.selectTrainInfoByNo(trainStartTimeList.get(i).getTrainInfo_no());
			
			Map<String, Object> map = new HashMap<>();
			map.put("startStationName", trainTaskDao.getStationName(trainStartTimeList.get(i).getTrainStation_no()));
			map.put("endStationName", trainTaskDao.getStationName(trainEndTimeList.get(i).getTrainStation_no()));
			map.put("departureTime", trainStartTimeList.get(i).getDepartureTime());
			map.put("arrivalTime", trainEndTimeList.get(i).getDepartureTime());
			map.put("trainNum", trainInfoVo.getTrainNum());
			map.put("trainModel", trainInfoVo.getTrainModel());
			
			int startHour = trainStartTimeList.get(i).getDepartureTime().getHours();
			int startMinut = trainStartTimeList.get(i).getDepartureTime().getMinutes();
			int endHour = trainEndTimeList.get(i).getDepartureTime().getHours();
			int endMinut = trainEndTimeList.get(i).getDepartureTime().getMinutes();
			int startTime = (startHour*60) + startMinut;
			int endTime = (endHour*60) + endMinut;
			if(startTime > endTime) endTime += (24*60);
			int operationTime = endTime - startTime;
			map.put("operationTime", new Time(operationTime/60, operationTime%60, 0));
			
			mappedTrainTimeList.add(map);
		}
		
		return mappedTrainTimeList;
	}
	
	public List<Map<String, Object>> getFastAndEarlyTrainTimeList(String startStation, String endStation, Date goDate)
	{
		int startStationNo = getStationNo(startStation);
		int endStationNo = getStationNo(endStation);
		int weekdayNo = getCategoryNo(goDate);
		
		List<TrainOperationRouteVo> trainStartTimeList = trainTaskDao.getStartFastAndEarlyTrainTimeList(startStationNo, endStationNo, 1);
		List<TrainOperationRouteVo> trainEndTimeList = trainTaskDao.getEndFastAndEarlyTrainTimeList(startStationNo, endStationNo, 1);
		
		switch (weekdayNo) {
		case 6: //월요일
		case 7: //화요일
		case 1: //수요일
		case 2: //목요일
			trainStartTimeList.addAll(trainTaskDao.getStartFastAndEarlyTrainTimeList(startStationNo, endStationNo, 2));
			trainEndTimeList.addAll(trainTaskDao.getEndFastAndEarlyTrainTimeList(startStationNo, endStationNo, 2));
			break;
		case 3: //금요일
			trainStartTimeList.addAll(trainTaskDao.getStartFastAndEarlyTrainTimeList(startStationNo, endStationNo, 2));
			trainEndTimeList.addAll(trainTaskDao.getEndFastAndEarlyTrainTimeList(startStationNo, endStationNo, 2));
			
			trainStartTimeList.addAll(trainTaskDao.getStartFastAndEarlyTrainTimeList(startStationNo, endStationNo, 3));
			trainEndTimeList.addAll(trainTaskDao.getEndFastAndEarlyTrainTimeList(startStationNo, endStationNo, 3));
			
			trainStartTimeList.addAll(trainTaskDao.getStartFastAndEarlyTrainTimeList(startStationNo, endStationNo, 4));
			trainEndTimeList.addAll(trainTaskDao.getEndFastAndEarlyTrainTimeList(startStationNo, endStationNo, 4));
			break;
		case 4: //토요일
			trainStartTimeList.addAll(trainTaskDao.getStartFastAndEarlyTrainTimeList(startStationNo, endStationNo, 3));
			trainEndTimeList.addAll(trainTaskDao.getEndFastAndEarlyTrainTimeList(startStationNo, endStationNo, 3));
			
			trainStartTimeList.addAll(trainTaskDao.getStartFastAndEarlyTrainTimeList(startStationNo, endStationNo, 4));
			trainEndTimeList.addAll(trainTaskDao.getEndFastAndEarlyTrainTimeList(startStationNo, endStationNo, 4));
			
			trainStartTimeList.addAll(trainTaskDao.getStartFastAndEarlyTrainTimeList(startStationNo, endStationNo, 5));
			trainEndTimeList.addAll(trainTaskDao.getEndFastAndEarlyTrainTimeList(startStationNo, endStationNo, 5));
			
			trainStartTimeList.addAll(trainTaskDao.getStartFastAndEarlyTrainTimeList(startStationNo, endStationNo, 6));
			trainEndTimeList.addAll(trainTaskDao.getEndFastAndEarlyTrainTimeList(startStationNo, endStationNo, 6));
			break;
		case 5: //일요일
			trainStartTimeList.addAll(trainTaskDao.getStartFastAndEarlyTrainTimeList(startStationNo, endStationNo, 3));
			trainEndTimeList.addAll(trainTaskDao.getEndFastAndEarlyTrainTimeList(startStationNo, endStationNo, 3));
			
			trainStartTimeList.addAll(trainTaskDao.getStartFastAndEarlyTrainTimeList(startStationNo, endStationNo, 5));
			trainEndTimeList.addAll(trainTaskDao.getEndFastAndEarlyTrainTimeList(startStationNo, endStationNo, 5));
			
			trainStartTimeList.addAll(trainTaskDao.getStartFastAndEarlyTrainTimeList(startStationNo, endStationNo, 7));
			trainEndTimeList.addAll(trainTaskDao.getEndFastAndEarlyTrainTimeList(startStationNo, endStationNo, 7));
			break;
		default: //?
			break;
		}
		
		if(trainStartTimeList.size()==0 || 
				trainStartTimeList == null || 
				trainStartTimeList.size() != trainEndTimeList.size()){
			return null;
		}
		
		List<Map<String, Object>> mappedTrainTimeList = new ArrayList<>();
		
		for(int i=0; i<trainStartTimeList.size(); i++){
			TrainInfoVo trainInfoVo = trainDao.selectTrainInfoByNo(trainStartTimeList.get(i).getTrainInfo_no());
			
			Map<String, Object> map = new HashMap<>();
			map.put("startStationName", trainTaskDao.getStationName(trainStartTimeList.get(i).getTrainStation_no()));
			map.put("endStationName", trainTaskDao.getStationName(trainEndTimeList.get(i).getTrainStation_no()));
			map.put("departureTime", trainStartTimeList.get(i).getDepartureTime());
			map.put("arrivalTime", trainEndTimeList.get(i).getDepartureTime());
			map.put("trainNum", trainInfoVo.getTrainNum());
			map.put("trainModel", trainInfoVo.getTrainModel());
			
			int startHour = trainStartTimeList.get(i).getDepartureTime().getHours();
			int startMinut = trainStartTimeList.get(i).getDepartureTime().getMinutes();
			int endHour = trainEndTimeList.get(i).getDepartureTime().getHours();
			int endMinut = trainEndTimeList.get(i).getDepartureTime().getMinutes();
			int startTime = (startHour*60) + startMinut;
			int endTime = (endHour*60) + endMinut;
			if(startTime > endTime) endTime += (24*60);
			int operationTime = endTime - startTime;
			map.put("operationTime", new Time(operationTime/60, operationTime%60, 0));
			
			mappedTrainTimeList.add(map);
		}
		
		Collections.sort(mappedTrainTimeList, new DepTimeASCCompare());
		
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
	
	static class DepTimeASCCompare implements Comparator<Map<String,Object>>{
		@Override
		public int compare(Map<String, Object> o1, Map<String, Object> o2) {
			Time t1 = (Time) o1.get("departureTime");
			Time t2 = (Time) o2.get("departureTime");
			return t1.compareTo(t2);
		}
	}
}
