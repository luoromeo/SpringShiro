package design.uranus.spring.shiro.domain.repository;

import design.uranus.spring.shiro.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @Author zhanghua.luo
 * @Description
 * @Date 2016/12/28 0028
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	@Query("SELECT u FROM User u Where u.username = :username")
	User findByName(@Param("username") String username);
}
