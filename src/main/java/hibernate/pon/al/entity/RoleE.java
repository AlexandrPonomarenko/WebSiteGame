package hibernate.pon.al.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "roles", schema = "test", uniqueConstraints = {@UniqueConstraint(columnNames = "id_role")})
public class RoleE implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "role_auto")
    @SequenceGenerator(name = "role_auto", sequenceName = "AUTO_RO", allocationSize = 1, schema ="test")
    @Column(name = "id_role", nullable = false)
    private Integer id_role;

    @Column(name ="role", nullable = false)
    private String role;

    @OneToMany(mappedBy = "roleE", cascade = CascadeType.ALL)
    private Set<UserE> users = new HashSet<UserE>();

    public RoleE(){}

    public RoleE(String role, Set<UserE> users) {
        this.role = role;
        this.users = users;
    }

    public RoleE(int id_role, String role, Set<UserE> users) {
        this.id_role = id_role;
        this.role = role;
        this.users = users;
    }

    public Integer getId_role() {
        return id_role;
    }

    public void setId_role(Integer id_role) {
        this.id_role = id_role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Set<UserE> getUsers() {
        return users;
    }

    public void setUsers(Set<UserE> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "RoleE{" +
                "id_role=" + id_role +
                ", role='" + role + '\'' +
                ", users=" + users.size() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RoleE)) return false;
        RoleE roleE = (RoleE) o;
        return Objects.equals(getId_role(), roleE.getId_role()) &&
                Objects.equals(getRole(), roleE.getRole());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId_role(), getRole());
    }
}
