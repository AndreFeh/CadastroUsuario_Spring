package com.dio.cadastrousuarios.service;

import com.dio.cadastrousuarios.dto.UsuarioDTO;
import com.dio.cadastrousuarios.entity.Usuario;
import com.dio.cadastrousuarios.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepo;

    UsuarioDTO usuarioDTO;

    public List<Usuario> findAll() {
        return usuarioRepo.findAll();
    }

    public Page<Usuario> findAll(Pageable pageable) {
        return usuarioRepo.findAll(pageable);
    }

    public UsuarioDTO salvarUser(UsuarioDTO usuarioDTO) throws Exception{
        Usuario usuario = new Usuario();
        usuario = usuarioRepo.save(usuario.convert(usuarioDTO));
        return usuarioDTO.convert(usuario);
    }

    public ResponseEntity<Usuario> getOne(Long identificador){
        Optional<Usuario> usuario = usuarioRepo.findByIdentificador(identificador);
        if (usuario.isPresent()){
            Usuario user = usuario.get();
            if(user.getId() != null || user.getNome()!= null || user.getEmail()!= null || user.getPhone()!= null || user.getIdentificador()!= null || user.getDataNasc()!= null){
                user.setId(usuarioDTO.getId());
                user.setNome(usuarioDTO.getNome());
                user.setIdentificador(usuarioDTO.getIdentificador());
                user.setEmail(usuarioDTO.getEmail());
                user.setDataNasc(usuarioDTO.getDataNasc());
                user.setPhone(usuarioDTO.getPhone());
            } usuarioRepo.save(user);
            return new ResponseEntity<Usuario>(usuario.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
//    public Optional<Usuario> getOne(Long identificador) {
//        return usuarioRepo.findByIdentificador(identificador);

//    }

    public Optional<Usuario> atualizar(UUID id) {
        return usuarioRepo.findById(id);

    }

    public Optional<Usuario> delete(UUID id) {
        return usuarioRepo.findById(id);

    }
}
