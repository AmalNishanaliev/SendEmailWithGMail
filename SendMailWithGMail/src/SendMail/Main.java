package SendMail;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        String username = "AmalNishanaliev@gmail.com";

        String password = "EP422646Amal";

        String[] to = { "doodusikk@gmail.com" }; // list of recipient email addresses

        String subject = "Это тема сообщения";

        String body = "Это Атааааакааааааа";

        SenderMail senderMail = new SenderMail(username, password, to);
        senderMail.sendFromGMail(subject, body);
    }
}
