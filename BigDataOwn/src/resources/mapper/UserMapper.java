package resources.mapper;

import po.User;

import java.util.List;

/**
 * Created by Administrator on 2017/8/8.
 */
public interface UserMapper {
    public List<User> findUserList(User user) throws Exception;
    public void addUserList(User user) throws Exception;
}
