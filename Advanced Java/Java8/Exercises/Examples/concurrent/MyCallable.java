package concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MyCallable implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		int x=(int)(Math.random()*10);
		if(x%2==0)return x;
		throw new Exception("not even..");
	}
	
	public static void main(String[] args) {
		ExecutorService exe=Executors.newFixedThreadPool(2);
		
		List<Callable<Integer>> tasks=new ArrayList<>();
		tasks.add(new MyCallable());
		tasks.add(new MyCallable());
		tasks.add(new MyCallable());
		tasks.add(new MyCallable());
		
		try {
			List<Future<Integer>> result=exe.invokeAll(tasks);
			//after completed...
			for(Future<Integer> f:result){
				try{
					System.out.println(f.get());
				}catch (ExecutionException e) {
					System.out.println(e.getCause().getMessage());
				}
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
