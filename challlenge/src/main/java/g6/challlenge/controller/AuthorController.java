package g6.challlenge.controller;

import g6.challlenge.model.Author;
import g6.challlenge.service.AuthorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/living")
    public List<Author> listLivingAuthorsByYear(@RequestParam int year) {
        return authorService.listLivingAuthorsByYear(year);
    }
}
