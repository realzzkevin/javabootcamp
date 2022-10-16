package com.company;
import java.util.Scanner;

public class CommandLineGram {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.print("What is your first name? ");
        String firstName = scan.nextLine();

        System.out.print("What is your last name? ");
        String lastName = scan.nextLine();

        System.out.print("What is your email address? ");
        String email = scan.nextLine();

        System.out.print("What is your Twitter handle? ");
        String twitterHandle = scan.nextLine();

        System.out.print("What is your Age? ");
        int age = Integer.parseInt(scan.nextLine());

        System.out.print("What country are you from? ");
        String country = scan.nextLine();

        System.out.print("What is your profession? ");
        String profession = scan.nextLine();

        System.out.print("What is your favorite operating system? ");
        String operatingSystem = scan.nextLine();

        System.out.print("What is your favorite programming language? ");
        String programmingLang = scan.nextLine();

        System.out.print("Who is your favorite computer scientist? ");
        String computerScientist = scan.nextLine();

        System.out.print("What is your favorite keyboard shortcut? ");
        String kbShortcut = scan.nextLine();

        System.out.print("Have you ever built your own computer? ");
        String builtComp = scan.nextLine();

        System.out.print("If you could be any superhero, who would it be? ");
        String superhero = scan.nextLine();

        System.out.println("");
        System.out.println("Your Information");
        System.out.println("----------------");
        System.out.println("");

        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Email Address: " + email);
        System.out.println("Twitter Handle: " + twitterHandle);
        System.out.println("Age: " + age);
        System.out.println("Country: " + country);
        System.out.println("Profession: " + profession);
        System.out.println("Favorite OS: " + operatingSystem);
        System.out.println("Favorite Programming Language: " + programmingLang);
        System.out.println("Favorite Computer Scientist: " + computerScientist);
        System.out.println("Favorite Keyboard Shortcut: " + kbShortcut);
        System.out.println("Built a Computer? " + builtComp);
        System.out.println("Superhero: " + superhero);

    }
}
