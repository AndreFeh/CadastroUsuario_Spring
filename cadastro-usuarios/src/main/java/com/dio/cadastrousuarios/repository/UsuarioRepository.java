package com.dio.cadastrousuarios.repository;

import com.dio.cadastrousuarios.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {
    Optional<Usuario> findByIdentificador(Long identificador);
//    @Query("SELECT usuario FROM tbl_user WHERE tbl_user.id_user =:id")
//    Optional<Usuario> findById(@Param("id") UUID id);
}
