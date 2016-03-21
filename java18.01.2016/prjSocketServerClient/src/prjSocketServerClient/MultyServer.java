package prjSocketServerClient;

import java.io.*;
import java.net.*;
import java.util.ArrayList;



public class MultyServer {
class ServeOneJabber extends Thread {
   private Socket socket;
   private BufferedReader in;
   private PrintWriter out;
  
   public ServeOneJabber(Socket s) throws IOException {
      socket = s;
      in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      // Включаем автоматическое выталкивание:
      out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket
            .getOutputStream())), true);
      // Если любой из вышеприведенных вызовов приведет к
      // возникновению исключения, то вызывающий отвечает за
      // закрытие сокета. В противном случае, нить
      // закроет его.
      start(); // вызываем run()
   }
  
   public void run() {
      try {
         while (true) {
            String str = in.readLine();
            if (str.equals("END"))
               break;
            System.out.println("Echoing: " + str);
            
            for (int i = 0; i < listClient.size(); i++) {
				 listClient.get(i).out.println(str);
			}
        /*    for (ServeOneJabber iter : listClient) {
				iter.out.println(str);
			}*/
            
         }
         System.out.println("closing...");
      }
      catch (IOException e) {
         System.err.println("IO Exception");
      }
      finally {
         try {
            socket.close();
         }
         catch (IOException e) {
            System.err.println("Socket not closed");
         }
      }
   }
}
static ArrayList<ServeOneJabber> listClient=new ArrayList<>();	
   static final int PORT = 8080;
  
   public static void main(String[] args) throws IOException {
	   MultyServer multyServ=new MultyServer(); 
      ServerSocket s = new ServerSocket(PORT);
      
      System.out.println("Server Started");
      try {
         while (true) {
            // Блокируется до возникновения нового соединения:
            Socket socket = s.accept();
            try {
               listClient.add(multyServ.new ServeOneJabber(socket));
            }
            catch (IOException e) {
               // Если завершится неудачей, закрывается сокет,
               // в противном случае, нить закроет его:
               socket.close();
            }
         }
      }
      finally {
         s.close();
      }
   }
}
