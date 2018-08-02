package introducaoAoJava;

public class Humano {

	protected int altura;
	protected String nome;
	protected String tipoDeSangue;

	public Humano() {
		this.altura = 30;
		this.respirar();
	}

	
	public void ficaAdmirada() {
		System.out.println("Uau!");
		
	}
	
	private void respirar() {
		System.out.println("respirei");

	}

	public int getAltura() {
		return altura;
	}

	/**
	 * Atribui uma altura à pessoa em centimetros
	 * 
	 * @author André
	 * @param altura
	 */
	public boolean setAltura(int altura) {

		if (altura < 100)
			return false;

		if (altura > 300)
			return false;

		this.altura = altura;
		return true;
	}

	public String getTipoDeSangue() {
		return tipoDeSangue;
	}

	public boolean setTipoDeSangue(String tipoDeSangue) {

		if (tipoDeSangue.equals("A+") || tipoDeSangue.equals("A-") || tipoDeSangue.equals("B+")
				|| tipoDeSangue.equals("B-") || tipoDeSangue.equals("O+") || tipoDeSangue.equals("O-")
				|| tipoDeSangue.equals("AB+") || tipoDeSangue.equals("AB-")) {
			this.tipoDeSangue = tipoDeSangue;
			return true;
		}

		return false;

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void chorar() {
		System.out.println("Buááááá");
	}

	public Alimento produzirLeite() {
		Alimento leite = new Alimento(1000);

		return leite;
	}

	public void alimentarSe(Alimento a) {

		int centimetros = a.getCalorias() / 1000;

		if (this.altura < 180) {
			this.altura += centimetros;
		}
	}

	public void casouSe(Humano h) {
		System.out.println("Eu " + h.getNome() + " aceito");
		System.out.println("Eu " + this.getNome() + " aceito");
		
	}

	public void apaixonouSe(Humano h) {
		System.out.println("Eu " + h.getNome() + " te amo");
		System.out.println("Eu " + this.getNome() + " te amo");
	}
	
	
	public Gameta produzirGameta() {
		Gameta g = new Gameta();
		g.setRna("agtuatgct");
		return g;
	}
	
	public Humano receberGameta(Gameta g) {
		if(g != null) {
			return new Humano();
		}
		return null;
	}
	
	
	
	
	
	
	
	
}
