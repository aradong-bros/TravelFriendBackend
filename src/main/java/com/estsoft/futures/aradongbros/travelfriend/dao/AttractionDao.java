package com.estsoft.futures.aradongbros.travelfriend.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.estsoft.futures.aradongbros.travelfriend.vo.AttractionVo;

@Repository
public class AttractionDao 
{	
    @Autowired
    private SqlSession sqlSession;  // mybatis 사용하기위해 선언

    public List<AttractionVo> selectList()
    {
    	List<AttractionVo> atrList = sqlSession.selectList("attraction.selectList");
    	
    	return atrList;
    }
    
    public AttractionVo selectByPostNo(int postList_no)
    {
    	AttractionVo atrVo = sqlSession.selectOne("attraction.selectByPostNo", postList_no);
    	
    	return atrVo;
    }
    
    public List<AttractionVo> selectListByCityNo(int cityList_no)
    {
    	List<AttractionVo> atrList = sqlSession.selectList("attraction.selectByCityNo", cityList_no);
    			
    	return atrList;
    }
    
	public void insert(AttractionVo atrVo)
	{
		sqlSession.insert("attraction.insert", atrVo);
	}
	
	public void delete(int postList_no)
	{
		sqlSession.delete("attraction.delete", postList_no);
	}
	
	public void modify(int postList_no, AttractionVo atrVo)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("postList_no", postList_no);
		map.put("atrVo", atrVo); 
		
		sqlSession.update("attraction.modify", map);
	}
}
