package com.sergeykuzmin.visiting_card.repository;

import com.sergeykuzmin.visiting_card.model.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationRepository extends QuerydslPredicateExecutor<Education>,JpaRepository<Education,Long> {

}
