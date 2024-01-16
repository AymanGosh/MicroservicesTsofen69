package search8;

import java.util.List;

@FunctionalInterface
public interface SearchTask<T> {
	default long startSearch(){return System.currentTimeMillis();}
	List<T> search(List<T> data);
	default long endSearch(){return System.currentTimeMillis();}
}
