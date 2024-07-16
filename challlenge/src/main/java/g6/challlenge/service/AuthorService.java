package g6.challlenge.service;

import g6.challlenge.model.Author;
import g6.challlenge.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> listLivingAuthorsByYear(int year) {
        LocalDate date = LocalDate.of(year, 1, 1);
        return authorRepository.findByBirthDateAfter(date);
    }
}
