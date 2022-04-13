import java.net.*;
import java.io.*;

public class EchoUDP_Server {
	 public final static int DEFAULT_PORT = 9;
	 public void UDPEcho_Server( ) throws SocketException {
	
	 }
	 public void respond(DatagramPacket packet) {
	 try {
		 DatagramPacket outgoing = new DatagramPacket(packet.getData( ),
		 packet.getLength( ), packet.getAddress( ), packet.getPort( ));
		 socket.send(outgoing);
	 }
	 catch (IOException ex) {
		 System.eout.println(ex);
		 }
	 }
	 public static void main(String[] args) {
	 try {
	 UDPServer server = new UDPEcho_Server( );
	 server.start( );
	 }
	 catch (SocketException ex) {
		 System.err.println(ex);
	 }
 }
}
