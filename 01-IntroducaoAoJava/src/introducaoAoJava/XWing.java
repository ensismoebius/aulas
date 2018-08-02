package introducaoAoJava;

public class XWing implements EspecificacaoParaOXWing {

	@Override
	public void controlarAsa1() {
		System.out.println("Controlando a asa 1");
	}

	@Override
	public void controlarAsa2() {
		System.out.println("Controlando a asa 2");
	}

	@Override
	public void controlarAsa3() {
		System.out.println("Controlando a asa 3");
	}

	@Override
	public void controlarAsa4() {
		System.out.println("Controlando a asa 4");
	}

	@Override
	public void atribuirPiloto1(XHumano p1) {
		System.out.println("Entramo no bagulho eu tenho " + p1.getSuperPoder());
	}

	@Override
	public void atribuirPiloto2(XHumano p2) {
		System.out.println("Entramo no bagulho eu tenho " + p2.getSuperPoder());
	}

}
