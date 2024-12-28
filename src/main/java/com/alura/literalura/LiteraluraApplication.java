package com.alura.literalura;

import com.alura.literalura.catalogos.CatalogoLibros;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
public class LiteraluraApplication {

	private final CatalogoLibros catalogo; // Inyección de dependencia

	@Autowired
	public LiteraluraApplication(CatalogoLibros catalogo) {
		this.catalogo = catalogo;
	}

	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

	@PostConstruct
	public void iniciarCatalogo() {
		catalogo.iniciar();
	}
}

