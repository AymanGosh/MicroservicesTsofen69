import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

import search8.string.StringSearchUtils;




public class Test4 {
	
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
		
		//sum of all letters
		System.out.println("Letter total count: "+hobbit.stream().collect(Collectors.summingInt((String s)->s.length())));
		
		//show length statistics
		IntSummaryStatistics st=hobbit.stream().collect(Collectors.summarizingInt((String s)->s.length()));
		System.out.println(st);
		
		//average word length 
		System.out.println("Average word length: "+hobbit.stream().collect(Collectors.averagingInt((String s)->s.length())));
		
		//starting with a distinct stream, map in which: 
		//key = word first letter
		//values = collection of words beginning with the key
		Map<Character, List<String>> map1=hobbit.stream().distinct().collect(Collectors.groupingBy((s)->s.charAt(0),Collectors.toList()));
		for(Map.Entry<Character, List<String>> e: map1.entrySet()){
			System.out.println(e);
		}
		
		//starting with a distinct stream, map in which: 
		//key = word first letter
		//values = number of occurrences in the text
		Map<Character, Long> map2=hobbit.stream().collect(Collectors.groupingBy((s)->s.charAt(0),Collectors.counting()));
		for(Map.Entry<Character, Long> e: map2.entrySet()){
			System.out.println(e);
		}
		
		//separate words in 2 groups:
		//1 - words without a,e,i and u 
		//2 - all others
		//show only group 1
		Map<Boolean, List<String>> map3=hobbit.stream().distinct().collect(Collectors.partitioningBy(
				(String s)->!s.contains("a")&&!s.contains("e")&&!s.contains("i")&&!s.contains("u"))
		);
		System.out.println("without a,e,i,u: "+map3.get(true));
		
		//show longest word
		System.out.println("longest word: "+hobbit.stream().reduce((String r,String s)->{if(s.length()>r.length()){r=s;}return r;}));
		
		//show first shortest word
		System.out.println("first shortest word found: "+hobbit.stream().reduce(hobbit.get(0),(r,s)->{if(s.length()<r.length()){r=s;}return r;}));
		
	}

}
