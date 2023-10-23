package com.example.thymeleafcrudeapplication;

import com.example.thymeleafcrudeapplication.Entity.Users;
import com.example.thymeleafcrudeapplication.Repository.UsersRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UsersRepositoryTests {
    @Autowired
    private UsersRepository usersRepository;

    @Test
    public void testAddNew(){
        Users user = new Users();
        user.setEmail("david.com");
        user.setPassword("12345");
        user.setFirstName("Chinaza");
        user.setLastName("gracewell");

        Users savedUser = usersRepository.save(user);
        Assertions.assertThat(savedUser).isNotNull();
        Assertions.assertThat(savedUser.getId()).isGreaterThan(0);
    }

    @Test
    public void testListAll(){
        Iterable<Users> users = usersRepository.findAll();
        Assertions.assertThat(users).hasSizeGreaterThan(0);
        for(Users user : users){
            System.out.println(user);
        }
    }
    @Test
    public void testUpdate(){
        Long usersId = 1L;
        Optional<Users> optionalUsers = usersRepository.findById(usersId);
        Users user = optionalUsers.get();
        user.setFirstName("femi");
        user.setLastName("james");
        user.setEmail("okeke@email.com");
        user.setPassword("kaka");
        usersRepository.save(user);

        Users updatedUser = usersRepository.findById(usersId).get();
        Assertions.assertThat(updatedUser.getFirstName()).isEqualTo("femi");
    }
    @Test
    public void testGet(){
        Long userId = 2L;
        Optional<Users> optionalUsers = usersRepository.findById(userId);
        Assertions.assertThat(optionalUsers).isPresent();
        System.out.println(optionalUsers.get());
    }
    @Test
    public void testDelete(){
        Long userId = 2L;
        usersRepository.deleteById(2L);

        Optional<Users> optionalUsers = usersRepository.findById(userId);
        Assertions.assertThat(optionalUsers).isNotPresent();
    }
}
