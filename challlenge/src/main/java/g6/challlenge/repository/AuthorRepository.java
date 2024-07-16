package g6.challlenge.repository;

import g6.challlenge.model.Author;
import java.time.LocalDate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    List<Author> findByBirthDateAfter(LocalDate date);
}