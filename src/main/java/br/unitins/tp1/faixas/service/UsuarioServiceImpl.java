package br.unitins.tp1.faixas.service;

import java.util.List;

import br.unitins.tp1.faixas.model.Usuario;
import br.unitins.tp1.faixas.repository.UsuarioRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class UsuarioServiceImpl implements UsuarioService {

    @Inject
    public UsuarioRepository usuarioRepository;

    @Override
    public Usuario findById(Long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public Usuario findByUsernameAndSenha(String username, String senha) {
        return usuarioRepository.findByUsernameAndSenha(username, senha);
    }

    @Override
    public List<Usuario> findByNome(String nome) {
        return null;
    }

    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.findAll().list();
    }


    @Override
    @Transactional
    public void delete(Long id) {
        usuarioRepository.deleteById(id);
    }
    
}
