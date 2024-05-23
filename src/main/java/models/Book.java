package models;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "books", schema = "public", catalog = "test1")
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
public class Book {
    @Id
    @SequenceGenerator(name = "books_seq", sequenceName = "BOOKS_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "books_seq")
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne()
    @JoinColumn(name = "idavtor")
    private Avtor avtor;

    @OneToOne(cascade = CascadeType.REMOVE, mappedBy = "book")
    public After18 after18;

    @ManyToMany()
    @JoinTable(name = "booksandstore",
            joinColumns = @JoinColumn(name = "idbooks", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "idstore", referencedColumnName = "id"))
    private Set<Store> stores = new HashSet<>();

    public Book(String name, Avtor avtor) {
        this.name = name;
        this.avtor = avtor;
    }
}