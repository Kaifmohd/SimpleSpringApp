package com.sdekaif.springbootwebtutorial.springbootweb.repositories;

import com.sdekaif.springbootwebtutorial.springbootweb.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {

}
