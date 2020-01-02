package org.jsen.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.apache.log4j.pattern.LogEvent;
import org.jsen.pojo.User;
import org.jsen.utils.MybatisUtils;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/*
 * @Author Jsen
 * @Time  2019/12/12 19:11
 *
 */
public class UserMapperTest {

    private static Logger logger = Logger.getLogger(UserMapperTest.class);

    @Test
    public void selectUser() {
        //第一步获取SqlSession
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //方式一 最新推荐
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.selectUser();
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            System.out.println(user.toString());

            logger.info("info：进入selectUser方法");
            logger.debug("debug：进入selectUser方法");
//            logger.error("error: 进入selectUser方法");
//            logger.debug(user.toString());
        }

        sqlSession.close();
    }



}