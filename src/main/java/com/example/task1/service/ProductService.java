package com.example.task1.service;

import com.example.task1.entity.*;
import com.example.task1.entity.Character;
import com.example.task1.peliod.ProductDTO;
import com.example.task1.repository.CategoryRepository;
import com.example.task1.repository.CharacterRepository;
import com.example.task1.repository.ProductRepository;
import com.example.task1.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository categoryRepository;

    @Autowired
    TypeRepository typeRepository;

    @Autowired
    CharacterRepository characterRepository;

    public ApiResponce addElement(ProductDTO category){
        Product category1 = new Product();
        return getApiResponce(category, category1);
    }

    public ApiResponce getList(){
        List<Product> categoryList = categoryRepository.findAll();
        return new ApiResponce(true , categoryList);
    }

    public ApiResponce getOne(int id ){
        Optional<Product> optionalCategory = categoryRepository.findById(id);
        Product category1 = optionalCategory.get();
        return new ApiResponce(true , category1);
    }

    public ApiResponce edite(int id , ProductDTO category){
        Optional<Product> optionalCategory = categoryRepository.findById(id);
        Product category1 = optionalCategory.get();
        return getApiResponce(category, category1);
    }

    private ApiResponce getApiResponce(ProductDTO category, Product category1) {
        category1.setName(category.getName());
        category1.setAmount(category.getAmount());
        category1.setPrice(category.getPrice());

        Optional<Type> byId = typeRepository.findById(category.getTypeId());
        category1.setType(byId.get());

        Optional<Character> byId1 = characterRepository.findById(category.getCharacterId());
        category1.setCharacter(byId1.get());
        categoryRepository.save(category1);

        return new ApiResponce(true , category1);
    }

    public ApiResponce delete(int id){
        categoryRepository.deleteById(id);
        Optional<Product> optionalCategory = categoryRepository.findById(id);
        Product category1 = optionalCategory.get();
        return new ApiResponce(true , category1);
    }

}
