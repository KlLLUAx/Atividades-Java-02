package br.com.fuctura.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Endereco  {
@Id @GeneratedValue(strategy = GenerationType.AUTO)
private long cod;
private String endereco;
private String bairro;
private String cep;
private String cidade;
private String uf;
public long getCod() {
	return cod;
}

public String getEndereco() {
	return endereco;
}
public void setEndereco(String endereco) {
	this.endereco = endereco;
}
public String getBairro() {
	return bairro;
}
public void setBairro(String bairro) {
	this.bairro = bairro;
}
public String getCep() {
	return cep;
}
public void setCep(String cep) {
	this.cep = cep;
}
public String getCidade() {
	return cidade;
}
public void setCidade(String cidade) {
	this.cidade = cidade;
}
public String getUf() {
	return uf;
}
public void setUf(String uf) {
	this.uf = uf;
}


}
