package com.projeto.demoprojeto.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Categoria")
public class Categoria {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(nullable=false, name="titulo")
	private String titulo;
	
	@OneToMany(mappedBy = "Promocoes")
	private List<Promocoes> promocoes;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<Promocoes> getPromocoes() {
		return promocoes;
	}

	public void setPromocoes(List<Promocoes> promocoes) {
		this.promocoes = promocoes;
	}

	@Override
	public String toString() {
		return "Categoria [id=" + id + ", titulo=" + titulo + ", promocoes=" + promocoes + "]";
	}
	
	
	
}
