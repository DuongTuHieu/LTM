import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ChuyenIPvaMacSangAdress {
	  public static void main(String[] args) throws IOException {

	        System.out.println("Nhập IP:");
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        String ip = br.readLine();
	        String checkclass = ip.substring(0, 3);



	        int cc = Integer.parseInt(checkclass);
	        System.out.println("Nhập mặt nạ mạng : ");
	        String mask = br.readLine();


	        String networkAddr="";
	        String[] ipAddrParts=ip.split("\\.");
	        String[] maskParts=mask.split("\\.");

	        for(int i=0;i<4;i++){
	            int x=Integer.parseInt(ipAddrParts[i]);
	            int y=Integer.parseInt(maskParts[i]);
	            int z=x&y;
	            networkAddr+=z+".";
	        }

	        System.out.println("Địa chỉ nhận được là:\n"+networkAddr);
	    }
}
