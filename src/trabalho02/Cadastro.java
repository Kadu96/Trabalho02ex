package trabalho02;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cadastro  {
 
	private Scanner ler = new Scanner(System.in);
	private List<Pessoa> pessoas;
    private List<Dependente> dependentes;
	private BufferedWriter gravar;
	private static final String nomeArquivo = "c:\\bd\\bd.txt"; 
	
	public Cadastro() {
		pessoas = new ArrayList<Pessoa>();
		boolean continua = true;
	    String sn;
	     
		do {

			Pessoa p = new Pessoa();
			System.out.println("********************************");
			System.out.println("Bem vindo...\n  Iniciando novo cadastro ");
			System.out.println("********************************");
			
			System.out.print("Informe nome: ");
			p.setNome(ler.next());
			
			System.out.print("Informe o sobrenome da pessoa: ");
			p.setSobreNome(ler.next());
			
			System.out.print("Informe o CPF: ");
			p.setCPF(ler.next());
			
			
			System.out.print("Esta pessoa possui denpendentes? (S/N): ");
			sn = ler.next();
			
            String Char;
			while (Character.toUpperCase(sn.charAt(0)) != 'S' && Character.toUpperCase(sn.charAt(0)) !=  'N'){			
            	System.out.print("Esta pessoa possui denpendentes? (S/N): ");
    			sn = ler.next();
    			
            }
           
			   
			while ((Character.toUpperCase(sn.charAt(0)) == 'S' )&& ( sn.length() == 1)) {
				dependentes = new ArrayList<Dependente>();
	                
				Dependente dep = new Dependente();
				
				System.out.print("Informe nome: ");
				dep.setNomeDependente(ler.next());
				System.out.print("Informe a idade: ");
				dep.setNomeDependente(ler.next());
				System.out.print("Relação de parentesco:");
				dep.setNomeDependente(ler.next());
				
				
				
				
				dependentes.add(dep);
				
				System.out.print("Esta pessoa possui outro dependente? (S/N): ");
				sn = ler.next();
			
			
	            while ( (sn.length() != 1 ) && (Character.toUpperCase(sn.charAt(0)) != 'S' )&& ( Character.toUpperCase(sn.charAt(0))) !=  'N' ){			
	            	System.out.print("Esta pessoa possui denpendentes? (S/N): ");
	    			sn = ler.next();
	    			
	            }
				
			
			}
			
			
			p.setDependentes(dependentes);
			
			pessoas.add(p);
			
			System.out.print("Deseja inserir outra pessoa? (S/N): ");
			sn = ler.next();
            while (Character.toUpperCase(sn.charAt(0)) != 'S' && Character.toUpperCase(sn.charAt(0)) !=  'N' && sn.length() != 0){			
            	System.out.print("Deseja inserir outra pessoa? (S/N): ");
    			sn = ler.next();
    			
            }
			
			
			if ( Character.toUpperCase(sn.charAt(0)) ==  'N' && sn.length() == 1) {
				continua = false;
				try {
					gravar = new BufferedWriter(new FileWriter(nomeArquivo));
					for (Pessoa pessoa : pessoas) {
						gravar.write("" + pessoa.genomedPessoa());
						gravar.write(" - ");
						gravar.write(pessoa.getSobrenome());
						gravar.write(" ");
						gravar.write(pessoa.getCPF());
						gravar.write("\n");
						
						for (Dependente dependente : dependentes) {
							gravar.write("\t");
							gravar.write("" + dependente.getIdDependente());
							gravar.write(" - ");
							gravar.write(dependente.getNomeDependente());
							gravar.write(" - ");
							gravar.write(dependente.getParentesco());
							gravar.write("\n");
						}
						
					}
					gravar.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		} while (continua);
		ler.close();
	}
	
//	private Object getDependente() {
//		// TODO Auto-generated method stub
//		return null;
//	}

	public static void main(String[] args) {
		new Cadastro();
	}
}
