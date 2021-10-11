package com.example.task1.service;

import com.example.task1.entity.ApiResponce;
import com.example.task1.entity.Category;
import com.example.task1.entity.Type;
import com.example.task1.peliod.TypeDTO;
import com.example.task1.repository.CategoryRepository;
import com.example.task1.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeService {

    @Autowired
    TypeRepository categoryRepository;

    @Autowired
    CategoryRepository categoryRepositoryId;

    public ApiResponce addElement(TypeDTO category){
        Type category1 = new Type();
        category.setName(category.getName());

        Category byId = categoryRepositoryId.getById(category.getCategoryId());
        category1.setCategory(byId);

        categoryRepository.save(category1);
        return new ApiResponce(true , category1);
    }

    public ApiResponce getList(){
        List<Type> categoryList = categoryRepository.findAll();
        return new ApiResponce(true , categoryList);
    }

    public ApiResponce getOne(int id ){
        Optional<Type> optionalCategory = categoryRepository.findById(id);
        Type category1 = optionalCategory.get();
        return new ApiResponce(true , category1);
    }

    public ApiResponce edite(int id , TypeDTO category){
        Optional<Type> optionalCategory = categoryRepository.findById(id);
        Type category1 = optionalCategory.get();
        category.setName(category.getName());

        Category byId = categoryRepositoryId.getById(category.getCategoryId());
        category1.setCategory(byId);

        categoryRepository.save(category1);

        return new ApiResponce(true , category1);
    }

    public ApiResponce delete(int id){
        categoryRepository.deleteById(id);
        Optional<Type> optionalCategory = categoryRepository.findById(id);
        Type category1 = optionalCategory.get();
        return new ApiResponce(true , category1);
    }

}
