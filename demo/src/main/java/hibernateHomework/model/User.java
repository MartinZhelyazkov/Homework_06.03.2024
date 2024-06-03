package hibernateHomework.model;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Set;
@Entity
@Table(name="Users")
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "first_name",nullable = false,length = 100)
    private String firstName;
    @Column(name = "last_name",nullable = false,length = 100)
    private String lastName;
    @Column(nullable = false,length = 200)
    private String email;
    @Column(length = 50)
    private String nationality;
    @OneToMany(mappedBy = "user",cascade = CascadeType.REMOVE,fetch = FetchType.EAGER)
    @JsonManagedReference
    private Set<Order> orders;


}
