package introducaoAoJava;

public class Principal {

	public static void main(String[] args) {
		Humano radija = new Humano();
		radija.setNome("Radija");

		Humano apiu = new Humano();
		apiu.setNome("Apiu");
		apiu.chorar();

		for (int qtde = 0; qtde < 10000; qtde++) {
			apiu.alimentarSe(radija.produzirLeite());
		}

		Humano roxele = new Humano();
		roxele.setNome("Roxele");

		apiu.casouSe(roxele);

		Humano uepeka = new Humano();
		uepeka.setNome("Uepeka");

		apiu.apaixonouSe(uepeka);

		// 21 anos depois... Apiu is dead!!!!

		Humano tonia = roxele.receberGameta(uepeka.produzirGameta());

		XHumano toniarine = (XHumano) tonia;
		toniarine.setSuperPoder("Super testa");

	}

}
