package com.projeto.demoprojeto.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Promocoes")
public class Promocoes implements Serializable{
	private static final long serialVersionUID = 4385055542014926011L;

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false, name ="title" )
	private String title;
	
	@Column(nullable = false, name ="link_promocao")
	private String link_promocao;
	
	@Column(nullable = false, name ="site_promocao" )
	private String site;
	
	@Column(name ="descricao")
	private String descricao;
	
	@Column(nullable = false, name ="preco_promocao" )
	private BigDecimal preco_promocao;
	
	@Column(nullable = false, name ="dCadastro")
	@DateTimeFormat
	private LocalDateTime data_cadastro;

	@ManyToOne
	@JoinColumn(name="categoria_fk")
	private Categoria categoria;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink_promocao() {
		return link_promocao;
	}

	public void setLink_promocao(String link_promocao) {
		this.link_promocao = link_promocao;
	}

	public String getSite_promocao() {
		return site;
	}

	public void setSite_promocao(String site_promocao) {
		this.site = site_promocao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getPreco_promocao() {
		return preco_promocao;
	}

	public void setPreco_promocao(BigDecimal preco_promocao) {
		this.preco_promocao = preco_promocao;
	}

	public LocalDateTime getData_cadastro() {
		return data_cadastro;
	}

	public void setData_cadastro(LocalDateTime data_cadastro) {
		this.data_cadastro = data_cadastro;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Promocoes [id=" + id + ", title=" + title + ", link_promocao=" + link_promocao + ", site_promocao="
				+ site + ", descricao=" + descricao + ", preco_promocao=" + preco_promocao + ", data_cadastro="
				+ data_cadastro + ", categoria=" + categoria + "]";
	}
	
	
	
}
