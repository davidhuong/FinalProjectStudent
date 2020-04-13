import entity.Student;
import service.StudentService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
@RequestScoped
public class AllStudentsView {
    private List<Student> students;

    @EJB
    private StudentService studentService;

    @PostConstruct
    public void init() {
        students = new ArrayList<>();
        students.addAll(studentService.getAll());
    }

    public List<Student> getPlayers() {
        return students;
    }

    public void setPlayers(List<Student> players) {
        this.students = players;
    }

    public String deleteStudent(long id) {
        studentService.delete(studentService.findById(id));
        return "/students.xhtml?faces-redirect=true";
    }


    public String redirectToEditPlayer() {
        return "/editStudent.xhtml?faces-redirect=true";
    }

}