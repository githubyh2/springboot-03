package com.example.springboot03.util;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * @author yanhao
 * @data 2024/3/13
 * <p>
 * 发送 QQ 邮件告警
 */
public class EmailAlertSenderUtil {
    public static void sendEmailAlert() {
        // 发件人邮箱和密码
        String senderEmail = "your-email@example.com";
        String senderPassword = "your-email-password";
//        String senderEmail = "532790872@qq.com";
//        String senderPassword = "nwhffujtcwfebhff";

        // 收件人邮箱
        String recipientEmail = "recipient@example.com";

        // 邮件主题和内容
        String emailSubject = "Alert: System Failure";
        String emailContent = "Dear user, \n\nOur system has encountered a critical failure. Please take immediate action. 我是在测试";

        // 设置邮件服务器属性
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.qq.com");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.port", "587"); // 可能需要根据具体邮件服务器设置端口号
        properties.put("mail.smtp.starttls.enable", "true");

        // 创建会话
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });

        try {
            // 创建邮件消息
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
            message.setSubject(emailSubject);
            message.setText(emailContent);

            // 发送邮件
            Transport.send(message);

            System.out.println("Email alert sent successfully!");

        } catch (AddressException e) {
            e.printStackTrace();
        } catch (javax.mail.MessagingException e) {
            e.printStackTrace();
            System.out.println("Failed to send email alert: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        sendEmailAlert();
    }
}
