package dao;

import models.Store;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class StoreDao {

    public Store getStoreById(Long id) throws Exception {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Store store = session.get(Store.class, id);
        if (store == null) {
            System.out.println("Искомые данные не найдены");
            session.close();
            throw new Exception();
        } else {
            session.close();
            return store;
        }
    }

    public List<Store> getAllStore() throws Exception {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<Store> stores = (List<Store>) session.createQuery("from Store", Store.class).list();
        if (stores == null) {
            System.out.println("Искомые данные не найдены");
            session.close();
            throw new Exception();
        } else {
            session.close();
            return stores;
        }
    }

    public void save(Store store){
        //получаем готовый SessionFactory и сразу открываем сессиию
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();

        session.getTransaction().begin(); //открыть транзакцию
        session.save(store); //фиксируем изменения
        session.getTransaction().commit(); //сохраняем изменения
        session.close(); //закрываем сессию
        System.out.println("CREATE");
    }

    public void update(Store store){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tr = session.beginTransaction();
        try {
            session.update(store);
            System.out.println("UPDATE");
        } catch (Exception e) {
            System.out.println("Ошибка: " + e);
        }
        finally {
            tr.commit();
            session.close();
        }
    }

    public void delete(Store store){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tr = session.beginTransaction();
        try {
            session.delete(store);
            System.out.println("DELETE");
        } catch (Exception e) {
            System.out.println("Ошибка: " + e);
        }
        finally {
            tr.commit();
            session.close();
        }
    }

    public void print(Store store){
        System.out.println("Store");
        System.out.printf("%4s|%20s|%20s|%10s|\n","Id", "City", "Street", "House");
        System.out.printf("%4d|%20s|%20s|%10s|\n",store.getId(),store.getCity(),store.getStreet(),store.getHouse());
    }

    public void print(List<Store> stores){
        System.out.println("Store");
        System.out.printf("%4s|%20s|%20s|%10s|\n","Id", "City", "Street", "House");
        for (int i = 0; i<stores.size();i++) {
            Store store = stores.get(i);
            System.out.printf("%4d|%20s|%20s|%10s|\n", store.getId(), store.getCity(), store.getStreet(), store.getHouse());
        }
    }
}
