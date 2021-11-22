package com.sergeykuzmin.visiting_card.repository;

import com.sergeykuzmin.visiting_card.model.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationRepository extends JpaRepository<Education,Long> {
}
