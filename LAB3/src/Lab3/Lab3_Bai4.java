package Lab3;
import java.util.Arrays;
import java.util.Scanner;
public class Lab3_Bai4 {
	public static void sapxep(String sv[], float DiemSV[]) {
		for(int i=0;i<sv.length-1;i++)
		{
			for(int j=i+1;j<sv.length;j++) {
				if(DiemSV[i]>DiemSV[j]) {
					float tam=DiemSV[i];
					DiemSV[i]=DiemSV[j];
					DiemSV[j]=tam;
					String svTam= sv[i];
					sv[i]=sv[j];
					sv[j]=svTam;
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int n;
		String sv[] = new String[3];
		float DiemSV[] = new float[3];
		
		Scanner nhap=new Scanner(System.in);
		//System.out.print("Nhap so phan tu cua mang: ");
		//n = nhap.nextInt();
		for(int i=0;i<3;i++)
		{
			System.out.printf("Tên sinh viên thứ "+ i +" là: ");
			sv[i]=nhap.nextLine();
			System.out.printf("Điểm sinh viên thứ "+ i+" là: ");
			DiemSV[i]=nhap.nextFloat();
		}
		System.out.println("Tên sinh viên "+Arrays.toString(sv));
		System.out.println("Điểm sinh viên "+Arrays.toString(DiemSV));
		
		sapxep(sv,DiemSV);
		
		for(int i=0;i<3;i++) {
			System.out.println("Họ tên "+sv[i]);
			System.out.println("Điểm sinh viên"+DiemSV[i]);
			if(DiemSV[i]>=9) {
				System.out.println("Xuất Sắc");
			}else if(DiemSV[i]>=7.5) {
				System.out.println("Giỏi");
			}else if(DiemSV[i]>=6.5) {
				System.out.println("Khá");
			}else if(DiemSV[i]>=5) {
				System.out.println("Trung bình");
			} else {
				System.out.println("Yếu");
			}
			System.out.println();
		}
}
}
