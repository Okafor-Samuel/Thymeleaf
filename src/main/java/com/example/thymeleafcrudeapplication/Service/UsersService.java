package com.example.thymeleafcrudeapplication.Service;

import com.example.thymeleafcrudeapplication.Entity.Users;
import com.example.thymeleafcrudeapplication.Exception.UserNotFoundException;
import com.example.thymeleafcrudeapplication.Repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsersService {
    private final UsersRepository usersRepository;

    public List<Users> listAll(){
        return (List<Users>)usersRepository.findAll();
    }

    public void save(Users users) {
        usersRepository.save(users);
    }
    public Users get(Long id) throws UserNotFoundException {
       Optional<Users> targetUser = usersRepository.findById(id);
        if(targetUser.isPresent()){
            return targetUser.get();
        }
        throw new UserNotFoundException("Could not find any user with id: " +id);
    }
}
