import com.netease.ysf.redis.utils.RedisUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by 谭化友 on 2016/7/7
 */

public class Test {

    @org.junit.Test
    public void test(){
        ApplicationContext ac =  new ClassPathXmlApplicationContext("classpath:config/spring-app.xml");
        RedisUtils redisClient = (RedisUtils)ac.getBean("redisUtils");
        redisClient.set("a", "qwewq");
        System.out.println(redisClient.get("a"));
    }
}
