package com.egide.schoolman.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.egide.schoolman.models.Bed;

@Repository
public interface BedRepository extends JpaRepository<Bed, Long>{}
