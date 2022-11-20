package UI;

import Domain.Patient;
import Utils.DateFormatter;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class UI {
    public static Scanner scanner = new Scanner(System.in);

    public static int readCommand() {
        System.out.println(displayMenu());
        int command = scanner.nextInt();
        scanner.nextLine();
        return command;
    }

    public static String displayMenu() {
        return """
                1.Display all the appointments
                2.Add appointment
                3.Delete appointment
                4.Update appointment
                5.Get all the appointments in one day
                6.Sort after appointment date
                0.exit
                """;
    }

    public static Date readDate() {
        while(true)
            try {
                System.out.println("Please enter the data in following formmat (MM DD HH): ");
                String date = scanner.nextLine();
                DateFormatter date1 = new DateFormatter(date);
                return date1.getDate();
            } catch (ParseException err) {
                System.out.println(err);
            }
    }

    public static Patient readPatient() {
        System.out.println("Enter firstname: ");
        String firstName = scanner.nextLine();
        System.out.println("Enter surname: ");
        String surname = scanner.nextLine();
        Date date = readDate();
        System.out.println("Enter ID: ");
        int id = scanner.nextInt();
        return new Patient(firstName, surname, date, id);
    }

    public static void updatePatient() {
        int id = readID();
        Patient patient = readPatient();
    }

    public static int readID() {
        System.out.println("Search for an ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        return id;
    }

    public static void printRepo(ArrayList<Patient> repo) {
        if(repo.size() == 0)
            System.out.println("There are no Patients in repository");
        System.out.println(repo);
    }

    public static void printErr(Exception err) {
        System.out.println(err);
    }
}
