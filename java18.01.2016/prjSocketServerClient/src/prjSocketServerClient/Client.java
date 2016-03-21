package prjSocketServerClient;

import java.net.*;
import java.io.*;

public class Client {
	
   public static void main(String[] args) throws IOException {
      // �������� null � getByName(), �������
      // ����������� IP ����� "��������� ��������"
      // ��� ������������ �� ������ ��� ����:
      InetAddress addr = InetAddress.getByName(null);
      // �������������, �� ������ ������������
      // ����� ��� ���:
      // InetAddress addr =
      // InetAddress.getByName("127.0.0.1");
      // InetAddress addr =
      // InetAddress.getByName("localhost");
      System.out.println("addr = " + addr);
      Socket socket = new Socket("localhost", 8080);
      // �������� ��� � ���� try-finally, �����
      // ���� ���������, ��� ����� ���������:
      try {
         System.out.println("socket = " + socket);
         BufferedReader in = new BufferedReader(new InputStreamReader(socket
               .getInputStream()));
         // ����� ������������� Output ������������� PrintWriter'��.
         final PrintWriter out = new PrintWriter(new BufferedWriter(
               new OutputStreamWriter(socket.getOutputStream())), true);
        new Thread(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					BufferedReader consoleIn= new BufferedReader(
        			new InputStreamReader(System.in)); 
					while(true)
					try {
						out.println("from console "+consoleIn.readLine());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}).start(); 
        
        for (int i = 0; i < 10; i++) {
         
            String str = in.readLine();
            System.out.println("From server ="+str);
         }
        // out.println("END");
      }
      finally {
         System.out.println("closing...");
         socket.close();
      }
   }
}
