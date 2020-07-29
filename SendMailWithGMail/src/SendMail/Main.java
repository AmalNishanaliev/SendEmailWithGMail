package SendMail;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Login:");
        String username = scanner.nextLine();
        System.out.println("Enter password");
        String password = scanner.nextLine();
        System.out.println("To");
        String[] to = scanner.nextLine().split("\\s+"); // list of recipient email addresses
        System.out.println("Subject");
        String subject = scanner.nextLine();
        System.out.println("Text");
        String body = scanner.nextLine();

        SenderMail senderMail = new SenderMail(username, password, to);
        senderMail.sendFromGMail(subject, body);
    }
}
