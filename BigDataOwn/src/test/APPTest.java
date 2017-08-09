package test;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import resources.mapper.UserMapper;

/**
 * Created by Administrator on 2017/8/8.
 */
public class APPTest {
    SqlSessionFactory sqlSessionFactory=null;
    @Before
    public void init() throws IOException{
        InputStream inputStream=Resources.getResourceAsStream("resources/SqlMapConfig.xml");
        sqlSessionFactory=new  SqlSessionFactoryBuilder().build(inputStream);
    }

   /* @Test
    public void test1(){
        SqlSession sqlSession=sqlSessionFactory.openSession();
        UserMapper mapper=sqlSession.getMapper(UserMapper.class);
        try {
            User user=new User();
            user.setUsername("张三");
            List<User> users=mapper.findUserList(user);
            for (User user1:users){
                System.out.println(user1.getUsername()+user1.getPassword());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }*/

   /* @Test
    public void Test2(){
        SqlSession sqlSession=sqlSessionFactory.openSession();
        User user=new User();
        user.setUsername("李四");
        user.setPassword("qwe");
        UserMapper mapper=sqlSession.getMapper(UserMapper.class);
        try {
            mapper.addUserList(user);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }*/
}
