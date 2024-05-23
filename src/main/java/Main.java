import models.After18;
import models.Avtor;
import models.Book;
import models.Store;
import services.After18Service;
import services.AvtorService;
import services.BookService;
import services.StoreService;

import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

        //Инициализация
        AvtorService avtorService = new AvtorService();
        BookService bookService = new BookService();
        StoreService storeService = new StoreService();
        After18Service after18Service =  new After18Service();


        //Авторы
        List<Avtor> avtors = avtorService.getAllAvtor();
        avtorService.print(avtors); //SELECT
        Avtor avtor = new Avtor("Лермонтов", "Михаил","Андреевич");
        avtorService.save(avtor); //CREATE
        avtorService.print(avtorService.getAllAvtor());

        avtor.setOt("Юрьевич"); //UPDATE
        avtorService.update(avtor);
        avtorService.print(avtorService.getAllAvtor());

        avtorService.delete(avtor); //DELETE
        avtorService.print(avtorService.getAllAvtor());

        //Магазины
        storeService.print(storeService.getAllStore()); //SELECT
        Store store = new Store("Сочи", "Вторая", "5");
        storeService.save(store); //CREATE
        storeService.print(storeService.getAllStore());

        store.setStreet("Первая");
        storeService.update(store); //UPDATE
        storeService.print(storeService.getAllStore());

        storeService.delete(store); //DELETE
        storeService.print(storeService.getAllStore());

        //Книги
        bookService.print(bookService.getAllBook()); //SELECT
        avtorService.print(avtorService.getAvtorById(51L));
        Book book = new Book("Тарас Бульба", avtor);
        bookService.save(book); //CREATE
        bookService.print(bookService.getAllBook());

        book.setName("Ночь перед Рождеством");
        bookService.update(book); //UPDATE
        bookService.print(bookService.getAllBook());
        //DELETE Book чуть ниже


        //Ограничение 18+
        after18Service.print(after18Service.getAllAfter18()); //SELECT
        After18 after18 = new After18(book);
        after18Service.save(after18); //CREATE
        bookService.print(bookService.getAllBook());

        after18.setBook(bookService.getBookById(3L));
        after18Service.update(after18); //UPDATE
        bookService.print(bookService.getAllBook());

        after18Service.delete(after18); //DELETE
        bookService.print(bookService.getAllBook());

        bookService.delete(book); //DELETE
        bookService.print(bookService.getAllBook());
    }
}
