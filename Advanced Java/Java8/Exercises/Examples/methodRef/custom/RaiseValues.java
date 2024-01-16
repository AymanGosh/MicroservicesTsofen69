package methodRef.custom;

import java.util.function.Supplier;

public class RaiseValues<T> {
	public void raise(IncrementByOne<? super T> entity){
		System.out.println(entity.increment());
	}
	
	public T createAndGet(Supplier<T> entity){
		return entity.get();	
	}

}
