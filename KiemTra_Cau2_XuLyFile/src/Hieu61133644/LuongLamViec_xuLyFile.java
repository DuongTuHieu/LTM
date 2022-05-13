package Hieu61133644;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class LuongLamViec_xuLyFile extends Thread{
		Socket socketClient;
		int id = -1;
		

		public LuongLamViec_xuLyFile(Socket socketClient, int id) {
			super();
			this.socketClient = socketClient;
			this.id = id;
	}
		
		@Override
		public void run() {
			try {
				System.out.print(socketClient.getInetAddress().getHostAddress());
				System.out.print(id);
				OutputStream osToClient = socketClient.getOutputStream();	
				OutputStreamWriter write2Client = new OutputStreamWriter(osToClient);
				BufferedWriter buffW = new BufferedWriter(write2Client);
			
				InputStream in = socketClient.getInputStream();
				InputStreamReader inReader = new InputStreamReader(in);
				BufferedReader buffR = new BufferedReader(inReader);
				
			while(true) {
					String chuoiNhan=buffR.readLine();
					String chuoiNhanrong=buffR.readLine();
					String chuoiNhanyc=buffR.readLine();
				
					if(chuoiNhan.equals("c")) {
					 File file = new File("D://"+ chuoiNhanyc); 	
			            if (file.createNewFile())
			                System.out.print("\nĐã tạo file thành công!");
			            else
			                System.out.print("Tạo file thất bại");
					}
					if(chuoiNhan.equals("d")) {
						 File file = new File("D://"+ chuoiNhanyc); 	
				            if (file.delete())
				                System.out.print("\nĐã xóa file thành công!");
				            else
				                System.out.print("Đã xóa file thất bại");
						}
			
			}
		}
	catch (Exception e) {
	// TODO: handle exception
	e.printStackTrace();
	}
		}
}
