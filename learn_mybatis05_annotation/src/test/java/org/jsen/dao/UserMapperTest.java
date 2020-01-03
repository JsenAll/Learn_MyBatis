package org.jsen.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.jsen.pojo.User;
import org.jsen.utils.MybatisUtils;
import org.junit.Test;

import java.util.List;


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
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.selectUser();
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            System.out.println(user.toString());

            logger.info(
                    user.toString());
        }

        sqlSession.close();
    }


    @Test
    public void selectUserById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectUserById(1);
        logger.debug(user.toString());
    }
}