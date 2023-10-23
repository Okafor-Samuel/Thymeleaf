package com.example.thymeleafcrudeapplication.Service;

import com.example.thymeleafcrudeapplication.Entity.Users;
import com.example.thymeleafcrudeapplication.Repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsersService {
    private final UsersRepository usersRepository;

    public List<Users> listAll(){
        return (List<Users>)usersRepository.findAll();
    }

}
