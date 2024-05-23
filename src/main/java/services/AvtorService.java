package services;

import dao.AvtorDao;
import lombok.NoArgsConstructor;
import models.Avtor;
import models.Book;

import java.util.List;
@NoArgsConstructor
public class AvtorService {
    private AvtorDao avtorDao = new AvtorDao();

    public Avtor getAvtorById(Long id) throws Exception {
        try {
            return avtorDao.getAvtorById(id);
        }  catch (Exception e){
            throw new Exception(e);
        }
    }

    public List<Avtor> getAllAvtor() throws Exception {
        try {
            return avtorDao.getAllAvtor();
        }  catch (Exception e){
            throw new Exception(e);
        }
    }

    public void save(Avtor avtor){
        avtorDao.save(avtor);
    }

    public void update(Avtor avtor){
        avtorDao.update(avtor);
    }

    public void delete(Avtor avtor){
        avtorDao.delete(avtor);
    }

    public void print(Avtor avtor){
        avtorDao.print(avtor);
    }

    public void print(List<Avtor> avtors){
        avtorDao.print(avtors);
    }

    public Book findBookById(Long id) throws Exception {
        try {
            return avtorDao.findBookById(id);
        } catch (Exception e){
            System.out.println("Таких данных нет в БД " + e);
            throw new Exception(e);
        }
    }
}
