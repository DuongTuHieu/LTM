import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			Socket soc = new Socket("localhost",8888);
		System.out.print("Conected!");
		InputStream in = soc.getInputStream();
		InputStreamReader inReader = new InputStreamReader(in);
		BufferedReader buff = new BufferedReader(inReader);
		System.out.print(buff.readLine());
		}
		catch(IOException e) {
			e.printStackTrace();		}
	}

}
