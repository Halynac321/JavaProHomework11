import java.io.*;
import java.net.*;
import java.time.LocalDateTime;

public class MyServer {
    public static void main(String[] args)
    {
        try {
            ServerSocket scvSoc = new ServerSocket(8081);
            Socket soc = scvSoc.accept();
            DataInputStream dis
                    = new DataInputStream(soc.getInputStream());
            DataOutputStream dos = new DataOutputStream(
                    soc.getOutputStream());
            String input = (String)dis.readUTF();
            System.out.println("Srv received:= " + input);
            if (input.equals("Hello!")) {
                System.out.println("Srv responded:= " + "привіт");
                dos.writeUTF("привіт");
            }
            input = (String)dis.readUTF();
            System.out.println("Srv received:= " + input);
            if (input.matches(".*[ЁёъыЭэ].*")) {
                System.out.println("Srv responded:= " + "що таке паляниця?");
                dos.writeUTF("що таке паляниця?");
            }
            input = (String)dis.readUTF();
            System.out.println("Srv received:= " + input);
            if (input.matches(".*[хліб].*")) {
                System.out.println("Srv responded:= " + LocalDateTime.now() + " Bye Bye...");
                dos.writeUTF(LocalDateTime.now() + " Bye Bye...");
            }

            dos.close();
            dis.close();
            soc.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}