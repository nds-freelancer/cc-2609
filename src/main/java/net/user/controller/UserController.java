package net.user.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import lombok.AllArgsConstructor;
import net.user.entity.Leaf;
import net.user.entity.TreeDto;
import net.user.entity.User;
import net.user.service.LeafService;
import net.user.service.UserService;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {

    private UserService userService;
    private LeafService leaService;
	
    // Build Get All Users REST API
    // http://localhost:8080/api/users
    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    
    @RequestMapping("/token")
    public User getToken(){
        return userService.getUserById(1L);
    }
    
	@PostMapping("/uploadFile")
	@ResponseBody
	public TreeDto singleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
		Leaf leaf;
		TreeDto treeDto = null;
		try {
			leaf = leaService.checkLeaf(file.getBytes());
			treeDto = new TreeDto(leaf.getTreeid(), 
					leaf.getLeafname(),
					leaf.getImage(),
					leaf.getImage(), 
					leaf.getImage(), 
					leaf.getImage(), 
					leaf.getImage(), 
					leaf.getImage(), 
					leaf.getEclipse(),
					leaf.getDFT(),
					"aasa");
			
			System.out.print("LEAF:"+leaf.getImage());
			
			return treeDto;
		} catch (Exception e) {
		}
		return treeDto;
	}
    
    @GetMapping("/swap")
    public String swapIdUsingQueryParam(@RequestParam String token) {
    
    	 User user = userService.getUserById(1L);
    	 user.setUsername(token);
         User updatedUser = userService.updateUser(user);
    	
        return "token: " + token;
    }
}
