import org.apache.ibatis.session.SqlSession;
import org.jsen.dao.TeacherMapper;
import org.jsen.pojo.Teacher;
import org.jsen.utils.MybatisUtils;
import org.junit.Test;

public class Mytest {
    public static void main(String[] args) {

        System.out.println("wolaile ");
    }
    @Test
    public void texts(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher tt = mapper.getTT();
        System.out.println(tt);
    }
}
