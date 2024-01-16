import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;







public class Test3 {
	
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
		
		//TODO: perform stream match operations
			
		
		//TODO:  show how many words are shorter than 3 letters
		
		
		//TODO: show sorted unique value list of all strings length
		
		
		//TODO: print the all story by breaking line each 20 words showing 'i' as it should be: 'I'
				
	}

}
