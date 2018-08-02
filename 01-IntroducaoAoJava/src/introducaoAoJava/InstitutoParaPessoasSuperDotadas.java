package introducaoAoJava;

import java.util.ArrayList;

public class InstitutoParaPessoasSuperDotadas {

	private ArrayList<XHumano> listaDeAlunos;
	
	public InstitutoParaPessoasSuperDotadas() {
		this.listaDeAlunos = new ArrayList<XHumano>();
	}
	
	public void adicionarAluno(XHumano a) {
		this.listaDeAlunos.add(a);
	}
}
