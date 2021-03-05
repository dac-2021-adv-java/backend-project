package in.edac;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	
	
	@GetMapping("/{id}")
	public User getUserById(@PathVariable int id) {
		
		// buniss login will be in seprate class.
		return userRepository.findById(id).get();
	}
	
	
	@GetMapping("/")
	public List<User> getUsers() {
		
		return userRepository.findAll(Sort.by(Direction.DESC, "id"));
	}
	


	@PostMapping("/")
	public boolean createUser(@RequestBody User user) {
		userRepository.save(user);
		return true;
	}
	
	
	
	@PutMapping("/{id}")
	public boolean updateUser(@PathVariable int id, @RequestBody User user) {
		// userRepository.save(user);
		
		User dbuser = userRepository.findById(id).get();
		dbuser.setUsername(user.getUsername());
		dbuser.setPassword(user.getPassword());
		dbuser.setEmail(user.getEmail());

		
		userRepository.save(dbuser);
		
		return true;
	}
	
	
	@DeleteMapping("/{id}")
	public boolean deleteUser(@PathVariable int id) {
		userRepository.deleteById(id);
		return true;
	}
	
	
	

}









