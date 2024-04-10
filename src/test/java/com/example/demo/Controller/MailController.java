package com.example.demo.Controller;

import com.example.demo.Model.MailStructure;
import com.example.demo.Service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/mail")
public class MailController {

    @Autowired
    private MailService mailService;

    @RequestMapping ("/envoyer/{email}")
    public String envoyerEmail(@PathVariable String mail, @RequestBody MailStructure mailStructure){
        mailService.sendMail(mail, mailStructure);
        return "Email envoyé avec succes ! ";
    }
}
