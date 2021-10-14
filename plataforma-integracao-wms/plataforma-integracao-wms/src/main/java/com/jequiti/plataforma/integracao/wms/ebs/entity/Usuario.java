package com.jequiti.plataforma.integracao.wms.ebs.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "APPL_USUARIO", uniqueConstraints = @UniqueConstraint(columnNames = "FANTASIA"))

public class Usuario {
	
	@Id
	@Column(name="ID_USUARIO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "APPL_USER_SEQ")
	private Long idUsuario;
	
	@Column(name="NOME", nullable=false, length=250)
	private String nome;
	
	@Column(name="FANTASIA", nullable=false, length=40)
	private String fantasia;
	
	@Column(name="SITUACAO", nullable=false)
	private String situacao;
	
	@Column(name="SENHA", nullable=false)
	private String senha;
	
	@Column(name="EMAIL")
	private String enderecoEmail;
	
	@Column(name="DATA_CRIACAO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCriacao;
	
	@Column(name="DATA_ATUALIZACAO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataAtualizacao;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(
			name = "APPL_USUARIO_POR_PERFIL",
			joinColumns = {@JoinColumn(name = "USER_ID")},
			inverseJoinColumns = {@JoinColumn(name = "USER_PERFIL_ID")})
	private Perfil perfil;
	
	public Usuario() {}
	
	public Usuario(String nome,  String fantasia, String enderecoEmail, String senha, String situacao,
				   Date dataCriacao, Date dataAtualizacao){
				
		this.nome = nome;
		this.fantasia = fantasia;
		this.senha = senha;
		this.enderecoEmail = enderecoEmail;
		this.situacao = situacao;
		this.dataCriacao = dataCriacao;
		this.dataAtualizacao = dataAtualizacao;
	}
	
	public Usuario(String nome,  String fantasia, String enderecoEmail, String senha, String situacao,
			   Date dataCriacao, Date dataAtualizacao, Perfil perfil){
			
	this.nome = nome;
	this.fantasia = fantasia;
	this.senha = senha;
	this.enderecoEmail = enderecoEmail;
	this.situacao = situacao;
	this.dataCriacao = dataCriacao;
	this.dataAtualizacao = dataAtualizacao;
	this.perfil = perfil;
}


	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFantasia() {
		return fantasia;
	}

	public void setFantasia(String fantasia) {
		this.fantasia = fantasia;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEnderecoEmail() {
		return enderecoEmail;
	}

	public void setEnderecoEmail(String enderecoEmail) {
		this.enderecoEmail = enderecoEmail;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime *  result + idUsuario);
		result = prime * result + ((fantasia == null) ? 0: fantasia.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (fantasia == null){
			if (other.fantasia != null)
				return false;
		}else if (!fantasia.equals(other.fantasia))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		String ret = "";
		
		if(this.fantasia != null){
			ret += "Login: " + this.fantasia + "\n";
		}
		if(this.enderecoEmail != null){
			ret += "Email: " + this.enderecoEmail + "\n";
		}
		if(this.nome != null){
			ret += "Nome: " + this.nome + "\n";
		}
		
		return ret;
	}

}
