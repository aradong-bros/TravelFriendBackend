package com.estsoft.futures.aradongbros.travelfriend.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.estsoft.futures.aradongbros.travelfriend.dao.AttractionDao;
import com.estsoft.futures.aradongbros.travelfriend.vo.AttractionVo;

@Service
public class AttractionService 
{
	@Autowired
	private AttractionDao atrDao;
	
	public List<AttractionVo> selectList()
	{
		List<AttractionVo> atrList = atrDao.selectList();
		
		return atrList;
	}
	
	public AttractionVo selectByPostNo(int postList_no)
	{
		AttractionVo atrVo = atrDao.selectByPostNo(postList_no);
		
		return atrVo;
	}
	
	public List<AttractionVo> selectListByCityNo(int cityList_no)
	{
		List<AttractionVo> atrList = atrDao.selectListByCityNo(cityList_no);
		
		return atrList;
	}
	
	public void insert(AttractionVo atrVo)
	{
		atrDao.insert(atrVo);
	}
	
	public void delete(int postList_no)
	{
		atrDao.delete(postList_no);
	}
	
	public void modify(int postList_no, AttractionVo atrVo)
	{
		atrDao.modify(postList_no, atrVo);
	}
}
