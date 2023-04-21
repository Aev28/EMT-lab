import React from "react";
import {useNavigate} from 'react-router-dom/dist';

const BooksEdit = (props) => {
    const navigate = useNavigate();
    const [formData, updateFormData] = React.useState({
        name: "",
        category: 0,
        author: 0,
        availableCopies: 0
    });

    const handleChange = (e) => {
        updateFormData({
            ...formData,
            [e.target.name]: e.target.value.trim()
        })
    }

    const onFormSubmit = (e) => {
        e.preventDefault();
        const name = formData.name !== "" ? formData.name : props.book.name;
        const availableCopies = formData.availableCopies !== 0 ? formData.availableCopies : props.book.availableCopies;
        const category = formData.category !== 0 ? formData.category : props.book.category;
        const author = formData.author !== 0 ? formData.author : props.book.author.id;

        props.onEditBook(props.book.id, name,category,author, availableCopies);
        navigate("/books");
    }

    return (
        <div className="row mt-5">
            <div className="col-md-5">
                <form onSubmit={onFormSubmit}>
                    <div className="form-group">
                        <label htmlFor="name">Book name</label>
                        <input type="text"
                               className="form-control"
                               id="name"
                               name="name"
                               required
                               defaultValue={props.book.name}
                               onChange={handleChange}
                        />
                    </div>
                    <div className="form-group">
                        <label htmlFor="availableCopies">Available copies</label>
                        <input type="text"
                               className="form-control"
                               id="availableCopies"
                               name="availableCopies"
                               placeholder="Available copies"
                               defaultValue={props.book.availableCopies}
                               required
                               onChange={handleChange}
                        />
                    </div>
                    <div className="form-group">
                        <label>Category</label>
                        <select name="category" className="form-control" onChange={handleChange}>
                            {props.categories.map((term) =>{
                                    if(props.book.category !== undefined && props.book.category === term) {
                                        return <option selected={props.book.category} value={term.id}>{term}</option>
                                    }
                                    else {
                                        return <option value={term.id}>{term}</option>
                                    }
                                }
                            )}
                        </select>
                    </div>
                    <div className="form-group">
                        <label>Author</label>
                        <select name="author" className="form-control" onChange={handleChange}>
                            {props.authors.map((term) =>{
                                    if(props.book.author !== undefined && props.book.author.id === term.id)
                                        return <option selected={props.book.author.id} value={term.id}>{term.name}</option>
                                    else
                                        return <option value={term.id}>{term.name}</option>
                                }
                            )}
                        </select>
                    </div>
                    <button id="submit" type="submit" className="btn btn-primary mt-3 ">Submit</button>
                </form>
            </div>
        </div>

    )
}

export default BooksEdit;