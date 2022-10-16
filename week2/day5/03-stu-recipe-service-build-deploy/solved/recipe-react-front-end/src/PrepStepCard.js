function PrepStepCard({ prepStep, subNotify }) {

    function handleDelete() {
        fetch(`http://localhost:8080/prepsteps/${prepStep.prepStepId}`, { method: "DELETE" })
            .then(() => subNotify({ action: "delete-prepstep", prepStep: prepStep }))
            .catch(error => subNotify({ action: "delete-prepstep", error: error }));
    }

    return (
        <tr key={prepStep.ingredientId}>
            <td>{prepStep.stepNumber}</td>
            <td>{prepStep.prepStepText}</td>
            <td>
                <button id="deleteButton" className="btn btn-danger mr-3" type="button" onClick={handleDelete}>Delete</button>
                <button id="editButton" className="btn btn-secondary" type="button" onClick={() => subNotify({ action: "edit-prepstep-form", prepStep: prepStep })}>Edit</button>
            </td>
        </tr>
    );
}

export default PrepStepCard;
