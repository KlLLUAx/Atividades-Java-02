package br.com.fuctura.entidades;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import br.com.fuctura.config.Emteste;

@Entity
@NamedQueries({ 
	@NamedQuery(name = "Aluno.findAll", query = "select a from Aluno a"),
	@NamedQuery(name = "Aluno.findByCpf",query = "select a from Aluno a where cpf like :cpf")
})
public class Aluno {
	
	
	
	private String nome;
	private String genero;
	@Column(nullable = false)
	private int idade;
	private String email;
	@Column(nullable = false)
	private String rg;
	@Id
	@Column(nullable = false)
	private String cpf;
	private String orgaoEmissor;
	private String uf;
	@Temporal(TemporalType.DATE)
	private Calendar dataDeEmissao;
	private String celular;
	private String telefone;
	private String instagram;
	private String pagamento;
	
	public String getPagamento() {
		return pagamento;
	}

	public void setPagamento(String pagamento) {
		this.pagamento = pagamento;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getInstagram() {
		return instagram;
	}

	public void setInstagram(String instagram) {
		this.instagram = instagram;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getOrgaoEmissor() {
		return orgaoEmissor;
	}

	public void setOrgaoEmissor(String orgaoEmissor) {
		this.orgaoEmissor = orgaoEmissor;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public Calendar getDataDeEmissao() {
		return dataDeEmissao;
	}

	public void setDataDeEmissao(Calendar dataDeEmissao) {
		this.dataDeEmissao = dataDeEmissao;
	}

}
