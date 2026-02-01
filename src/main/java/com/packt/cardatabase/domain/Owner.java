package com.packt.cardatabase.domain;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Owner {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long ownerid;
	private String firstname, lastname;
	
	// 일대다
	@OneToMany(cascade=CascadeType.ALL, mappedBy="owner")
	private List<Car> cars;
	
	// 다대다
//	@ManyToMany(cascade=CascadeType.PERSIST)
//	@JoinTable(name="car_owner", 
//				joinColumns = {
//						@JoinColumn(name="ownerid")
//						},
//				inverseJoinColumns= {
//						@JoinColumn(name="id")
//						}
//			)
//	private Set<Car> cars = new HashSet<Car>();
	
	
	public Owner() {
		
	}
	
	public Owner(String firstname, String lastname) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public Long getOwnerid() {
		return ownerid;
	}

	public void setOwnerid(Long ownerid) {
		this.ownerid = ownerid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	// 다대다
//	public Set<Car> getCars() {
//		return cars;
//	}
//
//	public void setCars(Set<Car> cars) {
//		this.cars = cars;
//	}

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}
	
	
}
