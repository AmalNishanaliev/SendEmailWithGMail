package SendMail;

public class Main {

    public static void main(String[] args) {

        String[] to = { "test@gmail.com" }; // list of recipient email addresses
        String subject = "Test subject";
        String body = "Test text body";
        String username = "Username@gmail.com";
        String password = "password";

        SenderMail senderMail = new SenderMail(username, password, to);
        senderMail.sendFromGMail(subject, body);
    }
}
