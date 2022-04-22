package com.example.coach4you.adapter.repository;

import com.example.coach4you.adapter.repository.model.SportDictionaryDbModel;
import org.springframework.data.jpa.repository.JpaRepository;

interface SportDictionaryJpaRepository extends JpaRepository<SportDictionaryDbModel, Long> {}
