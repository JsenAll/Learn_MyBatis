package org.jsen.dao;

import org.apache.ibatis.session.SqlSession;
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
        }

        sqlSession.close();
    }


    @Test
    public void getUserById() {
        //第一步获取SqlSession
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User userById = mapper.getUserById(1);
        System.out.println(userById);
    }

    @Test
    public void addUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = new User(2, "胡金文", "hujinwen");
        int i = mapper.addUser(user);
        System.out.println(i);
        //提交事务
        sqlSession.commit();//没有不会提交到数据库中
        sqlSession.close();
    }

    @Test
    public void upDateUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(2, "韩钰", "123456784546");
        int i = mapper.upDateUser(user);
        //提交事务
        sqlSession.commit();//没有不会提交到数据库中
        sqlSession.close();

    }


    @Test
    public void delUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int i = mapper.delUser(9);
        //提交事务
        sqlSession.commit();//没有不会提交到数据库中
        sqlSession.close();
    }


    @Test
    public void selectUserLike() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userName", "%李%");
        List<User> users = mapper.selectUserLike(map);
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            System.out.println(user.toString()
            );

        }
        //提交事务
        sqlSession.commit();//没有不会提交到数据库中
        sqlSession.close();
    }
}