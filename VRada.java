package lession13;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * The class to work with VR + iterators+list
 * 
 * @author ARTUR
 * @since JDK 13.0.2
 */
public class VRada {
	private static VRada vr13Convocation;
	List<Faction> factionVR13 = new ArrayList<Faction>();
	public static final String nonFractional = "NONFRACTIONAL";

	private VRada() {
	}

	public static VRada ifCreation() {
		if (vr13Convocation == null) {
			vr13Convocation = new VRada();
			vr13Convocation.addFaction(nonFractional);
		}
		return vr13Convocation;
	}

	public boolean addFaction(String nameFaction) {
		ListIterator<Faction> f = factionVR13.listIterator();
		boolean bool = false;
		while (f.hasNext()) {
			Faction temp = f.next();
			if (temp.getNameFaction().equalsIgnoreCase(nameFaction)) {
				bool = true;
			}
		}
		if (!bool) {
			Faction newFaction = new Faction(nameFaction);
			factionVR13.add(newFaction);
		}
		return !bool;
	}

	public boolean removeFaction(String nameFaction) {
		ListIterator<Faction> f = factionVR13.listIterator();
		boolean bool = false;
		while ((f.hasNext()) && (nameFaction != nonFractional)) {
			Faction tempFaction = f.next();
			if (tempFaction.getNameFaction().equalsIgnoreCase(nameFaction)) {
				System.out.println(
						"фракція " + nameFaction + " видалена, всі депутати фракції переведені у позафракційні");
				Iterator<Deputat> tempDeputat = tempFaction.getDeputaty().iterator();
				while (tempDeputat.hasNext()) {
					Deputat temp = tempDeputat.next();
					addDeputatInFaction(nonFractional, temp);
				}

				f.remove();
				bool = true;
			}
		}
		return bool;
	}

	public void printAllFaction() {
		ListIterator<Faction> f = factionVR13.listIterator();
		while (f.hasNext()) {
			Faction temp = f.next();
			System.out.print(temp.getNameFaction() + " ");
		}
	}

	public boolean removeAllDeputatInFaction(String nameFaction) {
		ListIterator<Faction> f = factionVR13.listIterator();
		boolean bool = false;
		while (f.hasNext()) {
			Faction tempFaction = f.next();
			if (tempFaction.getNameFaction().equalsIgnoreCase(nameFaction)) {
				System.out.println(
						"У фракція " + nameFaction + " очищена, всі депутатів фракції переведені у позафракційні");

				Iterator<Deputat> tempDeputat = tempFaction.getDeputaty().iterator();
				while (tempDeputat.hasNext()) {
					Deputat temp = tempDeputat.next();
					addDeputatInFaction(nonFractional, temp);
				}

				tempFaction.removeAllDeputat();
				bool = true;
			}
		}
		return bool;
	}

	public boolean printAllDeputatInFaction(String nameFaction) {
		ListIterator<Faction> f = factionVR13.listIterator();
		boolean bool = false;
		while (f.hasNext()) {
			Faction temp = f.next();
			if (temp.getNameFaction().equalsIgnoreCase(nameFaction)) {
				System.out.println("У фракції " + nameFaction + " є наступні депутати:");
				temp.printAllDeputat();
				bool = true;
			}
		}
		return bool;
	}

	public boolean addDeputatInFaction(String nameFaction, Deputat deputat) {
		ListIterator<Faction> f = factionVR13.listIterator();
		boolean bool = false;
		while (f.hasNext()) {
			Faction temp = f.next();
			if (temp.getNameFaction().equalsIgnoreCase(nameFaction)) {
				temp.addDeputat(deputat);
				bool = true;
			}
		}
		return bool;
	}

	public boolean removeDeputatFromFaction(String nameFaction, String name, String surName) {
		ListIterator<Faction> f = factionVR13.listIterator();
		boolean bool = false;
		while ((f.hasNext()) && (nameFaction != nonFractional)) {
			Faction temp = f.next();
			if (temp.getNameFaction().equalsIgnoreCase(nameFaction)) {
				Deputat tempDeputat = temp.returnDeputat(name, surName);
				addDeputatInFaction(nonFractional, tempDeputat);
				temp.removeDeputat(name, surName);
				System.out.println("З фракції " + nameFaction + " видалили депутата " + name + " " + surName
						+ " і перевели в позафракційні");
				bool = true;
			}
		}
		return bool;

	}

	public void printAllDeputatXabarnuk(String nameFaction) {
		ListIterator<Faction> f = factionVR13.listIterator();
		while (f.hasNext()) {
			Faction temp = f.next();
			if (temp.getNameFaction().equalsIgnoreCase(nameFaction)) {
				temp.printAllDeputatXabarnuk();
			}
		}

	}

	public void printBiggestDeputatXabarnukInFraction(String nameFaction) {
		ListIterator<Faction> f = factionVR13.listIterator();
		Deputat maxDeputatXabarnuk = null;
		while (f.hasNext()) {
			Faction temp = f.next();
			if (temp.getNameFaction().equalsIgnoreCase(nameFaction)) {
				maxDeputatXabarnuk = temp.findBiggestDeputatXabarnuk();
				System.out.println(maxDeputatXabarnuk.toString());

			}
		}
	}

}
