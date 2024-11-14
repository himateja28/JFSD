package klu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import klu.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long>
{

	@Query("select count(u) from User u where u.username=:uname")
	public int validateUser(@Param("uname") String uname);
	
	@Query("select count(u) from User u where u.username=:uname and u.password=:pass")
	public int validateLogin(@Param("uname") String uname,@Param("pass") String pass);
}
