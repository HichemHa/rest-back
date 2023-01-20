package project.backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.backend.entites.Admin;

import project.backend.repositories.AdminRepo;

@RestController
@RequestMapping("api/v1/admin")
public class AdminController {
	
	@Autowired
	private AdminRepo adrep;
	
	@PostMapping("/create")
    public Admin createAdmin(@RequestBody Admin newAdmin){
        return adrep.save(newAdmin);
    }
	
	
	@PostMapping("/login")
	public ResponseEntity<String> loginAdmin(@RequestBody Admin logAdmin) {
		String nameAdmin = logAdmin.getUsername();
		String passAdmin = logAdmin.getPassword();
		
        System.out.println(nameAdmin);
        System.out.println(passAdmin);

        Admin getNameResult = adrep.findByUsername(nameAdmin);
        System.out.println(getNameResult.getPassword());

		if( getNameResult.getPassword().equals(passAdmin)) {
		    return new ResponseEntity<String>("Hello World!", HttpStatus.OK);		
		    }else {
		        return new ResponseEntity<String>("password or login flase", HttpStatus.OK);
		    }
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
