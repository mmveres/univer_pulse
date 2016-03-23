package prjSocketObject;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientObj {
	private Socket sock = null;
	private ObjectOutputStream out = null;
	private ObjectInputStream in = null;

	// �����������
	public ClientObj(String ip, int port) throws IOException {
		// ������������� ����������
		sock = new Socket(ip, port);
		System.out.println(sock);
		// �������� ������ �����-������
		in = new ObjectInputStream(sock.getInputStream());
		out = new ObjectOutputStream(sock.getOutputStream());
		System.out.println("after");
	}

	// ��������� ������ ������� � �������� �����
	private int sendQuery(int operation, int value1, int value2)
			throws IOException {
		// ��������� ������
		Calc calc= new Calc(operation, value1, value2);
		out.writeObject(calc);
		System.out.println("to serv "+calc);
		// ������� �����
		Calc resCalc = null;
		try {
			resCalc = (Calc)in.readObject();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("from serv "+resCalc);
		return resCalc.res;
	}// ��������� ����� �����

	public int sum(int value1, int value2) throws IOException {
		return sendQuery(0, value1, value2);
	}

	// ��������� �������� �����
	public int sub(int value1, int value2) throws IOException {
		return sendQuery(1, value1, value2);
	}

	// �������������
	public void disconnect() throws IOException {
		sock.close();
	}

	// ������� �����
	public static void main(String[] args) {
		try {
			ClientObj client = new ClientObj("localhost", 12345);
			System.out.println(client);
			int a = client.sum(15, 20);
			int b = client.sub(30, 38);
			int c = client.sum(100, 200);
			System.out.println(a);
			System.out.println(b);
			System.out.println(c);
			client.disconnect();
		} catch (IOException e) {
			System.out.println("�������� ������");
		}
	}
}
