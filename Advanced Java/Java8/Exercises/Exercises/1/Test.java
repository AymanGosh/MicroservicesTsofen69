import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Test {

	public static void main(String[] args) {
		
		//Load Hobbit as TXT (make sure Hobbit.txt is at the root of your project)
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
		
		
		//TODO: instantiate and populate SearchEngine<String> with hobbit collection data
		
		//TODO: search and print all words with length > 5
		
		//TODO: print search time
		
		//TODO: Use StringSearchUtils populated with the letter "a" non static method refs
		
		//TODO: Use StringSearchUtils static method ref to show top tree
		
	}

}
