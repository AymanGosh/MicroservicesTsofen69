package exercise.search8;

import java.util.List;

public class SearchEngine<T> {
	
	private List<T> data;
	private long lastSearchTimeInMillis;
	
	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public long getLastSearchTimeInMillis() {
		return lastSearchTimeInMillis;
	}

	public List<T> executeSearch(SearchTask<T> task){
		long time=task.startSearch();
		List<T> results=task.search(data);
		lastSearchTimeInMillis=task.endSearch()-time;
		return results;
	}
}
