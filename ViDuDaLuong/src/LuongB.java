
public class LuongB extends Thread {
@Override
public void run() {
	for(int i=1 ; i<100;i+=2)
		System.out.print("\n B "+i);
}
}
