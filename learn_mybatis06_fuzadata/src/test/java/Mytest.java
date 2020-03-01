import org.apache.ibatis.session.SqlSession;
import org.jsen.dao.StudentMapper;
import org.jsen.dao.TeacherMapper;
import org.jsen.pojo.Student;
import org.jsen.pojo.Teacher;
import org.jsen.utils.MybatisUtils;
import org.junit.Test;

import java.util.List;

public class Mytest {
    public static void main(String[] args) {

        System.out.println("wolaile ");
    }

    /**
     * 直接查询 Teacher 属性-> null
     */
    @Test
    public void texts() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> tt = mapper.getSTP();
        tt.forEach(t -> {
            System.out.println(t);
        });
        sqlSession.close();
    }


    /**
     * 解决方式一:
     * 按查询嵌套处理:
     * 先查询 student  得到 tid --> 再查询 teacher 得到 Teacher 对象
     */
    @Test
    public void getST() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> tt = mapper.getST();
        tt.forEach(t -> {
            System.out.println(t);
        });
        sqlSession.close();

    }

    /**
     * 解决方式二:
     * 按结果嵌套处理: 按照结果进行嵌套处理就像SQL中的联表查询
     */
    @Test
    public void getST2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> tt = mapper.getStudents2();
        tt.forEach(t -> {
            System.out.println(t);
        });
        sqlSession.close();

    }
}
