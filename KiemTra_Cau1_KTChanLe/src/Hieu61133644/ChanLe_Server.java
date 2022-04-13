package Hieu61133644;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
public class ChanLe_Server extends Thread{
	Socket socketClient;
	int id = -1;
	

	public ChanLe_Server(Socket socketClient, int id) {
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
				
			while(true){
				String chuoiNhan=buffR.readLine();
				System.out.print(chuoiNhan);
				float i = Integer.parseInt(chuoiNhan);
				if( (i%2) ==0 ) {
					if(chuoiNhan.equals("0")) break;
					String chuoiGui = " Chẵn";
					buffW.write(chuoiGui +"\n");
					buffW.flush();
					
				}else {
					if(chuoiNhan.equals("0")) break; 
					String chuoiGui = "Lẻ";

					buffW.write(chuoiGui +"\n");
					buffW.flush();

				} 
				

				
			}
			socketClient.close();

				}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
