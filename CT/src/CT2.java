import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/*
 * sử dụng đối tượng URLConnection, đọc mã nguồn HTMl trang web
 * 
 * */
public class CT2 {

	public static void main(String[] args) throws IOException {

		String  chuoiURL="https://ntu.edu.vn/Gioi-thieu/Thong-%C4%91iep-cua-Hieu-truong";
		//
		URL u = new URL (chuoiURL);
		
		// mở kết nối
		URLConnection uCon = u.openConnection();
		uCon.connect();
		
		// lấy về luồng nhập
		InputStream in = uCon.getInputStream();
		
		
		InputStreamReader inR = new InputStreamReader(in);
		BufferedReader buff = new BufferedReader(inR);
		String lineHTML;
		while(true)
		{
			lineHTML = buff.readLine();
			if(lineHTML == null) break;
			else 
				System.out.println(lineHTML);
		}
		
		
		
		buff.close();
		inR.close();
		in.close();
		
	}
}