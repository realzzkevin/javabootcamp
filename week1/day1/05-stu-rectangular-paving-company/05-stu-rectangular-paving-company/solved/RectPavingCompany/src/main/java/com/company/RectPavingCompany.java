package com.company;
import java.util.Scanner;

public class RectPavingCompany {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("What is the width of the driveway in feet?");
        int width = Integer.parseInt(scan.nextLine());

        System.out.println("What is the length of the driveway in feet?");
        int length = Integer.parseInt(scan.nextLine());

        float concreteCost = 12.5f;
        float framingCost = 8.25f;

//        System.out.print("What is the cost of concrete per square foot? ");
//        concreteCost = Float.parseFloat(scan.nextLine());
//
//        System.out.print("What is the cost of framing/footers per linear foot? ");
//        framingCost = Float.parseFloat(scan.nextLine());

        int area = length * width;
        int perimeter = 2*length + 2*width;

        System.out.format("The area of the driveway is %d square feet.%n", area);
        System.out.format("The perimeter of the driveway is %d square feet.%n", perimeter);

        System.out.format("The cost of the concrete is %f.%n", area*concreteCost);
        System.out.format("The cost of the framing/footers is %f.%n", perimeter*framingCost);
    }
}
