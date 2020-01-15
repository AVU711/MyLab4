package my.lab.four.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component
@ComponentScan("my.lab.four.config.MailConfig")
public class EmailServiceImpl {

    @Autowired
    JavaMailSender javaMailSender;

    public void sendPassword(String address){
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("lexa200004@mail.ru");
        message.setTo(address);
        message.setSubject("Регистрация");
        message.setText("Ваш пароль : 1234");

        javaMailSender.send(message);
    }


}
