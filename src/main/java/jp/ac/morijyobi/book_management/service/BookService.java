package jp.ac.morijyobi.book_management.service;

import jp.ac.morijyobi.book_management.bean.entity.Book;
import jp.ac.morijyobi.book_management.bean.form.BookForm;

import java.util.List;

public interface BookService {

    void registerBook(BookForm bookForm);
    List<Book> getBooksByKeyword(String keyword);

    }
