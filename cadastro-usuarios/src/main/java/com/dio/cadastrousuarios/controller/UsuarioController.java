package com.dio.cadastrousuarios.controller;

import com.dio.cadastrousuarios.dto.UsuarioDTO;
import com.dio.cadastrousuarios.entity.Usuario;
import com.dio.cadastrousuarios.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

//    @GetMapping
    /*ResponseEntity<Object>allUserCTRL(@PageableDefault(page = 0,size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.findAll(pageable));
    }*/

    @GetMapping
    public List<Usuario> allUserCTRL() throws Exception{
        return usuarioService.findAll();
    }
    @PostMapping
    public UsuarioDTO cadastrarInovacao(@RequestBody UsuarioDTO usuarioDTO) throws Exception {
		return usuarioService.salvarUser(usuarioDTO);


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
