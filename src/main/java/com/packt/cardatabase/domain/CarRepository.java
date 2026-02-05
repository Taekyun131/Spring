package com.packt.cardatabase.domain;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

// JPA의 CrudRepository 인터페이스를 바탕으로 확장된 클래스
// Car 엔티티 클래스의 리포지터리이고 Id필드 타입이 Long임을 정의

// RepositoryRestResource 애너테이션은 쿼리를 포함시키는 요청 전송 가능
@RepositoryRestResource
public interface CarRepository extends CrudRepository<Car, Long> {

// 페이징 및 정렬을 통해 엔티티 검색하는 메서드 제공
//public interface CarRepository extends PagingAndSortingRepository <Car, Long> {
	// 브랜드로 자동차를 검색
//	List<Car> findByBrand(String brand);
	List<Car> findByBrand(@Param("brand") String brand);
	
	// 색상으로 자동차 검색
//	List<Car> findByColor(String color);
	List<Car> findByColor(@Param("color") String color);
	
	// 연도로 자동차 검색
	List<Car> findByModelYear(int modelYear);
	
	// 브랜드와 모델로 자동차를 검색
	List<Car> findByBrandAndModel(String brand, String model);
	
	// 브랜드 또는 색상별로 자동차 가져오기
	List<Car> findByBrandOrColor(String Brand, String color);
	
	// 브랜드로 자동차를 검색하고 연도로 정렬
	List<Car> findByBrandOrderByModelYearAsc(String brand);
	
	// SQL문을 이용해 브랜드로 자동차를 검색
//	@Query("select c from Car c where c.brand = ?1")
//	List<Car> findByBrand(String brand);
	
	// 고급 표현식 사용
	@Query("select c from Car c where c.brand like %?1")
	List<Car> findByBrandEndsWith(String brnad);
}
