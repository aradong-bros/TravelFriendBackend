package com.estsoft.futures.aradongbros.travelfriend.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.estsoft.futures.aradongbros.travelfriend.vo.TrainOperationRouteVo;

@Repository
public class TrainTaskDao 
{
	@Autowired
	private SqlSession sqlSession;

	public Integer getStationNo(String stationName) 
	{
		Integer no = sqlSession.selectOne("train_task.selectStationNo", stationName);
		return no;
	}

	public List<TrainOperationRouteVo> getTrainTimeList(int startStationNo, int endStationNo, int categoryNo) 
	{
		Map<String, Integer> map = new HashMap<>();
		map.put("startStationNo", startStationNo);
		map.put("endStationNo", endStationNo);
		map.put("categoryNo", categoryNo);
		List<TrainOperationRouteVo> trainTimeList = sqlSession.selectList("train_task.selectTrainTime", map);
		return trainTimeList;
	}
	
	public String getStationName(int trainStation_no)
	{
		String stationName = sqlSession.selectOne("train_task.selectStationName", trainStation_no);
		
		return stationName;
	}
}
