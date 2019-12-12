package org.jsen.dao;

import org.jsen.pojo.User;

import java.util.List;

/*
 * @Author Jsen
 * @Time  2019/12/12 18:07
 *
 */
public interface UserMapper {
    List<User> selectUser();
}