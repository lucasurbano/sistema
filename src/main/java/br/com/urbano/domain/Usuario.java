package br.com.urbano.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

//@Table(name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// @Column(name = "codigo", unique = true)
	private Integer codigo;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false, unique = true)
	private String email;
	
	@Column
	private String telefone;

	@Column(nullable = false)
	private String senha;

}
