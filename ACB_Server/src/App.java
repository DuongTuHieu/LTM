import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			ServerSocket socketServer = new ServerSocket(8888);
			System.out.print("Tôi lắng nghe trong 8888 cổng ...");
			while(true) {
				Socket socketClient = socketServer.accept();
				OutputStream osToClient = socketClient.getOutputStream();	
				OutputStreamWriter write2Client = new OutputStreamWriter(osToClient);
				write2Client.write("Xin Chào");
				BufferedWriter buffW = new BufferedWriter(write2Client);
				buffW.write("Xin Chào\n");
				buffW.flush();
				socketClient.close();
				//socketServer.close();
			}
		
		}
		catch(IOException e) {
			e.printStackTrace();		}
	}

}
