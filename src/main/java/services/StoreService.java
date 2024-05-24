package services;

import dao.StoreDao;
import lombok.NoArgsConstructor;
import models.Store;

import java.util.List;

@NoArgsConstructor
public class StoreService {
    private StoreDao storeDao = new StoreDao();

    public Store getStoreById(Long id) throws Exception {
        try {
            return storeDao.getStoreById(id);
        } catch (Exception e){
            throw new Exception(e);
        }
    }

    public List<Store> getAllStore() throws Exception {
        try {
            return storeDao.getAllStore();
        } catch (Exception e){
            throw new Exception(e);
        }
    }

    public void save(Store store){
        storeDao.save(store);
    }

    public void update(Store store){
       storeDao.update(store);
    }

    public void delete(Store store){
        storeDao.delete(store);
    }

    public void print(Store store){
        storeDao.print(store);
    }

    public void print(List<Store> stores){
        storeDao.print(stores);
    }

}
