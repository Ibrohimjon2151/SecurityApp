package com.example.task1.controller;

import com.example.task1.entity.ApiResponce;
import com.example.task1.entity.Category;
import com.example.task1.entity.Character;
import com.example.task1.service.CategoryService;
import com.example.task1.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/character/")
public class CharacterController {
    @Autowired
    CharacterService categoryService;

    @PreAuthorize(value = "hasAnyAuthority('ADD')")
    @PostMapping
    public HttpEntity<ApiResponce> addElement(@RequestBody Character category){
        ApiResponce apiResponce = categoryService.addElement(category);
        return ResponseEntity.status(apiResponce.isSuccess() ? HttpStatus.CREATED : HttpStatus.CONFLICT).body(apiResponce);
    }

    @PreAuthorize(value = "hasAnyAuthority('READ')")
    @GetMapping
    public HttpEntity<ApiResponce>getList(){
        ApiResponce list = categoryService.getList();
        return ResponseEntity.ok(list);
    }

    @PreAuthorize(value = "hasAnyAuthority('READ')")
    @GetMapping("/{id}")
    public HttpEntity<ApiResponce> getOne(@RequestParam Integer id){
        ApiResponce list = categoryService.getOne(id);
        return ResponseEntity.status(list.isSuccess() ? HttpStatus.OK : HttpStatus.NOT_FOUND).body(list);
    }

    @PreAuthorize(value = "hasAnyAuthority('UPDATE')")
    @PutMapping("/{id}")
    public HttpEntity<ApiResponce> edite(@RequestParam Integer id , @RequestBody Character category){
        ApiResponce list = categoryService.edite(id , category);
        return ResponseEntity.status(list.isSuccess() ? HttpStatus.OK : HttpStatus.NOT_FOUND).body(list);
    }

    @PreAuthorize(value = "hasAnyAuthority('DELETE')")
    @DeleteMapping
    public HttpEntity<ApiResponce> delete(@RequestParam Integer id ){
        ApiResponce list = categoryService.delete(id);
        return ResponseEntity.ok(list);
        }


}
