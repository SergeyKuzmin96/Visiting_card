package com.sergeykuzmin.visiting_card.repository;

import com.sergeykuzmin.visiting_card.model.Resume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResumeRepository extends JpaRepository<Resume, Integer> {
}
