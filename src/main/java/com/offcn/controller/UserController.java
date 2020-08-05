package com.offcn.controller;

import com.offcn.pojo.User;
import com.offcn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;


    public String Demo01(String name){
        int a = 10;
        System.out.println("天上有月亮");
        System.out.println("10个亿");
        return name;


    }
    //查询全部
    @GetMapping ("/")
    public String findAll(Model model){
        List<User> list = userService.findAll();
        model.addAttribute("userList",list);
        return "list";
    }

    //跳转到添加页面
    @RequestMapping("/userAdd")
    public String addUser(){
        return "userAdd";
    }
    //添加数据
    @PostMapping("/add")
    public String add(User user){
        userService.add(user);
        return "redirect:/user/";

    }
    //通过id查询
    @GetMapping("/{id}")
    public String getById(@PathVariable(name = "id")Long id, Model model){
        User user = userService.findOne(id);
        model.addAttribute("user",user);
        return "userEdit";
    }

    //通过id保存数据修改
    @RequestMapping("/update")
    public String updateUser(User user){
        userService.update(user.getId(),user);
        return "redirect:/user/";
    }

    //通过id删除数据
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id")Long id){
        userService.delete(id);
        return "redirect:/user/";
    }
}
