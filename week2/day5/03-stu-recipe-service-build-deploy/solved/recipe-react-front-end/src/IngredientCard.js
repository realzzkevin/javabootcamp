function IngredientCard({ ingredient, subNotify }) {

    function handleDelete() {
        fetch(`http://localhost:8080/ingredients/${ingredient.ingredientId}`, { method: "DELETE" })
            .then(() => subNotify({ action: "delete-ingredient", ingredient: ingredient }))
            .catch(error => subNotify({ action: "delete-ingredient", error: error }));
    }

    return (
        <tr key={ingredient.ingredientId}>
            <td>{ingredient.name}</td>
            <td>{ingredient.description}</td>
            <td>{ingredient.amount}</td>
            <td>
                <button id="deleteButton" className="btn btn-danger mr-3" type="button" onClick={handleDelete}>Delete</button>
                <button id="editButton" className="btn btn-secondary" type="button" onClick={() => subNotify({ action: "edit-ingredient-form", ingredient: ingredient })}>Edit</button>
            </td>
        </tr>
    );
}

export default IngredientCard;