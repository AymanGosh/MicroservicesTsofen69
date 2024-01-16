package stream;

public class Address {
	
	private City city;
	private String street;
	
	public Address(City city, String street) {
		super();
		this.city = city;
		this.street = street;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	@Override
	public String toString() {
		return city.toString();
	}
	
	
	
}
