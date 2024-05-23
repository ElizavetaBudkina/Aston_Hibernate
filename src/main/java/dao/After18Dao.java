package dao;


import models.After18;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class After18Dao {
    public After18 getAfter18ById(Long id) throws Exception {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        After18 after18 = session.get(After18.class, id);
        if (after18 == null) {
            System.out.println("Искомые данные не найдены");
            session.close();
            throw new Exception();
        } else {
            session.close();
            return after18;
        }
    }

    public List<After18> getAllAfter18() throws Exception {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<After18> after18s = (List<After18>) session.createQuery("from After18", After18.class).list();
        if (after18s == null) {
            System.out.println("Искомые данные не найдены");
            session.close();
            throw new Exception();
        } else {
            session.close();
            return after18s;
        }
    }

    public void save(After18 after18){
        //получаем готовый SessionFactory и сразу открываем сессиию
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();

        session.getTransaction().begin(); //открыть транзакцию
        session.save(after18); //фиксируем изменения
        session.getTransaction().commit(); //сохраняем изменения
        session.close(); //закрываем сессию
        System.out.println("CREATE");
    }

    public void update(After18 after18){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tr = session.beginTransaction();
        try {
            session.update(after18);
            System.out.println("UPDATE");
        } catch (Exception e) {
            System.out.println("Ошибка: " + e);
        }
        finally {
            tr.commit();
            session.close();
        }
    }

    public void delete(After18 after18){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tr = session.beginTransaction();
        try {
            session.delete(after18);
            System.out.println("DELETE");
        } catch (Exception e) {
            System.out.println("Ошибка: " + e);
        }
        finally {
            tr.commit();
            session.close();
        }
    }

    public void print(After18 after18){
        System.out.println("After18");
        System.out.printf("%4s|%30s|%15s|%15s|%15s|\n","Id", "BookName", "FamAvtor", "ImAvtor", "OtAvtor");
        System.out.printf("%4s|%30s|%15s|%15s|%15s|\n",after18.getId(),after18.getBook().getName(),after18.getBook().getAvtor().getFam(),after18.getBook().getAvtor().getIm(),after18.getBook().getAvtor().getOt());
    }

    public void print(List<After18> after18s){
        System.out.println("After18");
        System.out.printf("%4s|%30s|%15s|%15s|%15s|\n","Id", "BookName", "FamAvtor", "ImAvtor", "OtAvtor");
        for (int i = 0; i<after18s.size();i++) {
            After18 after18 = after18s.get(i);
            System.out.printf("%4s|%30s|%15s|%15s|%15s|\n",after18.getId(),after18.getBook().getName(),after18.getBook().getAvtor().getFam(),after18.getBook().getAvtor().getIm(),after18.getBook().getAvtor().getOt());
        }
    }
}
