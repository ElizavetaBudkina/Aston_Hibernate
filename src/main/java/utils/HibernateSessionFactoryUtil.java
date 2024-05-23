package utils;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//класс для инициализации Hibernate
public class HibernateSessionFactoryUtil{

    // Фабрика для создания сессий
    private static SessionFactory sessionFactory = initSessionFactory();

    private HibernateSessionFactoryUtil() {}

    public static SessionFactory initSessionFactory() throws ExceptionInInitializerError{
        try{
            return new Configuration().configure().buildSessionFactory();
        } catch (Exception e){
            System.out.println("Не удалось инициализировать SessionFactory\n" + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSessionFactory(){
         return sessionFactory;
    }

    //закрвыем все соеденения с помощью SessionFactory
    public static void close(){
        getSessionFactory().close();
    }
}
