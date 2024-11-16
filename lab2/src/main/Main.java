package main;

import Phone.Phone;

public class Main {

    public static void main(String[] args) {
        Phone[] phones = {
                new Phone(1, "Улитько", "Максим", "Володимирович", "12345", 120, 0),
                new Phone(2, "Німченко", "Артем", "Петрович", "23456", 200, 15),
                new Phone(3, "Омельченко", "Лев", "Юрійович", "34567", 50, 10),
                new Phone(4, "Крайній", "Данило", "Олександрович", "45678", 180, 25),
                new Phone(5, "Пасько", "Андрій", "Олегович", "56789", 60, 0)
        };

        System.out.println("Абоненти з часом міських розмов більше 100 хвилин:");
        printLocalCallsAbove(phones, 100);

        System.out.println("\nАбоненти, які користувались міжміським зв'язком:");
        printWithLongDistanceCalls(phones);

        System.out.println("\nАбоненти з номером рахунку в діапазоні [20000, 40000]:");
        printByAccountNumberRange(phones, "20000", "40000");
    }

    public static void printLocalCallsAbove(Phone[] phones, int minLocalCallTime) {
        for (Phone phone : phones) {
            if (phone.getLocalCallTime() > minLocalCallTime) {
                System.out.println(phone);
            }
        }
    }

    public static void printWithLongDistanceCalls(Phone[] phones) {
        for (Phone phone : phones) {
            if (phone.getLongDistanceCallTime() > 0) {
                System.out.println(phone);
            }
        }
    }

    public static void printByAccountNumberRange(Phone[] phones, String minAccount, String maxAccount) {
        for (Phone phone : phones) {
            if (phone.getAccountNumber().compareTo(minAccount) >= 0 &&
                    phone.getAccountNumber().compareTo(maxAccount) <= 0) {
                System.out.println(phone);
            }
        }
    }
}
