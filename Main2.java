package Homework6;

import java.util.Scanner;

public class Main2 {
    static void menu() {
        System.out.println();
        System.out.println("Введіть 1, щоб перевірити, чи існує введений місяць");
        System.out.println("Введіть 2, щоб вивести всі місяці з такою ж порою року");
        System.out.println("Введіть 3, щоб вивести всі місяці з такою ж кількістю днів");
        System.out.println("Введіть 4, щоб вивести всі місяці з парною кількістю днів");
        System.out.println("Введіть 5, щоб вивести всі місяці з непарною кількістю днів");
        System.out.println("Введіть 6, щоб перевірити чи парна кількість днів у введеному місяці");
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Months[] arrayMonths = Months.values();
        Seasons[] arraySeasons = Seasons.values();

        while (true) {
            menu();

            switch (scanner.nextInt()) {

                case 1: {
                    System.out.println("=== Програма перевірки існування введеного місяця ===");
                    System.out.println("Введіть місяць:");
                    String month1 = scanner.next();

                    boolean flag = isMonthExists(arrayMonths, month1);

                    if (flag == true) {
                        System.out.println("Введений місяць існує!");
                    } else
                        System.out.println("Такого місяця нема!");

                    break;
                }

                case 2: {
                    System.out.println("=== Програма виведення всіх місяців із введеною пори року ===");
                    System.out.println("Введіть пору року:");
                    String season2 = scanner.next();

                    boolean flag = false;

                    for (Months months : arrayMonths) {
                        if (months.getSeason().name().equalsIgnoreCase(season2)) {
                            flag = true;
                        }
                    }

                    if (flag == true) {
                        System.out.println("Пора року " + season2 + " у наступних місяцях:");

                        for (Months months2 : arrayMonths) {
                            if (months2.getSeason().toString().equalsIgnoreCase(season2)) {
                                System.out.println(months2);
                            }
                        }
                    }

                    if (flag == false)
                        System.out.println("Таких місяців нема!");

                    break;
                }

                case 3: {
                    System.out.println("=== Програма виведення всіх місяців із введеною кількістю днів ===");
                    System.out.println("Введіть кількість днів:");
                    int numberOfDays3 = scanner.nextInt();

                    boolean flag = false;

                    for (Months months : arrayMonths) {
                        if (months.getNumberOfDays() == numberOfDays3) {
                            flag = true;
                        }
                    }

                    if (flag == true) {
                        System.out.println("Кількість днів " + numberOfDays3 + " в наступних місяцях:");

                        for (Months months2 : arrayMonths) {
                            if (months2.getNumberOfDays() == numberOfDays3) {
                                System.out.println(months2);
                            }
                        }
                    }

                    if (flag == false)
                        System.out.println("Таких місяців нема!");

                    break;
                }
                case 4: {
                    System.out.println("=== Програма виведення місяців із парною кількістю днів ===");

                    for (Months months : arrayMonths) {
                        if (months.getNumberOfDays() % 2 == 0) {
                            System.out.println(months);
                        }
                    }

                    break;
                }

                case 5: {
                    System.out.println("=== Програма виведення місяців з непарною кількістю днів ===");

                    for (Months months : arrayMonths) {
                        if (months.getNumberOfDays() % 2 != 0) {
                            System.out.println(months);
                        }
                    }

                    break;
                }

                case 6: {
                    System.out.println("===Програма перевірки парності кількості днів у введеному місяці ===");
                    System.out.println("Введіть місяць:");
                    String month0 = scanner.next();

                    boolean flag = isMonthExists(arrayMonths, month0);

                    if (flag == true) {
                        Months month = Months.valueOf(firstUpperCase(month0.toLowerCase()));

                        if (month.getNumberOfDays() % 2 == 0) {
                            System.out.println("Кількість днів на місяць " + month0 + " - " + month.getNumberOfDays()
                                    + ". Це число – парне");
                        } else {
                            System.out.println("Кількість днів на місяць " + month0 + " - " + month.getNumberOfDays()
                                    + ". Це число – непарне");
                        }
                    }

                    if (flag == false)
                        System.out.println("Такого місяця немає!");

                    break;
                }

                default: {
                    System.out.println("Введіть число от 0 до 9!");

                    break;
                }

            }
        }
    }

    static boolean isMonthExists(Months[] arrayMonths, String month) {
        boolean flag = false;

        for (Months months : arrayMonths) {
            if (months.name().equalsIgnoreCase(month)) {
                flag = true;
            }
        }

        return flag;
    }

    static String firstUpperCase(String string) {
        if (string == null || string.isEmpty()) {
            return string;
        } else {
            return string.substring(0, 1).toUpperCase() + string.substring(1);
        }
    }

}
