function RatingCard({ rating, subNotify }) {

    function handleDelete() {
        fetch(`http://localhost:8080/ratings/${rating.ratingId}`, { method: "DELETE" })
            .then(() => subNotify({ action: "delete-rating", rating: rating }))
            .catch(error => subNotify({ action: "delete-rating", error: error }));
    }

    return (
        <tr key={rating.ratingId}>
            <td>{rating.recommended ? 'Y' : 'N'}</td>
            <td>{rating.numStars}</td>
            <td>{rating.ratingText}</td>
            <td>
                <button id="deleteButton" className="btn btn-danger mr-3" type="button" onClick={handleDelete}>Delete</button>
            </td>
        </tr>
    );
}

export default RatingCard;