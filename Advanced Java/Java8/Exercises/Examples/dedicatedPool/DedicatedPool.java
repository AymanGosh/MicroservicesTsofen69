package dedicatedPool;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.ThreadFactory;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DedicatedPool {

	public static void main(String[] args) {
		List<Person> people=new ArrayList<>();
		for(int i=0;i<10000;i++){
			people.add(new Person("a"+i, (int)(Math.random()*121)));
		}
		
		Callable<List<Person>> call=()->{return
			people.parallelStream().filter((p)->{
								return p.getName().startsWith("a2");})
            .filter((p)->p.getName().indexOf("a21")!=-1)
			   .filter((p)->p.getAge()>30)
            .filter((p)->p.getAge()<100).collect(Collectors.toList());	
		};
		
	//	ThreadFactory tf=(r)->new Thread(r);
		
		long start=System.currentTimeMillis();
		ForkJoinTask<List<Person>> task=ForkJoinTask.adapt(call);
		ForkJoinPool pool=new ForkJoinPool();
		pool.invoke(task);
		System.out.println("exe time: "+(System.currentTimeMillis()-start)+" ms");
	}

}
