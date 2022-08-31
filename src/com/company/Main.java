package com.company;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;


public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter length of array: ");
        Employee[] employees = new Employee[scanner.nextInt()];
        scanner.nextLine();
        for (int i = 0; i < employees.length; i++) {
            employees[i] = new Employee();
            employees[i].setName(writeName(i, EnumEmployee.NAME));
            employees[i].setSurname(writeName(i, EnumEmployee.SURNAME));
            employees[i].setBirthYear(writeYear(i, EnumEmployee.BIRTHYEAR));
            employees[i].setBeginWorkYear(writeWorkYear(i, employees[i].getBirthYear(), EnumEmployee.BEGINWORKYEAR));
        }

        for (Employee i: employees) {
            System.out.println("Name: " + i.getName());
            System.out.println("Surname: " + i.getSurname());
            System.out.println("Birth year: " + i.getBirthYear());
            System.out.println("Begin work year: " + i.getBeginWorkYear());
            System.out.println("-----------------------------------");
        }
    }

    public static String writeName(int i, EnumEmployee enumEmployee) {
        System.out.printf("Enter %d'th employee's %s: ", i, enumEmployee.getWord());
        String name = scanner.nextLine();
        try {
            if (!checkName(name))
                throw new Exception("Error! " + enumEmployee.getWord() + " must contain only letters");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            while (!checkName(name)) {
                System.out.printf("Enter %s'th employee's %s again: ", i, enumEmployee.getWord());
                name = scanner.nextLine();
            }
        }
        return name;
    }

    public static boolean checkName(String name) {
        int count = 0;
        for (int i = 0; i < name.length(); i++)
            if (Character.isLetter(name.charAt(i)))
                count++;

        return count == name.length();
    }

    public static int writeYear(int i, EnumEmployee enumEmployee){
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter %d'th employee's %s: ", i, enumEmployee.getWord());
        int year = scanner.nextInt();
        try {
            if (!checkYear(year))
                throw new Exception("Error year");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            while (!checkYear(year)){
                System.out.printf("Enter %s's again: ", year);
                System.out.printf("Enter %d'th employee's %s again: ", i, enumEmployee.getWord());
                year = scanner.nextInt();
            }
        }
        return year;

    }

    public static boolean checkYear(int year){
        if (year > LocalDate.now().getYear())
            return false;
        return true;
    }


    public static int writeWorkYear(int i, int birthYear, EnumEmployee enumEmployee){
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter %d'th employee's %s: ", i, enumEmployee.getWord());
        int workYear = scanner.nextInt();
        try {
            if (!checkWorkYear(workYear, birthYear))
                throw new Exception("Error workYear");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            while (!checkWorkYear(workYear, birthYear)){
                System.out.printf("Enter %d'th employee's %s again: ", i, enumEmployee.getWord());
                workYear = scanner.nextInt();
            }
        }
        return workYear;

    }

    public static boolean checkWorkYear(int workYear, int birthYear){
        if ((workYear - birthYear) < 18)
            return false;
        return true;
    }
}