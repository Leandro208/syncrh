package br.com.syncrh.dominio;

import java.time.OffsetDateTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "registro_entrada")
public class RegistroEntrada {

	@Id
	@Column(name = "id_registro_entrada")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "data_entrada")
	@Temporal(TemporalType.TIMESTAMP)
	private OffsetDateTime dataEntrada;
	
	@Column(name = "data_saida")
	@Temporal(TemporalType.TIMESTAMP)
	private OffsetDateTime dataSaida;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;
	
	private String ip;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public OffsetDateTime getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(OffsetDateTime dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public OffsetDateTime getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(OffsetDateTime dataSaida) {
		this.dataSaida = dataSaida;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RegistroEntrada other = (RegistroEntrada) obj;
		return Objects.equals(id, other.id);
	}
	
}
