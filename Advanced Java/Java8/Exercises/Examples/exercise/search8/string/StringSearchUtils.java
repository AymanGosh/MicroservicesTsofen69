package exercise.search8.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringSearchUtils {

	private String toSearch;
	
	public StringSearchUtils(String toSearch) {
		super();
		this.toSearch = toSearch;
	}

	public List<String> startsWith(List<String> data){
		Set<String> result=new HashSet<>();
		for(String curr:data){
			if(curr.startsWith(toSearch))
				result.add(curr);
		}
		return new ArrayList<String>(result);
	}
	
	public List<String> endsWith(List<String> data){
		Set<String> result=new HashSet<>();
		for(String curr:data){
			if(curr.endsWith(toSearch))
				result.add(curr);
		}
		return new ArrayList<String>(result);
	}
	
	public List<String> contains(List<String> data){
		Set<String> result=new HashSet<>();
		for(String curr:data){
			if(curr.indexOf(toSearch)!=-1)
				result.add(curr);
		}
		return new ArrayList<String>(result);
	}
	
	public boolean startsWith(String s){
		return s.startsWith(toSearch);
	}
	
	public boolean endsWith(String s){
		return s.endsWith(toSearch);
	}
	
	public boolean contains(String s){
		return s.contains(toSearch);
	}
	
	public boolean equals(String s){
		return s.equals(toSearch);
	}
	
	public static List<String> topThree(List<String> data){
		if(data.size()>3)
		return data.subList(0,3);
		return data;
	}
	
}
