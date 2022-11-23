package com.dio.cadastrousuarios.entity;

import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

@Entity
public class Usuario {
    @Id
    UUID id;
    String nome;
    @CPF
    @CNPJ
    Long identificador;
    String email;
    LocalDate dataNasc;
    Long phone;

    public Usuario() {
    }

    public Usuario(String nome, LocalDate dataNasc)/*Valida Idade*/ {
        this.nome = nome;
        this.dataNasc = dataNasc;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getIdentificador() {
        return identificador;
    }

    public void setIdentificador(Long identificador) {
        this.identificador = identificador;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public int getIdade(){
        return (int) ChronoUnit.YEARS.between(this.dataNasc, LocalDate.now());
    }
}
