package mapper;

import pojo.User;

import java.util.List;

public interface UserDao {
    //分页
    List<User> getUserPager(int pageNO, int size);//pageNo页码，size每页几条

    //登录
    User getUserByPhone(String phone);

    //获得单个用户对象
    User getUserById(int userid);

    //获得用户总数
    int getUserCount();

    //添加
    int insert(User user);

    //删除单个
    int delete(int userid);

    //删除多个
    int deletes(int[] userids);

    //修改信息（含密码）
    int updateInfo(User user);

}
