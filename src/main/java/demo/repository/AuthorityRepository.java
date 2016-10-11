package demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import demo.domain.Authority;

@RestResource(exported = false)
public interface AuthorityRepository extends CrudRepository<Authority, Long> {

	List<Authority> findByUsername(String username);

}
