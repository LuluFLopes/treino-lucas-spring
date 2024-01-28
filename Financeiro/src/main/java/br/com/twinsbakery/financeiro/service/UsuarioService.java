package br.com.twinsbakery.financeiro.service;

import br.com.twinsbakery.financeiro.model.Usuario;
import br.com.twinsbakery.financeiro.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void salvarUsuario(Usuario usuario) {
        validarSePodeCadastrar(usuario);
        usuarioRepository.save(usuario);
    }

    private void validarSePodeCadastrar(Usuario usuario) {
        if (usuario.getDataNascimento().isAfter(LocalDate.now())){
            throw new IllegalArgumentException("Não é possível informar uma data depois de hoje");
        }
    }

    public List<Usuario> listarUsuarios(){
        return usuarioRepository.findAll();
    }

}
