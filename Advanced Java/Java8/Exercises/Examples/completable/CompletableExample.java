package completable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableExample {
	public static void main(String[] args) {
		
		CompletableFuture<Void> task1=CompletableFuture.supplyAsync(()->(int)(Math.random()*10)).
		thenAccept(i->System.out.println(i%8==0));
		CompletableFuture<Void> task2=CompletableFuture.completedFuture(100).thenAccept(System.out::println);
		try {
			task1.get();
			CompletableFuture<Void> task3=CompletableFuture.allOf(task1,task2).thenRun(()->System.out.println("Done"));
			task3.get();
		}catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
