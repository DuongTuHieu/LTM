import java.net.DatagramSocket;

public class CT {

	public static void main(String[] args) {
		for(int i =0;i<65535;i++) {
		
		try {
			DatagramSocket socket = new DatagramSocket(0);

			socket.close();
			System.out.println("Cổng " +i + " ON");
		} catch (Exception e) {
			System.out.println("Cổng " +i + " OFF");
		}
	}
		}

}
