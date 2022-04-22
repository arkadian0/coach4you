package com.example.coach4you.adapter.repository;

import com.example.coach4you.adapter.repository.model.CoachDbModel;
import org.springframework.data.jpa.repository.JpaRepository;

interface CoachJpaRepository extends JpaRepository<CoachDbModel, Long> {}
