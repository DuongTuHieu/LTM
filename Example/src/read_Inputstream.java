import java.io.IOException;
import java.io.InputStream;


public class read_Inputstream {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputStream banphim = System.in; // tạo đối tượng và gán bằng luồng nhập chuẩn "System.in"
		// đọc ký tự từ bàn phím
		System.out.print("Mời nhập vào ký tự: ");
		int kt = banphim.read();
		System.out.print("Ký tự nhập là: " +(char)kt);
		
//		try {
//			System.out.print("Mời nhập vào ký tự: ");
//			int kt = banphim.read();
//			// nơi thực hiện các khả năng sinh ra lỗi
//			System.out.print("Ký tự nhập là: " +(char)kt);
//		} catch (IOException e) {
////			e.printStackTrace();
//			System.out.print("Bị lỗi rồi!!");
//			// nơi xử lý nếu có lỗi xảy ra
//		}

	}

}