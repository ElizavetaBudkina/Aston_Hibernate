package dao;

import models.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class BookDao {
    public Book getBookById(Long id) throws Exception {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Book book = session.get(Book.class, id);

        if (book == null) {
            System.out.println("Искомые данные не найдены");
            session.close();
            throw new Exception();
        } else {
            session.close();
            return book;
        }
    }

    public List<Book> getAllBook() throws Exception {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<Book> books = (List<Book>) session.createQuery("from Book", Book.class).list();
        if (books == null) {
            System.out.println("Искомые данные не найдены");
            session.close();
            throw new Exception();
        } else {
            session.close();
            return books;
        }
    }

    public void save(Book book){
        //получаем готовый SessionFactory и сразу открываем сессиию
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();

        session.getTransaction().begin(); //открыть транзакцию
        session.save(book); //фиксируем изменения
        session.getTransaction().commit(); //сохраняем изменения
        session.close(); //закрываем сессию
        System.out.println("CREATE");
    }

    public void update(Book book){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tr = session.beginTransaction();
        try {
            session.update(book);
            System.out.println("UPDATE");
        } catch (Throwable e) {
            System.out.println("Ошибка: " + e);
        }
        finally {
            tr.commit();
            session.close();
        }
    }

    public void delete(Book book){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tr = session.beginTransaction();
        try {
            session.delete(book);
            System.out.println("DELETE");
        } catch (Throwable e) {
            System.out.println("Ошибка: " + e);
        }
        finally {
            tr.commit();
            session.close();
        }
    }

    public void print(Book book){
        String after18;
        System.out.println("Book");
        System.out.printf("%4s|%30s|%15s|%15s|%15s|%10s|\n","Id", "Name", "FamAvtor", "ImAvtor", "OtAvtor", "After18");
        if (book.getAfter18() == null) {after18 = "No";}
        else {after18 = "Yes"; }
        System.out.printf("%4s|%30s|%15s|%15s|%15s|%10s|\n",book.getId(),book.getName(),book.getAvtor().getFam(),book.getAvtor().getIm(),book.getAvtor().getOt(), after18);
    }

    public void print(List<Book> books){
        String after18;
        System.out.println("Book");
        System.out.printf("%4s|%30s|%15s|%15s|%15s|%10s|\n","Id", "Name", "FamAvtor", "ImAvtor", "OtAvtor", "After18");
        for (int i = 0; i<books.size();i++) {
            Book book = books.get(i);
            if (book.getAfter18() == null) {after18 = "No";}
            else {after18 = "Yes"; }
            System.out.printf("%4s|%30s|%15s|%15s|%15s|%10s|\n",book.getId(),book.getName(),book.getAvtor().getFam(),book.getAvtor().getIm(),book.getAvtor().getOt(), after18);
        }
    }
}
