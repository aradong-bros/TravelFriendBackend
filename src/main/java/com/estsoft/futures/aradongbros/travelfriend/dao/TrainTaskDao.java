package com.estsoft.futures.aradongbros.travelfriend.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.estsoft.futures.aradongbros.travelfriend.vo.TrainOperationRouteVo;
import com.estsoft.futures.aradongbros.travelfriend.vo.TrainStationVo;

@Repository
public class TrainTaskDao 
{
	@Autowired
	private SqlSession sqlSession;

	public List<TrainOperationRouteVo> getStartTrainTimeList(int startStationNo, int endStationNo, int categoryNo) 
	{
		Map<String, Integer> map = new HashMap<>();
		map.put("startStationNo", startStationNo);
		map.put("endStationNo", endStationNo);
		map.put("categoryNo", categoryNo);
		List<TrainOperationRouteVo> trainTimeList = sqlSession.selectList("train_task.selectStartTrainTime", map);
		return trainTimeList;
	}
	
	public List<TrainOperationRouteVo> getEndTrainTimeList(int startStationNo, int endStationNo, int categoryNo) 
	{
		Map<String, Integer> map = new HashMap<>();
		map.put("startStationNo", startStationNo);
		map.put("endStationNo", endStationNo);
		map.put("categoryNo", categoryNo);
		List<TrainOperationRouteVo> trainTimeList = sqlSession.selectList("train_task.selectEndTrainTime", map);
		return trainTimeList;
	}
	
	public List<TrainOperationRouteVo> getStartFastAndEarlyTrainTimeList(int startStationNo, int endStationNo, int categoryNo)
	{
		Map<String, Integer> map = new HashMap<>();
		map.put("startStationNo", startStationNo);
		map.put("endStationNo", endStationNo);
		map.put("categoryNo", categoryNo);
		List<TrainOperationRouteVo> trainTimeList = sqlSession.selectList("train_task.selectStartFastAndEarlyTrainTime", map);
		return trainTimeList;
	}
	
	public List<TrainOperationRouteVo> getEndFastAndEarlyTrainTimeList(int startStationNo, int endStationNo, int categoryNo)
	{
		Map<String, Integer> map = new HashMap<>();
		map.put("startStationNo", startStationNo);
		map.put("endStationNo", endStationNo);
		map.put("categoryNo", categoryNo);
		List<TrainOperationRouteVo> trainTimeList = sqlSession.selectList("train_task.selectEndFastAndEarlyTrainTime", map);
		return trainTimeList;
	}
	
	public Integer getStationNo(String stationName) 
	{
		Integer no = sqlSession.selectOne("train_task.selectStationNo", stationName);
		return no;
	}
	
	public String getStationName(int trainStation_no)
	{
		String stationName = sqlSession.selectOne("train_task.selectStationName", trainStation_no);
		
		return stationName;
	}

	public List<TrainStationVo> getCityStationList(int cityNum) 
	{
		List<TrainStationVo> stationList = sqlSession.selectList("train_task.selectTrainStationByCityNo", cityNum);
		System.out.println(stationList);
		return stationList;
	}
}
