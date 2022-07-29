package test;

import java.util.Random;

import model.Body;
import model.Play;

public class Test {

	public static void main(String[] args) {

		Play play = new Play();
		Random r = new Random();
		Body body;
		
		play.addYears(150);
		play.addSizeScreen(100);
		
		for (int i = 0; i < 2; i++) {
			body = play.createBodyMen(i);
			play.addBody(body);
		}
		for (int i = 0; i < 2; i++) {
			body = play.createBodyWomen(i);
			play.addBody(body);
		}
		
		System.out.println("años" + play.getQuantityYears());

		play.show();

		System.out.println();
		System.out.println("poblacion INICIAL: " + play.getSize());
		System.out.println("cantidad de pendejos: " + play.quantityMan());
		System.out.println("cantidad de pendejas: " + play.quantityWoman());

		System.out.println();
		System.out.println("MUERTE");
		
		for (int i = 0; i < play.getSize() - 1; i++) {
			for (int j = 0; j < play.getSize(); j++) {
				if (j != i) {
					play.killBodie(play.getBodiesList().get(i), play.getBodiesList().get(j));
				}
			}
		}
		
		
		System.out.println("poblacion : " + play.getSize());
		System.out.println("cantidad de pendejos: " + play.quantityMan());
		System.out.println("cantidad de pendejas: " + play.quantityWoman());

		System.out.println();
//		play.show();
		
		System.out.println("niñez "+ play.clasifyTypeChildren());
		System.out.println("Adolecentes: " + play.clasifyTypeTeenage());
		System.out.println("Joven: " + play.clasifyTypeYoung());
		System.out.println("Adulto: " + play.clasifyTypeAdult());
		System.out.println("Anciano: " + play.clasifyTypeSeniors());
		System.out.println();

		System.out.println();
		System.out.println("NACIMIENTOS");
		for (int i = 0; i < play.getSize(); i++) {
			play.bornBodie(play.getBodiesList().get(i), play.getBodiesList().get(r.nextInt(play.getSize())), i);
		}
		System.out.println("poblacion : " + play.getSize());
		System.out.println("cantidad de pendejos: " + play.quantityMan());
		System.out.println("cantidad de pendejas: " + play.quantityWoman());

		System.out.println();
		play.show();
		
		play.aumentandoedad();
		System.out.println("aqui hay algo nuevoooo");
		
		System.out.println();
		System.out.println("MUERTE");
		
		play.doKill();

		System.out.println("PASADOS LOS " + play.getQuantityDay() + " DIAS LOS RESULTADOS SON LOS SIGUIENTES: ");
		System.out.println("NUMERO DE NACIMIENTOS " + play.quantityBorn());
		System.out.println("NUMERO DE MUERTES " + play.quantityKillWomen());
		System.out.println("POBLACION " + play.getSize());
		play.doKill();
		play.show();
		System.out.println();
		System.out.println("hay mas");
		play.doKill();
		play.show();
	}
}
