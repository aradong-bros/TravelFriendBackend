package com.estsoft.futures.aradongbros.travelfriend.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estsoft.futures.aradongbros.travelfriend.dao.AttractionDao;
import com.estsoft.futures.aradongbros.travelfriend.vo.AttractionVo;
import com.estsoft.futures.aradongbros.travelfriend.vo.CityListVo;

@Service
public class AttractionService 
{
	@Autowired
	private AttractionDao atrDao;
	
	public Map<String, Object> selectList()
	{
		Map<String, Object> map = atrDao.selectList();
		
		return map;
	}
	
	public AttractionVo selectByPostNo(int no)
	{
		AttractionVo atrVo = atrDao.selectByPostNo(no);
		
		return atrVo;
	}
	
	public List<AttractionVo> selectListByCityNo(int cityList_no)
	{
		List<AttractionVo> atrList = atrDao.selectListByCityNo(cityList_no);
		
		return atrList;
	}
	
	public CityListVo selectCLListByCityNo(int cityList_no)
	{
		CityListVo clVo = atrDao.selectCityListVoByCityNo(cityList_no);
		
		return clVo;
	}
	
	public void insert(AttractionVo atrVo)
	{
		atrDao.insert(atrVo);
	}
	
	public void insertBasic(String FilePath)
	{
		atrDao.insertBasic(FilePath);
	}
	
	public void delete(int no)
	{
		atrDao.delete(no);
	}
	
	public void modify(int no, AttractionVo atrVo)
	{
		atrDao.modify(no, atrVo);
	}
}
