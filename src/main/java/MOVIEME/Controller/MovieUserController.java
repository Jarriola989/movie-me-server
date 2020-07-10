package MOVIEME.Controller;

import MOVIEME.Model.MovieUser;
import MOVIEME.Repository.MovieUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/users")
@CrossOrigin
public class MovieUserController {

    @Autowired
    MovieUserRepository userRepository;

    @GetMapping
    public List<MovieUser> getAllUsers(){
        try {
            return userRepository.findAll();
        } catch (Exception e){
            throw new Error(e);
        }
    }

    @GetMapping(path="{id}")
    public Optional<MovieUser> getUserById(@PathVariable("id") Integer id){
        return userRepository.findById(id);
    }

    @PostMapping(path="/create")
    public MovieUser createUser(@RequestBody MovieUser user){
        return userRepository.save(user);
    }

    @PutMapping(path="{id}")
    public MovieUser updateUser(@PathVariable("id") Integer id,  @RequestBody MovieUser user){
        return userRepository.findById(id).map(userToUpdate -> {
            if(user.getUsername() != null){
                userToUpdate.setUsername(user.getUsername());
            }
            if(user.getEmail() != null){
                userToUpdate.setEmail(user.getEmail());
            }
            if(user.getPassword() != null){
                userToUpdate.setPassword(user.getPassword());
            }
            return userRepository.save(userToUpdate);
        }).orElseThrow(() -> new ResourceNotFoundException("Could not find user " + id));
    }
}
