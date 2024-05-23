package models;


import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "avtor", schema = "public", catalog = "test1")
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
public class Avtor {
    @Id
    @SequenceGenerator(name = "avtor_seq", sequenceName = "AVTOR_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "avtor_seq")
    @Column (name = "id")
    private Long id;

    @Column(name = "fam")
    private String fam;

    @Column(name = "im")
    private String im;

    @Column(name = "ot")
    private String ot;

    public Avtor(String fam, String im, String ot){
        this.fam = fam;
        this.im = im;
        this.ot = ot;
        books = new ArrayList<>();

    }

    //добавляем связь
    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "avtor")
    private List<Book> books;

    @Override
    public boolean equals(Object avtor){
        if (avtor == this) {return true;}
        if (avtor == null || avtor.getClass() != this.getClass()){
            return false;
        }
        Avtor avtor1 = (Avtor) avtor;
        return (fam == avtor1.fam || (fam != null && fam.equals(avtor1.getFam())))
                && (im == avtor1.im || (im != null && im.equals(avtor1.getIm())))
                && (ot == avtor1.ot || (ot != null && ot.equals(avtor1.getOt())));
    }
}
