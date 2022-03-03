package com.example.coach4you.adapter.repository;

import com.example.coach4you.adapter.repository.model.ActivityDictionaryDbModel;
import org.springframework.data.jpa.repository.JpaRepository;

interface ActivityDictionaryJpaRepository extends JpaRepository<ActivityDictionaryDbModel, Long> {

}
