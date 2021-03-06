import com.atguigu.crud.bean.Department;
import com.atguigu.crud.bean.Employee;
import com.atguigu.crud.dao.DepartmentMapper;
import com.atguigu.crud.dao.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

/**
 * Created by Administrator on 2017/8/16.
 * 推荐Spring项目可以使用Spring单元测试，可以自动注入我们需要的组件
 * 1.导入SpringTest模块
 * 2.使用@ContextConfiguration指定spring配置文件的位置
 * 3.直接使用autowired即可
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MapperTest {
    @Autowired
    DepartmentMapper departmentMapper;

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    SqlSession sqlSession;
    /**
     * 测试DepartmentMapper
     */
@Test
    public void testCRUD(){
        /*ApplicationContext ioc=new ClassPathXmlApplicationContext("applicationContext.xml");
        ioc.getBean(DepartmentMapper.class);*/
    System.out.println(departmentMapper);

    //departmentMapper.insertSelective(new Department(null,"开发部"));
    //departmentMapper.insertSelective(new Department(null,"测试部"));

    //2.插入单个员工
    //employeeMapper.insertSelective(new Employee(null,"Jerry","M","Jerry@atguigu.com",1));
    //3.批量插入多个员工：批量，使用可以执行批量操作的sqlSession
    EmployeeMapper mapper=sqlSession.getMapper(EmployeeMapper.class);
    for (int i=0;i<1000;i++){
        String uid=UUID.randomUUID().toString().substring(0,5)+i;
        mapper.insertSelective(new Employee(null,uid,"M",uid+"@atguigu.com",1));
    }

    }
}
