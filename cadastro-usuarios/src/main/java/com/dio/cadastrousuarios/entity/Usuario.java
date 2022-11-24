package com.dio.cadastrousuarios.entity;

import com.dio.cadastrousuarios.dto.UsuarioDTO;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "tbl_user")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_user")
    private UUID id;
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;
    @CPF
    @CNPJ
    @Column(name = "cpf_cnpj", length = 25, nullable = false)
    private Long identificador;
    @Column(name = "email", length = 50, nullable = false)
    private String email;
    @Column(name = "data_nasc", length = 20, nullable = false)
    private LocalDate dataNasc;
    @Column(name = "telefone", length = 10, nullable = false)
    private Long phone;

    public Usuario(String nome, LocalDate dataNasc)/*Valida Idade*/ {
        this.nome = nome;
        this.dataNasc = dataNasc;
    }

    public int getIdade() {
        return (int) ChronoUnit.YEARS.between(this.dataNasc, LocalDate.now());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Usuario usuario = (Usuario) o;
        return id != null && Objects.equals(id, usuario.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    public static Usuario convert(UsuarioDTO usuarioDTO) throws Exception {
        Usuario usuario = new Usuario();
        usuario.setId(usuarioDTO.getId());
        usuario.setNome(usuarioDTO.getNome());
        usuario.setIdentificador(usuarioDTO.getIdentificador());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setDataNasc(usuarioDTO.getDataNasc());
        usuario.setPhone(usuarioDTO.getPhone());
        return usuario;

    }
}
