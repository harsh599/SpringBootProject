package com.appdeveloperblog.app.ws.mobileappwsNew;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.appdeveloperblog.app.ws.mobileappwsNew.io.entity.UserEntity;

//import com.appdeveloperblog.app.ws.mobileappwsNew.io.entity.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

	UserEntity findByEmail(String email);

	UserEntity findById(String id);

	@Query(value = "Select * from users", nativeQuery = true)
	List<UserEntity> findAllDetails();

}
