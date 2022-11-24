package com.dio.cadastrousuarios.controller;

import com.dio.cadastrousuarios.dto.UsuarioDTO;
import com.dio.cadastrousuarios.entity.Usuario;
import com.dio.cadastrousuarios.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping
    ResponseEntity<Object>allUserCTRL(@RequestBody UsuarioDTO usuarioDTO){
        return ResponseEntity.status(HttpStatus.OK).body(usuarioDTO);
    }

    @PostMapping
    ResponseEntity<UsuarioDTO>saveUserCTRL(@RequestBody UsuarioDTO usuarioDTO) throws Exception {
        if (usuarioDTO != null) {
            JOptionPane.showMessageDialog(null, "Usuario Já Cadastrado");
            return ResponseEntity.status(HttpStatus.CONFLICT).body(usuarioDTO);
        } usuarioService.salvarUser(usuarioDTO);
        return ResponseEntity.status(HttpStatus.OK).body(usuarioDTO);
    }

    @GetMapping("/{identificador}") /*Uma Forma de Fazer*/
    ResponseEntity<Usuario> getOneCTRL(@PathVariable(value = "identificador") Long identificador){
        return usuarioService.getOne(identificador);
    }

    @PutMapping("/{id}") /*Outra forma de Fazer*/
    ResponseEntity<Object>atualizarCTRL(@PathVariable(value = "id") UUID id, @RequestBody UsuarioDTO usuarioDTO) {
        Optional<Usuario> usuarioOptional = usuarioService.atualizar(id);
        if (!usuarioOptional.isPresent()) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("CPF/CNPJ Nao Encontrado");
        }   return ResponseEntity.status(HttpStatus.OK).body("Usuario Atualizado");
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Object> deleteCTRL(@PathVariable(value = "identificador") UUID id){
        Optional<Usuario> usuarioOptional = usuarioService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Usuario Deletado Com Sucesso");
    }

}
