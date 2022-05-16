import java.util.Scanner;

public class ChuyenHostInterfaceVaMatNaMang {
	
	public static void main(String[] args) {
        Scanner ip = new Scanner(System.in);
        System.out.println("Nhập địa chỉ IP của host interface: ");
        String IP = ip.nextLine();
        System.out.println("Nhập mặt nạ mạng:");
        String Subnet_Mask = ip.nextLine();
        String[] arrIP, arrSubnet_mark;
        int[] result = new int[4];
        arrIP = IP.split(".");
        arrSubnet_mark = Subnet_Mask.split(".");
        int O = Integer.parseInt(arrSubnet_mark[0]);
        if(O <= 126) {
            System.out.println("Mặt nạ mạng lớp A");
            result[0] = Integer.parseInt(arrIP[0]);
            result[1] = 0;
            result[2] = 0;
            result[3] = 0;
        } else {
            if((O > 127) && (O <= 191)) {
                System.out.println("Mặt nạ mạng lớp B");
                result[0] = Integer.parseInt(arrIP[0]);
                result[1] = Integer.parseInt(arrIP[1]);
                result[2] = 0;
                result[3] = 0;
            } else if(O <= 223) {
                System.out.println("Mặt nạ mạng lớp C");
                result[0] = Integer.parseInt(arrIP[0]);
                result[1] = Integer.parseInt(arrIP[1]);
                result[2] = Integer.parseInt(arrIP[2]);
                result[3] = 0;
            }
        }
        String rs = result[0] + "." + result[1] + "." + result[2] + "." + result[3];
        System.out.println("Địa chỉ mạng là: " + rs);
    }
}