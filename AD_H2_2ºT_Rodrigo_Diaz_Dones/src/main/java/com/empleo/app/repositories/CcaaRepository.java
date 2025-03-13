package com.empleo.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.empleo.app.model.CCAA;

@Repository
public interface CcaaRepository extends JpaRepository<CCAA, Integer> {
}
