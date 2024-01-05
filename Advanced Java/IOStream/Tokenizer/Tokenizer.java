import java.io.IOException;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class Tokenizer {
	private static final int QUOTE_CHARACTER = '\'';
	private static final int DOUBLE_QUOTE_CHARACTER = '"';

	public static List<Object> streamTokenizerWithDefaultConfiguration(Reader reader) throws IOException {
	    StreamTokenizer streamTokenizer = new StreamTokenizer(reader);
	    List<Object> tokens = new ArrayList<Object>();

	    int currentToken = streamTokenizer.nextToken();
	    while (currentToken != StreamTokenizer.TT_EOF) {

	        if (streamTokenizer.ttype == StreamTokenizer.TT_NUMBER) {
	            tokens.add(streamTokenizer.nval);
	        } else if (streamTokenizer.ttype == StreamTokenizer.TT_WORD
	            || streamTokenizer.ttype == QUOTE_CHARACTER
	            || streamTokenizer.ttype == DOUBLE_QUOTE_CHARACTER) {
	            tokens.add(streamTokenizer.sval);
	        } else {
	            tokens.add((char) currentToken);
	        }

	        currentToken = streamTokenizer.nextToken();
	    }

	    return tokens;
	}

	public static void main(String[] args) {
        // Example usage with a StringReader
        String inputString = "3 quick brown foxes jump over the \"lazy\" dog!\r\n"
        		+ "#test1\r\n"
        		+ "//test2";
        Reader reader = new StringReader(inputString);

        try {
            List<Object> tokens = streamTokenizerWithDefaultConfiguration(reader);

            System.out.println("Tokens:");
            for (Object token : tokens) {
                System.out.println(token);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}