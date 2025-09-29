package portal.elearning.UserService.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private userEntity userEntity;

    public boolean userLogin(userRequestDto userDTO){
        Optional<userEntity> userEmail=userRepository.findByEmail(userDTO.getEmail());
        if(userEmail.isPresent()){
            return true;
        }
        return false;
    }

    public boolean userRegister(userRequestDto userDTO){
    //    userRepository.save(userEntity);
        if(!userDTO.getEmail().contains("@"))return false;
        return true;
    }

    @Override
    public userEntity saveUser(userEntity user) {
        userRepository.save(user);
        return user;
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
