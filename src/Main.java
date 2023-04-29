import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static int menu() {
		System.out.println("1 - создать новый кинотеатр");
		System.out.println("2 - сохранить кинотеатр в файл");
		System.out.println("3 - загрузить кинотеатр из файла");
		System.out.println("4 - создать/изменить график работы кинотеатра на день");
		System.out.println("5 - удалить график работы кинотеатра на день");
		System.out.println("6 - вывести график работы кинотеатра на неделю");
		System.out.println("7 - создать зал в кинотеатре");
		System.out.println("8 - удалить зал из кинотеатра");
		System.out.println("9 - вывести перечень залов кинотеатра");
		System.out.println("10 - создать/изменить график работы зала кинотеатра на день");
		System.out.println("11 - удалить график работы зала кинотеатра на день");
		System.out.println("12 - вывести график работы зала кинотеатра на неделю");
		System.out.println("13 - создать/изменить расписание сеансов зала кинотеатра на день");
		System.out.println("14 - удалить расписание сеансов зала кинотеатра на день");
		System.out.println("15 - вывести расписание сеансов зала кинотеатра на неделю");
		System.out.println("16 - добавить сеанс в расписание сеансов зала кинотеатра на день");
		System.out.println("17 - удалить сеанс из расписания сеансов зала кинотеатра на день");
		System.out.println("18 - добавить фильм и набор сеансов в расписание зала кинотеатра");
		System.out.println("19 - удалить фильм из расписания сеансов всех залов кинотеатра");
		System.out.println("0 - выйти из программы");
		System.out.println();

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.print("Сделайте Ваш выбор: ");
		int menuChoise = scanner.nextInt();

		return menuChoise;
	}

	public static void main(String[] args)
			throws NumberFormatException, IllegalTimeFormatException, IOException, ClassNotFoundException {
		Cinema cinema = null;

		while (true) {
			switch (menu()) {

			case 1: {
				cinema = Cinema.inputCinema();
				break;
			}

			case 2: {
				SerializeMethods.serialize(cinema, new File("Cinema.obj"));
				System.out.println("Кинотеатр \"" + cinema.getName() + "\" успешно сохранён в файл!\n");
				break;
			}

			case 3: {
				cinema = (Cinema) SerializeMethods.deserialize(new File("Cinema.obj"));
				System.out.println("Кинотеатр \"" + cinema.getName() + "\" успешно загружен из файла!\n");
				break;
			}

			case 4: {
				cinema.addTimeTableToCinema();
				break;
			}

			case 5: {
				cinema.removeTimeTableFromCinema();
				break;
			}

			case 6: {
				cinema.viewCinemaTimeTable();
				break;
			}

			case 7: {
				cinema.addHallToCinema();
				break;
			}

			case 8: {
				cinema.removeHallFromCinema();
				break;
			}

			case 9: {
				cinema.viewCinemaHalls();
				break;
			}

			case 10: {
				cinema.addTimeTableToHallInCinema();
				break;
			}

			case 11: {
				cinema.removeTimeTableFromHallInCinema();
				break;
			}

			case 12: {
				cinema.viewHallTimeTableInCinema();
				break;
			}

			case 13: {
				cinema.addScheduleToHallInCinema();
				break;
			}

			case 14: {
				cinema.removeScheduleFromHallInCinema();
				break;
			}

			case 15: {
				cinema.viewHallScheduleInCinema();
				break;
			}

			case 16: {
				cinema.addSeanceToScheduleInHallInCinema();
				break;
			}

			case 17: {
				cinema.removeSeanceFromScheduleInHallInCinema();
				break;
			}
			
			case 18: {
				cinema.addMovieToSeanceInScheduleInHallInCinema();
				break;
			}

			case 19: {
				cinema.removeMovieFromSeanceInScheduleInAllHallsInCinema();
				break;
			}
			
			case 0: {
				System.out.println("Надеюсь, Вам удалось по достоинству оценить весь функционал нашего Кинотеатра! Всего наилучшего!\n");
				System.exit(0);
				break;
			}

			default: {
				System.err.println("Такого пункта меню не существует!\n");
				break;
			}
			}
		}
	}
}
