package com.jequiti.plataforma.integracao.wms.ebs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="APPL_PERFIL_USUARIO")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Perfil implements GrantedAuthority {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4355283434302113388L;

	@Id
	@Column(name="ID_PERFIL")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "APPL_USER_PERFIL_SEQ")
	private Long id;
	
	@Column(name="TIPO", nullable=false)
	private String tipo;
	
	@Column(name="DESCRICAO")
	private String descricao;
	
	public Perfil() {}
	
	public Perfil(String tipo){
		this.tipo = tipo;
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
		
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime *  result + id);
		result = prime * result + ((tipo == null) ? 0: tipo.hashCode());
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
		Perfil other = (Perfil) obj;
		if (id == null){
			if (other.id != null)
				return false;
		}else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		String ret = "";
		
		if(this.id != null){
			ret += "ID: " + this.id + "\n";
		}
		if(this.tipo != null){
			ret += "Email: " + this.tipo + "\n";
		}
		
		return ret;
	}

	@Override
	public String getAuthority() {
		
		return getTipo();
	}
}
