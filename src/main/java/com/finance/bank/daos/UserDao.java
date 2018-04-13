package com.finance.bank.daos;

import com.finance.bank.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserDao extends JpaRepository<User, String>{

    @Override
    List<User> findAll();

    @Override
    Optional<User> findById(String id);

    @Query(value = "SELECT u FROM User u WHERE u.name=:name", nativeQuery = true)
    Optional<User> findByName(@Param("name") String name);

    @Query(value = "SELECT u FROM User u WHERE u.familyName=:familyname", nativeQuery = true)
    Optional<User> findByFamilyName(@Param("familyname") String familyName);

    @Override
    User save(User user);

    @Override
    void delete(User user);
}
