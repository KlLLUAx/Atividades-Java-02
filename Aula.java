package br.com.fuctura.entidades;

public class Aula {
protected String diciplina;
protected String turno;
protected String professor;
protected String curso;
protected int numeroDeAlunos;
public String getDiciplina() {
	return diciplina;
}
public void setDiciplina(String diciplina) {
	this.diciplina = diciplina;
}
public String getTurno() {
	return turno;
}
public void setTurno(String turno) {
	this.turno = turno;
}
public String getProfessor() {
	return professor;
}
public void setProfessor(String professor) {
	this.professor = professor;
}
public String getCurso() {
	return curso;
}
public void setCurso(String curso) {
	this.curso = curso;
}
public int getNumeroDeAlunos() {
	return numeroDeAlunos;
}
public void setNumeroDeAlunos(int numeroDeAlunos) {
	this.numeroDeAlunos = numeroDeAlunos;
}

}
