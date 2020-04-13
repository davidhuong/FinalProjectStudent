package service;

import entity.Student;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Stateless
public class StudentService {
    @PersistenceContext(unitName = "studentPersistenceUnit")
    private EntityManager manager;
    public List<Student> getAll() {
        return manager.createNamedQuery("findAllStudents", Student.class).getResultList();
    }
    public Student findById(long id) {
        return manager.find(Student.class, id);
    }

    @Transactional
    public void update(Student student) {
        manager.getTransaction().begin();
        manager.merge(student);
        manager.getTransaction().commit();
    }
    @Transactional
    public void create(Student student) {
        manager.getTransaction().begin();
        manager.persist(student);
        manager.getTransaction().commit();
    }
    @Transactional
    public void delete(Student student) {
        manager.getTransaction().begin();
        if (!manager.contains(student)) {
            student = manager.merge(student);
        }

        manager.remove(student);
        manager.getTransaction().commit();
    }


}
