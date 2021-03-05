package in.edac;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dummy")
public class DummyService {
	
	/**
	 * http://localhost:8080/dummy/
	 * @return
	 */
	@GetMapping("/") 
	public String dummy1() {
		return "Hello World";
	}
	
	
	/**
	 * http://localhost:8080/dummy/hie
	 * @return
	 */
	@GetMapping("/hie") 
	public String dummy2() {
		return "Hello Hieeee";
	}
	
	
	@GetMapping("/list") 
	public List<String> dummy3() {
		List<String> list = new ArrayList<String>();
		list.add("DELHIE");
		list.add("DELHIE");
		list.add("DELHIE");
		list.add("DELHIE");
		return list;
	}
	
	
	@GetMapping("/map") 
	public Map<String, String> dummy4() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("a", "APPLE");
		map.put("b", "Ball");
		return map;
	}
	
	
	
	@GetMapping("/user")
	public User dummyUser() {
		User user = new User();
		
		return user;
	}
	
	
	@GetMapping("/user-list")
	public List<User> dummyUserList() {
		
		List<User> userlist = new ArrayList<User>();
 		
		User user = new User();
		
		userlist.add(user);
		userlist.add(user);
		userlist.add(user);
		
		return userlist;
	}
	
	
	
}
