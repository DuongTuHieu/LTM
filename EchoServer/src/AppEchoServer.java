
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class AppEchoServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			ServerSocket socketServer = new ServerSocket(9999);
			System.out.print("Tôi lắng nghe trong cổng 9999  ...");
			while(true) {
				Socket socketClient = socketServer.accept();
				OutputStream osToClient = socketClient.getOutputStream();	
				OutputStreamWriter write2Client = new OutputStreamWriter(osToClient);
				BufferedWriter buffW = new BufferedWriter(write2Client);
			
				InputStream in = socketClient.getInputStream();
				InputStreamReader inReader = new InputStreamReader(in);
				BufferedReader buffR = new BufferedReader(inReader);
				while(true) {
				String chuoiNhan = buffR.readLine();
				//Gửi trả
				String chuoiGui = chuoiNhan;
				buffW.write(chuoiGui+"\n");
				buffW.flush();
				if(chuoiGui.equals("Bye")) break;
			}
				socketClient.close();
				}
		
		}
		catch(IOException e) {
			e.printStackTrace();		}
	}

}
