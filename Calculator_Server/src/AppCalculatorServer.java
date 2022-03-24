import java.io.BufferedReader;
import java.io.BufferedWriter;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class AppCalculatorServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		char kt;
		try {
			ServerSocket svSocket = new ServerSocket(7777);
			System.out.println("Server is connecting...");
			Socket socket = svSocket.accept();
			System.out.println("Server connected");
			DataInputStream input = new DataInputStream(socket.getInputStream());
			DataOutputStream output = new DataOutputStream(socket.getOutputStream());
			
			InputStreamReader inReader = new InputStreamReader(input);
			BufferedReader buffR = new BufferedReader(inReader);
			
			OutputStreamWriter write2Client = new OutputStreamWriter(output);
			BufferedWriter buffW = new BufferedWriter(write2Client);
			
			while(true) {
			
           
				write2Client.write("Nhập vào số a:");
				double a = input.readDouble();
				write2Client.write("Nhập vào số b:");
				double b = input.readDouble();
				write2Client.write("Nhập vào phép tính:");
				char dau = input.readChar();
	

				double kq =   0;
                switch (dau) {
                    case '+':
                        kq = a + b;
                        break;
                    case '-':
                        kq = a - b;
                        break;
                    case '/':
                        kq = a / b;
                        break;
                    case '*':
                        kq = a * b;
                        break;
                    default:
                        break;
                        
                }
                output.writeDouble(kq);
                write2Client.write("Bạn có muốn tiếp tục (Y/N): ");
                String rep = sc.next();
				if(rep.equalsIgnoreCase("N")) {
					break;
				}
                socket.close();			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
