package com.example.thymeleafcrudeapplication.Repository;

import com.example.thymeleafcrudeapplication.Entity.Users;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<Users, Long> {
}
