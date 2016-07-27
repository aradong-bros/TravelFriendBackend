package com.estsoft.futures.aradongbros.travelfriend.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.estsoft.futures.aradongbros.travelfriend.vo.AttractionVo;
import com.estsoft.futures.aradongbros.travelfriend.vo.Category;
import com.estsoft.futures.aradongbros.travelfriend.vo.CityListVo;

@Repository
public class AttractionDao 
{	
    @Autowired
    private SqlSession sqlSession;  // mybatis 사용하기위해 선언

	public Map<String, Object> selectList()
    {
    	List<AttractionVo> atrList = sqlSession.selectList("attraction.selectList");
    	List<CityListVo> clList = new ArrayList<CityListVo>();
    	
    	for ( int i = 0; i < atrList.size(); i++)
    	{	
    		clList.add(i, sqlSession.selectOne("attraction.selectCityList", atrList.get(i).getCityList_no()));
    	}
    		
    	Map<String, Object> map = new HashMap<String, Object>();
    	map.put("atrList", atrList);
    	map.put("clList", clList);
    	
    	return map;
    }
    
    public AttractionVo selectByPostNo(int no)
    {
    	AttractionVo atrVo = sqlSession.selectOne("attraction.selectByPostNo", no);
    	
    	return atrVo;
    }
    
    public List<AttractionVo> selectListByCityNo(int cityList_no)
    {
    	List<AttractionVo> atrList = sqlSession.selectList("attraction.selectByCityNo", cityList_no);
    			
    	return atrList;
    }
    
    public CityListVo selectCityListVoByCityNo(int cityList_no)
    {
    	CityListVo clVo = sqlSession.selectOne("attraction.selectCityListVoByCityNo", cityList_no);
    	
    	return clVo;
    }
    
	public void insert(AttractionVo atrVo)
	{
		sqlSession.insert("attraction.insert", atrVo);
	}
		
	public void delete(int no)
	{
		sqlSession.delete("attraction.delete", no);
	}
	
	public void modify(int no, AttractionVo atrVo)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("no", no);
		map.put("atrVo", atrVo); 
		
		sqlSession.update("attraction.modify", map);
	}
	
	public void insertBasic(String FilePath)
	{
		ArrayList<AttractionVo> basicAtrList = readBasicFile(FilePath);
		
		for (int i = 0; i < basicAtrList.size(); i++)
		{
			sqlSession.insert("attraction.insertBasicData", basicAtrList.get(i));
		}
	}
	
	public ArrayList<AttractionVo> readBasicFile(String FilePath)
	{
		ArrayList<AttractionVo> list = null;
		
		try {
			list = new ArrayList<AttractionVo>();

			// 파일에서 스트림을 통해 주르륵 읽어들인다
			BufferedReader in = new BufferedReader(new FileReader(FilePath));

			// 요 s에다가 한 줄씩 읽어 올거다
			String s;

			// 반복한다! 언제까지? s에 앞서 읽어온 in이라는 문자 스트림에서 한 줄을 읽어 오는게 실패할 때까지!
			while ((s = in.readLine()) != null) 
			{
				// 그렇게 한 줄 가져와서.. 스플릿으로 조각조각 내 준다. 파싱 기준은 공백인 \t 로 하자
				String[] split = s.split("\t");

				// 아래 변수들은 클래스에 선언되어 있음을 가정한다
				int cityList_no = Integer.valueOf(split[0]);
				String name = split[1];
				String location = split[2];
				String picture = split[3];
				String info = split[4];
				Category category = Enum.valueOf(Category.class ,split[5]);
				String address = split[6];

				AttractionVo attractionVo = new AttractionVo();

				attractionVo.setCityList_no(cityList_no);
				attractionVo.setName(name);
				attractionVo.setLocation(location);
				attractionVo.setPicture(picture);
				attractionVo.setInfo(info);
				attractionVo.setCategory(category);
				attractionVo.setAddress(address);

				// 그 후 적절한 리스트나 자료구조에 투입한다!
				list.add(attractionVo);
			}
			// 다 뽑아먹었으니 버퍼리더를 닫아 준다.
			in.close();

		} 
		catch (IOException e) 
		{

			// 혹시 입출력 에러가 발생했다면 어떤 에러인지 출력하고 끄자.
			System.err.println(e);
			System.exit(1);
		}
		
		return list;
	}
}
