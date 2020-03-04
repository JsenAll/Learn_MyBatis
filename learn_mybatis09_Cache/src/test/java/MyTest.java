import org.apache.ibatis.session.SqlSession;
import org.jsen.dao.UserMapper;
import org.jsen.pojo.User;
import org.jsen.utils.MybatisUtils;
import org.junit.Test;

public class MyTest {

    @Test
    public void getUserById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User userById = mapper.getUserById(1);
        User userById2 = mapper.getUserById(1);
        System.out.println(userById);
        System.out.println(userById2);

        System.out.println(userById == userById2);
        sqlSession.close();
    }

    @Test
    public void getUserById2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User userById = mapper.getUserById(1);
        System.out.println(userById);
        sqlSession.close();


        SqlSession sqlSession2 = MybatisUtils.getSqlSession();
        UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);
        User userById2 = mapper2.getUserById(1);
        System.out.println(userById2);
        sqlSession2.close();
        System.out.println(userById == userById2);
    }

    @Test
    public void getUserById3() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User userById = mapper.getUserById(1);
        User userById2 = mapper.getUserById(2);
        System.out.println(userById);
        System.out.println(userById2);

        System.out.println(userById == userById2);
        sqlSession.close();
    }

    @Test
    public void getUserById4() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User userById = mapper.getUserById(1);
        mapper.upDateUser(new User(2,"2B","1324646"));

        User userById2 = mapper.getUserById(1);
        System.out.println(userById);
        System.out.println(userById2);

        System.out.println(userById == userById2);
        sqlSession.close();
    }

    @Test
    public void getUserById5() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User userById = mapper.getUserById(1);

        sqlSession.clearCache();//手动清除缓存

        User userById2 = mapper.getUserById(1);
        System.out.println(userById);
        System.out.println(userById2);

        System.out.println(userById == userById2);
        sqlSession.close();
    }



    @Test
    public void getUserById6() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User userById = mapper.getUserById(1);
        System.out.println(userById);
        sqlSession.close();


        SqlSession sqlSession2 = MybatisUtils.getSqlSession();
        UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);
        User userById2 = mapper2.getUserById(1);
        System.out.println(userById2);
        sqlSession2.close();
        System.out.println(userById == userById2);
    }


}
