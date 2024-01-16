package search8.string;

import java.util.ArrayList;
import java.util.List;

public class StringSearchUtils {

	private String toSearch;
	
	public StringSearchUtils(String toSearch) {
		super();
		this.toSearch = toSearch;
	}

	public List<String> startsWith(List<String> data){
		List<String> result=new ArrayList<>();
		for(String curr:data){
			if(curr.startsWith(toSearch))
				result.add(curr);
		}
		return result;
	}
	
	public List<String> endsWith(List<String> data){
		List<String> result=new ArrayList<>();
		for(String curr:data){
			if(curr.endsWith(toSearch))
				result.add(curr);
		}
		return result;
	}
	
	public List<String> contains(List<String> data){
		List<String> result=new ArrayList<>();
		for(String curr:data){
			if(curr.indexOf(toSearch)!=-1)
				result.add(curr);
		}
		return result;
	}
	
	public static List<String> topThree(List<String> data){
		if(data.size()>3)
		return data.subList(0,3);
		return data;
	}
}
