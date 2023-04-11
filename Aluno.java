package br.com.fuctura.entidades;

public class Aluno {
protected String nomeAluno;
private int matricula;
private double media;
public String getNomeAluno() {
	return nomeAluno;
}
public void setNomeAluno(String nomeAluno) {
	this.nomeAluno = nomeAluno;
}
public int getMatricula() {
	return matricula;
}
public void setMatricula(int matricula) {
	this.matricula = matricula;
}
public double getMedia() {
	return media;
}
public void setMedia(double media) {
	this.media = media;
}

}
