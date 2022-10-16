package com.company;
import java.util.Scanner;
public class CommandLineGram {
    public static void main(String[] args) {
        String[] userInfo = new String[13];
        String[] questions = {"What is your first name",
        "What is your last name",
        "what is your Email",
        "What is your twitter handle",
        "what is your age",
        "What country are you from",
        "What is your profession",
        "What is your Favorite operating System",
        "What is your favorite Programming language",
        "what is your favorite computer Scientist?",
        "what is your favorite keyboard shortcut?",
        "have you ever built your own computer",
        "if you could be any superhero, who would it be?"};
        Scanner input = new Scanner(System.in);

        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);
            userInfo[i] = input.nextLine();
        }

        System.out.println("Below is your informations");

        for (String s : userInfo) {
            System.out.println(s);
        }
    }
}
