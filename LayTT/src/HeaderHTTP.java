import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class HeaderHTTP {

	public static void main(String[] args) throws IOException {

		String  chuoiURL="https://ntu.edu.vn/Gioi-thieu/Thong-%C4%91iep-cua-Hieu-truong";
		//
		URL u = new URL (chuoiURL);
		
		// mở kết nối
		URLConnection uCon = u.openConnection();
		uCon.connect();
		
		// lấy thông tin Header
		System.out.print("ContentType: " + uCon.getContentType());
	}

}