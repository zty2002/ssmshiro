package com.zking.controller;

import com.zking.model.User;
import com.zking.service.IUserService;
import com.zking.util.PasswordHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/register")
public class UserController {

    @Autowired
    private IUserService iUserService;

    @RequestMapping("/upd")
    @ResponseBody
    public Map<String,Object> goupdate(User u ){

        String salt = PasswordHelper.createSalt();
        String saltpwd = PasswordHelper.createCredentials(u.getPassword(), salt);
        u.setPassword(saltpwd);
        u.setSalt(salt);
        int n = iUserService.updateByPrimaryKey(u);
        String msg="修改";
        Map<String,Object>  map = new HashMap<>();
        if (n>0) {
            msg+="成功";
        } else {
            msg+="失败";
        }
        map.put("code",n);
        map.put("msg",msg);
        return map;
    }


    @RequestMapping("/register")
    @ResponseBody
    public  Map<String, Object> goRegister(User u){
        String salt = PasswordHelper.createSalt();
        String saltpwd = PasswordHelper.createCredentials(u.getPassword(), salt);
        u.setPassword(saltpwd);
        u.setSalt(salt);
        int n = iUserService.insert(u);
          String msg="增加";
        Map<String,Object>  map = new HashMap<>();
        if (n>0) {
            msg+="成功";
        } else {
            msg+="失败";
        }
        map.put("code",n);
        map.put("msg",msg);
        return map;
    }

    @RequestMapping("/del")
    @ResponseBody
    public Map<String,Object> deluser(Integer userid){
        int n = iUserService.deleteByPrimaryKey(userid);
         String msg="删除";
        if (n>0) {
            msg+="成功";
        }else{
            msg+="失败";
        }
        Map<String,Object> map=new HashMap<>();
        map.put("code",n);
        map.put("msg",msg);
        return map;
    }
}
