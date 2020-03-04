import org.apache.ibatis.session.SqlSession;

import org.jsen.dao.BlogMapper;
import org.jsen.pojo.Blog;
import org.jsen.utils.IDUtil;
import org.jsen.utils.MybatisUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Mytest {
    public static void main(String[] args) {
        System.out.println("wolaile ");
    }


    @Test
    public void genId() {
        System.out.println(IDUtil.genId());
    }


    /**
     * 导入测试数据
     */
    @Test
    public void addInitBlog() {
        SqlSession session = MybatisUtils.getSqlSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);

        Blog blog = new Blog();
        blog.setId(IDUtil.genId());
        blog.setTitle("Mybatis如此简单");
        blog.setAuthor("Jsen");
        blog.setCreateTime(new Date());
        blog.setViews(9999);

        int a = mapper.addBlog(blog);

        blog.setId(IDUtil.genId());
        blog.setTitle("Java如此简单Jsen");
        mapper.addBlog(blog);

        blog.setId(IDUtil.genId());
        blog.setTitle("Spring如此简单Jsen");
        a = mapper.addBlog(blog);

        blog.setId(IDUtil.genId());
        blog.setTitle("微服务如此简单Jsen");
        a = mapper.addBlog(blog);

        session.close();
    }


    @Test
    public void queryBlogIf() {
        SqlSession session = MybatisUtils.getSqlSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);

        HashMap<String, String> map = new HashMap<String, String>();
        map.put("author", "狂神说");
        List<Blog> blogs = mapper.queryBlogIf(map);

        System.out.println(blogs);

        session.close();

    }

    @Test
    public void testQueryBlogChoose() {
        SqlSession session = MybatisUtils.getSqlSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);

        HashMap<String, Object> map = new HashMap<String, Object>();
//        map.put("title","Java如此简单");
//        map.put("author","狂神说");
//        map.put("views",9999);
        List<Blog> blogs = mapper.queryBlogChoose(map);

        System.out.println(blogs);

        session.close();
    }


    @Test
    public void testQueryBlogForeach() {
        SqlSession session = MybatisUtils.getSqlSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);

        HashMap map = new HashMap();
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(2);
        ids.add(3);
        map.put("ids", ids);

        List<Blog> blogs = mapper.queryBlogForeach(map);

        System.out.println(blogs);

        session.close();
    }

    @Test
    public void tt() {
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(2);
        ids.add(3);
        String open = "and (";
        String close = ")";
        String separator = " or";
        String sql = "";
        int counter = 1;
        for (Integer id : ids) {
            if (counter == 1)
                sql = sql + open;
            if (counter == ids.size()) {
                sql = sql + " id=" + id + close;
                continue;
            }
            counter++;
            sql = sql + " id=" + id + separator;


        }
        System.out.println(sql);
    }


}

