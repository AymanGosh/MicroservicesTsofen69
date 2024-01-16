import java.util.function.Predicate;

public class PredicateExample {

	public static void main(String[] args) {
		int x=100;
		int y=200;
		
		Predicate<Integer> false1=(num)->num>100;
		Predicate<Integer> true1=(num)->num>200;
		
		Predicate<Integer> result1=false1.and(true1);
		Predicate<Integer> result2=false1.or(true1);
		Predicate<Integer> result3=false1.or(num->num%2==0);
		
		System.out.println(result1.test(x));
		System.out.println(result2.test(y));
		System.out.println(result3.test(x));

	}

}
