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

import javax.swing.filechooser.FileNameExtensionFilter;

public class LuongLamViec_xuLyFile extends Thread{
	Socket socketClient;
	int id = -1;
	public LuongLamViec_xuLyFile(Socket socketClient, int id) {
		super();
		this.socketClient = socketClient;
		this.id = id;
	}
	public boolean guifile(File tenFile)throws IOException{
		FileReader fr = new FileReader(tenFile);
		BufferedReader buffR = new BufferedReader(fr);

		OutputStream osToClient = socketClient.getOutputStream();
		OutputStreamWriter write2client = new OutputStreamWriter(osToClient);
		BufferedWriter buffW = new BufferedWriter(write2client);

		String line;
		while((line=buffR.readLine()) != null) {
			buffW.write(line);
			buffW.flush();
		}
		fr.close();
		return true ;
	}
	
	public void run() {
		try {
			System.out.print(socketClient.getInetAddress().getHostAddress());
			System.out.print(id);
			
			OutputStream osToClient = socketClient.getOutputStream();
			OutputStreamWriter W2client = new OutputStreamWriter(osToClient);
			BufferedWriter buffW = new BufferedWriter(W2client);
			
			InputStream in = socketClient.getInputStream();
			InputStreamReader R2client = new InputStreamReader(in);
			BufferedReader buffR = new BufferedReader(R2client);
			while(true) {
				String chuoinhan = buffR.readLine();
				String name = null;
				if(chuoinhan.contains("create")) {
					for (String item : chuoinhan.split("create ")) {
						name = item;
					}
					File file = new File("D://"+ name); 
					if (file.createNewFile()) {
						buffW.write("\nĐã tạo file " + name + " thành công!");
						buffW.flush();
					}
					else {
						System.out.print("\nĐã tạo file " + name + " thất bại!");
						buffW.write("\nĐã tạo file " + name + " thất bại!");
						buffW.flush();
					}
				}
				if(chuoinhan.contains("delete")) {
					for (String item : chuoinhan.split("delete ")) {
						name = item;
					}
					File file = new File("D://"+ name); 
					if(file.delete()) {
						buffW.write("\nĐã xóa file " + name + " thành công!");
						buffW.flush();
					}
					else {
						buffW.write("\nXóa file " + name + " thất bại!");
						buffW.flush();
					}
				}
				if(chuoinhan.contains("get")) {
					for (String item : chuoinhan.split("get ")) {
						name = item;
					}
					File file = new File("D://"+ name); 
					boolean chuoigui = guifile(file);
					buffW.write(chuoigui+"\n");
					buffW.flush();
					
//					if(guifile(file)) {
//						System.out.print("\nDa tai file thanh cong!");
//					}
//					else {
//						System.out.print("\nTai file that bai");
//						String chuoigui = "Tai file that bai";
//						buffW.write(chuoigui+"\n");
//						buffW.flush();
//					}
				}
				if(chuoinhan.contains("end")) {
					String chuoigui="Kết thúc";
					buffW.write(chuoigui+"\n");
					buffW.flush();
					break;
				}
			}
		}catch(Exception e) {
			System.out.print(e.getMessage());
		}
	}
}
