package services;

import dao.After18Dao;
import lombok.NoArgsConstructor;
import models.After18;

import java.util.List;

@NoArgsConstructor
public class After18Service {
    private After18Dao after18Dao = new After18Dao();

    public After18 getAfter18ById(Long id) throws Exception {
        try {
            return after18Dao.getAfter18ById(id);
        } catch (Exception e){
            throw new Exception(e);
        }
    }

    public List<After18> getAllAfter18() throws Exception {
        try {
            return after18Dao.getAllAfter18();
        } catch (Exception e){
            throw new Exception(e);
        }
    }

    public void save(After18 after18){
        after18Dao.save(after18);
    }

    public void update(After18 after18){
        after18Dao.update(after18);
    }

    public void delete(After18 after18){
        after18Dao.delete(after18);
    }

    public void print(After18 after18){
        after18Dao.print(after18);
    }

    public void print(List<After18> after18s){
        after18Dao.print(after18s);
    }
}
