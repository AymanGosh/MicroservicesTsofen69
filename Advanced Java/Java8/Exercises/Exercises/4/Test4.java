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
		
		
		// COLLECTORS //
		
		//TODO: show sum of all letters
		//TODO: show length statistics
		//TODO: show average word length 
		
		
		
		// Grouping By //
		
		//TODO: 
		//starting with a distinct stream, show a map in which: 
		//key = word first letter
		//values = collection of words beginning with the key
		
		//TODO: 
		//starting with a distinct stream, show a map in which: 
		//key = word first letter
		//values = number of occurrences in the text
		
		
		
		// Partition By //
		
		//TODO:
		//separate words in 2 groups:
		//1 - words without a,e,i and u 
		//2 - all others
		//show only group 1

		
		
		// Reduce //
		
		//TODO: show longest word
		//TODO: show first shortest word
		
	}

}
