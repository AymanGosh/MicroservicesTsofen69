import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
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
		
		//TODO: Show word count
		//TODO: Show unique word count
		//TODO: Show first word
		//TODO: Show any word
		//TODO: Sort uniques and show first
		//TODO: Sort uniques in the opposite order and show first
		
		System.out.println("Time: "+(System.currentTimeMillis()-time+" ms."));
				
	}

}
