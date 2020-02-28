package org.jsen.dao;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
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
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        RowBounds rowBounds = new RowBounds(0, 4);
        List<User> users =sqlSession.selectList("org.jsen.dao.UserMapper.selectUser", null,rowBounds);
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            System.out.println(user.toString());
        }
        sqlSession.close();
    }

    @Test
    public void testLog4J() {
        logger.info("info:");
        logger.debug("debug");
        logger.error("error");
    }

    @Test
    public void limitUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("start", 1);
        map.put("end", 2);
        List<User> users = mapper.getUsetByLimit(map);
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            System.out.println(user.toString());
        }
        sqlSession.close();
    }


}