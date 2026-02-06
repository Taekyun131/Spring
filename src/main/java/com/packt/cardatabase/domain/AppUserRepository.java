package com.packt.cardatabase.domain;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

// 해당 리포지터리가 REST 리소스로 노출되지 않게 설정(/appUsers 엔드포인트 표출 안되게 설정)
@RepositoryRestResource(exported=false)
public interface AppUserRepository extends CrudRepository<AppUser, Long> {
	Optional<AppUser> findByUsername(String username);
	
}
