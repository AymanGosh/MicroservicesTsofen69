package stream.arrays;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FillAndSortExample {

	public static void main(String[] args) {
		int[] nums=new int[100000];
		Arrays.parallelSetAll(nums, index->ThreadLocalRandom.current().nextInt(100000));
		System.out.println(Arrays.toString(nums));
		Arrays.parallelSort(nums);
		System.out.println(Arrays.toString(nums));
		
		
		
//		IntStream s=Arrays.stream(nums);
//		System.out.println(s.sum());
//		System.out.println(s.sum());

	}

}
