package methodRef.custom;

public class Test {

	public static void main(String[] args) {
		Person p = new Person("David",20);
		RaiseValues<Person> calc=new RaiseValues<Person>();
		calc.raise(p::birthday);	
		
		System.out.println(calc.createAndGet(Person::new));
	}
	
	public static void m(String s){
		
	}

}
