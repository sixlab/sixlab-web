package cn.sixlab.web.server.util;

import cn.sixlab.web.server.beans.ToolsMovie;
import org.nutz.dao.Cnd;
import org.nutz.dao.Condition;
import org.nutz.dao.Dao;
import org.nutz.dao.util.DaoUp;
import org.nutz.json.Json;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

/**
<<<<<<< HEAD
 * @author <a href="https://blog.sixlab.cn/">六楼的雨/Patrick Root</a>
=======
 * @author 六楼的雨/Patrick Root
 * @since 2.0.0
>>>>>>> 初始化网站后台项目 sixlab-server
 */
public class HisServiceTest {
    
    @BeforeClass
    public void beforeClass() throws Exception {
        DaoUp.me().init("jdbc.properties");
    }
    
    @AfterClass
    public void afterClass() throws Exception {
        DaoUp.me().close();
    }
    
    @Test
    public void test() throws Exception {
        Dao dao = DaoUp.me().dao();
    
        Condition cnd = Cnd.where("movieName", "like", "%"+"2012"+"%");
    
        List<ToolsMovie> movieList = dao.query(ToolsMovie.class, cnd);
    
        System.out.println(Json.toJson(movieList));
    }
    
    
    @Test
    public void testSawMovie() throws Exception {
        
    }
    
    @Test
    public void testBeginShow() throws Exception {
        
    }
    
    @Test
    public void testAddSeason() throws Exception {
        
    }
    
    @Test
    public void testAddEpisode() throws Exception {
        
    }
    
    @Test
    public void testAddPost() throws Exception {
        
    }
    
}