package com.smvd.dao;

import java.util.List;
import java.util.Map;

public interface BaseDao<T> {

	public List<T> findAll( T t,String SqlId );
	
	//针对分页的查询 或者自定义的
	public List<T> find( T t,Map<?, ?> map, String SqlId );
	
	public int add( T t,String SqlId );
	
	//自定义的 map 添加
	public int add( T t, Map<?, ?> map ,String SqlId );
	
	//批量添加的
	public int addMany( T t, List<?> list , String SqlId );
	
	public int del( T t, String SqlId );
	
	public int del( T t, Map<?, ?> map , String SqlId );//delete from 表  where id in (1,2,3);
	
	public int delMany( T t, List<?> list , String SqlId );
	
	public int update( T t, String SqlId );
	
	public int update( T t, Map<?, ?> map , String SqlId ); //update 表  set x=y where id in (1,2,3);
	
	public int updateMany( T t, List<?> list, String SqlId );
	
	//聚合查询
	public double findFunc( T t , String SqlId );// Select count(*) from xxx
	
	//自定义
	public double findFunc( T t ,Map<?, ?> map, String SqlId );
	
}
