package br.com.fuctura;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

import DAO.AlunoDAO;
import DAO.IAlunoDAO;
import br.com.fuctura.config.Conexao;
import br.com.fuctura.config.Emteste;
import br.com.fuctura.entidades.Aluno;
import br.com.fuctura.entidades.Endereco;

public class Aplicacao {

	public static void main(String[] args) {
		
		Aluno a;
		Endereco end;
		

		Conexao conn = new Conexao("FUCTURA-PU");
		Emteste em = new Emteste(conn);
		IAlunoDAO dao = new AlunoDAO(em);
		
		menuPrincipal(a = new Aluno(),end = new Endereco(),dao);
			
		
		
	}

	public static boolean validaEstado(String uf) { // CODIGO QUE VALIDA O ESTADO
		String estadosValidos[] = { "PE", "DF", "AM", "PB", "PI", "RJ", "SP", "MG", "MS", "MT", "RS", "PR", "AC", "MA",
				"GO", "ES", "BA", "CE", "SC", "RN", "PA", "AL", "RR", "SER", "TO", "AP" };
		boolean valida = false;
		for(int i = 0; i<estadosValidos.length  ;i++) {
		
			if(uf.equalsIgnoreCase(estadosValidos[i])) {
				valida = true;
				i = estadosValidos.length;
			}
			}
			
			
		return valida;	
		}
		
			
	

		

	
	public static void menuPrincipal(Aluno a, Endereco end, IAlunoDAO dao) {
		Scanner s = new Scanner(System.in);
		Scanner n = new Scanner(System.in);
		int opc = 0;
		do {
			System.out.println("Gerenciador Academico");
			System.out.println("1 - Cadastrar aluno");
			System.out.println("2 - Consultar aluno");
			System.out.println("3 - Excluir Aluno");
			System.out.println("4 - Atualizar Cadastro");
			System.out.println(" 5- sair ");
			System.out.println("Digite a opção desejada: ");
			opc = n.nextInt();
			switch (opc) {
			case 1:
				a = new Aluno();
				end = new Endereco();
				menuCadastro(a, end, dao);
				break;

			case 2:
				menuConsulta(dao);
				break;
			case 3:

				menuExclusao(dao);

				break;
			case 4:
				menuUpdate(dao);
				break;
			case 5:
				System.out.println("Operação Encerrada!");
				break;
				default: 
					System.err.println("Opção Invalida!");
					break;
			}

		} while (opc != 5);
		s.close();
		n.close();
	}

	public static void menuCadastro(Aluno a, Endereco end, IAlunoDAO dao) {// MENU DE CADASTRO DO ALUNO
		
		Scanner s = new Scanner(System.in);
		Scanner n = new Scanner(System.in);
		int opc = 0;
		String email;
		String cpf = null;
		String rg = null;
		String uf = null;

		
		System.out.println("INFORMÇÕES DO ALUNO");
		System.out.println();
		System.out.println("Digite o nome do aluno: ");
		a.setNome(s.nextLine());
		System.out.println("Digite a idade do aluno: ");
		a.setIdade(n.nextInt());
		System.out.println("Selecione o genero do aluno:");
		System.out.println("1 - Masculino");
		System.out.println("2 - Feminino");
		opc = s.nextInt();
		if (opc == 1) {
			a.setGenero("Masculino");
		} else {
			a.setGenero("Feminino");
		}
		System.out.println("FORMA DE PAGAMENTO");
		System.out.println("1 - Boleto(Enviar via email)");
		System.out.println("2 - Cartão de Credito");
		System.out.println("3 - Debito automatico");
		System.out.println("Escolha a opção de pagamento: ");
		opc =n.nextInt();
		switch(opc) {
		case 1: 
			a.setPagamento("Boleto");
			break;
		case 2:
			a.setPagamento("Cartão de Credito");
			break;
		case 3:
			a.setPagamento("Debito Automatico");
			break;
		}
		do {
			System.out.println("Digite o Email do aluno: ");
			email = s.next();
			a.setEmail(email);
		} while (email.contains("@") == false);
		do {
			System.out.println("Digite o CPF do aluno:");
			cpf = n.next();
			a.setCpf(cpf);
		} while (cpf.length() < 11);
		do {
			System.out.println("Digite o RG do aluno: ");
			rg = n.next();
			a.setRg(rg);

		} while (rg.length() < 9);

		System.out.println("Digite o orgão emissor: ");
		a.setOrgaoEmissor(s.next());
		do {
			System.out.println("Digite a UF: ");
			uf = s.next();
			a.setUf(uf);
		} while (validaEstado(uf) == false);

		String celular = null;

		do {
			System.out.println("Digite o numero de celular do aluno: ");
			celular = n.next();
			a.setCelular(celular);
		} while (celular.length() < 11);
		String telefone = null;

		do {
			System.out.println("Digite o numero de telefone do aluno: ");
			telefone = n.next();
			a.setTelefone(telefone);
		} while (telefone.length() < 8);
		String instagram = null;

		do {
			System.out.println("Digite o instagram do aluno: ");
			instagram = s.next();
			a.setInstagram(instagram);
		} while (instagram.contains("@") == false);
		
		System.out.println("Digite a data de emissão: (dia/mes/ano)");
		System.out.println("Dia:");
		int dia = n.nextInt();
		System.out.println("Mes: ");
		int mes = n.nextInt();
		System.out.println("Ano: ");
		int ano = n.nextInt();
		a.setDataDeEmissao(new GregorianCalendar(ano, mes, dia));
		s.nextLine();

		System.out.println("Digite o endereço do aluno: ");
		end.setEndereco(s.nextLine());
		System.out.println("Digite o bairro do aluno: ");
		end.setBairro(s.nextLine());
		System.out.println("Digite o CEP do aluno: ");
		end.setCep(s.next());
		System.out.println("Digite a cidade do aluno: ");
		end.setCidade(s.next());
		do {
			System.out.println("Digite a UF do aluno: ");
			uf = s.next();
			end.setUf(uf);
		} while (validaEstado(uf) == false);
		dao.inserirAluno(a);
		dao.inserirEndereco(end);
	}

	public static void menuConsulta(IAlunoDAO dao) {  // MENU DE CONSULTA 
		Scanner s = new Scanner(System.in);
		Scanner n = new Scanner(System.in);
		int opc = 0;
		String cpf;
		System.out.println("Consultar Alunos");
		System.out.println("1 - consultar todos os alunos");
		System.out.println("2 - consultar aluno por CPF");
		System.out.println("Digite a opção desejada:");
		opc = s.nextInt();

		switch (opc) {
		case 1:											// CONSULTA TODOS OS ALUNOS 
			List<Aluno> alunos1 = dao.consultarAlunos();
			for (Aluno aluno : alunos1) {
				
				System.out.println("INFORMAÇÕES DO ALUNO:");
				System.out.println("Nome: " + aluno.getNome());
				System.out.println("Idade: " + aluno.getIdade());
				System.out.println("Informações de Identitade:");
				System.out.println("CPF: " + aluno.getCpf());
				System.out.println("RG:" + aluno.getRg());
				System.out.println("Orgão Emissor: " + aluno.getOrgaoEmissor());
				System.out.println("UF: " + aluno.getUf());
				
				manipulaDatas(aluno);
				System.out.println("INFORMAÇÕES DE CONTATO: ");
				System.out.println("Email: " + aluno.getEmail());
				System.out.println("Celular/whatsapp: "+aluno.getCelular());
				System.out.println("Telefone: "+aluno.getTelefone());
				System.out.println("Rede Social: "+aluno.getInstagram());
				System.out.println("INFORMAÇÕES DE PAGAMENTO");
				System.out.println(aluno.getPagamento());

				
				
				
			}
			break;
		case 2:										// CONSULTA ALUNO POR CPF
			System.out.println("Consultar Alunos por CPF");
			System.out.println("Digite o CPF do Aluno desejado: ");
			cpf = s.next();  
			List<Aluno> alunos = dao.consultarCPF(cpf);
			for (Aluno aluno : alunos) {
				System.out.println("INFORMAÇÕES DO ALUNO:");
				System.out.println("Nome: " + aluno.getNome());
				System.out.println("Idade: " + aluno.getIdade());
				System.out.println("Informações de Identitade:");
				System.out.println("CPF: " + aluno.getCpf());
				System.out.println("RG:" + aluno.getRg());
				System.out.println("Orgão Emissor: " + aluno.getOrgaoEmissor());
				System.out.println("UF: " + aluno.getUf());
				manipulaDatas(aluno);
				System.out.println("INFORMAÇÕES DE CONTATO: ");
				System.out.println("Email: " + aluno.getEmail());
				System.out.println("Celular/whatsapp: "+aluno.getCelular());
				System.out.println("Telefone: "+aluno.getTelefone());
				System.out.println("Rede Social: "+aluno.getInstagram());
				System.out.println("INFORMAÇÕES DE PAGAMENTO");
				System.out.println(aluno.getPagamento());

			}

			break;
		default:
			System.err.println("Digite uma opção valida!");
			break;
		}

	}

	public static void menuExclusao(IAlunoDAO dao) {				//MENU DE EXCLUSAO
		Scanner s = new Scanner(System.in);
		Scanner n = new Scanner(System.in);
		int opc = 0;
		String cpf;
		System.out.println("Menu de Exclusão");
		System.out.println("1 - Deletar aluno por cpf");
		System.out.println("2 - deletar todos os alunos");
		System.out.println("Digite a opção desejada:");
		opc = s.nextInt();
		switch (opc) {
		case 1:																// EXCLUI ALUNO POR CPF
			System.out.println("Digite o cpf do aluno a ser excluido: ");
			cpf = s.next();
			dao.deletarAluno(cpf);
			System.out.println("Aluno deletado com sucesso!");
			break;
		case 2:												//EXCLUI TODOS OS ALUNOS
			System.out.println("Você está prestes a excluir todos os alunos. tem certeza que deseja contnuar?");
			System.out.println("1 - sim");
			System.out.println("2 - não");
			opc = s.nextInt();
			if (opc == 1)
				dao.deletarTodosAlunos();
			break;
		}
	}

	public static void menuUpdate(IAlunoDAO dao) {			//MENU DE UPDATE
		Scanner s = new Scanner(System.in);
		Scanner n = new Scanner(System.in);
		int opc = 0;
		String cpf;
		System.out.println("Menu Atualização");
		System.out.println("1 - Atualizar email");
		System.out.println("2 - Atualizar numero de celular do aluno");
		System.out.println("3 - Alualizar numero de telefone do aluno");
		System.out.println("4 - Atualizar Instagram do aluno");
		System.out.println("5 - Atualizar forma de pagamento");
		System.out.println("Digite a opção desejada: ");
		opc = s.nextInt();
		switch (opc) {
		case 1:										//UPDATE EMAIL
			System.out.println("Digite o CPF do aluno:");
			cpf = s.next();
			System.out.println("digite o novo email do aluno: ");
			String emailNovo = s.next();
			dao.updateEmail(cpf, emailNovo);
			break;
		case 2:									// UPDATE CELULAR
			System.out.println("Digite o Cpf do aluno:");
			cpf = s.next();
			System.out.println("Digite o novo numero de celular do aluno: ");
			String celularNovo = s.next();
			dao.updateCelular(cpf, celularNovo);
			break;

		case 3:											// UPDATE TELEFONE
			System.out.println("Digite o Cpf do aluno: ");						
			cpf = s.next();
			System.out.println("Digite o novo numero de telefone do aluno:");
			String telefoneNovo = s.next();

			dao.updateTelefone(cpf, telefoneNovo);
			break;
		case 4:										/// UPDATE INSTAGRAM
			System.out.println("Digite o Cpf do aluno: ");
			cpf = s.next();
			System.out.println("Digite o novo Instagram do aluno: ");
			String instagramNovo = s.next();
			dao.updateInstagram(cpf, instagramNovo);
			break;
		case 5:					///UPDATE FORMA DE PAGAMENTO
			String novoPagamento = null;
			System.out.println("Digite o Cpf do aluno: ");
			cpf =s.next();
			System.out.println("Informe o novo metodo de pagamento desejado: ");
			System.out.println("1 - Boleto(Enviado no email");
			System.out.println("2 - Cartão de Credito");
			System.out.println("3 - Debito Automático");
			 opc = s.nextInt();
			 
			switch(opc) {
			case 1: novoPagamento = "Boleto";
				break;
			case 2:novoPagamento = "Cartão de Credito";
				break;
			case 3: novoPagamento = "Debito Automático";
				break;
			default:
					System.err.println("Opção invalida!");
					break;
			}
			dao.updatePagamento(cpf, novoPagamento);
			break;
		}

	}
	public static void manipulaDatas(Aluno a) {
		Calendar c = a.getDataDeEmissao();
		
	int dia = c.get(Calendar.DAY_OF_MONTH);
		int mes = c.get(Calendar.MONTH);
		int ano = c.get(Calendar.YEAR);
		System.out.println( "Data de emissão: "+dia+"/" + mes+ "/"+ ano);
		
	}

}
