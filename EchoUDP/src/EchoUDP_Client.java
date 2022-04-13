import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class EchoUDP_Client {
	public static void main(String[] args) {
		 String hostname = "localhost";
		 int port = 9;
		 if (args.length > 0) {
		 hostname = args[0];
		 }
		 try {
		 InetAddress ia = InetAddress.getByName(hostname);
		 Thread sender = new SenderThread(ia, 9);
		 sender.start( );
		 Thread receiver = new ReceiverThread(sender.getSocket( ));
		 receiver.start( );
		 }
		 catch (UnknownHostException ex) {
		 System.err.println(ex);
	}
	
	catch (SocketException ex) {
		 System.err.println(ex);
		 }
	}
}
