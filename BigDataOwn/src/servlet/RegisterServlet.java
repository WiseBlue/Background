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

/**
 * Created by Administrator on 2017/8/9.
 */
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        MyBatisUtils myBatisUtils=new MyBatisUtils();
        SqlSessionFactory sqlSessionFactory=myBatisUtils.findSqlSessionFactory();
        SqlSession sqlSession=sqlSessionFactory.openSession();
        UserMapper mapper=sqlSession.getMapper(UserMapper.class);
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        try {
            mapper.addUserList(user);
            sqlSession.commit();
            req.getRequestDispatcher("index.jsp").forward(req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }
}
