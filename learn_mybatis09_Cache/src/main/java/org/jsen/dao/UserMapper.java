package org.jsen.dao;

import org.jsen.pojo.User;

import java.util.List;
import java.util.Map;

/*
 * @Author Jsen
 * @Time  2019/12/12 18:07
 *
 */
public interface UserMapper {

    User getUserById(int id);

    int upDateUser(User user);




}