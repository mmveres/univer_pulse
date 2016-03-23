package prjSocketObject;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerObj {
	private ServerSocket server = null;
	private Socket sock = null;
	private ObjectOutputStream out = null;
	private ObjectInputStream in = null;

	// ��������� ������
	public void start(int port) throws IOException {
		server = new ServerSocket(port);
		System.out.println(server);
		while (true) {
			// ��������� ���������� �� ������ �������
			sock = server.accept();
			System.out.println("accept "+sock);
			// �������� ������ �����-������
			in = new ObjectInputStream(sock.getInputStream());
			out = new ObjectOutputStream(sock.getOutputStream());
			System.out.println("after accept "+sock);
			// ���� ���������� �������, ������������ �������
			while (processQuery())
				;
		}
	}

	// ��������� �������
	private boolean processQuery() {
		try {
			// ������� ������ �� �������
			Calc calc=null;
			try {
				calc= (Calc)in.readObject();
				System.out.println(calc);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int oper = calc.oper; // ��������
			int v1 = calc.value1; // ����� 1
			int v2 = calc.value2; // ����� 2
			// ������ ���������
			// ��������� ��������
			calc.res = (oper == 0) ? (v1 + v2) : (v1 - v2);
			// ��������� ��������� �������
			System.out.println(calc);
			out.writeObject(calc);
			return true;
		} catch (IOException e) {
			return false;
		}
	}// ������� �����

	public static void main(String[] args) {
		try {
			ServerObj srv = new ServerObj();
			srv.start(12345);
			
		} catch (IOException e) {
			System.out.println("�������� ������");
		}
	}
}
