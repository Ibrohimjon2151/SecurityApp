package com.example.task1.entity;

import com.example.task1.entity.template.AbcNameEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Product extends AbcNameEntity {
    private double price;
    private int amount;

    @ManyToOne
    private Type type;

    @ManyToOne
    private Character character;
}
