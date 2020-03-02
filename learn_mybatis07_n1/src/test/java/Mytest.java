import org.apache.ibatis.session.SqlSession;
import org.jsen.dao.StudentMapper;
import org.jsen.pojo.Student;
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
        List<Student>  tt = mapper.selectAll();
        tt.forEach(t -> {
            System.out.println(t);
        });
        sqlSession.close();

    }
}
