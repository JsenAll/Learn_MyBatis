package org.jsen.dao;

import org.apache.ibatis.annotations.Select;
import org.jsen.pojo.User;

import java.util.List;

/*
 * @Author Jsen
 * @Time  2019/12/12 18:07
 *
 */
public interface UserMapper {
    /**
     * 查询全部用户
     */
    @Select("select * from user")
    List<User> selectUser();

    @Select("select * from user where id=#{id}")
    User selectUserById(int id);


}