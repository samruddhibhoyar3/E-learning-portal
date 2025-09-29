package portal.elearning.UserService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import portal.elearning.UserService.dto.userRequestDto;
import portal.elearning.UserService.dto.userResponseDto;
import portal.elearning.UserService.entity.userEntity;
import portal.elearning.UserService.repository.userRepository;

import java.util.List;


public interface userService {



     boolean userLogin(userRequestDto userDTO);
     boolean userRegister(userRequestDto userDTO);
    userEntity saveUser(userEntity user);
    void deleteUser(Integer id);
    List<userEntity> getAllusers();

}
