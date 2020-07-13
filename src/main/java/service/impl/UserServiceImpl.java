package service.impl;

import mapper.UserDao;
import org.springframework.stereotype.Service;
import pojo.User;
import service.UserService;

import javax.annotation.Resource;
import java.util.List;
@Service("userService")
public class UserServiceImpl implements UserService {
    //自动装配
    @Resource
    private UserDao userDao;
    //分页
    public List<User> getUserPager(int pageNO, int size) {
        int skip=(pageNO-1)*size;   //从第几条开始查，查几条
        return userDao.getUserPager(skip, size);
    }
    //登录
    public User getUserByPhone(String phone) {
        return userDao.getUserByPhone(phone);
    }
    //获得单个用户对象
    public User getUserById(int userid) {
        return userDao.getUserById(userid);
    }
    //获得用户总数
    public int getUserCount() {
        return userDao.getUserCount();
    }
    //添加用户
    public int insert(User user) {
        return userDao.insert(user);
    }
    //删除用户
    public int delete(int userid) {
        return userDao.delete(userid);
    }
    //删除多个用户
    public int deletes(int[] userids) {
        int rows=0;
        for (int id : userids) {
            rows+=delete(id);
        }
        return rows;
    }
    //修改个人信息
    public int updateInfo(User user) {
        return userDao.updateInfo(user);
    }
}
