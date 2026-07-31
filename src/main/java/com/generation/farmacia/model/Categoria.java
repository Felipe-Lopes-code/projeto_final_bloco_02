package com.generation.farmacia.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_categorias")
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O atributo nome é obrigatório!")
	@Size(min = 5, max = 100, message = "O atributo nome deve ter no mínimo 5 e no máximo 100 caracteres!")
	@Column(length = 100)
	private String nome;
	
	@NotBlank(message = "O atributo descricao é obrigatório!")
	@Size(min = 5, max = 255, message = "O atributo descricao deve ter no mínimo 5 e no máximo 255 caracteres!")
	@Column(length = 255)
	private String descricao;
	
	@NotNull(message = "O atributo ativa é obrigatório!")
	private Boolean ativa;
	
	@NotNull(message = "O atributo exigePrescricaoMedica é obrigatório!")
	private Boolean exigePrescricaoMedica;

	/*
	@OneToMany
	@JsonIgnoreProperties("categoria")
	private Produto produto;
	*/			
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Boolean getAtiva() {
		return ativa;
	}

	public void setAtiva(Boolean ativa) {
		this.ativa = ativa;
	}

	public Boolean getExigePrescricaoMedica() {
		return exigePrescricaoMedica;
	}

	public void setExigePrescricaoMedica(Boolean exigePrescricaoMedica) {
		this.exigePrescricaoMedica = exigePrescricaoMedica;
	}

	/*
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	*/
	
}
