package servlet;

import Utils.MyBatisUtils;
import com.google.gson.Gson;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import po.User;
import resource.mapper.UserMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Created by Administrator on 2017/8/9.
 */
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String line=null;
        InputStream inputStream=req.getInputStream();
        BufferedReader reader=new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb=new StringBuilder();
        while ((line=reader.readLine())!=null){
            sb.append(line);
        }
        Gson gson=new Gson();
        User user2=gson.fromJson(sb.toString(),User.class);
        String username=user2.getUsername();
        String password=user2.getPassword();
        ApplicationContext ctx=new ClassPathXmlApplicationContext("resource/config/spring-config.xml");
        SqlSessionFactory sqlSessionFactory= (SqlSessionFactory) ctx.getBean("sqlSessionFactory");
        SqlSession sqlSession=sqlSessionFactory.openSession();
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        UserMapper userMapper= (UserMapper) ctx.getBean("UserMapper");
        try {
            List<User> users=userMapper.findUserList(user);
            if (users.isEmpty()){
                userMapper.addUserList(user);
                sqlSession.commit();
                resp.setCharacterEncoding("UTF-8");
                resp.getWriter().write("true");
            }else
            {
                resp.setCharacterEncoding("UTF-8");
                resp.getWriter().write("have");
            }

        } catch (Exception e) {
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write("false");
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }

    }
}
