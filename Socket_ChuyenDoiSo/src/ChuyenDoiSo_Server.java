import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ChuyenDoiSo_Server {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ServerSocket socketServer = new ServerSocket(8989);
			System.out.print("I'm listening on 8989 port ...");
			while(true) {
				Socket socketClient = socketServer.accept(); // chấp nhận kết nối 
				
				System.out.print(socketClient.getInetAddress().getHostAddress()); // nhập giống thầy
				
				OutputStream osToClient = socketClient.getOutputStream();	
				OutputStreamWriter write2Client = new OutputStreamWriter(osToClient);
				BufferedWriter buffW = new BufferedWriter(write2Client);
			
				InputStream in = socketClient.getInputStream();
				InputStreamReader inReader = new InputStreamReader(in);
				BufferedReader buffR = new BufferedReader(inReader);
				
				//Gửi hello
				String chuoiHello_Gui = "Hello bạn muốn trả về số  mấy nào ? ";
				buffW.write(chuoiHello_Gui+ "\n" );
				buffW.flush();
				//Nhận về sô và trả lời
				String chuoiSo0_Nhan = buffR.readLine();
				String chuoiTraLoi0 = "Không ";
				buffW.write(chuoiTraLoi0+ "\n" );
				buffW.flush();
		
		
				
				buffW.flush();
				}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
