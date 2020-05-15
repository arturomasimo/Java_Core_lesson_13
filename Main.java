package lession13;

import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The Main class to work with iterators
 * 
 * @author ARTUR
 * @since JDK 13.0.2
 */
public class Main {

	public static void main(String[] args) throws Exception {

		String st;
		while (true) {
			printMenu();
			st = new Scanner(System.in).nextLine();
			switch (st) {
			case "1": { // створити фракцію
				System.out.print("Введіть назву фракції ");
				st = new Scanner(System.in).nextLine();
				if (checkErrors(st)) {
					if (!VRada.ifCreation().addFaction(st)) {
						System.out.println("Помилка створення фрації " + st + " . Скоріше за все така фракція існує!");
					} else {
						System.out.println("Фракція " + st + " успішно створена!");
					}
				}
				break;
			}
			case "2": { // видалити фракцію
				System.out.print("Введіть назву фракції ");
				st = new Scanner(System.in).nextLine();
				if (checkErrors(st)) {
					if (!VRada.ifCreation().removeFaction(st)) {
						System.out.println("фракція " + st + " НЕ знайдено!");
					}
				}
				break;
			}
			case "3": {
				System.out.println("Зареєстровані такі фракції: ");
				VRada.ifCreation().printAllFaction();
				System.out.println();
				break;
			}
			case "4": {// очистити від депутатів фракцію
				System.out.print("Введіть назву фракції ");
				st = new Scanner(System.in).nextLine();
				if (checkErrors(st)) {
					if (!VRada.ifCreation().removeAllDeputatInFaction(st)) {
						System.out.println("фракція " + st + " НЕ знайдено!");
					}
				}
				break;
			}
			case "5": { // надрукувати депутатів вказаної фракції
				System.out.print("Введіть назву фракції ");
				st = new Scanner(System.in).nextLine();
				if (checkErrors(st)) {
					if (!VRada.ifCreation().printAllDeputatInFaction(st)) {
						System.out.println("фракція " + st + " НЕ знайдено!");
					}
				}
				break;
			}

			case "6": { // додати депутатів в фракцію
				System.out.print("Введіть назву фракції ");
				st = new Scanner(System.in).nextLine();
				if (checkErrors(st)) {

					Deputat d = new Deputat(0, 0);
					Random rand = new Random();
					String[] nameMass = { "Ivan", "Petro", "Oleg", "Stepan", "Mykola", "Maksum", "Stepan", "Danil" };
					String[] surNameMass = { "Ivanov", "Petrov", "Olegov", "Stepanov", "Matov", "Maksumov", "Stepanov",
							"Dumov" };

					System.out.print("Будемо вводити руками (1) чи згенеруємо рандомно (2)?");
					String s = new Scanner(System.in).nextLine();
					int i = 0;
					if (s.equals("1")) {
						System.out.print("Введіть імя ");
						String ss = new Scanner(System.in).nextLine();
						if (checkErrors(ss)) {
							d.setName(ss);
						}
						System.out.print("Введіть прізвище ");
						ss = new Scanner(System.in).nextLine();
						if (checkErrors(ss)) {
							d.setSurName(ss);
						}
						System.out.print("Введіть вік ");
						i = Integer.parseInt(new Scanner(System.in).nextLine());
						d.setAge(i);
						System.out.print("Введіть вагу ");
						i = Integer.parseInt(new Scanner(System.in).nextLine());
						d.setWeight(i);
						System.out.print("Введіть зріст ");
						i = Integer.parseInt(new Scanner(System.in).nextLine());
						d.setHeigth(i);

						System.out.print("Введіть чи хабарник: так (1), ні (0)");
						ss = new Scanner(System.in).nextLine();
						if (ss.equals("1")) {
							d.setXabar(true);
						}
						if (ss.equals("0")) {
							d.setXabar(false);
						}
					}
					if (s.equals("2")) {
						d.setWeight(rand.nextInt(100) + 100);
						d.setHeigth(rand.nextInt(100) + 100);
						d.setAge(rand.nextInt(50) + 25);
						d.setXabar(true);
						d.setSurName(surNameMass[rand.nextInt(7)]);
						d.setName(nameMass[rand.nextInt(7)]);

					}

					if (d.isXabar()) {
						System.out.println("Депутату " + d.getName() + " " + d.getSurName()
								+ " потрібно дати хабар, введіть число");
						int xabarNew = Integer.parseInt(new Scanner(System.in).nextLine());
						d.giveXabar(xabarNew);
					}

					if (VRada.ifCreation().addDeputatInFaction(st, d)) {
						System.out.println("У фракцію " + st + " додали депутата " + d.toString());
					} else {
						System.out.println("фракція " + st + " НЕ знайдено!");
					}
				}
				break;
			}
			case "7": { // видалити депутата з фракції
				String st1 = "";
				System.out.print("Введіть назву фракції ");
				st = new Scanner(System.in).nextLine();
				if (checkErrors(st)) {
					if (!VRada.ifCreation().printAllDeputatInFaction(st)) {
						System.out.println("фракція " + st + " НЕ знайдено!");
					} else {
						System.out.print("Введіть Імя та Прізвище депутата, якого видалити (через пробіл) :");
						st1 = new Scanner(System.in).nextLine();
						if (checkErrors(st)) {
							String[] s = st1.split(" ");
							VRada.ifCreation().removeDeputatFromFaction(st, s[0], s[1]);

						}
					}
				}
				break;
			}
			case "8": { // надрукувати список хабарників вказаної фракції
				System.out.print("Введіть назву фракції ");
				st = new Scanner(System.in).nextLine();
				if (checkErrors(st)) {
					if (!VRada.ifCreation().printAllDeputatInFaction(st)) {
						System.out.println("фракція " + st + " НЕ знайдено!");
					} else {
						System.out.println("Список депутатів хабарників фракції " + st);
						VRada.ifCreation().printAllDeputatXabarnuk(st);
					}
				}
				break;
			}
			case "9": { // надрукувати найбільшого хабарника вказаної фракції
				System.out.print("Введіть назву фракції ");
				st = new Scanner(System.in).nextLine();
				if (checkErrors(st)) {
					if (!VRada.ifCreation().printAllDeputatInFaction(st)) {
						System.out.println("фракція " + st + " НЕ знайдено!");
					} else {
						System.out.println("Найбільший депутат хабарник фракції " + st);
						VRada.ifCreation().printBiggestDeputatXabarnukInFraction(st);
					}
				}
				break;
			}

			case "0": {
				System.exit(0);
			}
			}
		}
	}

	// print menu
	private static void printMenu() {
		System.out.println("Введіть 1  щоб створити фракцію");
		System.out.println("Введіть 2  щоб видалити фракцію");
		System.out.println("Введіть 3  щоб надрукувати всі фракції");
		System.out.println("Введіть 4  щоб очистити від депутатів фракцію");
		System.out.println("Введіть 5  щоб надрукувати депутатів вказаної фракції");
		System.out.println("Введіть 6  щоб додати депутатів в фракцію");
		System.out.println("Введіть 7  щоб видалити депутата з фракції");
		System.out.println("Введіть 8  щоб надрукувати список хабарників вказаної фракції");
		System.out.println("Введіть 9  щоб надрукувати найбільшого хабарника вказаної фракції");
		System.out.println("Введіть 0  щоб вийти з програми");

	}

	private static boolean checkErrors(String s1) throws Exception {
		String kirilica = "[а-яА-Я+]";
		Pattern pattern = Pattern.compile(kirilica);
		Matcher mather = pattern.matcher(s1);

		if (s1.length() < 3 || s1.length() > 15)
			throw new IllegalArgumentException("Назва " + s1 + " введена невірно (кількість знаків)");
		if (!s1.matches("^\\D*$"))
			throw new IllegalArgumentException("Назва " + s1 + " не може містити цифри");
		if (mather.find())
			throw new IllegalArgumentException("Назва " + s1 + " не може містити кирилицю");
		return true;

	}

}
