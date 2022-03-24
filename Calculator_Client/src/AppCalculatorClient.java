import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class AppCalculatorClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Client is conecting ...");
			Socket socket =  new Socket("localhost",7777);
			System.out.println("Client connected");
			DataOutputStream output = new DataOutputStream(socket.getOutputStream());
			DataInputStream input = new DataInputStream(socket.getInputStream());
			
			InputStreamReader inReader = new InputStreamReader(input);
			BufferedReader buffR = new BufferedReader(inReader);
			
			OutputStreamWriter write2Client = new OutputStreamWriter(output);
			BufferedWriter buffW = new BufferedWriter(write2Client);
			
			while(true) {
				System.out.print(buffR.readLine());
				output.writeDouble(sc.nextDouble());
				output.flush();
				
				System.out.print(buffR.readLine());
				output.writeDouble(sc.nextDouble());
				output.flush();
				
				System.out.print(buffR.readLine());
				output.writeChar(sc.nextShort());
				output.flush();
				
			     Double kq = input.readDouble();
		         System.out.println("kết quả:" + kq);
		     	System.out.print(buffR.readLine());
				String rep = sc.next();
				if(rep.equalsIgnoreCase("N")) {
					break;
				}
				socket.close();
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
