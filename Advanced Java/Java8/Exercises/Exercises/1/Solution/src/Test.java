import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import search8.SearchEngine;
import search8.string.StringSearchUtils;


public class Test {

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
		
		
		SearchEngine<String> se=new SearchEngine<String>();
		//for testing:
		//se.setData(Arrays.asList("aaa","bbb","aba","csa","scd","gha"));
		//for real:
		se.setData(hobbit);
		
		//search and print all words with length > 5
		se.executeSearch((d)->{
			for(String curr:d){
				if(curr.length()>5)
				System.out.println(curr);
			}
			return d;
		});
		
		//print search time
		System.out.println("Search took "+se.getLastSearchTimeInMillis()+" ms.");
		
		//Use StringSearchUtils populated with the letter "a"
		StringSearchUtils utils=new StringSearchUtils("a");
		System.out.println(se.executeSearch(utils::contains));
		System.out.println(se.executeSearch(utils::startsWith));
		System.out.println(se.executeSearch(utils::endsWith));
		System.out.println(se.executeSearch(StringSearchUtils::topThree));
	}

}
