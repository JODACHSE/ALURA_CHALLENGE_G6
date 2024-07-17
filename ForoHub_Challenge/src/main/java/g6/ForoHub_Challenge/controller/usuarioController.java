package g6.ForoHub_Challenge.controller;

import g6.ForoHub_Challenge.Usuario;
import g6.ForoHub_Challenge.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/registro")
    public ResponseEntity<?> registrarUsuario(@RequestBody Usuario usuario) {
        if (usuarioService.encontrarPorUsername(usuario.getUsername()) != null) {
            return ResponseEntity.badRequest().body("El usuario ya existe");
        }
        usuarioService.crearUsuario(usuario);
        return ResponseEntity.ok("Usuario creado exitosamente");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Usuario usuario) {
        Usuario usuarioExistente = usuarioService.encontrarPorUsername(usuario.getUsername());
        if (usuarioExistente != null && new BCryptPasswordEncoder().matches(usuario.getPassword(), usuarioExistente.getPassword())) {
            return ResponseEntity.ok("Inicio de sesión exitoso");
        }
        return ResponseEntity.badRequest().body("Credenciales inválidas");
    }
}
