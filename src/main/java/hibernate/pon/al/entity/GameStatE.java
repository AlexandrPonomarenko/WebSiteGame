package hibernate.pon.al.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "statisticsgame", schema = "test", uniqueConstraints = {@UniqueConstraint(columnNames = "id_game")})
public class GameStatE  implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "stat_auto")
    @SequenceGenerator(name = "stat_auto", sequenceName = "AUTO_ST", allocationSize = 1, schema ="test")
    @Column(name = "id_game", nullable = false)
    private Integer id_game;

    @Column(name = "vin", nullable = false)
    private int vin;

    @Column(name = "lost", nullable = false)
    private int lost;

    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private UserE userE;

    public GameStatE(){}

    public GameStatE(int vin, int lost, UserE userE) {
        this.vin = vin;
        this.lost = lost;
        this.userE = userE;
    }

    public GameStatE(int id_game, int vin, int lost, UserE userE) {
        this.id_game = id_game;
        this.vin = vin;
        this.lost = lost;
        this.userE = userE;
    }

    public Integer getId_game() {
        return id_game;
    }

    public void setId_game(Integer id_game) {
        this.id_game = id_game;
    }

    public int getVin() {
        return vin;
    }

    public void setVin(int vin) {
        this.vin = vin;
    }

    public int getLost() {
        return lost;
    }

    public void setLost(int lost) {
        this.lost = lost;
    }

    public UserE getUserE() {
        return userE;
    }

    public void setUserE(UserE userE) {
        this.userE = userE;
    }

    public String getNameUser(){
        return getUserE().getNickname();
    }

    @Override
    public String toString() {
        return "GameStatE{" +
                "id_game=" + id_game +
                ", vin='" + vin + '\'' +
                ", lost='" + lost + '\'' +
                ", userE=" + userE.getNickname() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GameStatE)) return false;
        GameStatE gameStatE = (GameStatE) o;
        return getVin() == gameStatE.getVin() &&
                getLost() == gameStatE.getLost() &&
                Objects.equals(getId_game(), gameStatE.getId_game());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId_game(), getVin(), getLost());
    }
}
