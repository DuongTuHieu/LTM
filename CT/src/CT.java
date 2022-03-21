import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/*
 * sử dụng đối tượng URL, đọc mã nguồn HTMl trang web
 * 
 * */
public class CT {

	public static void main(String[] args) throws IOException {
		//
		String  chuoiURL="https://ntu.edu.vn/Gioi-thieu/Thong-%C4%91iep-cua-Hieu-truong";
		//
		URL u = new URL (chuoiURL);
		// lấy về luồng nhập
		InputStream in = u.openStream();
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