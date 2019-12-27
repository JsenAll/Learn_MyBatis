package org.jsen.pojo;

import org.apache.ibatis.type.Alias;

/*
 * @Author Jsen
 * @Time  2019/12/12 18:04
 *
 */
@Alias("user")
public class User {
    private int id; //id
    private String name; //姓名
    private String password; //密码

    public User(int id, String name, String pwd) {
        this.id = id;
        this.name = name;
        this.password = pwd;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pwd='" + password + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //构造,有参,无参
//set/get
//toString()
}