package com.yu.javaBasic;

import com.sun.mail.util.MailSSLSocketFactory;

import java.io.File;
import java.util.*;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;

public class SendEmail {
    public static void main(String[] args) throws Exception {

        //邮件标题
        String subjectTitle = "测试邮件含附件";
        //邮件内容
        String content ="好家伙！test send email";
        //内容类型
        String contentType = "text/html;charset=UTF-8";

        Properties prop = new Properties();
        prop.setProperty("mail.host", "smtp.qq.com");  //设置QQ邮件服务器
        prop.setProperty("mail.transport.protocol", "smtp"); // 邮件发送协议
        prop.setProperty("mail.smtp.auth", "true"); // 需要验证用户名密码

        // 关于QQ邮箱，还要设置SSL加密，加上以下代码即可
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        prop.put("mail.smtp.ssl.enable", "true");
        prop.put("mail.smtp.ssl.socketFactory", sf);

        //使用JavaMail发送邮件的5个步骤

        //创建定义整个应用程序所需的环境信息的 Session 对象

        Session session = Session.getDefaultInstance(prop, new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                //发件人邮件用户名、密码
                return new PasswordAuthentication("zhuojun.yu@qq.com", "zhuojun520");
            }
        });


        //开启Session的debug模式，这样就可以查看到程序发送Email的运行状态
        session.setDebug(true);

        //2、通过session得到transport对象
        Transport ts = session.getTransport();

        //3、使用邮箱的用户名和授权码连上邮件服务器
        ts.connect("smtp.qq.com", "zhuojun.yu@qq.com", "dtizexllengmjhed");

        //4、创建邮件

        //创建邮件对象
        MimeMessage message = new MimeMessage(session);
        //指明邮件的发件人
        message.setFrom(new InternetAddress("zhuojun.yu@qq.com"));
        //指明邮件的收件人，(这里用我的qq邮箱发送我的163邮箱)
        message.setRecipient(Message.RecipientType.TO, new InternetAddress("zhuo_jun_yu@163.com"));
        //邮件的标题
        message.setSubject(subjectTitle);

        //发送附件
        File[] files = null;
//        File[] files = new File[2];
//        files[0] = new File("D:/test.xls");
//        files[1] = new File("D:/test2.xls");
        //判断附件是否存在
        if(null != files && files.length > 0){
            //Multipart是一个容器它转载多个body Part（正文、附件或内嵌资源）
            MimeMultipart multipart = new MimeMultipart();

            BodyPart contentPart = new MimeBodyPart();
            contentPart.setContent(content, contentType);
            //添加一个正文内容的 bodyPart
            multipart.addBodyPart(contentPart);

            for (File file : files) {
                MimeBodyPart attachment = new MimeBodyPart();
                DataHandler dh2 = new DataHandler(new FileDataSource(file));
                attachment.setDataHandler(dh2);
                attachment.setFileName(MimeUtility.encodeText(dh2.getName()));
                //添加附件 bodyPart
                multipart.addBodyPart(attachment);
            }
            multipart.setSubType("mixed");
            message.setContent(multipart);
        }else{//邮件不含附件的内容
            //邮件的文本内容
        message.setContent(content, contentType);
        }

        //5、发送邮件
        ts.sendMessage(message, message.getAllRecipients());
        ts.close();
    }
}
