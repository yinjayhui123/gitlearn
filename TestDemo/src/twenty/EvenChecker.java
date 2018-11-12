package twenty;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EvenChecker implements Runnable {

	public Object ob = new Object();
	private IntGenerator gen;
	private final int id;
	
	public EvenChecker(IntGenerator g,int id){
		this.gen = g;
		this.id = id;
	}
	
	@Override
	public void run() {
		while(!gen.isCanceled()){
			int val = gen.next();
			System.out.println("val="+val+",id="+id);
			if(val % 3 == 0 ){
				System.out.println("val="+val+" not even!");
				gen.cancel();
			}
		}
		
	}
	
	public static void test(IntGenerator g,int count){
		ExecutorService exec = Executors.newCachedThreadPool();
		List<EvenChecker> list = new ArrayList<EvenChecker>();
		EvenChecker v = null;
		for(int i =0 ;i<count;i++){
			v = new EvenChecker(g, i);
			list.add(v);
			exec.execute(new EvenChecker(g, i));
		}
		exec.shutdown();
	}

}
