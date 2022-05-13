package Hieu61133644;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class XuLyFile_Client {
	public static void main(String[] args) {
		try {
			
			Socket socket = new Socket("localhost",9999);
			System.out.print("Conected!");
			InputStream in = socket.getInputStream();
			InputStreamReader inReader = new InputStreamReader(in);
			BufferedReader buffR = new BufferedReader(inReader);

			OutputStream osToClient = socket.getOutputStream();	
			OutputStreamWriter write2Client = new OutputStreamWriter(osToClient);
			BufferedWriter buffW = new BufferedWriter(write2Client);

			Scanner banPhim = new Scanner(System.in);
		while(true) {
				System.out.print("\nClient(Create/Delete/Get + tenFile): ");
				String chuoiGui = banPhim.nextLine();
				 char character = chuoiGui.charAt(0);
				 buffW.write(character+"\n");
				switch (character) {
                case 'c':
                	String[] split = chuoiGui.split("create ");
   				 	for (String item : split) {
   					buffW.write(item+"\n");
   				 	buffW.flush();
   				 }
               
                case 'd':
                	String[] splits = chuoiGui.split("delete ");
   				 	for (String item : splits) {
   					buffW.write(item+"\n");
   				 	buffW.flush();
   				 	}
          
                case 'g':
                	String[] splitss = chuoiGui.split("get ");
   				 	for (String item : splitss) {
   					buffW.write(item+"\n");
   				 	buffW.flush();
   				 	}
                 
           
				}
				 
				String chuoiNhan = buffR.readLine();
				System.out.print("Server: "+ chuoiNhan);
				
			
			}	
		}
		catch(Exception e) {
			System.out.print(e.getMessage());
		}
	}
}
