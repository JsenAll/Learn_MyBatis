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


    @Test
    public void getST2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> tt = mapper.selectAll();
        tt.forEach(t -> {
            System.out.println(t);
        });
        sqlSession.close();

    }

    @Test
    public void coTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacher(1);
        System.out.println(teacher);
        sqlSession.close();

    }
    @Test
    public void coTsest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacher2(1);
        System.out.println(teacher);
        sqlSession.close();

    }
}
