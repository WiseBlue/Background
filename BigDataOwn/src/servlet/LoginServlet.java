package servlet;

import Utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import po.User;
import resources.mapper.UserMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2017/8/8.
 */
public class LoginServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        MyBatisUtils myBatisUtils=new MyBatisUtils();
        SqlSessionFactory sqlSessionFactory=myBatisUtils.findSqlSessionFactory();
        SqlSession sqlSession=sqlSessionFactory.openSession();
        UserMapper mapper=sqlSession.getMapper(UserMapper.class);
        try {
            User user=new User();
            user.setUsername(username);
            List<User> users=mapper.findUserList(user);
                for (User user1:users){
                    resp.setContentType("text/html;charset=UTF-8");
                    resp.getWriter().write("<strong>欢迎"+user1.getUsername()+",你的密码是"+user1.getPassword()+"</strong>");
                }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }

    }
}
