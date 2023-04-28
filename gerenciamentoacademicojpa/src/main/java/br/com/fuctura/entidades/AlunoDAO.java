package br.com.fuctura.entidades;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fuctura.config.Emteste;

public class AlunoDAO {
	private EntityManager em;

	public AlunoDAO(Emteste em) {

		this.em = em.getEm();
	}

	public void inserirAluno(Aluno a) {
		em.getTransaction().begin();
		em.persist(a);
		em.getTransaction().commit();
	}

	public void inserirEndereco(Endereco end) {
		em.getTransaction().begin();
		em.persist(end);
		em.getTransaction().commit();
	}

	public void deletarAluno(String cpf) {
		TypedQuery<Aluno> resultadoex = em.createNamedQuery("Aluno.findByCpf", Aluno.class);
		resultadoex.setParameter("cpf", cpf);
		List<Aluno> alunosCpf = resultadoex.getResultList();

		for (Aluno aluno : alunosCpf) {
			em.getTransaction().begin();
			em.remove(aluno);
			em.getTransaction().commit();
		}
	}

	public void deletarTodosAlunos() {
		TypedQuery<Aluno> resultado = em.createNamedQuery("Aluno.findAll", Aluno.class);
		List<Aluno> alunos = resultado.getResultList();
		for (Aluno aluno : alunos) {
			em.getTransaction().begin();
			em.remove(aluno);
			em.getTransaction().commit();
		}

	}

	public void updateEmail(String cpf, String emailNovo) {

		TypedQuery<Aluno> resultadoUpdate = em.createNamedQuery("Aluno.findByCpf", Aluno.class);
		resultadoUpdate.setParameter("cpf", cpf);
		List<Aluno> alunos = resultadoUpdate.getResultList();
		for (Aluno aluno : alunos) {
			aluno.setEmail(emailNovo);
			em.getTransaction().begin();
			em.persist(aluno);
			em.getTransaction().commit();
		}

	}

	public void updateCelular(String cpf, String celularNovo) {

		TypedQuery<Aluno> resultadoUpdate = em.createNamedQuery("Aluno.findByCpf", Aluno.class);
		resultadoUpdate.setParameter("cpf", cpf);
		List<Aluno> alunos = resultadoUpdate.getResultList();
		for (Aluno aluno : alunos) {
			aluno.setCelular(celularNovo);
			em.getTransaction().begin();
			em.persist(aluno);
			em.getTransaction().commit();
		}

	}

	public void updateInstagram(String cpf, String instagramNovo) {
		TypedQuery<Aluno> resultadoUpdate = em.createNamedQuery("Aluno.findByCpf", Aluno.class);
		resultadoUpdate.setParameter("cpf", cpf);
		List<Aluno> alunos = resultadoUpdate.getResultList();
		for (Aluno aluno : alunos) {
			aluno.setInstagram(instagramNovo);
			em.getTransaction().begin();
			em.persist(aluno);
			em.getTransaction().commit();
		}
	}

	public void updateTelefone(String cpf, String telefoneNovo) {
		TypedQuery<Aluno> resultadoUpdate = em.createNamedQuery("Aluno.findByCpf", Aluno.class);
		resultadoUpdate.setParameter("cpf", cpf);
		List<Aluno> alunos = resultadoUpdate.getResultList();

		for (Aluno aluno : alunos) {
			aluno.setTelefone(telefoneNovo);
			em.getTransaction().begin();
			em.persist(aluno);
			em.getTransaction().commit();

		}

	}
	public void updatePagamento(String cpf,String novoPagamento) {
		TypedQuery<Aluno> resultadoUpdate = em.createNamedQuery("Aluno.findByCpf",Aluno.class);
		resultadoUpdate.setParameter("cpf", cpf);
		List<Aluno> alunos = resultadoUpdate.getResultList();
		for (Aluno aluno : alunos) {
			aluno.setPagamento(novoPagamento);
		}
	}

	public List<Aluno> consultarAlunos() {
		TypedQuery<Aluno> resultado = em.createNamedQuery("Aluno.findAll", Aluno.class);
		List<Aluno> alunos = resultado.getResultList();
		return alunos;
	}

	public List<Aluno> consultarCPF(String cpf) {
		TypedQuery<Aluno> resultado2 = em.createNamedQuery("Aluno.findByCpf", Aluno.class);
		resultado2.setParameter("cpf", cpf);
		List<Aluno> alunosCpf = resultado2.getResultList();
		return alunosCpf;
	}

}
