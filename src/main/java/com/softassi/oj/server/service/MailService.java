package com.softassi.oj.server.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * @ClassName : MailService
 * @Description : 发送邮件服务
 * @Author : cybersa
 * @Date: 2020-09-22 22:33
 */
@Service
@Slf4j
public class MailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private TemplateEngine templateEngine;

    @Value("${spring.mail.username}")
    private String username;

    //发送邮件(接收三个前台传过来的参数:addressee 收件人地址、theme 邮件主题、text 邮件正文)
    @Async("taskExecutor")
    public void sendMail(String receiver,String theme,String text){
        //发邮件
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(username);
        //收件人邮件地址
        message.setTo(receiver);
        //邮件主题
        message.setSubject(theme);
        //邮件正文
        message.setText(text);
        try {
            javaMailSender.send(message);
        }
        catch (Exception e) {
            log.error("纯文本邮件发送失败");
            e.printStackTrace();

        }
    }

    /**
     * 功能描述: 发送html模板邮件
     *
     * @Param: [receiver, theme, content]
     * @Return: void
     * @Author: a1725
     * @Date: 2020/10/5 22:25
     */
    @Async("taskExecutor")
    public void sendHtmlMail(String receiver,String theme,String content) {
        //发邮件
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(username);
            mimeMessageHelper.setTo(receiver);
            mimeMessageHelper.setSubject(theme);
            mimeMessageHelper.setText(content, true);
            javaMailSender.send(mimeMessage);
        }
        catch (Exception e) {
            e.printStackTrace();
            log.error("发送html模板邮件错误");
        }
    }

    /**
     * 功能描述: 发送图片邮件
     *
     * @Param: [receiver, theme, content, imagePath, rscId]
     * @Return: void
     * @Author: a1725
     * @Date: 2020/10/5 22:25
     */
    @Async("taskExecutor")
    public void sendImageMail(String receiver, String theme, String content, String imagePath,String rscId) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(username);
            mimeMessageHelper.setTo(receiver);
            mimeMessageHelper.setSubject(theme);
            mimeMessageHelper.setText(content, true);
            FileSystemResource fileSystemResource = new FileSystemResource(new File(imagePath));
            mimeMessageHelper.addInline(rscId, fileSystemResource);
            javaMailSender.send(mimeMessage);
        }
        catch (Exception e) {
            e.printStackTrace();
            log.error("发送富文本邮件错误");
        }
    }

    /**
     * 功能描述: 根据模板发送邮件
     *
     * @Param: [receiver, subject, content]
     * @Return: void
     * @Author: a1725
     * @Date: 2020/10/5 22:25
     */
    @Async("taskExecutor")
    public void sendTemplateMail(String receiver, String subject, String content) {
        Context context = new Context();
        context.setVariable("content", content);
        String process = templateEngine.process("emilTemplate", context);
        sendHtmlMail(receiver, subject, process);
    }
}
