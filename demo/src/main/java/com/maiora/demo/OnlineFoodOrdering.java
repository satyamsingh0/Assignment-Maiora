package com.maiora.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OnlineFoodOrdering {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String[] items = {"Pizza", "Burger", "Pasta", "Roll"};
        double[] prices = {250, 120, 180, 90};

        Map<String, Integer> cart = new HashMap<>();

        while(true){
            System.out.println("--- Menu ---");
            for (int i = 0; i < items.length; i++) {
                System.out.println((i+1) + ". " + items[i] + " --> " + prices[i]);
            }

            System.out.println("0. Checkout");

            System.out.print("Choose an item number: ");
            int choice = s.nextInt();

            if (choice == 0) {
                break;
                //checkout
            }else{
                String item = items[choice - 1];
                cart.put(item, cart.getOrDefault(item, 0) + 1);
                System.out.println(item + " added to cart.");
            }
        }

        s.nextLine();
        System.out.print("please specify any special instructions: ");
        String instructions = s.nextLine();

        double subtotal = 0;
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            String item = entry.getKey();
            int count = entry.getValue();
            double price = 0;

            for (int i = 0; i < items.length; i++) {
                if (items[i].equals(item)) {
                    price = prices[i];
                    break;
                }
            }

            double totalItemPrice = price * count;
            subtotal += totalItemPrice;
        }

        double tax = subtotal * 18/100;
        double delivery = 40;
        double total = subtotal + tax + delivery;

        System.out.println("tax: " + tax);
        System.out.println("delivery: " + delivery);
        System.out.println("total: "+ total);
        System.out.println("special instructions: " + instructions);
    }
}
