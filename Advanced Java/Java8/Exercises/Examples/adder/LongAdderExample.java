package adder;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

public class LongAdderExample {
	
	private static final int NUM_OF_THREADS=3;

	public static void main(String[] args) {
		withAdder(true);
		withAdder(false);
		withAtomicLong(true);
		withAtomicLong(false);
	}
	
	public static void withAdder(boolean cook) {
		long milis=System.currentTimeMillis();
		final LongAdder adder=new LongAdder();  //initialized with 0 by default
		Runnable task1 = ()->{ adder.add((long)(Math.random()*10000));};
		Runnable task2 = ()->{ adder.increment();};
		Runnable task3 = ()->{ adder.decrement();};
		Runnable task4 = ()->{ adder.longValue();};
		ExecutorService exe=Executors.newFixedThreadPool(NUM_OF_THREADS);
		for(int i=0;i<100000;i++){
			exe.execute(task1);
			exe.execute(task2);
			exe.execute(task3);
			exe.execute(task4);
			exe.execute(task2);
			exe.execute(task3);
		}
		
		if(!cook){
			System.out.println(adder.longValue());
			milis=System.currentTimeMillis()-milis;
			System.out.println("With LongAdder: "+milis);
		}
	}
	
	public static void withAtomicLong(boolean cook) {
		long milis=System.currentTimeMillis();
		final AtomicLong atom=new AtomicLong();  //initialized with 0 by default
		Runnable task1 = ()->{ atom.set((long)(Math.random()*10000));};
		Runnable task2 = ()->{ atom.incrementAndGet();};
		Runnable task3 = ()->{ atom.decrementAndGet();};
		Runnable task4 = ()->{ atom.longValue();};
		ExecutorService exe=Executors.newFixedThreadPool(NUM_OF_THREADS);
		for(int i=0;i<100000;i++){
			exe.execute(task1);
			exe.execute(task2);
			exe.execute(task3);
			exe.execute(task4);
			exe.execute(task2);
			exe.execute(task3);
		}
		if(!cook){
			System.out.println(atom.longValue());
			milis=System.currentTimeMillis()-milis;
			System.out.println("With AtomicLong: "+milis);
		}
	}

}
