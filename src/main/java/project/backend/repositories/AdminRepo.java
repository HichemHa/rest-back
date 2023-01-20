package project.backend.repositories;



import org.springframework.data.jpa.repository.JpaRepository;

import project.backend.entites.Admin;



public interface AdminRepo extends JpaRepository<Admin,Long>{
	Admin findByUsername(String username);
}
