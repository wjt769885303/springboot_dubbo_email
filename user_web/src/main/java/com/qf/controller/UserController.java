package com.qf.controller;

import com.alibaba.dubbo.config.annotation.Reference;


import com.qf.entity.Email;
import com.qf.entity.User;
import com.qf.service.IEmailService;
import com.qf.service.IUserLogin;
import com.qf.service.IUserResgistor;

import org.jboss.netty.handler.codec.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Random;


/**
 * @Author WJT
 * @Date 2019/6/29 10:37
 * @Version 1.0
 **/


@Controller
public class UserController {

    @Reference
    IEmailService iEmailService;

   @Reference
   IUserResgistor iUserResgistor;

   @Reference
    IUserLogin iUserLogin;

    @RequestMapping("/toRegistor")
    public  String toRegistor(){
        return "registor";
    }

    @RequestMapping("/sendEmail")
    @ResponseBody
    public void sendEmail(String email,HttpSession session){


        Email emails=new Email();
        emails.setFrom("3134629631@qq.com");
        emails.setAddTo(email);
        emails.setSetSubject("验证码");


        Random random = new Random();
        StringBuffer s = new StringBuffer();
        for(int i=0;i<4;i++){
            int i1 = random.nextInt(10);
            s.append(i1);


        }

        emails.setSetText(s.toString());

        session.setAttribute("emailcode",s.toString());

        iEmailService.sendEmail(emails);


    }


    @PostMapping("/Registor")
    @ResponseBody
    public int  Registor(User user, @RequestParam String emailcode, HttpSession session, Model model){

        Boolean aBoolean = iUserResgistor.selectByName(user.getUsername());
        if (aBoolean){
            return 0;
        }else{
            String emailcodes =(String) session.getAttribute("emailcode");
            if (!emailcode.equals(emailcodes)){
                return 1;
            }
            iUserResgistor.inserUser(user);
            return 2;

        }

    }


    @RequestMapping("/login")
    public String  login(){

        return "login";

    }


    @RequestMapping("/backPage")
    public String  backPage(){

        return "backPassword";

    }



    @RequestMapping("/sendEmailByUsername")
    @ResponseBody
    public int sendEmailByUsername(String username){

        User user = iUserLogin.selectUserByusername(username);

        if (user==null){

            return 1;
        }else {

            String emailTo = user.getEmail();
            Email emails=new Email();

            emails.setFrom("3134629631@qq.com");
            emails.setAddTo(emailTo);
            emails.setSetSubject("找回密码");
            emails.setSetText("请点击<a href='http://localhost:8080/setPassword?username="+username+"'>这里</a>找回密码~");

            iEmailService.sendEmail(emails);
            return 2;
        }


    }



    @RequestMapping("/setPassword")

    public String setPassword(String username,Model model){

            model.addAttribute("username",username);

            return "setPasswordPage";

    }




        @RequestMapping("/newPassword")
        @ResponseBody
        public void newPassword(String username,String password) {
            User user=new User();
            user.setUsername(username);
            user.setPassword(password);

            iUserLogin.updatePassword(user);


        }



    @RequestMapping("/loginByUser")
    @ResponseBody
    public int loginByUser(String username,String password) {
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);

        Boolean aBoolean = iUserLogin.selectByUser(user);
        if (aBoolean==true){
            return 1;
        }else {
            return 2;
        }


    }



}
