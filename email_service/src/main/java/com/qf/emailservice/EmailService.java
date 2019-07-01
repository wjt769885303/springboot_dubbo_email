package com.qf.emailservice;

import com.alibaba.dubbo.config.annotation.Service;
import com.qf.entity.Email;
import com.qf.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Date;


/**
 * @Author WJT
 * @Date 2019/6/29 15:32
 * @Version 1.0
 **/



@Service
public class EmailService implements IEmailService  {

    @Autowired
    private JavaMailSender javaMailSender;


    @Override
    public void sendEmail(Email email) {



            //创建一封邮件
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();

            //创建一个Spring提供的邮件帮助对象
        MimeMessageHelper messageHelper = null;
        try {
            messageHelper = new MimeMessageHelper(mimeMessage,true);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        //设置时间
            try {
                messageHelper.setSentDate(new Date());
            } catch (MessagingException e) {
                e.printStackTrace();
            }

            //设置发送方
            try {
                messageHelper.setFrom(email.getFrom());
            } catch (MessagingException e) {
                e.printStackTrace();
            }

            //设置接收方
            //to - 普通接收方
            //cc - 抄送方
            //bcc - 密送方
            try {
                messageHelper.addTo(email.getAddTo());
            } catch (MessagingException e) {
                e.printStackTrace();
            }

            //设置标题
            try {
                messageHelper.setSubject(email.getSetSubject());
            } catch (MessagingException e) {
                e.printStackTrace();
            }

            try {
                messageHelper.setText(email.getSetText(),true);
            } catch (MessagingException e) {
                e.printStackTrace();
            }


            javaMailSender.send(mimeMessage);




        }


}
