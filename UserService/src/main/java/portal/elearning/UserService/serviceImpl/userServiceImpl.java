package portal.elearning.UserService.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import portal.elearning.UserService.dto.userRequestDto;
import portal.elearning.UserService.dto.userResponseDto;
import portal.elearning.UserService.entity.userEntity;
import portal.elearning.UserService.repository.userRepository;
import portal.elearning.UserService.service.userService;

import java.util.List;
import java.util.Optional;

@Service
public class userServiceImpl implements userService {

    @Autowired
    private userRepository userRepository;

    private userEntity userEntity;

    public boolean userLogin(userRequestDto userDTO){
        Optional<userEntity> userEmail=userRepository.findByEmail(userDTO.getEmail());
        if(userEmail.isPresent()){
            return true;
        }
        return false;
    }

    public userEntity userRegister(userEntity userDTO){
        // Check if email already exists
        if (userRepository.findByEmail(userDTO.getEmail()).isPresent()) {
            return null; // means registration failed
        }

        // Map DTO → Entity
        userEntity newUser = userEntity.builder()
                .name(userDTO.getName())
                .email(userDTO.getEmail())
                .password(userDTO.getPassword())
                .build();

        // Save entity in DB
        return userRepository.save(newUser);

    }

    @Override
    public userEntity saveUser(userEntity user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);

    }

    @Override
    public List<userEntity> getAllusers() {
        return (List<userEntity>) userRepository.findAll();
    }

}
