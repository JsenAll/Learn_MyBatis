package org.jsen.dao; /*
 *@author Jsen
 *@description
 */

import org.jsen.pojo.Student;

import java.util.List;

public interface StudentMapper {


    /**
     *普通 直接查询 属性的teacher  则为null
     */
    List<Student>  getSTP();

    /**
     * 按查询嵌套处理
     * @return
     */
    List<Student>  getST();


    public List<Student> getStudents2();

}
