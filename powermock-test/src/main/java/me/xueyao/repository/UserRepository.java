package me.xueyao.repository;

import me.xueyao.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Simon.Xue
 * @date 2021/4/8 3:34 下午
 **/
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
