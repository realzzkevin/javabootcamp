package com.example.recipe.controller;

import com.example.recipe.model.Recipe;
import com.example.recipe.repository.RecipeRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;


import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(RecipeController.class)
public class RecipeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RecipeRepository repo;

    private ObjectMapper mapper = new ObjectMapper();

    private Recipe efgRecipe;
    private String efgJson;


    @org.junit.Before
    public void setUp() throws Exception {
        efgRecipe = new Recipe();
        efgRecipe.setTitle("Egg Fried Rice");
        efgRecipe.setCategory("Fried Rice");
        efgRecipe.setDescription("Read the name please!");
        efgRecipe.setPrepTime("8 hours");
        efgRecipe.setCookTime("5 minutes");
        efgRecipe.setServings(2);
        efgRecipe.setRecipeId(1);

        efgJson = mapper.writeValueAsString(efgRecipe);

    }

    @Test
    public void shouldCreateNewRecipesOnPostRequest() throws Exception {
        Recipe inputRecipe = new Recipe();
        inputRecipe.setTitle("Egg Fried Rice");
        inputRecipe.setCategory("Fried Rice");
        inputRecipe.setDescription("Read the name please!");
        inputRecipe.setPrepTime("8 hours");
        inputRecipe.setCookTime("5 minutes");
        inputRecipe.setServings(2);
        inputRecipe.setRecipeId(1);
        String inputJson = mapper.writeValueAsString(inputRecipe);

        doReturn(efgRecipe).when(repo).save(inputRecipe);

        mockMvc.perform(
                post("/recipes")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(efgJson));
    }

    @Test
    public void shouldGetRecipeByIdOnGetRequest() throws Exception {

        doReturn(Optional.of(efgRecipe)).when(repo).findById(anyInt());

        ResultActions result = mockMvc.perform(
                get("/recipes/5")
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(efgJson));

    }
    @Test
    public void shouldReturnListRecipesOnGetRequest() throws Exception {
        List<Recipe> recipeList = new ArrayList<>();
        String recipeListJson = mapper.writeValueAsString(recipeList);
        doReturn(recipeList).when(repo).findAll();

        mockMvc.perform(
                get("/recipes")
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(recipeListJson));
    }

    @Test
    public void shouldReturnRecipesInSameCategory() throws Exception {
        List<Recipe> recipeList = new ArrayList<>();
        String recipeListJson = mapper.writeValueAsString(recipeList);
        doReturn(recipeList).when(repo).findAllRecipesByCategory(anyString());

        mockMvc.perform(
                get("/recipes/category/rice")
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(recipeListJson));
    }

    @Test
    public void shouldUpdateRecipesAndReturnCode200OnPutRequest() throws Exception {
        mockMvc.perform(
                put("/recipes")
                        .content(efgJson)
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldDeleteByIdAndReturn200StatusCode () throws Exception {
        mockMvc.perform(
                delete("/recipes/3")
        )
                .andDo(print())
                .andExpect(status().isOk());
    }
}