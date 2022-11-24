package com.dio.cadastrousuarios.dto;

import com.dio.cadastrousuarios.entity.Usuario;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class UsuarioDTO {
    private UUID id;
    private String nome;
    private Long identificador;
    private String email;
    private LocalDate dataNasc;
    private Long phone;


    public static UsuarioDTO convert (Usuario usuario) throws Exception{
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setId(usuario.getId());
        usuarioDTO.setNome(usuario.getNome());
        usuarioDTO.setIdentificador(usuario.getIdentificador());
        usuarioDTO.setEmail(usuario.getEmail());
        usuarioDTO.setDataNasc(usuario.getDataNasc());
        usuarioDTO.setPhone(usuario.getPhone());
        return usuarioDTO;
    }
}
