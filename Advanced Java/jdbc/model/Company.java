package com.model;

import java.util.Objects;

public class Company {
	private int id ;
	private String name ;
	private String email; 
	private String password;
	
	
	
	//Constructor
		public Company(String name, String email, String password) {
			this.id = id;
			this.name = name;
			this.email = email;
			this.password = password;
			
			
		}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return id == company.id && Objects.equals(email, company.email);  // email.equals(company.email);
        
    }

    @Override
    public int hashCode() {
        int result = 17; // Start with a non-zero constant

        // Combine the hash code of the 'id' field
        result = 31 * result + id;

        // Combine the hash code of the 'email' field (handle null explicitly)
        result = 31 * result + (email != null ? email.hashCode() : 0);

        return result;
    }
}
