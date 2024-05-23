package dao;

import models.Avtor;
import models.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;
import services.BookService;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class AvtorDao {

    public Avtor getAvtorById(Long id) throws Exception {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Avtor avtor = session.get(Avtor.class, id);
        if (avtor == null) {
            System.out.println("Искомые данные не найдены");
            session.close();
            throw new Exception();
        } else {
            session.close();
            return avtor;
        }
    }

    public List<Avtor> getAllAvtor() throws Exception {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<Avtor> avtors = (List<Avtor>) session.createQuery("from Avtor", Avtor.class).list();
        if (avtors == null) {
            System.out.println("Искомые данные не найдены");
            session.close();
            throw new Exception();
        } else {
            session.close();
            return avtors;
        }
    }

    public void save(Avtor avtor){
        //получаем готовый SessionFactory и сразу открываем сессиию
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();

        session.getTransaction().begin(); //открыть транзакцию
        session.save(avtor); //фиксируем изменения
        session.getTransaction().commit(); //сохраняем изменения
        session.close(); //закрываем сессию
        System.out.println("CREATE");
    }

    public void update(Avtor avtor){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tr = session.beginTransaction();
        try {
            session.update(avtor);
            System.out.println("UPDATE");
        } catch (Exception e) {
            System.out.println("Ошибка: " + e);
        }
        finally {
            tr.commit();
            session.close();
        }
    }

    public void delete(Avtor avtor){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tr = session.beginTransaction();
        try {
            session.delete(avtor);
            System.out.println("DELETE");
        } catch (Exception e) {
            System.out.println("Ошибка: " + e);
        }
        finally {
            tr.commit();
            session.close();
        }
    }

    public void print(Avtor avtor){
        System.out.println("Avtor");
        System.out.printf("%4s|%15s|%15s|%15s|\n","Id", "Fam", "Im", "Ot");
        System.out.printf("%4s|%15s|%15s|%15s|\n",avtor.getId(),avtor.getFam(),avtor.getIm(),avtor.getOt());
    }

    public void print(List<Avtor> avtors){
        System.out.println("Avtor");
        System.out.printf("%4s|%15s|%15s|%15s|\n","Id", "Fam", "Im", "Ot");
        for (int i = 0; i<avtors.size();i++) {
            Avtor avtor = avtors.get(i);
            System.out.printf("%4s|%15s|%15s|%15s|\n", avtor.getId(), avtor.getFam(),avtor.getIm(),avtor.getOt());
        }
    }

    public Book findBookById(Long id) throws Exception {
        BookService bookService = new BookService();
        Book book = bookService.getBookById(id);
        if (book == null) {
            System.out.println("Искомые данные не найдены");
            throw new Exception();
        } else return book;
    }
}
