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

	// запустить сервер
	public void start(int port) throws IOException {
		server = new ServerSocket(port);
		System.out.println(server);
		while (true) {
			// Принимаем соединение от нового клиента
			sock = server.accept();
			System.out.println("accept "+sock);
			// Получаем потоки ввода-вывода
			in = new ObjectInputStream(sock.getInputStream());
			out = new ObjectOutputStream(sock.getOutputStream());
			System.out.println("after accept "+sock);
			// Пока соединение активно, обрабатываем запросы
			while (processQuery())
				;
		}
	}

	// обработка запроса
	private boolean processQuery() {
		try {
			// Получаю запрос от клиента
			Calc calc=null;
			try {
				calc= (Calc)in.readObject();
				System.out.println(calc);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int oper = calc.oper; // Операция
			int v1 = calc.value1; // Число 1
			int v2 = calc.value2; // Число 2
			// Считаю результат
			// Результат операции
			calc.res = (oper == 0) ? (v1 + v2) : (v1 - v2);
			// Отправляю результат клиенту
			System.out.println(calc);
			out.writeObject(calc);
			return true;
		} catch (IOException e) {
			return false;
		}
	}// главный метод

	public static void main(String[] args) {
		try {
			ServerObj srv = new ServerObj();
			srv.start(12345);
			
		} catch (IOException e) {
			System.out.println("Возникла ошибка");
		}
	}
}
