package services;

import dao.BookDao;
import models.Book;
import models.Store;

import java.util.List;
import java.util.Set;

public class BookService {
    private BookDao bookDao = new BookDao();

    public Book getBookById(Long id) throws Exception {
        try {
            return bookDao.getBookById(id);
        } catch (Exception e){
            throw new Exception(e);
        }
    }

    public List<Book> getAllBook() throws Exception {
        try {
            return bookDao.getAllBook();
        } catch (Exception e){
            throw new Exception(e);
        }
    }

    public void save(Book book){
        bookDao.save(book);
    }

    public void update(Book book){
        bookDao.update(book);
    }

    public void delStoreById(Set<Store> stores){
        bookDao.delStoreById(stores);
    }
    public void delete(Book book){
        bookDao.delete(book);
    }

    public void print(Book book){
        bookDao.print(book);
    }

    public void print(List<Book> books){
        bookDao.print(books);
    }

}
