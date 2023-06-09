import axios from '../custom-axios/axios';

const bookEShopRepository = {

    fetchBooks: () => {
        return axios.get('/books');
    },

    fetchCategories: () => {
        return axios.get('/books/categories');
    },

    fetchAuthors: () => {
        return axios.get('/authors');
    },

    getBook: (id) => {
        return axios.get(`/books/${id}`)
    },

    addBook: (name, category, author, availableCopies) => {
        return axios.post(`/books/add`, {
            "name": name,
            "category": category,
            "author": author,
            "availableCopies": availableCopies
        });
    },

    editBook: (id, name, category, author, availableCopies) => {
        return axios.put(`/books/edit/${id}`, {
            "name": name,
            "category": category,
            "author": author,
            "availableCopies": availableCopies
        });
    },

    deleteBook: (id) => {
        return axios.delete(`/books/delete/${id}`);
    },

    markTaken: (id) => {
        return axios.post(`/books/rent/${id}`);
    }
}

export default bookEShopRepository;