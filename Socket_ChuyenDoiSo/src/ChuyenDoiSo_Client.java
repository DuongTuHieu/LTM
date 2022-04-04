import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChuyenDoiSo_Client {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
try {
	Socket soc = new Socket("localhost",8989);
	System.out.print("Conected!\n");
	
	InputStream in = soc.getInputStream();
	InputStreamReader inReader = new InputStreamReader(in);
	BufferedReader buffR = new BufferedReader(inReader);

	OutputStream osToClient = soc.getOutputStream();	
	OutputStreamWriter write2Client = new OutputStreamWriter(osToClient);
	BufferedWriter buffW = new BufferedWriter(write2Client);
	
	Scanner banPhim = new Scanner(System.in);
	//=====THIẾT KẾ GIAO THỨC ======
	String chuoiHello_Nhan = buffR.readLine();
	System.out.println("BMI server: " + chuoiHello_Nhan);
	
	String chuoiSo0_Gui = "0";
	buffW.write(chuoiSo0_Gui +"\n");
	buffW.flush();
	String chuoiSo0_Nhan = buffR.readLine();
	System.out.println("BMI server: " + chuoiSo0_Nhan);
	
			buffW.flush();

	
} catch (Exception e) {
	// TODO: handle exception
	e.printStackTrace();
}
	}


}
