package entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
@NamedQueries({
        @NamedQuery(name = "findAllStudents", query = "SELECT s FROM Student s")
})
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;
    private int contactNumber;
    private String program;
    private String DoB;

    public Student(String name, String email, int contactNumber, String program, String DoB ) {
       this.name = name;
       this.email = email;
       this.program = program;
       this.contactNumber = contactNumber;
       this.DoB  = DoB;
    }
}
