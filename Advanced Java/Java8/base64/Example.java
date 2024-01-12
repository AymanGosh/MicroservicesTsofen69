package base64;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Example {

	public static void main(String[] args) {
		String text = "This test is Base64 encoded and decoded !";
		System.out.println(text);
		byte[] bin=text.getBytes(StandardCharsets.UTF_8);
		
		//encode
		String encoded = Base64.getEncoder().encodeToString(bin);
		System.out.println( encoded );
		
		//decode
		String decoded = new String(Base64.getDecoder().decode( encoded ),	
		            				StandardCharsets.UTF_8 );
		System.out.println( decoded );
	}
}
