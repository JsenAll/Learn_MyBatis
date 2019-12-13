package org.jsen.dao;

import org.apache.ibatis.session.SqlSession;
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


        //方式二 不推荐
//        List<User> userList = sqlSession.selectList("org.jsen.dao.UserMapper.selectUser");
//        for (int i = 0; i < userList.size(); i++) {
//            User user = userList.get(i);
//            System.out.println(user.toString());
//        }

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
        User user = new User(9, "蒋厚森", "123456784546");
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
        User user = new User(9, "韩钰", "123456784546");
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
}