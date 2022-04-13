package Hieu61133644;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class CTChinh_ChanLe {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ServerSocket socketServer = new ServerSocket(8888);
		System.out.print("Tôi lắng nghe trong cổng 8888  ...");
		int id =0;
		while(true) {
			Socket s = socketServer.accept();
			ChanLe_Server luongTask = new ChanLe_Server(s, id);
			luongTask.start();
		}
	}
}
