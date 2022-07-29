package model;

public class Body {

	private boolean gender;
	private int age;
	private double height;
	private int x,y;
	private String typeAge;
	private int dayBorn;
	
	public Body(char gender, int age, double height, int x, int y, int yearBorn) {
		this.gender = gender(gender);
		this.age = age;
		this.height = height;
		this.x = x;
		this.y = y;
		this.typeAge = ageRange();
		this.dayBorn = yearBorn;
	}
	
	public void aumentandoEdad(int year) {
		if (year > 0) {
			age++;
		}
	}
	
	public boolean gender(char string) {
		if(string == 'M') {
			gender = false;
		} else if (string == 'F') {
			gender = true;
		}
		return gender;
	}
	
	public String ageRange() {
		String type = "";
		if (age >= 0 && age <= 11) {
			type = "Niñez";
		} if(age >= 12 && age <= 18) {
			type = "Adolecente";
		} else if(age >= 14 && age <= 26) {
			type = "Joven";
		} else if (age >= 27 && age <= 59) {
			type = "Adulto";
		} else if(age >= 60) {
			type = "Anciano";
		}
		return type;
	}

	
	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public String getTypeAge() {
		return typeAge;
	}
	
	public int getYearBorn() {
		return dayBorn;
	}
	
    @Override
    public String toString() {
        return "CUERPO{" + " genero=" + gender + ", age=" + age + ", height=" + height + ", coordenate x = " + x + ", coordenate x = " + y + ", tipo = " + typeAge +'}';
    }
	
	
}
