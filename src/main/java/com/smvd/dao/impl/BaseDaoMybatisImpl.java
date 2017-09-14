package com.smvd.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.smvd.dao.BaseDao;

@Repository
public class BaseDaoMybatisImpl<T> extends SqlSessionDaoSupport implements BaseDao<T> {
	private String mapperLocation="com.smvd.mapping.";//mapper文件的包名
	
	@Override
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory( sqlSessionFactory );
	}
	
	//mapper文件的路径：包名.className+Mapper.mapperID
	//com.smvd.mapping.UserMapper.findAll
	private String getMapperId(T t,String SqlId ){
		return mapperLocation+t.getClass().getSimpleName()+"Mapper."+SqlId;
	}
	
	public List<T> findAll(T t,String SqlId) {
		return super.getSqlSession().selectList(  getMapperId(t, SqlId) ,t);
	}
	
	public List<T> find(T t, Map<?, ?> map, String SqlId) {
		return super.getSqlSession().selectList(  getMapperId(t, SqlId) ,map);
	}
	public int add(T t, String SqlId) {
		return super.getSqlSession().insert(  getMapperId(t, SqlId),t );
	}
	public int add(T t, Map<?, ?> map, String SqlId) {
		return super.getSqlSession().insert(  getMapperId(t, SqlId) ,map );
	}
	public int addMany(T t, List<?> list, String SqlId) {
		return super.getSqlSession().insert(  getMapperId(t, SqlId) ,list );
	}
	public int del(T t, String SqlId) {
		return super.getSqlSession().delete(  getMapperId(t, SqlId), t );
	}
	public int del(T t, Map<?, ?> map, String SqlId) {
		return super.getSqlSession().delete(  getMapperId(t, SqlId), map );
	}
	public int delMany(T t, List<?> list, String SqlId) {
		return super.getSqlSession().delete(  getMapperId(t, SqlId), list );
	}
	public int update(T t, String SqlId) {
		return super.getSqlSession().update(  getMapperId(t, SqlId), t );
	}
	public int update(T t, Map<?, ?> map, String SqlId) {
		return super.getSqlSession().update(  getMapperId(t, SqlId), map );
	}
	public int updateMany(T t,List<?> list, String SqlId) {
		return super.getSqlSession().update(  this.getMapperId(t, SqlId), list );
	}
	public double findFunc(T t, String SqlId) {
		return super.getSqlSession().selectOne(  this.getMapperId(t, SqlId) );
	}
	public double findFunc(T t, Map<?, ?> map, String SqlId) {
		return super.getSqlSession().selectOne(  this.getMapperId(t, SqlId), map );
	}

}






