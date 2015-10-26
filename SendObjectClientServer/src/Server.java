import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class Server {
	private ServerSocket serverSocket = null;
	private Socket socket = null;
	private ObjectInputStream inStream = null;

	public Server() {

	}

	public void communicate() {
		try {
			serverSocket = new ServerSocket(4445);
			socket = serverSocket.accept();
			System.out.println("Connected");
			inStream = new ObjectInputStream(socket.getInputStream());

			Student student = (Student) inStream.readObject();
			System.out.println("Object received = " + student);
			socket.close();

		} catch (SocketException se) {
			System.exit(0);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException cn) {
			cn.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Server server = new Server();
		server.communicate();
	}
}
