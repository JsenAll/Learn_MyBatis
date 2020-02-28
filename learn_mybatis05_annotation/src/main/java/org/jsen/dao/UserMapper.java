package org.jsen.dao;

import org.apache.ibatis.annotations.*;
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

    @Insert("insert into user(id,name,pwd) values (#{id} ,#{name},#{pwd})")
    Long insertUser(User user);

    @Update("update user set name=#{name}, pwd=#{pwd} where id=#{id}")
    int updateUser(User user);

    @Delete("delete from user where id=#{id}")
    int deleUser(User user);
    @Select("select * from user where id=#{id} and pwd=#{name22}")
    User seleUserByIdAndPwd(@Param("id")int id, @Param("name22") String pwd);
}