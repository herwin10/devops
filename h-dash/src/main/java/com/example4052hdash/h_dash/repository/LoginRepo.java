package com.example4052hdash.h_dash.repository;

import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepo extends JpaRepository<login,String>{

    login findByEmailAndPassword(String email,String password)
}
