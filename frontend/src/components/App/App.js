import './App.css';
import Header from "../Header/header";
import React, {Component} from "react";
import {BrowserRouter as Router, Routes, Route} from 'react-router-dom/dist'
import bookEShopRepository from "../../repository/bookEShopRepository";
import BooksList from "../Books/booksList";
import BooksAdd from "../Books/booksAdd";
import BooksEdit from "../Books/booksEdit";
import Categories from "../Categories/categories"

class App extends Component {

  constructor(props) {
    super(props);
    this.state = {
        books: [],
        categories: [],
        authors: [],
        selectedBook: {}
    }
  }

  render() {
    return (
        <Router>
            <Header/>
            <main>
                <div className="container">
                    <Routes>
                        <Route path={"/books/add"} exact
                               element={<BooksAdd categories={this.state.categories}
                                                  authors={this.state.authors}
                                                  onAddBook={this.addBook}/>}/>
                        <Route path={"/books/edit/:id"} exact
                               element={<BooksEdit book={this.state.selectedBook}
                                                  categories={this.state.categories}
                                                  authors={this.state.authors}
                                                  onEditBook={this.editBook}/>}/>
                        <Route path={"/books"} exact
                               element={<BooksList books={this.state.books}
                                                    onEdit={this.getBook}
                                                    onDelete={this.deleteBook}
                                                    MarkTaken={this.markTaken}/>}/>
                        <Route path={"/categories"} exact
                               element={<Categories categories={this.state.categories}/>}/>
                        <Route path={"/"} exact
                               element={<BooksList books={this.state.books}
                                                  onEdit={this.getBook}
                                                  onDelete={this.deleteBook}
                                                  MarkTaken={this.markTaken}/>}/>
                    </Routes>
                </div>
            </main>
        </Router>
    );
  }

  componentDidMount() {
    this.fetchData()
  }

  fetchData = () => {
    this.loadBooks();
    this.loadCategories();
    this.loadAuthors();
  }

  loadBooks = () => {
      bookEShopRepository.fetchBooks()
          .then((data) => {
              this.setState({
                  books: data.data
              })
          });
    }

  loadCategories = () => {
    bookEShopRepository.fetchCategories()
        .then((data) => {
          this.setState({
            categories: data.data
          })
        });
  }

    loadAuthors = () => {
      bookEShopRepository.fetchAuthors()
          .then((data) => {
              this.setState({
                  authors: data.data
              })
          });
    }

    getBook = (id) => {
        bookEShopRepository.getBook(id)
            .then((data) => {
                this.setState({
                    selectedBook: data.data
                })
            })
    }

    addBook = (name, category, author, availableCopies) => {
        bookEShopRepository.addBook(name, category, author, availableCopies)
            .then(() => {
                this.loadBooks();
            })
    }

    editBook = (id, name, category, author, availableCopies) => {
        bookEShopRepository.editBook(id, name, category, author, availableCopies)
            .then(() => {
                this.loadBooks();
            })
    }

    deleteBook= (id) => {
        bookEShopRepository.deleteBook(id)
            .then(() => {
                this.loadBooks();
            })
    }

    markTaken = (id) => {
        bookEShopRepository.markTaken(id)
            .then(()=>{
                this.loadBooks();
            })
    }
}

export default App;
