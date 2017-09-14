package com.smvd.test;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.smvd.dao.BaseDao;
import com.smvd.pojo.User;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class AppTest extends TestCase{

	public AppTest( String testName ){
		super( testName );
	}
	public static Test suite(){
		return new TestSuite( AppTest.class );
	}

	public void testApp() throws SQLException {
		ApplicationContext ac = new ClassPathXmlApplicationContext( "spring-mybatis.xml" );
		assertNotNull( ac.getBean("dataSource") );
		DataSource ds=(DataSource)ac.getBean("dataSource");
		System.out.println( ds.getConnection() );
	}

	public void testApp2() throws SQLException {
		ApplicationContext ac = new ClassPathXmlApplicationContext( "spring-mybatis.xml" );
		assertNotNull( ac.getBean("sqlSessionFactory") );
		SqlSessionFactory ds=(SqlSessionFactory)ac.getBean("sqlSessionFactory");
		System.out.println( ds );
	}

	public void testApp3() throws SQLException {
		ApplicationContext ac = new ClassPathXmlApplicationContext( "spring-mybatis.xml" );
		//assertNotNull( ac.getBean("baseDaoMybatisImpl") );
		
		BaseDao bd=(BaseDao) ac.getBean("baseDaoMybatisImpl");
		User user=new User();
		List<User> list=bd.findAll(user,"findAll");
		for (User p : list) {
			System.out.println( p );
		}
	}

}









