import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import search8.string.StringSearchUtils;




public class Test3 {
	
	public static int counter;
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
		
		//perform stream match operations
		
		StringSearchUtils utils=new StringSearchUtils("aba");
		System.out.println("starts with: "+hobbit.stream().anyMatch(utils::startsWith));
		System.out.println("ends with: "+hobbit.stream().anyMatch(utils::endsWith));
		System.out.println("contains: "+hobbit.stream().anyMatch(utils::contains));
		System.out.println("equals: "+hobbit.stream().anyMatch(utils::equals));
		
		
		//show how many words are shorter than 3 letters
		System.out.println(hobbit.stream().filter((s)->s.length()<3).count());
		
		//show sorted unique value list of all strings length
		Iterator<Integer> lengths = hobbit.stream().mapToInt((s)->s.length()).distinct().sorted().iterator();	
		System.out.print("[ ");
		while(lengths.hasNext()){System.out.print(lengths.next()+" ");}
		System.out.println("]");
		
		//print story by breaking line each 20 words showing 'i' as it should be: 'I'
		hobbit.stream().forEach((s)->{
				if(counter%20==0){
					System.out.println();
				}
				if(s.equals("i"))s="I";
				System.out.print(s+" ");
				counter++;
			});
		counter=0;			
	}

}
