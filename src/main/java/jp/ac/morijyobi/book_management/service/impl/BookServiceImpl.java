package jp.ac.morijyobi.book_management.service.impl;

import jp.ac.morijyobi.book_management.bean.entity.Book;
import jp.ac.morijyobi.book_management.bean.entity.BookTag;
import jp.ac.morijyobi.book_management.bean.form.BookForm;
import jp.ac.morijyobi.book_management.mapper.BookTagsMapper;
import jp.ac.morijyobi.book_management.mapper.BooksMapper;
import jp.ac.morijyobi.book_management.service.BookService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BooksMapper booksMapper;
    private final BookTagsMapper bookTagsMapper;

    public BookServiceImpl(BooksMapper booksMapper, BookTagsMapper bookTagsMapper) {
        this.booksMapper = booksMapper;
        this.bookTagsMapper = bookTagsMapper;
    }

    @Override
    @Transactional
    public void registerBook(BookForm bookForm) {
        Book book =new Book();
        book.setTitle(bookForm.getTitle());
        book.setAuthor(bookForm.getAuthor());
        book.setPublisher(bookForm.getPublisher());
        book.setPublication_date(bookForm.getPublicationDate());

        booksMapper.insertBook(book);
        for(int tagId:bookForm.getTagIdList()){
            BookTag bookTag = new BookTag();
            bookTag.setBookId(book.getId());
            bookTag.setTagId(tagId);
            bookTagsMapper.insertBookTag(bookTag);
        }

    }

    @Override
    public List<Book> getBooksByKeyword(String keyword) {
        return booksMapper.selectBooksByKeyword(keyword);
    }
}
