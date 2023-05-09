package musicPackage;

import jakarta.persistence.*;

import java.math.BigInteger;
import java.util.Objects;

@Entity
@Table(name = "CONN", schema = "MUSIC", catalog = "")
public class ConnEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private BigInteger id;
    @Basic
    @Column(name = "ID_ALBUM")
    private BigInteger idAlbum;
    @Basic
    @Column(name = "ID_GENRE")
    private BigInteger idGenre;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(BigInteger idAlbum) {
        this.idAlbum = idAlbum;
    }

    public BigInteger getIdGenre() {
        return idGenre;
    }

    public void setIdGenre(BigInteger idGenre) {
        this.idGenre = idGenre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConnEntity that = (ConnEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(idAlbum, that.idAlbum) && Objects.equals(idGenre, that.idGenre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idAlbum, idGenre);
    }
}
