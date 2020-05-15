package lession13;

/**
 * The class to work with deputat objects
 * 
 * @author ARTUR
 * @since JDK 13.0.2
 */
public class Deputat extends Human {
	private String name;
	private String surName;
	private int age;
	private boolean xabar;
	private int xabarSize;

	public Deputat(int weight, int heigth) {
		super(weight, heigth);
		this.name = "";
		this.surName = "";
		this.age = 0;
		this.xabar = false;
	}

	public Deputat(int weight, int heigth, String name, String surName, int age, boolean xabar) {
		super(weight, heigth);
		this.name = name;
		this.surName = surName;
		this.age = age;
		this.xabar = xabar;
	}

	public boolean giveXabar(int xabarNew) {
		boolean bool = false;
		if (xabarNew <= 5000) {
			this.xabarSize = xabarNew;
			bool = true;
			System.out.println("Взяв і не скривився");
		} else {
			System.out.println("Поліція увязнить депутата!");
			this.xabarSize = 0;
		}

		return bool;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isXabar() {
		return xabar;
	}

	public void setXabar(boolean xabar) {
		this.xabar = xabar;
	}

	public int getXabarSize() {
		return xabarSize;
	}

	public void setXabarSize(int xabarSize) {
		this.xabarSize = xabarSize;
	}

	@Override
	public String toString() {
		return "Deputat [name=" + name + ", surName=" + surName + ", age=" + age + ", xabar=" + xabarSize + "]"
				+ super.toString();
	}

}
