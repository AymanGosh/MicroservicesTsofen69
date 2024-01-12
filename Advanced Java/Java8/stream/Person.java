package stream;

public class Person {
	private  String name;
	private int age;
	private Address address;
	private Gender gender;
	
	public Person(){}
	
	public Person(String name, int age, Gender gender, City city, String street) {
		super();
		this.name = name;
		this.age = age;
		this.gender=gender;
		address=new Address(city, street);
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return name + "-" + age;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	public boolean isFemale(){
		if(gender==Gender.F)return true;
		return false;
	}
	
}
