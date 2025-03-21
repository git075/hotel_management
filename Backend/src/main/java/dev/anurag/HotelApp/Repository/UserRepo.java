package dev.anurag.HotelApp.Repository;

import dev.anurag.HotelApp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepo extends MongoRepository<User, Long> {
    Optional<User> findByusername(String username);
}
