package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Grocery {
    public static ArrayList<String> groceryList=new ArrayList<>();

    public static void startGrocery(){

        Scanner input = new Scanner(System.in);
        int value = input.nextInt();

        while (true) {
            if(value == 0){
                break;
            } else if(value == 1) {
                System.out.println("Eklenmesini istediğiniz elemanları giriniz.");
                String addInput = input.nextLine();
                addItems(addInput);
            } else if(value == 2) {
                System.out.println("Cıkarılmasını istediğiniz elemanları giriniz.");
                String removeInput = input.nextLine();
                removeItems(removeInput);
            }
        }
        input.close();
    }


    public static void addItems(String input) {
        String[] items = input.split(",");
        for(String item: items){
            String trimmedItem = item.trim();
            if(!trimmedItem.isEmpty() && !checkItemIsInList(trimmedItem)){
                groceryList.add(trimmedItem);
            }
        }
        printSorted();
    }

    public static void removeItems(String input) {
        String[] items = input.split(",");
        for(String item: items){
            String trimmedItem = item.trim();
            if(checkItemIsInList(trimmedItem)){
                groceryList.remove(trimmedItem);
            }
        }
        printSorted();
    }

    public static boolean checkItemIsInList(String product) {
        return groceryList.contains(product);
    }

    public static void printSorted() {
        Collections.sort(groceryList);
        System.out.println(groceryList);
    }
}
