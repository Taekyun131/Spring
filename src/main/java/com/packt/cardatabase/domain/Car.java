package com.packt.cardatabase.domain;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Car {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	// 기본 키는 @Id 애너테이션을 이용하여 정의
	// @GeneratredValue 애너테이션은 데이터베이스가 자동으로 ID를 생성하도록 지정
	// @Column 애너테이션을 이용해 칼럼의 길이와 nullable 여부를 지정할 수 있음
	
	private String brand, model, color, registrationNumber;
	private int modelYear, price;
	
	
	// 일대다 관계를 추가
	//FetchType은 데이터베이스에서 데이터를 검색하는 전략을 정의
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="owner")
	private Owner owner;
	
	// 다대다 관계
	// 다대다 관계는 List보다 Set을 사용하는 것이 좋
//	@ManyToMany(mappedBy="cars")
//	private Set<Owner> owners = new HashSet<Owner>();
	
	// 생성자 
	public Car() {
		
	}
	
//	public Car (String brand, String model, String color, String registrationNumber, 
//					int modelYear, int price) {
//		super();
//		this.brand = brand;
//		this.model = model;
//		this.color = color;
//		this.registrationNumber = registrationNumber;
//		this.modelYear = modelYear;
//		this.price = price;
//	}
	
	// Owner 추가
	public Car (String brand, String model, String color, String registrationNumber, 
			int modelYear, int price, Owner owner) {
		super();
		this.brand = brand;
		this.model = model;
		this.color = color;
		this.registrationNumber = registrationNumber;
		this.modelYear = modelYear;
		this.price = price;
		this.owner = owner;
}

	
	// getter, setter
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public int getModelYear() {
		return modelYear;
	}

	public void setModelYear(int modelYear) {
		this.modelYear = modelYear;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

//	public Set<Owner> getOwners() {
//		return owners;
//	}
//
//	public void setOwners(Set<Owner> owners) {
//		this.owners = owners;
//	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	
	
	
	
}
