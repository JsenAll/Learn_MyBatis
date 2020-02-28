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
    /**
     * 查询全部用户
     */
    List<User> selectUser();

    /**
     * 使用分页查询
     */
    List<User> getUsetByLimit(Map<String, Object> map);

}