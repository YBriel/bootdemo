package com.boot.bootdemo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import com.sun.org.apache.xpath.internal.operations.String;
import lombok.Data;
import org.apache.ibatis.executor.result.DefaultResultHandler;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * author: yuzq
 * create: 2020-10-24 17:04
 **/
@Data
@TableName("hobby")
@Component
public class Hobby {

    private int id;
    private String name;
    private String hobby;

    public   void getMyHobby(){
        SqlSession sqlSession = SqlHelper.FACTORY.openSession();
        Object o = sqlSession.selectOne("select name from hobby where id=1", new DefaultResultHandler());
        System.out.println(o);
    }

    public void test(){
        SqlSession sqlSession = SqlHelper.sqlSession(Hobby.class);
        //sqlSession.getConnection().prepareStatement()
        Object o = sqlSession.selectOne("select name from hobby where id=1");
        System.out.println(o);
    }

    /**
     * 有问题
     * @throws SQLException
     */
    public void test1() throws SQLException {
        SqlSession sqlSession = SqlHelper.sqlSession(Hobby.class);
        PreparedStatement preparedStatement = sqlSession.getConnection().prepareStatement("select name from hobby where id=1");
        ResultSet resultSet = preparedStatement.executeQuery();
        byte name = resultSet.getByte("name");
        Object o = sqlSession.selectOne("select name from hobby where id=1");
        System.out.println(o);
    }



}
