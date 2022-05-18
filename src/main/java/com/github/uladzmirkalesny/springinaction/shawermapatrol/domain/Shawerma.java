package com.github.uladzmirkalesny.springinaction.shawermapatrol.domain;

import lombok.Data;

import java.util.List;

@Data
public class Shawerma {
    private String name;
    private List<Ingredient> ingredients;
}
