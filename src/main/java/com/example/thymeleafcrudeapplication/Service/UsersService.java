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
    public void delete(Long id) throws UserNotFoundException {
        Long count = usersRepository.countById(id);
        if(count == null || count == 0){
            throw new UserNotFoundException("Could not find user with ID: "+id);
        }
        usersRepository.deleteById(id);
    }
}
