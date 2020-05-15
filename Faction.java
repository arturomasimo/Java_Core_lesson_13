package lession13;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * The class to work factions objects
 * 
 * @author ARTUR
 * @since JDK 13.0.2
 */
public class Faction {
	private String nameFaction;
	List<Deputat> deputaty = new ArrayList<Deputat>();

	public Faction(String nameFaction) {
		super();
		this.nameFaction = nameFaction;

	}

	public void addDeputat(Deputat deputat) {
		deputaty.add(deputat);
	}

	public boolean removeDeputat(String name, String surName) {
		Iterator<Deputat> d = deputaty.listIterator();
		boolean bool = false;
		while (d.hasNext()) {
			Deputat temp = d.next();
			if (temp.getName().equalsIgnoreCase(name) && temp.getSurName().equalsIgnoreCase(surName)) {
				d.remove();
				bool = true;
			}
		}
		return bool;
	}

	public Deputat returnDeputat(String name, String surName) {
		Iterator<Deputat> d = deputaty.listIterator();
		while (d.hasNext()) {
			Deputat temp = d.next();
			if (temp.getName().equalsIgnoreCase(name) && temp.getSurName().equalsIgnoreCase(surName)) {
				return temp;
			}
		}
		return null;

	}

	public void printAllDeputat() {
		for (Deputat d : deputaty) {
			System.out.println(d.toString());
		}
	}

	public void printAllDeputatXabarnuk() {
		for (Deputat d : deputaty) {
			if (d.isXabar() == true) {
				System.out.println(d.toString());
			}
		}
	}

	public Deputat findBiggestDeputatXabarnuk() {
		int maxXabar = 0;
		Deputat maxDeputatXabarnuk = null;

		Iterator<Deputat> d = deputaty.listIterator();
		while (d.hasNext()) {
			Deputat temp = d.next();
			if (temp.isXabar() == true) {
				if (temp.getXabarSize() > maxXabar) {
					maxXabar = temp.getXabarSize();
					maxDeputatXabarnuk = temp;
				}
			}
		}
		return maxDeputatXabarnuk;
	}

	public void removeAllDeputat() {
		deputaty.clear();
	}

	public String getNameFaction() {
		return nameFaction;
	}

	public void setNameFaction(String nameFaction) {
		this.nameFaction = nameFaction;
	}

	public List<Deputat> getDeputaty() {
		return deputaty;
	}

	@Override
	public String toString() {
		return "Faction [nameFaction=" + nameFaction + ", deputaty=" + deputaty + "]";
	}

}
