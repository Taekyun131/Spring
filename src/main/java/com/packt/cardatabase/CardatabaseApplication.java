package com.packt.cardatabase;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.packt.cardatabase.domain.Car;
import com.packt.cardatabase.domain.CarRepository;
import com.packt.cardatabase.domain.Owner;
import com.packt.cardatabase.domain.OwnerRepository;

@SpringBootApplication
public class CardatabaseApplication implements CommandLineRunner{
	private static final Logger logger = LoggerFactory.getLogger(
			CardatabaseApplication.class
			);
	private final CarRepository repository;
	private final OwnerRepository orepository;
	public CardatabaseApplication(CarRepository repository,
									OwnerRepository orepository) {
		this.repository = repository;
		this.orepository = orepository;
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(CardatabaseApplication.class, args);
		logger.info("Application started");
	}
	
	@Override
	public void run(String... args) throws Exception {
		// 이곳에 코드를 추가
		
		// 소유자 객체를 추가하고 데이터베이스에 저장
		Owner owner1 = new Owner("John", "Johnson");
		Owner owner2 = new Owner("Mary", "Robinson");
		orepository.saveAll(Arrays.asList(owner1, owner2));
		
//		repository.save(new Car("Ford", "Mustang", "Red", "ADF-1121", 2023, 59000));
//		repository.save(new Car("Nissan", "Leaf", "White", "SSJ-3002", 2020, 29000));
//		repository.save(new Car("Toyota", "Prius", "Silver", "KKO-0212", 2022, 39000));
		
		repository.save(new Car("Ford", "Mustang", "Red", "ADF-1121", 2023, 59000, owner1));
		repository.save(new Car("Nissan", "Leaf", "White", "SSJ-3002", 2020, 29000, owner2));
		repository.save(new Car("Toyota", "Prius", "Silver", "KKO-0212", 2022, 39000, owner2));
		
		//모든 자동차를 가져와 Console에 로깅
		for(Car car : repository.findAll()) {
			logger.info("brand: {}, model: {}", 
			car.getBrand(), car.getModel());
			
		}
	}

}
