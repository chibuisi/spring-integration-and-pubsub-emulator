package com.chibuisi.springlistenerpubsubemulatordemo;

import com.chibuisi.springlistenerpubsubemulatordemo.entity.PaymentReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailSender {
    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(PaymentReport paymentReport){
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
        try{
            mimeMessageHelper.setTo(paymentReport.getUser());
            mimeMessageHelper.setSubject("Your payment has been received and processed successfully");
            mimeMessageHelper.setText("Payment for account: " + paymentReport.getUser()
                    + "\nAmount " + paymentReport.getAmount()
                    + "has been processed successfully on " + paymentReport.getDateTime()
                    + "\n\nThank you for your continued support \n\n");
        }
        catch (MessagingException messagingException){
            messagingException.printStackTrace();
        }
        javaMailSender.send(mimeMessage);
    }
}
