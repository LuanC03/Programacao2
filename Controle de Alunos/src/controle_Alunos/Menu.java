package controle_Alunos;

import java.util.Scanner;

public class Menu {

	private static final String N = System.lineSeparator();
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		ControleAlunos sistema = new ControleAlunos();
		boolean pararPrograma = false;
		while (!pararPrograma) {
			
			System.out.println("(C)adastrar Aluno");
			System.out.println("(E)xibir Aluno");
			System.out.println("(N)ovo Grupo");
			System.out.println("(A)locar Aluno no Grupo e Imprimir Grupos");
			System.out.println("(R)egistrar Resposta de Aluno");
			System.out.println("(I)mprimir Alunos que Responderam");
			System.out.println("(O)ra, vamos fechar o programa!!" + N);
			System.out.printf("Opcao> ");
			String opcao = sc.nextLine();
			
			switch (opcao) {
			
			case "C":
				System.out.printf("Matricula: ");
				String matricula = sc.nextLine();
				System.out.printf("Nome: ");
				String nome = sc.nextLine();
				System.out.printf("Curso: ");
				String curso = sc.nextLine();
				
				try {
					sistema.cadastraAluno(matricula, nome, curso);
				} catch (Exception e) {					
					e.printStackTrace();
				}
				
				
				break;

			case "E":
				System.out.printf("Matricula: ");
				String matriculaPesquisada = sc.nextLine();
				
				Aluno aluno = sistema.buscaAluno(matriculaPesquisada);
				
				if(aluno == null)
					System.out.println("Aluno nao cadastrado."+N);
				else
					System.out.println(aluno.toString()+N);
				break;
			case "N":
				System.out.println("Grupo: ");
				String nomeDoGrupo = sc.nextLine();
				sistema.criaGrupo(nomeDoGrupo);
				break;
			case "A":
				System.out.printf("(A)locar Aluno ou (I)mprimir Grupo?");
				String op = sc.nextLine();
				if(op.equalsIgnoreCase("A")) {
					System.out.printf("Matricula: ");
					String matriculaAluno = sc.nextLine();
					System.out.printf("Grupo: ");
					String grupo = sc.nextLine();				
					sistema.alocarAluno(matriculaAluno, grupo);}
				else if(op.equalsIgnoreCase("I")) {
					System.out.printf("Grupo: ");
					String nomeGrupo = sc.nextLine();
					System.out.println(N);
					sistema.imprimirGrupo(nomeGrupo);
				}
				break;
			case "R":
				System.out.printf("Matricula: ");
				String matriculaDoAlunoQueRespondeu = sc.nextLine();
				
				sistema.cadastrarResposta(matriculaDoAlunoQueRespondeu);
				
				break;
			case "I":
				
				sistema.imprimeAlunosQueResponderamQuestoes();
				
				break;
			case "O":
				System.out.println("Finalizou o Programa!!!");
				pararPrograma = true;
				break;

			default:
				System.out.println("Opcao Invalida!!!"+N);
				break;
			}
		}
	}
}