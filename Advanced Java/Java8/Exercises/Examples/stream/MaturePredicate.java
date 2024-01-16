package stream;

public class MaturePredicate{

	public static boolean isMature(Person t) {
		if(t.getAge()>=18)return true;
		return false;
	}

}
