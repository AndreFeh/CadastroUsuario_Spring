package com.dio.cadastrousuarios;

import com.dio.cadastrousuarios.entity.Usuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
class CadastroUsuariosApplicationTests {

	@Test
	void contextLoads() {
	}

	//Validar idade
	@Test
	void validarCalcIdade() {
		Usuario usuario = new Usuario("André", LocalDate.of(2001, 7, 14));
		Assertions.assertEquals(21, usuario.getIdade());  //Espero que seja 21 o resultado de usuario, e pega o resultado Idade
	}
}
