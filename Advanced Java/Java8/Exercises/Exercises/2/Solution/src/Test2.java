import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;



public class Test2 {

	public static void main(String[] args) {
		
		//Load Hobbit as TXT
		List<String> hobbit=new ArrayList<>();
		try(BufferedReader in=new BufferedReader(new FileReader("Hobbit.txt"))){
			String line=in.readLine();
			while(line!=null){
				StringTokenizer tokens=new StringTokenizer(line, " ");
				while(tokens.hasMoreTokens()){
					hobbit.add(tokens.nextToken().toLowerCase());
				}
				line=in.readLine();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		//perform stream operations
		long time=System.currentTimeMillis();
		
		System.out.println("Word count: "+hobbit.stream().count());
		System.out.println("Distinct: "+hobbit.stream().distinct().count());
		System.out.println("Find First: "+hobbit.stream().findFirst().get());
		System.out.println("Find Any: "+hobbit.stream().findAny().get());
		System.out.println("Distinct, Sorted & Find First: "+hobbit.stream().distinct().sorted().findFirst().get());
		System.out.println("Distinct, Reverse Sorted & Find First: "+hobbit.stream().distinct().sorted((s1,s2)->s1.compareTo(s2)*(-1)).findFirst().get());
		
		System.out.println("Time: "+(System.currentTimeMillis()-time+" ms."));
				
	}

}
