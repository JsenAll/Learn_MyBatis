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
     * 根据用户id查询用户
     */
    User getUserById(int id);

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    int addUser(User user);

    /**
     * 更新用户
     *
     * @param user
     * @return
     */
    int upDateUser(User user);

    /**
     * 万能的Map  进行更新
     * @param map
     * @return
     */

    List<User> selectUserLike(Map<String, Object> map);


    /**
     * 根据id 删除一个用户
     *
     * @param id
     * @return
     */
    int delUser(int id);


}