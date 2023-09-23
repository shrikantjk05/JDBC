import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {

		System.out.println("1)ADD CAR");
		System.out.println("1)VIEW CAR");
		System.out.println("1)UPDATE CAR");
		System.out.println("1)DELETE CAR");

		Scanner sc = new Scanner(System.in);
		System.out.println("enter your choice");
		int c = sc.nextInt();
		CarCRUD crud = new CarCRUD();

		switch (c) {
		case 1: {
			System.out.println("enter car name");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.println("enter the price");
			double price = sc.nextDouble();
			System.out.println("enter the color");
			sc.nextLine();
			String color = sc.nextLine();

			boolean res = crud.saveCar(name, price, color);
			if (res) {
				System.out.println("car data saved successfully");
			} else {
				System.out.println("somthing went wrong");
			}
		}

			break;

		case 2: {
			crud.viewCar();
		}
			break;

		}
	}

}
