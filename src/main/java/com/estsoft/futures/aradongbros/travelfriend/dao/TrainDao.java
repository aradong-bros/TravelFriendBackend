package com.estsoft.futures.aradongbros.travelfriend.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.estsoft.futures.aradongbros.travelfriend.vo.TrainInfoVo;
import com.estsoft.futures.aradongbros.travelfriend.vo.TrainStationVo;

@Repository
public class TrainDao
{
	@Autowired
	private SqlSession sqlSession;

	public List<TrainStationVo> selectTrainStationList() 
	{
		List<TrainStationVo> trainStationList = sqlSession.selectList("train.selectTrainStation");
		
		return trainStationList;
	}
	
	public List<TrainInfoVo> selectTrainInfoList()
	{
		List<TrainInfoVo> trainInfoVoList = sqlSession.selectList("train.selectTrainInfo");
		
		return trainInfoVoList;
	}

	public void insertTrainStationData(TrainStationVo trainStationVo) 
	{
		sqlSession.insert("train.insertTrainStation", trainStationVo);
	}

	public void deleteTrainStationData(int no) 
	{
		sqlSession.delete("train.deleteTrainStation", no);
	}

	public TrainStationVo selectTrainStationByNo(int no) 
	{
		System.out.println(no);
		TrainStationVo trainStationVo = sqlSession.selectOne("train.selectTrainStationByNo", no);
		
		return trainStationVo;
	}

	public void modifyTrainStationData(TrainStationVo trainStationVo, int no) 
	{
		Map<String, Object> map = new HashMap<>();
		map.put("trainStationVo", trainStationVo);
		map.put("no", no);
		
		sqlSession.update("train.modifyTrainStation", map);
	}
}
