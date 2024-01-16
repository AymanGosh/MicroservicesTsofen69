package stream.arrays;

import java.util.Arrays;

public class Example {

	public static void main(String[] args) {
		int [] nums =new int[200];
		for(int i=0;i<nums.length;i++){
			nums[i]=(int)(Math.random()*100000);
		}
		
		System.out.println(Arrays.toString(nums));
		int[] sorted=Arrays.stream(nums).sorted().toArray();
		System.out.println(Arrays.toString(sorted));
		System.out.println(Arrays.stream(nums).average().getAsDouble());
		
		
	}
}
