package com.example.task1.service;

import com.example.task1.entity.ApiResponce;
import com.example.task1.entity.Category;
import com.example.task1.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public ApiResponce addElement(Category category){
        Category category1 = new Category();
        category.setName(category.getName());
        categoryRepository.save(category1);
        return new ApiResponce(true , category1);
    }

    public ApiResponce getList(){
        List<Category> categoryList = categoryRepository.findAll();
        return new ApiResponce(true , categoryList);
    }

    public ApiResponce getOne(int id ){
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        Category category1 = optionalCategory.get();
        return new ApiResponce(true , category1);
    }

    public ApiResponce edite(int id , Category category){
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        Category category1 = optionalCategory.get();
        category1.setName(category.getName());
        categoryRepository.save(category1);

        return new ApiResponce(true , category1);
    }

    public ApiResponce delete(int id){
        categoryRepository.deleteById(id);
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        Category category1 = optionalCategory.get();
        return new ApiResponce(true , category1);
    }

}
