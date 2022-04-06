import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class CT_ChinhDocFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ServerSocket socketServer = new ServerSocket(9999);
		System.out.print("Tôi lắng nghe trong cổng 9999  ...");
		int id =0;
		while(true) {
			Socket s = socketServer.accept();
			LuongLamViec_DocFile luongTask = new LuongLamViec_DocFile(s, id);
			luongTask.start();
		}
	}

}
