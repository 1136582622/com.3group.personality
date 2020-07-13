package controller;

import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pojo.User;
import service.UserService;
import utils.util;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

/*@Controller*/
@RestController//相当于controller+responsebody,下面的方法中返回值给安卓端就不用加 @ResponseBody
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;
    private String strUser;

    @RequestMapping("/addUser")
    public String addSave(@RequestParam Map<String, String> map) throws NoSuchAlgorithmException {
      /*  String e = map.toString(); */
        String strUser = map.get("strUser");//获取安卓端传过来的键
        Gson gson = new Gson();
        User user = gson.fromJson(strUser, User.class);
        /*String w = user.toString();*/
/*        System.out.print(e);*/
        user.setPassword(util.UseMD5(user.getPassword()));
        User userbyphone = userService.getUserByPhone(user.getPhone());
        if (userbyphone != null) {
            return "error";          //存在用户
        } else {
            int i = userService.insert(user);
            if (i > 0) {
                return "sucess";   //保存成功
            } else {
                return "fail";     //保存失败
            }
        }
    }

    @RequestMapping("/updateInfo")
    public String updateInfo(@RequestParam Map<String, String> map) {
        String e = map.toString();
        String strUser = map.get("strUser");
        Gson gson = new Gson();
        User user = gson.fromJson(strUser, User.class);
        userService.updateInfo(user);
        return "success";
    }

    @RequestMapping("/login")
    public String login(@RequestParam Map<String, String> map) throws NoSuchAlgorithmException {
        User user = userService.getUserByPhone(map.get("phone"));
        if (user != null) {
            String password = user.getPassword();
            if (password.equals(util.UseMD5(map.get("password")))) {
                String JsonStr = new Gson().toJson(user);
                return JsonStr;
            }
        }
        return "error";
    }

    @RequestMapping("/test")
    @ResponseBody
    public String testStr() {
        return "123";
    }


    public String getStrUser() {
        return strUser;
    }

    public void setStrUser(String strUser) {
        this.strUser = strUser;
    }
}
