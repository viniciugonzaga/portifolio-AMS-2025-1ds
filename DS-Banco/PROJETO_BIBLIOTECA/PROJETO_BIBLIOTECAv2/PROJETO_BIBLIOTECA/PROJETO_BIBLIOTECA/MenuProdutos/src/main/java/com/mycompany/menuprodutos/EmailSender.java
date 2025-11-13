package com.mycompany.menuprodutos;

import jakarta.mail.*;
import jakarta.mail.internet.*;
import jakarta.activation.*;

import java.util.Properties;

public class EmailSender {

    public static void enviarEmail(String destinatario) {
        final String remetente = "sofiatestejava@gmail.com"; // email que envia a mensagem
        final String senha = "qste bpuz okxv qxhu"; // senha do app criada

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        // Criando uma sessão
        Session session = Session.getInstance(props,
            new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(remetente, senha);
                }
            });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(remetente));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
            message.setSubject("Confirmação do Pedido");

            // Parte de texto HTML do email para aparecer dentro do corpo da mensagem de texto
            MimeBodyPart textPart = new MimeBodyPart();
            String htmlContent = "<html>" +
                                 "<body>" +
                                 "<p>Seu pedido foi recebido com sucesso!</p>" +
                                 "<p>Lembrando: Seus pedidos nunca chegarão, mas devíamos merecer o pix só pelo esforço!</p>" +
                                 "<p>Escaneie o QRCODE abaixo para realizar o pagamento:</p>" +
                                 "<img src='cid:qrCodeImage' alt='QR Code'>" +
                                 "</body>" +
                                 "</html>";
            textPart.setContent(htmlContent, "text/html");

            // Parte de imagem
            MimeBodyPart imagePart = new MimeBodyPart();
            String imagePath = "src/assets/images/QRcode1.png"; 
            imagePart.attachFile(imagePath);
            imagePart.setContentID("<qrCodeImage>");
            imagePart.setDisposition(MimeBodyPart.INLINE);

            // Combinação do texto e a imagem em uma parte multipart
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(textPart);
            multipart.addBodyPart(imagePart);

            // Fazendo com que o conteúdo vá para o email
            message.setContent(multipart);

            // Envia o email
            Transport.send(message);
            System.out.println("Email enviado com sucesso para: " + destinatario);
        } catch (MessagingException | java.io.IOException e) {
            e.printStackTrace();
        }
    }
}
