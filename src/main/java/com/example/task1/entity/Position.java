package com.example.task1.entity;

import com.example.task1.entity.template.AbcNameEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Position extends AbcNameEntity {

    @ManyToMany
    private List<Team> team;
}
