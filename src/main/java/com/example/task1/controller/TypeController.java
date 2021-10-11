package com.example.task1.controller;

import com.example.task1.entity.ApiResponce;
import com.example.task1.entity.Category;
import com.example.task1.peliod.TypeDTO;
import com.example.task1.service.CategoryService;
import com.example.task1.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/type/")
public class TypeController {
    @Autowired
    TypeService categoryService;

    @PreAuthorize(value = "hasAnyAuthority('ADD')")
    @PostMapping
    public HttpEntity<ApiResponce> addElement(@RequestBody TypeDTO category){
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

    @PreAuthorize(value = "hasAnyAuthority('UDATE')")
    @PutMapping("/{id}")
    public HttpEntity<ApiResponce> edite(@RequestParam Integer id , @RequestBody TypeDTO category){
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
