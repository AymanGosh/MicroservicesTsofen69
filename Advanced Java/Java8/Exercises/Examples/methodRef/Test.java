package methodRef;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {
	public static void main(String[] args) {

		List<String> data = new ArrayList<>();
		data.add("sdfsd");
		data.add("vmnb");
		data.add("erte");
		data.add("xzsza");
		data.add("poij");

		SomeComparator st = new SomeComparator();

		Collections.sort(data, st::check);
		System.out.println(data);
		
		Collections.sort(data, SomeStaticComparator::check);
		System.out.println(data);

	}
}
