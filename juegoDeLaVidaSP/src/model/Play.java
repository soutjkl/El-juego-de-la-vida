package model;
import java.util.ArrayList;
import java.util.Random;

public class Play {

	private ArrayList<Body> bodiesList;
	private Random random;
	private int screen;
	private int killWomen;
	private int killMen;
	private int born;
	private int bornw;
	private static int year = 365;
	private int days;
	
	public Play() {
		this.bodiesList = new ArrayList<Body>();
		random = new Random();
		this.screen = 0;
		killWomen = 0;
		killMen = 0;
		born = 0;
		days = 0;
	}
	
	public void aumentandoedad() {
		for (int i = 0; i < bodiesList.size(); i++) {
			for (int k = 0; k < getQuantityYears(); k++) {
				bodiesList.get(i).aumentandoEdad(k);
			}
			System.out.println(bodiesList.get(i).toString());
		}
	}


	public char booleanToChar(boolean string) {
		if (string == false) {
			return 'M';
		}
		return 'F';
	}
	
	public void addBody(Body newBody) {
			if (newBody.isGender() == true) {
				bodiesList.add(newBody);
			} else {
				bodiesList.add(newBody);
			}
	}

	public Body createBodyMen(int n) {
		return new Body(booleanToChar(false), random.nextInt(110), random.nextDouble(2), random.nextInt(screen), random.nextInt(screen), random.nextInt(n));
	}

	public Body createBodyWomen(int n) {
		return new Body(booleanToChar(true), random.nextInt(110), random.nextDouble(2), random.nextInt(screen), random.nextInt(screen), random.nextInt(n));
	}
	
	public Body createBody(int n) {
		return new Body(booleanToChar(random.nextBoolean()), 0, random.nextDouble(2), random.nextInt(screen), random.nextInt(screen), random.nextInt(n));
	}

	public void show() {
		for (int i = 0; i < bodiesList.size(); i++) {
			System.out.println(bodiesList.get(i).toString());
		}
	}

	public void deleteBody(Body bodyTwo) {
			bodiesList.remove(bodyTwo);
			if(bodyTwo != null && bodyTwo.isGender() == true) {
				killWomen++;
			} else {
				killMen++;
			}
	}
	
	public int clasifyTypeChildren() {
		int quantity = 0;
		for(int i = 0; i < bodiesList.size(); i++) {
			if (bodiesList.get(i).getTypeAge() == "Niñez") {
				quantity++;
			}
		}
		return quantity;
	}
	
	public int clasifyTypeTeenage() {
		int quantity = 0;
		for(int i = 0; i < bodiesList.size(); i++) {
			if (bodiesList.get(i).getTypeAge() == "Adolecente") {
				quantity++;
			}
		}
		return quantity;
	}
	
	public int clasifyTypeYoung() {
		int quantity = 0;
		for(int i = 0; i < bodiesList.size(); i++) {
			if (bodiesList.get(i).getTypeAge() == "Joven") {
				quantity++;
			}
		}
		return quantity;
	}
	public int clasifyTypeAdult() {
		int quantity = 0;
		for(int i = 0; i < bodiesList.size(); i++) {
			if (bodiesList.get(i).getTypeAge() == "Adulto") {
				quantity++;
			}
		}
		return quantity;
	}
	public int clasifyTypeSeniors() {
		int quantity = 0;
		for(int i = 0; i < bodiesList.size(); i++) {
			if (bodiesList.get(i).getTypeAge() == "Anciano") {
				quantity++;
			}
		}
		return quantity;
	}

	public void killBodie(Body bodyOne, Body bodyTwo) {
		if (bodyOne.getAge() > bodyTwo.getAge() && (bodyOne.isGender() == false && bodyTwo.isGender() == false) && (bodyOne.getX() == bodyTwo.getX() && bodyOne.getY() == bodyTwo.getY())) {
			deleteBody(bodyTwo);
		} else if (bodyOne.getAge() < bodyTwo.getAge() && (bodyOne.isGender() == false && bodyTwo.isGender() == false) && (bodyOne.getX() == bodyTwo.getX() && bodyOne.getY() == bodyTwo.getY())) {
			deleteBody(bodyOne);
		} else if (bodyOne.getAge() > bodyTwo.getAge() && (bodyOne.isGender() == true && bodyTwo.isGender() == true) && (bodyOne.getX() == bodyTwo.getX() && bodyOne.getY() == bodyTwo.getY())) {
			deleteBody(bodyTwo);
		} else if (bodyOne.getAge() < bodyTwo.getAge() && (bodyOne.isGender() == true && bodyTwo.isGender() == true) && (bodyOne.getX() == bodyTwo.getX() && bodyOne.getY() == bodyTwo.getY())) {
			deleteBody(bodyOne);
		} else if (bodyOne.getAge() == bodyTwo.getAge() && (bodyOne.isGender() == false && bodyTwo.isGender() == false) && (bodyOne.getX() == bodyTwo.getX() && bodyOne.getY() == bodyTwo.getY())) {
			randomDelete(bodyOne, bodyTwo);
		} else if ((bodyOne.getAge() == bodyTwo.getAge()) && (bodyOne.isGender() == true && bodyTwo.isGender() == true) && (bodyTwo.getX() == bodyOne.getX() && bodyOne.getY() == bodyTwo.getY())) {
			randomDelete(bodyOne, bodyTwo);
		} 

		if (bodyOne.getAge() > 110 && bodyOne.isGender() == true && bodyOne.isGender() == false ) {
			deleteBody(bodyOne);
		} 
		
		if (bodyTwo.getAge() > 110 && bodyTwo.isGender() == true && bodyTwo.isGender() == false) {
			deleteBody(bodyTwo);
		}
	}
	
	public void doKill() {
		for (int i = 0; i < bodiesList.size() - 1; i++) {
			for (int j = 0; j < bodiesList.size(); j++) {
				if (j != i) {
					killBodie(bodiesList.get(i), bodiesList.get(j));
				}
			}
		}
	}
	
	private void randomDelete(Body bodyOne, Body bodyTwo) {
		int randomDelete = random.nextInt(2);
		if (randomDelete == 1) {
			deleteBody(bodyTwo);
		} else {
			deleteBody(bodyOne);
		}
	}

	public void bornBodie(Body bodyOne, Body bodyTwo, int n) {
		if ((bodyOne.isGender() == false && bodyTwo.isGender() == true || bodyOne.isGender() == true && bodyTwo.isGender() == false) && bodyOne.getAge() > 13 && bodyTwo.getAge() > 13) {
			Body bod = createBody(n);
			addBody(bod);
			if(bod.isGender() == false) {
				bornw++;
			} else {
				born++;
			}
		}
	}
	
	public void isborn(int n) {
		Random r = new Random();
		for (int i = 0; i < bodiesList.size(); i++) {
			bornBodie(bodiesList.get(i), bodiesList.get(r.nextInt(bodiesList.size())),n);
		}
	}

	public int getSize() {
		return bodiesList.size();
	}

	public boolean gender(Body newBody) {
		return newBody.isGender();
	}

	public int quantityMan() {
		int index = 0;
		for (int i = 0; i < bodiesList.size(); i++) {
			boolean n = bodiesList.get(i).isGender();
			if (n == false) {
				index++;
			}
		}
		return index;
	}

	public int quantityWoman() {
		int index = 0;
		for (int i = 0; i < bodiesList.size(); i++) {
			boolean n = bodiesList.get(i).isGender();
			if (n != false) {
				index++;
			}
		}
		return index;
	}
	
	public int getScreen() {
		return screen;
	}
	
	public void addSizeScreen(int size) {
		screen = size;
	}

	public int addYears(int years) {
			return days = years*year;
	}
	
	public int getQuantityDay() {
		return days;
	}
	
	public int getQuantityYears() {
		return days/year;
	}

	public int getYearBornBody() {
		int yearBorn = 0;
		for(int i = 0; i < bodiesList.size(); i++) {
			yearBorn = bodiesList.get(i).getYearBorn();
		}
		return yearBorn;
	}
	
	public int quantityKillWomen() {
		return killWomen ;
	}
	
	public int quantityKillMen() {
		return killMen ;
	}
	
	public int quantityWomenBorn() {
		return bornw;
	}
	
	public int quantityMenBorn() {
		return born;
	}
	
	public int quantityBorn() {
		return born+bornw;
	}
	
	public ArrayList<Body> getBodiesList() {
		return bodiesList;
	}
	
}