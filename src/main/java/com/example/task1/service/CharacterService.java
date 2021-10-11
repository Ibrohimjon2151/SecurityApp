package com.example.task1.service;

import com.example.task1.entity.ApiResponce;
import com.example.task1.entity.Category;
import com.example.task1.entity.Character;
import com.example.task1.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CharacterService {

    @Autowired
    CharacterRepository characterRepository;

    public ApiResponce addElement(Character category){
        Character category1 = new Character();
        category.setName(category.getName());
        characterRepository.save(category1);
        return new ApiResponce(true , category1);
    }

    public ApiResponce getList(){
        List<Character> categoryList = characterRepository.findAll();
        return new ApiResponce(true , categoryList);
    }

    public ApiResponce getOne(int id ){
        Optional<Character> optionalCategory = characterRepository.findById(id);
        Character category1 = optionalCategory.get();
        return new ApiResponce(true , category1);
    }

    public ApiResponce edite(int id , Character category){
        Optional<Character> optionalCategory = characterRepository.findById(id);
        Character category1 = optionalCategory.get();
        category1.setName(category.getName());
        characterRepository.save(category1);

        return new ApiResponce(true , category1);
    }

    public ApiResponce delete(int id){
        characterRepository.deleteById(id);
        Optional<Character> optionalCategory = characterRepository.findById(id);
        Character category1 = optionalCategory.get();
        return new ApiResponce(true , category1);
    }

}
