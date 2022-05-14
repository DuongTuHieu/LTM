import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class CTChinh_AmDuong {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ServerSocket socketServer = new ServerSocket(8888);
		System.out.print("Tôi lắng nghe trong cổng 8888  ...");
		int id =0;
		while(true) {
			Socket s = socketServer.accept();
			AmDuong_Server luongTask = new AmDuong_Server(s, id);
			luongTask.start();
		}
	}
}
