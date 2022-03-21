import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class AppEchoClient {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			Socket soc = new Socket("localhost",9999);
		System.out.print("Conected!\n");
		InputStream in = soc.getInputStream();
		InputStreamReader inReader = new InputStreamReader(in);
		BufferedReader buffR = new BufferedReader(inReader);

		OutputStream osToClient = soc.getOutputStream();	
		OutputStreamWriter write2Client = new OutputStreamWriter(osToClient);
		BufferedWriter buffW = new BufferedWriter(write2Client);
		// lấy chuỗi nhập từ bàn phím
		Scanner banPhim = new Scanner(System.in);
		while(true) 
		{
		
		System.out.print("\nClient:");
		String chuoiGui = banPhim.nextLine();
		//Gửi đi
	
		buffW.write(chuoiGui+"\n");
		buffW.flush();
		//Nhận về
		String chuoiNhan = buffR.readLine();
		System.out.print("Server: "+ chuoiNhan);

		if(chuoiGui.equals("Bye")) break;
		}
		soc.close();
		}
			catch(IOException e) {
			e.printStackTrace();		}
	}
}
