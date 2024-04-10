import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    @Autowired
    private JavaMailSender emailSender;

    @PostMapping("/envoyer-email")
    public ResponseEntity<String> envoyerEmail(@RequestBody String texte) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("votre_email@gmail.com");
            message.setTo("destinataire@example.com");
            message.setSubject("Nouveau Message");
            message.setText(texte);
            emailSender.send(message);
            return ResponseEntity.ok("E-mail envoyé avec succès !");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de l'envoi de l'e-mail.");
        }
    }
}
