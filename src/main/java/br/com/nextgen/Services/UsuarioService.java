package br.com.nextgen.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.nextgen.Entities.Usuario;
import br.com.nextgen.Repository.UsuarioRepository;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
    public Usuario salvarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
    public Usuario buscarUsuarioId(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public List<Usuario> buscarTodosUsuario() {
        return usuarioRepository.findAll();
    }

    public Usuario alterarUsuario(Long id, Usuario alteraUsuario) {
        Optional<Usuario> existeUsuario = usuarioRepository.findById(id);
        if (existeUsuario.isPresent()) {
            return usuarioRepository.save(alteraUsuario);
        } else {
            return null;
        }
    }

    //RETIRAR O DELETE USUARIO, APENAS DESATIVAR DEIXAR USUARIO INATIVO
    public Boolean deletarUsuario(Long id) {
        Optional<Usuario> existeUsuario = usuarioRepository.findById(id);
        if (existeUsuario.isPresent()) {
            usuarioRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

}
