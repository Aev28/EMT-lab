import React from 'react';
import {Link} from 'react-router-dom';

const BooksTerm = (props) => {
    return (
        <tr>
            <td>{props.term.name}</td>
            <td>{props.term.category}</td>
            <td>{props.term.author.name}</td>
            <td>{props.term.availableCopies}</td>
            <td className={"text-right"}>
                <Link className={"btn btn-success me-2"}
                      onClick={() => props.MarkTaken(props.term.id)}>
                    Mark As Taken
                </Link>
                <Link className={"btn btn-primary me-2"}
                      onClick={() => props.onEdit(props.term.id)}
                      to={`/books/edit/${props.term.id}`}>
                    Edit
                </Link>
                <a title={"Delete"} className={"btn btn-danger"}
                   onClick={() => props.onDelete(props.term.id)}>
                    Delete
                </a>
            </td>
        </tr>
    )
}

export default BooksTerm;
