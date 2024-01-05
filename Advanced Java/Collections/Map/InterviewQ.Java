

// you can also use imports, for example:
import java.util.*;


public class Solution {


    public static void main(String [] args) {
       
        System.out.println("This is a debug message");
        WordServices wordService = new WordServices();
        wordService.putWordIntoCollection("");
    }
}


class WordServices {
        public static Set<String> wordsCollection  = new HashSet<String>();
        Map<String , Set<String>> wordPermatMap = new HashMap <String , Set<String>>();
      
        public void putWordIntoCollection (String s)
        {
            Set<String> allPermSet = new HashSet<String>();
            //the words collection 
            if(wordPermatMap.containsKey(sortWord(s)))
            {
                allPermSet = new HashSet<String>(wordPermatMap.get(sortWord(s)));
            }
                allPermSet.add(s);
                wordPermatMap.put(sortWord(s) , allPermSet);
        }


        public Set<String> getAllPerm( String word  )
        {
            return wordPermatMap.get(sortWord(word)); 
        }


        public String sortWord(String word)
        {
            char[] wordArr = word.toCharArray();
            Arrays.sort(wordArr);
            word = new String(wordArr);
            return word;
        }
}
