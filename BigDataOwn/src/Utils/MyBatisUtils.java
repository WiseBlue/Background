package Utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Administrator on 2017/8/9.
 */
public class MyBatisUtils {
    private SqlSessionFactory sqlSessionFactory=null;
    public SqlSessionFactory findSqlSessionFactory(){
        InputStream inputStream= null;
        try {
            inputStream = Resources.getResourceAsStream("resources/SqlMapConfig.xml");
            sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return sqlSessionFactory;
    }
}
