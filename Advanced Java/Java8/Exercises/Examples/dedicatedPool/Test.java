package dedicatedPool;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test {

	public static void main(String[] args) {
//		concurrentModify1();
//		concurrentModify2();
//		filterCheck();
//		mapCheck();
//		groupCheck();
//		primitives();
		flow();
	}
	
	public static void concurrentModify1(){ //fails 
		List<Person> people=new ArrayList<>();
		for(int i=0;i<10;i++){
			people.add(new Person("a"+i, (int)(Math.random()*121)));
		}
		people.parallelStream().peek(people::remove).sorted().forEach(System.out::println);
	}
	
	public static void concurrentModify2(){  
		Queue<Person> people=new ConcurrentLinkedQueue<>();
		for(int i=0;i<10;i++){
			people.add(new Person("a"+i, (int)(Math.random()*121)));
		}
		people.parallelStream().peek(people::remove).sorted().forEach(System.out::println);
	}
	
	
	public static void filterCheck(){
		List<Person> people=new ArrayList<>();
		for(int i=0;i<1000000;i++){
			people.add(new Person("a"+i, (int)(Math.random()*121)));
		}
		long start=System.currentTimeMillis();
		//make it hot...
		people.stream().filter((p)->p.getName().startsWith("a2")&&
				                    p.getName().indexOf("a21")!=-1&&
				                    p.getAge()>30&&
				                    p.getAge()<100).collect(Collectors.toList());
		System.out.println("Person single filter: "+(System.currentTimeMillis()-start)+" ms");
		//now we start:
		start=System.currentTimeMillis();
		people.stream().filter((p)->p.getName().startsWith("a2")&&
				                    p.getName().indexOf("a21")!=-1&&
				                    p.getAge()>30&&
				                    p.getAge()<100).collect(Collectors.toList());
		System.out.println("Person single filter: "+(System.currentTimeMillis()-start)+" ms");
		
		start=System.currentTimeMillis();
		people.parallelStream().filter((p)->p.getName().startsWith("a2")&&
				                            p.getName().indexOf("a21")!=-1&&
				                            p.getAge()>30&&
				                            p.getAge()<100).collect(Collectors.toList());
		System.out.println("Person single filter prallel: "+(System.currentTimeMillis()-start)+" ms");
		
		start=System.currentTimeMillis();
		people.stream().filter((p)->p.getName().startsWith("a2"))
		               .filter((p)->p.getName().indexOf("a21")!=-1)
					   .filter((p)->p.getAge()>30)
		               .filter((p)->p.getAge()<100).collect(Collectors.toList());
		System.out.println("Person multi filter: "+(System.currentTimeMillis()-start)+" ms");
		
		start=System.currentTimeMillis();
		people.parallelStream().filter((p)->p.getName().startsWith("a2"))
		               .filter((p)->p.getName().indexOf("a21")!=-1)
					   .filter((p)->p.getAge()>30)
		               .filter((p)->p.getAge()<100).collect(Collectors.toList());
		System.out.println("Person multi filter parallel: "+(System.currentTimeMillis()-start)+" ms");
		
		start=System.currentTimeMillis();
		List<Person> result=new ArrayList<>();
		for(Person p:people){
			if(p.getName().startsWith("a2")&&p.getName().indexOf("a21")!=-1&&p.getAge()>30&&p.getAge()<100){
				result.add(p);
			}
		}
		System.out.println("Person simple for loop: "+(System.currentTimeMillis()-start)+" ms");
		
		System.out.println("____________");
	}
	
	public static void mapCheck(){
		List<Person> people=new ArrayList<>();
		for(int i=0;i<10000000;i++){
			people.add(new Person("a"+i, (int)(Math.random()*121)));
		}
		
		long start=System.currentTimeMillis();
		people.stream().filter((p)->p.getName().startsWith("a2")).mapToInt((p)->p.getAge()).average();
		System.out.println("map stream: "+(System.currentTimeMillis()-start)+" ms");
		
		start=System.currentTimeMillis();
		people.parallelStream().filter((p)->p.getName().startsWith("a2")).mapToInt((p)->p.getAge()).average();
		System.out.println("map parallel stream: "+(System.currentTimeMillis()-start)+" ms");
		
		start=System.currentTimeMillis();
		int average=0,count=0;
		for(Person p:people){
			if(p.getName().startsWith("a2")){
				count++; average+=p.getAge();
			}
		}
		average/=count;
		System.out.println("map loop: "+(System.currentTimeMillis()-start)+" ms");
		
		System.out.println("____________");
	}
	
	public static void groupCheck(){
		List<Person> people=new ArrayList<>();
		for(int i=0;i<1000000;i++){
			people.add(new Person("a"+i, (int)(Math.random()*121)));
		}
		long start=System.currentTimeMillis();
		people.stream().filter(p->p.getAge()>18).collect(Collectors.groupingBy(Person::getAge));
		System.out.println("group stream: "+(System.currentTimeMillis()-start)+" ms");
		
		start=System.currentTimeMillis();
		people.stream().filter(p->p.getAge()>18).collect(Collectors.groupingByConcurrent(Person::getAge));
		System.out.println("group conc stream: "+(System.currentTimeMillis()-start)+" ms");
		
		
		start=System.currentTimeMillis();
		people.parallelStream().filter(p->p.getAge()>18).collect(Collectors.groupingByConcurrent(Person::getAge));
		System.out.println("group conc parallel stream: "+(System.currentTimeMillis()-start)+" ms");
		
		start=System.currentTimeMillis();
		people.parallelStream().filter(p->p.getAge()>18).collect(Collectors.groupingBy(Person::getAge));
		System.out.println("group parallel stream: "+(System.currentTimeMillis()-start)+" ms");
		
		
		System.out.println("____________");
	}
	
	public static void primitives(){
		int[] nums=IntStream.generate(()->(int)(Math.random()*100000)).limit(10000000).toArray();
		
		long start=System.currentTimeMillis();
		int[]result=IntStream.of(nums).filter(i->i%8==0).filter(i->i%3==0).toArray();
		System.out.println("int [] multi filter: "+(System.currentTimeMillis()-start)+" ms");
		
		start=System.currentTimeMillis();
		result=IntStream.of(nums).filter(i->i%8==0&&i%3==0).toArray();
		System.out.println("int [] single filter: "+(System.currentTimeMillis()-start)+" ms");
	
		start=System.currentTimeMillis();
		List<Integer> numTmp=new LinkedList<>();
		for(int i:nums){
			if(i%8==0&&i%3==0){
				numTmp.add(i);
			}
		}
		numTmp.toArray();
		System.out.println("int [] loop: "+(System.currentTimeMillis()-start)+" ms");
		
		start=System.currentTimeMillis();
		result=Arrays.stream(nums).parallel().filter(i->i%8==0&&i%3==0).toArray();		
		System.out.println("int [] parallel: "+(System.currentTimeMillis()-start)+" ms");
		
		System.out.println("____________");
	}
	
	public static void flow(){
		long start=System.currentTimeMillis();
		IntStream.of(1,2,3,4,5)
	    .filter(i -> {
	        System.out.println("filter: " + i);
	        return true;
	    })
	    .map(i->{System.out.println("map:" + i);
	    	return i;
	    })
	    .forEach(s -> System.out.println("forEach: " + s));
		System.out.println("flow parallel: "+(System.currentTimeMillis()-start)+" ms");
	}
		
}
