package dedicatedPool;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class Limit {

	public static void main(String[] args) {
		DoubleStream.generate(Math::random).count();
		System.out.println("aaa");
		

	}

}
