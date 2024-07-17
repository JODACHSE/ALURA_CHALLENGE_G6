package g6.ForoHub_Challenge.repository;

import g6.ForoHub_Challenge.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByUsername(String username);
}
