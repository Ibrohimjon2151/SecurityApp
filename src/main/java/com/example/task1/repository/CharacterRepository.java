package com.example.task1.repository;

import com.example.task1.entity.Category;
import com.example.task1.entity.Character;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterRepository extends JpaRepository<Character, Integer> {

}
