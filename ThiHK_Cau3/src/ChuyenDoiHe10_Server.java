import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ChuyenDoiHe10_Server extends Thread {
	Socket socketClient;
	int id = -1;
	

	public ChuyenDoiHe10_Server(Socket socketClient, int id) {
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
				 int num = Integer.parseInt(chuoiNhan,16);
				
					buffW.write(num +"\n");
					buffW.flush();
				if(chuoiNhan.equals("#")) break;
					
			}
			socketClient.close();

				}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
