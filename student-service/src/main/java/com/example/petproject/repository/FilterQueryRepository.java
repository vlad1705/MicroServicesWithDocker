package com.example.petproject.repository;

import com.example.petproject.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FilterQueryRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Student> findBooksByAuthorEmail(String email) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> cq = cb.createQuery(Student.class);


        Root<Student> student = cq.from(Student.class);
        student.fetch("notes");
        Predicate studentNamePredicate = cb.equal(student.get("email"), email);
        cq.where(studentNamePredicate);

        TypedQuery<Student> query = entityManager.createQuery(cq);
        return query.getResultList();
    }

}
