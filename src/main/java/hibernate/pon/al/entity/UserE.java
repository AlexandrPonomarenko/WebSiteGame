package hibernate.pon.al.entity;

import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "users", schema = "test", uniqueConstraints = {@UniqueConstraint(columnNames = "id")})
public class UserE implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "user_auto")
    @SequenceGenerator(name = "user_auto", sequenceName = "AUTO_US", allocationSize = 1, schema ="test")
    @Column(name ="id", nullable = false, updatable = false)
    private Integer id;

    @Column(name ="nickname", nullable = false, unique = true)
    private String nickname;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name ="firstname", nullable = false)
    private String firstname;

    @Column(name = "lastname", nullable = false)
    private String lastname;

    @Column(name = "password",nullable = false)
    private String password;

    @Column(name = "passwordTwo", nullable = false)
    private String passwordTwo;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "key", nullable = true)
    private String key;

    @ManyToOne
    @JoinColumn(name = "id_role", nullable = false)
    private RoleE roleE;

    @OneToMany(mappedBy = "userE",cascade = CascadeType.ALL)
    private Set<GameStatE> statgame = new HashSet<GameStatE>();

    public UserE(){}

    public UserE(String nickname, String firstname, String lastname, String password, String passwordTwo, String status, RoleE roleE, Set<GameStatE> statgame) {
        this.nickname = nickname;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.passwordTwo = passwordTwo;
        this.status = status;
        this.roleE = roleE;
        this.statgame = statgame;
    }

    public UserE(int id, String nickname, String firstname, String lastname, String password, String passwordTwo, String status, RoleE roleE, Set<GameStatE> statgame) {
        this.id = id;
        this.nickname = nickname;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.passwordTwo = passwordTwo;
        this.status = status;
        this.roleE = roleE;
        this.statgame = statgame;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordTwo() {
        return passwordTwo;
    }

    public void setPasswordTwo(String passwordTwo) {
        this.passwordTwo = passwordTwo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public RoleE getRoleE() {
        return roleE;
    }

    public void setRoleE(RoleE roleE) {
        this.roleE = roleE;
    }

    public Set<GameStatE> getStatgame() {
        return statgame;
    }

    public void setStatgame(Set<GameStatE> statgame) {
        this.statgame = statgame;
    }

    @Override
    public String toString() {
        return "UserE{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", password='" + password + '\'' +
                ", passwordTwo='" + passwordTwo + '\'' +
                ", status='" + status + '\'' +
                ", key='" + key + '\'' +
                ", roleE=" + roleE.getRole() +
                ", statgame=" + statgame.size() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserE)) return false;
        UserE userE = (UserE) o;
        return Objects.equals(getId(), userE.getId()) &&
                Objects.equals(getNickname(), userE.getNickname()) &&
                Objects.equals(getEmail(), userE.getEmail()) &&
                Objects.equals(getFirstname(), userE.getFirstname()) &&
                Objects.equals(getLastname(), userE.getLastname()) &&
                Objects.equals(getPassword(), userE.getPassword()) &&
                Objects.equals(getPasswordTwo(), userE.getPasswordTwo()) &&
                Objects.equals(getStatus(), userE.getStatus());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getNickname(), getEmail(), getFirstname(), getLastname(), getPassword(), getPasswordTwo(), getStatus());
    }
}
