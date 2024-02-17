import java.io.*;
import java.net.*;
public class MyClient {

    // Main driver method
    public static void main(String[] args)
    {

        // Try block to check if exception occurs
        try {

            Socket soc = new Socket("localhost", 8081);

            DataOutputStream dos = new DataOutputStream(
                    soc.getOutputStream());
            DataInputStream dis
                    = new DataInputStream(soc.getInputStream());
            dos.writeUTF("Hello!");
            System.out.println("Client said:= " + "Hello!");
            String input = (String)dis.readUTF();
            System.out.println("Client received:= " + input);
            dos.writeUTF("ы!");
            System.out.println("Client said:= " + "ы!");
            input = (String)dis.readUTF();
            System.out.println("Client received:= " + input);
            dos.writeUTF("хліб");
            System.out.println("Client said:= " + "хліб");
            input = (String)dis.readUTF();
            System.out.println("Client received:= " + input);
            dos.flush();
            dos.close();
            soc.close();
        }

        // Catch block to handle exceptions
        catch (Exception e) {

            // Print the exception on the console
            System.out.println(e);
        }
    }
}
