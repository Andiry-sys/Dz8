package com.step.dz8.service;

import com.step.dz8.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailSend {
    @Autowired
    private JavaMailSender javaMailSender;
    public  void SendMail(User user){
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom("marchycandriy@gmail.com");
        msg.setTo(user.getEmail());

        msg.setSubject("Your orders");
        msg.setText(user.getName()+"\n"+user.getEmail()+"\n"+user.getPizza()+" with "+user.getTopping());

        javaMailSender.send(msg);
    }
}
