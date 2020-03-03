package org.jsen.dao; /*
 *@author Jsen
 *@description
 */

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.jsen.pojo.Teacher;

public interface TeacherMapper {


    //获取指定老师下的所有学生 以及老师的信息

    Teacher getTeacher(@Param("id") int id);

    Teacher getTeacher2(@Param("id") int id);
}
