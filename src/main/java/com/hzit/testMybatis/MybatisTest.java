package com.hzit.testMybatis;

import com.hzit.testMybatis.bean.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisTest {

    public static void main(String[] args) throws IOException {

        String resource = "mybatis-config.xml";
        // 指定全局配置文件
        InputStream is = Resources.getResourceAsStream(resource);
        // 读取配置文件
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(is);
        // 构建sqlSessionFactory
        SqlSession ss = ssf.openSession();
        User u = ss.selectOne("MyMapper.selectLaoban" , "3");
       System.out.println(u);
       ss.close();
    }
}
