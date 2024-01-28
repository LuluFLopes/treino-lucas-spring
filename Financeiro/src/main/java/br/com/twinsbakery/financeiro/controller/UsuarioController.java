package br.com.twinsbakery.financeiro.controller;

import br.com.twinsbakery.financeiro.model.Usuario;
import br.com.twinsbakery.financeiro.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/home")
public class UsuarioController {

    public final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/salvarUsuario")
    public void salvarUsuario(@RequestBody Usuario usuario) {
        usuarioService.salvarUsuario(usuario);
    }

    @GetMapping("/listarUsuarios")
    @ResponseBody
    public ResponseEntity<List<Usuario>> listarUsuarios(){
        return ResponseEntity.ok(usuarioService.listarUsuarios());
    }

}
