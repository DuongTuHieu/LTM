import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class LuongLamViec_DocFile extends Thread{
	Socket socketClient;
	int id = -1;
	

	public LuongLamViec_DocFile(Socket socketClient, int id) {
		super();
		this.socketClient = socketClient;
		this.id = id;
}
	void GuiFile(String tenFile) throws IOException{
		
		FileReader fr = new FileReader(tenFile);
		BufferedReader buffRead = new BufferedReader(fr);
		OutputStream osToClient = socketClient.getOutputStream();	
		OutputStreamWriter write2Client = new OutputStreamWriter(osToClient);
		BufferedWriter buffW = new BufferedWriter(write2Client);
		String line;
		while((line = buffRead.readLine()) != null) {
			buffW.write(line);
			buffW.flush();
		}
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
		
		socketClient.close();
	}
catch (Exception e) {
// TODO: handle exception
e.printStackTrace();
}
	}
	}
