package org.jsen.dao;

import org.jsen.pojo.Blog;

import java.util.List;
import java.util.Map;

/**
 * @author Jsen
 * @description
 */

public interface BlogMapper {


    int addBlog(Blog blog);

    List<Blog> queryBlogIf(Map map);

    int updateBlog(Map map);

    List<Blog> queryBlogChoose(Map map);

    List<Blog> queryBlogForeach(Map map);


}
