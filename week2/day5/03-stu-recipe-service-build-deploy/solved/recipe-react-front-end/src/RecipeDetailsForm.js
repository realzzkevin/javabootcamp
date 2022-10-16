import { useState } from 'react';
import './RecipeDetails.css';
import IngredientCard from './IngredientCard.js';
import IngredientForm from './IngredientForm.js';
import PrepStepCard from './PrepStepCard.js';
import PrepStepForm from './PrepStepForm.js';
import RatingCard from './RatingCard.js';
import RatingForm from './RatingForm.js';

function RecipeDetailsForm({ recipe: initialRecipe, notify }) {

    const [recipe] = useState(initialRecipe);
    const [ingredients, setIngredients] = useState(initialRecipe.ingredients);
    const [showIngredientForm, setShowIngredientForm] = useState(false);
    const [scopedIngredient, setScopedIngredient] = useState({});
    const [prepSteps, setPrepSteps] = useState(initialRecipe.prepSteps);
    const [showPrepStepForm, setShowPrepStepForm] = useState(false);
    const [scopedPrepStep, setScopedPrepStep] = useState({});
    const [ratings, setRatings] = useState(initialRecipe.ratings);
    const [showRatingForm, setShowRatingForm] = useState(false);
    const [scopedRating, setScopedRating] = useState({});
    const [error, setError] = useState();

    function addIngredientClick() {
        setScopedIngredient({ ingredientId: 0, recipeId: recipe.recipeId, name: "", description: "", amount: 0 });
        setShowIngredientForm(true);
    }

    function addPrepStepClick() {
        setScopedPrepStep({ prepStepId: 0, recipeId: recipe.recipeId, stepNumber: prepSteps.length + 1, text: "" });
        setShowPrepStepForm(true);
    }

    function addRatingClick() {
        setScopedRating({ ratingId: 0, recipeId: recipe.recipeId, recommended: true, numStars: 5, ratingText: "" });
        setShowRatingForm(true);
    }

    function detailsFormNotify({ action, ingredient, prepStep, rating, error }) {

        if (error) {
            setError(error);
            setShowIngredientForm(false);
            setShowPrepStepForm(false);
            setShowRatingForm(false);
            return;
        }

        switch (action) {
            case "add-ingredient":
                setIngredients([...ingredients, ingredient]);
                break;
            case "edit-ingredient":
                setIngredients(ingredients.map(e => {
                    if (e.ingredientId === ingredient.ingredientId) {
                        return ingredient;
                    }
                    return e;
                }));
                break;
            case "edit-ingredient-form":
                setScopedIngredient(ingredient);
                setShowIngredientForm(true);
                return;
            case "delete-ingredient":
                setIngredients(ingredients.filter(e => e.ingredientId !== ingredient.ingredientId));
                break;
            case "add-prepstep":
                setPrepSteps([...prepSteps, prepStep]);
                break;
            case "edit-prepstep":
                setPrepSteps(prepSteps.map(e => {
                    if (e.prepStepId === prepStep.prepStepId) {
                        return prepStep;
                    }
                    return e;
                }));
                break;
            case "edit-prepstep-form":
                setScopedPrepStep(prepStep);
                setShowPrepStepForm(true);
                return;
            case "delete-prepstep":
                setPrepSteps(prepSteps.filter(e => e.prepStepId !== prepStep.prepStepId));
                break;
            case "add-rating":
                setRatings([...ratings, rating]);
                break;
            case "delete-rating":
                setRatings(ratings.filter(e => e.ratingId !== rating.ratingId));
                break;
            default:
                break;
        }
        
        setError("");
        setShowIngredientForm(false);
        setShowPrepStepForm(false);
        setShowRatingForm(false);
    }

    if (showIngredientForm) {
        return <IngredientForm ingredient={scopedIngredient} subNotify={detailsFormNotify} />
    }
    else if (showPrepStepForm) {
        return <PrepStepForm prepStep={scopedPrepStep} subNotify={detailsFormNotify} />
    }
    else if (showRatingForm) {
        return <RatingForm rating={scopedRating} subNotify={detailsFormNotify} />
    }

    return (
        <>
            <h1>Recipe Details</h1>
            {error && <div className="alert alert-danger">{error}</div>}
            <div className="col">
                <button className="btn btn-secondary" type="button" onClick={() => notify({ action: "exit-details-form" })}>Exit</button>
            </div>
            <div>
                <h1 id='ingredientTitle'>Ingredients</h1>
                <button className="btn btn-primary" type="button" onClick={addIngredientClick}>Add Ingredient</button>
                <table id='ingredients'>
                    <tr>
                        <th>Name</th>
                        <th>Description</th>
                        <th>Amount</th>
                        <th>Actions</th>
                    </tr>
                    <tbody>
                        {ingredients.map(x => <IngredientCard key={x.ingredientId} ingredient={x} subNotify={detailsFormNotify} />)}
                    </tbody>
                </table>
            </div>
            <div>
                <h1 id='prepStepTitle'>Prep Steps</h1>
                <button className="btn btn-primary" type="button" onClick={addPrepStepClick}>Add Prep Step</button>
                <table id='prepSteps'>
                    <tr>
                        <th>Step Number</th>
                        <th>Text</th>
                        <th>Actions</th>
                    </tr>
                    <tbody>
                        {prepSteps.map(x => <PrepStepCard key={x.prepStepId} prepStep={x} subNotify={detailsFormNotify} />)}
                    </tbody>
                </table>
            </div>
            <div>
                <h1 id='ratingsTitle'>Ratings</h1>
                <button className="btn btn-primary" type="button" onClick={addRatingClick}>Add Rating</button>
                <table id='ratings'>
                    <tr>
                        <th>Recommended</th>
                        <th>Number of Stars</th>
                        <th>Text</th>
                        <th>Actions</th>
                    </tr>
                    <tbody>
                        {ratings.map(x => <RatingCard key={x.ratingId} rating={x} subNotify={detailsFormNotify} />)}
                    </tbody>
                </table>
            </div>
        </>
    );
}

export default RecipeDetailsForm;