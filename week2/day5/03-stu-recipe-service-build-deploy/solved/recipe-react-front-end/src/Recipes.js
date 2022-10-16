import { useState, useEffect } from 'react';
import './Recipes.css';
import RecipeCard from './RecipeCard.js';
import RecipeForm from './RecipeForm.js';
import RecipeDetailsForm from './RecipeDetailsForm.js';

function Recipes() {

    const [recipes, setRecipes] = useState([]);
    const [showForm, setShowForm] = useState(false);
    const [showDetailsForm, setShowDetailsForm] = useState(false);
    const [scopedRecipe, setScopedRecipe] = useState({});
    const [error, setError] = useState();

    useEffect(() => {
        fetchFromAPI();
    }, []);

    function fetchFromAPI() {
        fetch("http://localhost:8080/recipes")
            .then(response => response.json())
            .then(result => { console.log(JSON.stringify(result)); setRecipes(result); })
            .catch(console.log);
    }

    function addClick() {
        setScopedRecipe({ recipeId: 0, title: "", category: "Carnivore", description: "", prepTime: 0, cookTime: 0, servings: 0 });
        setShowForm(true);
    }

    function notify({ action, recipe, error }) {

        if (error) {
            setError(error);
            setShowForm(false);
            setShowDetailsForm(false);
            return;
        }

        switch (action) {
            case "add":
                setRecipes([...recipes, recipe]);
                break;
            case "edit":
                setRecipes(recipes.map(e => {
                    if (e.recipeId === recipe.recipeId) {
                        return recipe;
                    }
                    return e;
                }));
                break;
            case "edit-form":
                setScopedRecipe(recipe);
                setShowForm(true);
                return;
            case "details":
                setScopedRecipe(recipe);
                setShowDetailsForm(true);
                return;
            case "delete":
                setRecipes(recipes.filter(e => e.recipeId !== recipe.recipeId));
                break;
            case "exit-details-form":
                fetchFromAPI();
                break;
            default:
                break;
        }
        
        setError("");
        setShowForm(false);
        setShowDetailsForm(false);
    }

    if (showForm) {
        return <RecipeForm recipe={scopedRecipe} notify={notify} />
    } else if (showDetailsForm) {
        return <RecipeDetailsForm recipe={scopedRecipe} notify={notify} />
    }

    return (
        <>
            {error && <div className="alert alert-danger">{error}</div>}
            <div>
                <h1 id='recipeTitle'>Recipes</h1>
                <button className="btn btn-primary" type="button" onClick={addClick}>Add a Recipe</button>
                <table id='recipes'>
                    <tr>
                        <th>Title</th>
                        <th>Servings</th>
                        <th>Prep Time</th>
                        <th>Cook Time</th>
                        <th>Category</th>
                        <th>Description</th>
                        <th>Actions</th>
                    </tr>
                    <tbody>
                        {recipes.map(r => <RecipeCard key={r.recipeId} recipe={r} notify={notify} />)}
                    </tbody>
                </table>
            </div>
        </>
    )
}

export default Recipes;