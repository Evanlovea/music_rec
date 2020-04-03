package com.haut.music.utils;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
/**
 * @Author: Evan
 * @Description: 邮箱注册工具类
 * @Date: Created in 15:31 2019/4/23
 * @Modified By:
 */




/**
 * 邮件工具类
 */
public class MailUtil {
    /**
     * 发送邮件
     * @param to 给谁发
     * @param text 发送内容
     */
    public static boolean send_mail(String to,String text)  {
        //创建连接对象 连接到邮件服务器
        Properties properties = new Properties();
        //设置发送邮件的基本参数
        //发送邮件服务器(注意，此处根据你的服务器来决定，如果使用的是QQ服务器，请填写smtp.qq.com)
        properties.put("mail.smtp.host", "smtp.163.com");
        //发送端口（根据实际情况填写，一般均为25）
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.auth", "true");
        //设置发送邮件的账号和密码
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                //两个参数分别是发送邮件的账户和密码(注意，如果配置后不生效，请检测是否开启了 POP3/SMTP 服务，QQ邮箱对应设置位置在: [设置-账户-POP3/IMAP/SMTP/Exchange/CardDAV/CalDAV服务])
                return new PasswordAuthentication("13253312194@163.com","Aa123456");
            }
        });

        try {
            //创建邮件对象
            Message message = new MimeMessage(session);
            //设置发件人
            message.setFrom(new InternetAddress("13253312194@163.com"));
            //设置收件人
            message.setRecipient(Message.RecipientType.TO,new InternetAddress(to));
            //设置主题
            message.setSubject("验证码验证");
            //设置邮件正文  第二个参数是邮件发送的类型
            message.setContent(text,"text/html;charset=UTF-8");
            //发送一封邮件
            Transport.send(message);
            return true;
        }catch (MessagingException e){
            e.printStackTrace();
            return false;
        }

    }
}
