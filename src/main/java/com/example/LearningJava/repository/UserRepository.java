package com.example.LearningJava.repository;

import com.example.LearningJava.entity.user.UserEntify;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<UserEntify, Long>, JpaSpecificationExecutor<UserEntify> {
    // find userName and email
    UserEntify findByUserNameAndEmail(String userName, String email);

    /*
    * WHERE userName like %?
    * */

    List<UserEntify> findByUserNameStartingWith(String userName);

    /*
     * WHERE userName like ?%
     * */
    List<UserEntify> findByUserNameEndingWith(String userName);

    /*
     * WHERE id < 1
     * */

    List<UserEntify> findByIdLessThan(Long id);

    /*
     * Raw query JQPL
     * */
    @Query("SELECT u from UserEntify u where u.id = (SELECT max (p.id) FROM UserEntify p)")
    UserEntify findMaxId();


    @Query("SELECT u from UserEntify u where u.userName = ?1 and u.email = ?2")
    List<UserEntify> getUserEntityBy(String userName,String email);
//    OR
    @Query("SELECT u from UserEntify u where u.userName = :userName and u.email = :email")
    List<UserEntify> getUserEntityBy2(@Param("userName") String userName,@Param("email")  String email);

    /*
    * update
    * */
    @Modifying
    @Query("UPDATE UserEntify u SET u.userName = ?1")
    @Transactional
    int updateUserName(String userName);


    /*
    * Native query
    * */

    @Query(value = "SELECT count(id) FROM user001",nativeQuery = true)
    long getTotaleUser();

    /*
    * Pageable
    * */

    Page<UserEntify> findByUserName(String userName, Pageable pageable);
}
