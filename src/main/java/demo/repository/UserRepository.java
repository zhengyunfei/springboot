package demo.repository;

import java.util.Collection;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import demo.domain.User;

/**
 * 用户User CrudRepository定义
 * 
 * @author jiekechoo
 *
 */
@RestResource(exported = false)
public interface UserRepository extends CrudRepository<User, Long> {

	Collection<User> findAll();

	User findByUsername(String username);

	Page<User> findAll(Pageable p);

	Page<User> findByUsernameContaining(String searchPhrase, Pageable p);

}
