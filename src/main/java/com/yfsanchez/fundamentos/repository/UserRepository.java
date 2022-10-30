package com.yfsanchez.fundamentos.repository;

import com.yfsanchez.fundamentos.dto.UserDto;
import com.yfsanchez.fundamentos.entity.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("Select u From User u Where u.email=?1")
    Optional<User> findByUserEmail(String email);

    @Query("Select u From User u Where u.name like ?1%")
    List<User> findAndSort(String name, Sort sort);

    List<User> findByName(String name);

    Optional<User> findByNameAndEmail(String name, String email);
    List<User> findByNameLike(String name);
    List<User> findByNameOrEmail(String name, String email);
    List<User> findByBirthDateBetween(LocalDate begin, LocalDate end);
    List<User> findByNameLikeOrderByIdDesc(String name);
    List<User> findByNameContainingOrderByIdDesc(String name);
    @Query("SELECT new com.yfsanchez.fundamentos.dto.UserDto(u.name,u.email,u.birthDate)" +
            " FROM User u" +
            " WHERE u.birthDate=:parameterBirthDate AND u.email=:parameterEmail")
    Optional<UserDto> getAllByBirthDateAndEmail(@Param("parameterBirthDate") LocalDate birthDate,
                                                @Param("parameterEmail") String email);
}
