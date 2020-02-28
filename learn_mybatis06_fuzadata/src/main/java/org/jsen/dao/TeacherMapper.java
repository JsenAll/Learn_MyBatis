package org.jsen.dao; /*
 *@author Jsen
 *@description
 */

import org.apache.ibatis.annotations.Select;
import org.jsen.pojo.Teacher;

public interface TeacherMapper {
    @Select("select * from teacher ")
    public Teacher getTT();
}
