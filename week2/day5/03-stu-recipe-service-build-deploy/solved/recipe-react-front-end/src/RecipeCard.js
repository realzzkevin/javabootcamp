function RecipeCard({ recipe, notify }) {

    function handleDelete() {
        fetch(`http://localhost:8080/recipes/${recipe.recipeId}`, { method: "DELETE" })
            .then(() => notify({ action: "delete", recipe: recipe }))
            .catch(error => notify({ action: "delete", error: error }));
    }

    return (
        <tr key={recipe.recipeId}>
            <td>{recipe.title}</td>
            <td>{recipe.servings}</td>
            <td>{recipe.prepTime}</td>
            <td>{recipe.cookTime}</td>
            <td>{recipe.category}</td>
            <td>{recipe.description}</td>
            <td>
                <button id="deleteButton" className="btn btn-danger mr-3" type="button" onClick={handleDelete}>Delete</button>
                <button id="editButton" className="btn btn-secondary" type="button" onClick={() => notify({ action: "edit-form", recipe: recipe })}>Edit</button>
                <button id="detailsButton" className="btn btn-secondary" type="button" onClick={() => notify({ action: "details", recipe: recipe })}>Details</button>
            </td>
        </tr>
    );
}

export default RecipeCard;
