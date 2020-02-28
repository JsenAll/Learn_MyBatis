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

    SqlSession sqlSession = MybatisUtils.getSqlSession();
    UserMapper mapper = sqlSession.getMapper(UserMapper.class);


    @Test
    public void selec() {
        List<User> users = mapper.selectUser();
        users.forEach(user -> {
            System.out.println(user);
        });
        sqlSession.close();

    }

    @Test
    public void byID() {
        User user = mapper.selectUserById(11);
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void insertUser() {
        Long aLong = mapper.insertUser(new User(12, "诸葛大力", "daliwoaini"));
        System.out.println(aLong > 0 ? "成功插入" : "插入失败");
        sqlSession.commit();//没有不会提交到数据库中
        sqlSession.close();
    }

    @Test
    public void updateUser() {
        int aLong = mapper.updateUser(new User(11, "诸葛大力", "成果"));
        System.out.println(aLong > 0 ? "更新成功" : "更新失败");
        sqlSession.commit();//没有不会提交到数据库中
        sqlSession.close();
    }

    @Test
    public void deleUser() {
        int aLong = mapper.deleUser(new User(12, "诸葛大力", "成果"));
        System.out.println(aLong > 0 ? "删除成功" : "删除失败");
        sqlSession.commit();//没有不会提交到数据库中
        sqlSession.close();
    }


    @Test
    public void byIdName() {
        User user = mapper.seleUserByIdAndPwd(12,"daliwoaini");
        System.out.println(user);
        sqlSession.close();
    }
}