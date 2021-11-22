package com.sergeykuzmin.visiting_card.repository;

import com.sergeykuzmin.visiting_card.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {
}
