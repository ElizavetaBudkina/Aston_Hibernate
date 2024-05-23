package models;


import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "after18", schema = "public", catalog = "test1")
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
public class After18 {
    @Id
    @SequenceGenerator(name = "after18_seq", sequenceName = "AFTER18_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "after18_seq")
    @Column (name = "id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idbooks", unique  = true)
    private Book book;

    public After18(Book book){
        this.book = book;
    }
}
