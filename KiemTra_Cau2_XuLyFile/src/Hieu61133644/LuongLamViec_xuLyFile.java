package Hieu61133644;

import java.io.BufferedReader;
import java.io.BufferedWriter;
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
		void TaoFile(String tenFile) throws IOException{
			
			FileReader fr = new FileReader(tenFile);
			BufferedReader buffRead = new BufferedReader(fr);
			OutputStream osToClient = socketClient.getOutputStream();	
			OutputStreamWriter write2Client = new OutputStreamWriter(osToClient);
			BufferedWriter buffW = new BufferedWriter(write2Client);
		
			fr.close();
			
		}
		void TaiFile(String tenFile) throws IOException{
			
			FileReader fr = new FileReader(tenFile);
			BufferedReader buffRead = new BufferedReader(fr);
			OutputStream osToClient = socketClient.getOutputStream();	
			OutputStreamWriter write2Client = new OutputStreamWriter(osToClient);
			BufferedWriter buffW = new BufferedWriter(write2Client);
			String line;
			
			fr.close();
			
		}
		void XoaFile(String tenFile) throws IOException{
			
			FileReader fr = new FileReader(tenFile);
			BufferedReader buffRead = new BufferedReader(fr);
			OutputStream osToClient = socketClient.getOutputStream();	
			OutputStreamWriter write2Client = new OutputStreamWriter(osToClient);
			BufferedWriter buffW = new BufferedWriter(write2Client);
		
			fr.close();
			
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
					System.out.print("\n"+chuoiNhan);
					
				
				}
			
			
		}
	catch (Exception e) {
	// TODO: handle exception
	e.printStackTrace();
	}
		}
}
