package servlet;

import Utils.MyBatisUtils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
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
import java.io.*;
import java.util.List;

/**
 * Created by Administrator on 2017/8/8.
 */
public class LoginServlet extends HttpServlet{
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
        /*InputStream is=req.getInputStream();
        ByteArrayOutputStream baos=new ByteArrayOutputStream();
        int length=0;
        byte[] buffer=new byte[1024];
        while ((length=is.read(buffer))!=-1){
            baos.write(buffer,0,length);
        }*/
        Gson gson=new Gson();
        User user2=gson.fromJson(sb.toString(),User.class);
        String username=user2.getUsername();
        String password=user2.getPassword();


        ApplicationContext ctx=new ClassPathXmlApplicationContext("resource/config/spring-config.xml");
        SqlSessionFactory sqlSessionFactory= (SqlSessionFactory) ctx.getBean("sqlSessionFactory");
        SqlSession sqlSession=sqlSessionFactory.openSession();
        User user=new User();
        user.setUsername(username);
        //user.setPassword(password);
        UserMapper mapper= (UserMapper) ctx.getBean("UserMapper");
        try {
            List<User> users=mapper.findUserList(user);
            for (User user1:users){
                if (user1.getPassword().equals(password)){
                    resp.setCharacterEncoding("UTF-8");
                    resp.getWriter().write("true");
                }else {
                    resp.setCharacterEncoding("UTF-8");
                    resp.getWriter().write("false");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }

    }
}
