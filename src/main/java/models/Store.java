package models;


import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;


@Entity
@Table (name = "store", schema = "public", catalog = "test1")
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
public class Store {

    @Id
    @SequenceGenerator(name = "store_seq", sequenceName = "STORE_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "store_seq")
    @Column (name = "id")
    private Long id;

    @Column(name = "city")
    private String city;

    @Column(name = "street")
    private String street;

    @Column(name = "house")
    private String house;

    public Store(String city, String street, String house){
        this.city = city;
        this.street = street;
        this.house = house;

    }

    @ManyToMany(mappedBy = "stores")
    private Set<Book> books = new HashSet();


}
