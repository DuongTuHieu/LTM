import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class CTChinh_ChuyenDoiHe10 {
	public static void main(String[] args) throws IOException {
		ServerSocket socketServer = new ServerSocket(8998);
		System.out.print("Tôi lắng nghe trong cổng 8998  ...");
		int id =0;
		while(true) {
			Socket s = socketServer.accept();
			ChuyenDoiHe10_Server luongTask = new ChuyenDoiHe10_Server(s, id);
			luongTask.start();
		}
	}
}
