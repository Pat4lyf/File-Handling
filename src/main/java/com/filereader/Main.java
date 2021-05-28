package com.filereader;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String nameOfFile = null;

        if (args.length == 0) {
            nameOfFile = "config.txt";
        } else {
            if (args[0].equalsIgnoreCase("production")) {
                nameOfFile = "config.txt";

            } else if (args[0].equalsIgnoreCase("staging")) {
                nameOfFile = "config.txt.staging";

            } else if (args[0].equalsIgnoreCase("development")) {
                nameOfFile = "config.txt.dev";

            } else {
                System.out.println("Invalid file name");
            }

        }


        // creating a config object that reads from the file based on the name passed as argument
        ConfigParser config = new ConfigParser(nameOfFile);

        //creating an object that reads from the defaultName when no argument is passed
        ConfigParser config1 = new ConfigParser();

        Scanner input = new Scanner(System.in);
        System.out.println("Enter key");
        String key = input.nextLine();
        System.out.println(config.get(key));
        System.out.println(config1.get(key));

    }
}