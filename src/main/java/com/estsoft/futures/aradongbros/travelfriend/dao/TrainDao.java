package com.estsoft.futures.aradongbros.travelfriend.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.estsoft.futures.aradongbros.travelfriend.vo.TrainCategoryVo;
import com.estsoft.futures.aradongbros.travelfriend.vo.TrainInfoVo;
import com.estsoft.futures.aradongbros.travelfriend.vo.TrainLineVo;
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
		List<TrainInfoVo> trainInfoList = sqlSession.selectList("train.selectTrainInfo");
		
		return trainInfoList;
	}
	
	public List<TrainLineVo> selectTrainLineList() 
	{
		List<TrainLineVo> trainLineList = sqlSession.selectList("train.selectTrainLine");
		
		return trainLineList;
	}
	
	public List<TrainCategoryVo> selectTrainCategoryList() 
	{
		List<TrainCategoryVo> trainCategoryList = sqlSession.selectList("train.selectTrainCategory");
		
		return trainCategoryList;
	}

	public void insertTrainStationData(TrainStationVo trainStationVo) 
	{
		sqlSession.insert("train.insertTrainStation", trainStationVo);
	}
	
	public void insertTrainInfoData(TrainInfoVo trainInfoVo) 
	{
		sqlSession.insert("train.insertTrainInfo", trainInfoVo);
	}
	
	public void insertTrainLineData(TrainLineVo trainLineVo) 
	{
		sqlSession.insert("train.insertTrainLine", trainLineVo);
	}
	
	public void insertTrainCategoryData(TrainCategoryVo trainCategoryVo) 
	{
		sqlSession.insert("train.insertTrainCategory", trainCategoryVo);
	}

	public void deleteTrainStationData(int no) 
	{
		sqlSession.delete("train.deleteTrainStation", no);
	}
	
	public void deleteTrainInfoData(int no) 
	{
		sqlSession.delete("train.deleteTrainInfo", no);
	}
	
	public void deleteTrainLineData(int no) 
	{
		sqlSession.delete("train.deleteTrainLine", no);
	}
	
	public void deleteTrainCategoryData(int no) 
	{
		sqlSession.delete("train.deleteTrainCategory", no);
	}

	public TrainStationVo selectTrainStationByNo(int no) 
	{
		TrainStationVo trainStationVo = sqlSession.selectOne("train.selectTrainStationByNo", no);
		
		return trainStationVo;
	}
	
	public TrainInfoVo selectTrainInfoByNo(int no) 
	{
		TrainInfoVo trainInfoVo = sqlSession.selectOne("train.selectTrainInfoByNo", no);
		
		return trainInfoVo;
	}
	
	public TrainLineVo selectTrainLineByNo(int no) 
	{
		TrainLineVo trainLineVo = sqlSession.selectOne("train.selectTrainLineByNo", no);
		
		return trainLineVo;
	}
	
	public TrainCategoryVo selectTrainCategoryByNo(int no) 
	{
		TrainCategoryVo trainCategoryVo = sqlSession.selectOne("train.selectTrainCategoryByNo", no);
		
		return trainCategoryVo;
	}

	public void modifyTrainStationData(TrainStationVo trainStationVo, int no) 
	{
		Map<String, Object> map = new HashMap<>();
		map.put("trainStationVo", trainStationVo);
		map.put("no", no);
		
		sqlSession.update("train.modifyTrainStation", map);
	}

	public void modifyTrainInfoData(TrainInfoVo trainInfoVo, int no) 
	{
		Map<String, Object> map = new HashMap<>();
		map.put("trainInfoVo", trainInfoVo);
		map.put("no", no);
		
		sqlSession.update("train.modifyTrainInfo", map);
	}

	public void modifyTrainLineData(TrainLineVo trainLineVo, int no) 
	{
		Map<String, Object> map = new HashMap<>();
		map.put("trainLineVo", trainLineVo);
		map.put("no", no);
		
		sqlSession.update("train.modifyTrainLine", map);
	}

	public void modifyTrainCategoryData(TrainCategoryVo trainCategoryVo, int no) 
	{
		Map<String, Object> map = new HashMap<>();
		map.put("trainCategoryVo", trainCategoryVo);
		map.put("no", no);
		
		sqlSession.update("train.modifyTrainCategory", map);
	}
}
