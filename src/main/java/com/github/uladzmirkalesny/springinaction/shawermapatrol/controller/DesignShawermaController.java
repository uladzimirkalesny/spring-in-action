package com.github.uladzmirkalesny.springinaction.shawermapatrol.controller;

import com.github.uladzmirkalesny.springinaction.shawermapatrol.domain.Ingredient;
import com.github.uladzmirkalesny.springinaction.shawermapatrol.domain.Shawerma;
import com.github.uladzmirkalesny.springinaction.shawermapatrol.domain.ShawermaOrder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Arrays;
import java.util.stream.Collectors;

import static com.github.uladzmirkalesny.springinaction.shawermapatrol.domain.Ingredient.Type.CHEESE;
import static com.github.uladzmirkalesny.springinaction.shawermapatrol.domain.Ingredient.Type.PROTEIN;
import static com.github.uladzmirkalesny.springinaction.shawermapatrol.domain.Ingredient.Type.SAUCE;
import static com.github.uladzmirkalesny.springinaction.shawermapatrol.domain.Ingredient.Type.VEGGIES;
import static com.github.uladzmirkalesny.springinaction.shawermapatrol.domain.Ingredient.Type.WRAP;
import static java.util.stream.Collectors.toList;

@Slf4j

@Controller
@RequestMapping("/design")
@SessionAttributes(value = {"shawermaOrder"})
public class DesignShawermaController {

    @GetMapping
    public String showDesignForm() {
        return "design";
    }

    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        var ingredients = Arrays.asList(
                new Ingredient("FLTO", "Flour Tortilla", WRAP),
                new Ingredient("COTO", "Corn Tortilla", WRAP),
                new Ingredient("PORK", "Pork", PROTEIN),
                new Ingredient("Beef", "Beef", PROTEIN),
                new Ingredient("CHKN", "Chicken", PROTEIN),
                new Ingredient("TMTO", "Diced Tomatoes", VEGGIES),
                new Ingredient("CCMB", "Cucumber", VEGGIES),
                new Ingredient("LETC", "Lettuce", VEGGIES),
                new Ingredient("ONON", "ONION", VEGGIES),
                new Ingredient("CHED", "Cheddar", CHEESE),
                new Ingredient("JACK", "Monterrey Jack", CHEESE),
                new Ingredient("SLSA", "Salsa", SAUCE),
                new Ingredient("SRCR", "Sour Cream", SAUCE)
        );

        ingredients.stream()
                .collect(Collectors.groupingBy(Ingredient::getType, toList()))
                .forEach((key, value) -> model.addAttribute(key.toString().toLowerCase(), value));
    }

    @ModelAttribute(name = "shawermaOrder")
    public ShawermaOrder shawermaOrder() {
        return new ShawermaOrder();
    }

    @ModelAttribute(name = "shawerma")
    public Shawerma shawerma() {
        return new Shawerma();
    }
}


