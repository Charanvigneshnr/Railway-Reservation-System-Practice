package Charan.RailwayReservationSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Railway Reservation System");
        System.out.println("--------------------------");
        Backend b = new Backend();
        Scanner sc = new Scanner(System.in);
        int input;
        int id = 1;
        while (true) {
            System.out.println("1. Book tickets\n2. Cancel tickets\n3. Available tickets\n4. Booked tickets\n5. Exit");
            System.out.print("Enter your choice: ");
            input = sc.nextInt();
            switch (input) {
                case 1:
                    System.out.println("Book tickets\n");
                    System.out.print("Enter name: ");
                    sc.nextLine();
                    String name = sc.nextLine();
                    System.out.print("Enter age: ");
                    int age = sc.nextInt();
                    System.out.print("Enter berth preference: ");
                    char preference = sc.next().charAt(0);
                    Passenger p = new Passenger(id++, name, age, preference);
                    b.bookTickets(p);
                    System.out.println("Booked tickets, Passenger ID: " + b.getPassengerId(name));
                    break;
                case 2:
                    System.out.println("Cancel tickets\n");
                    System.out.print("Enter passenger ID: ");
                    int pid = sc.nextInt();
                    Passenger p1 = new Passenger(pid);
                    b.cancelTickets(p1, id);
                    System.out.println("Ticket cancelled for passenger ID: " + pid);
                    break;
                case 3:
                    b.printAvailableTickets();
                    break;
                case 4:
                    System.out.println("Show booked tickets\n");
                    System.out.print("Enter passenger ID: ");
                    int id1 = sc.nextInt();
                    b.printBookedTickets(id1);
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        }
    }
}
