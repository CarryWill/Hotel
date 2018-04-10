package com.cs.test;

import com.cskaoyan.bean.User;
import com.cskaoyan.dao.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

public class MyBatisTest {


    SqlSessionFactory sqlSessionFactory ;
    UserMapper dao;
    SqlSession sqlSession;
    //在任何一个测试方法之前执行
    @Before
    public void before() throws Exception {
        //加载配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        sqlSession = sqlSessionFactory.openSession();
        dao = sqlSession.getMapper(UserMapper.class);
    }


    @After
    public void After(){
        sqlSession.commit();
        sqlSession.close();
    }


    @Test
    public void test1(){

        User user = dao.queryUserByPrimaryKey(12);

        System.out.println("user="+user);

    }

}
