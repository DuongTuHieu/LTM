import java.util.Scanner;

public class LopClassCuaOctet {
	public static void main(String[] args) {
		   Scanner scanner = new Scanner(System.in);
	        System.out.print("Nhập vào Octet bất kỳ: ");
	        String M = scanner.nextLine();
	
	        int Octet = Integer.parseInt(M);
	      while(true) {
	    if (Octet > 239 && Octet<256  ) {
	      System.out.println("Octet "+Octet +" là class E"); 
	    }  
	    else if(Octet < 240 && Octet > 223) {
	    	System.out.println("Octet "+Octet +" là class D"); 
	    }
	    else if(Octet <224 && Octet > 191) {
	    	System.out.println("Octet "+Octet +" là class C"); 
	    }
	    else if(Octet <192 && Octet >127 ) {
	    	System.out.println("Octet "+Octet +" là class B"); 
	    }
	    else if(Octet <127 && Octet > 0) {
	    	System.out.println("Octet "+Octet +" là class A"); 
	    }
	    else  {
	    	System.out.println("Octet " + Octet +" Của bạn không thuôc class nào" ); 
	    }
	    System.out.println("Bạn có muốn tiếp tục(Y/N)");
	    String Y = scanner.nextLine();
        scanner.close();
        if (Y.equals("N")) {
        break;	
        }
        
	  }
	        }
	}

	
