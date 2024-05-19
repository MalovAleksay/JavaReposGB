package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class UserDataProcessor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные в следующем формате: Фамилия Имя Отчество датарождения номертелефона пол");

        String input = scanner.nextLine();
        String[] data = input.split(" ");

        try {
            if (data.length != 6) {
                throw new IllegalArgumentException("Введено неверное количество данных. Требуется 6 значений.");
            }

            String lastName = data[0];
            String firstName = data[1];
            String middleName = data[2];
            String birthDate = data[3];
            String phoneNumber = data[4];
            String gender = data[5];

            if (!Pattern.matches("\\d{2}\\.\\d{2}\\.\\d{4}", birthDate)) {
                throw new IllegalArgumentException("Неверный формат даты рождения. Требуется формат dd.mm.yyyy.");
            }

            if (!Pattern.matches("\\d+", phoneNumber)) {
                throw new IllegalArgumentException("Неверный формат номера телефона. Требуется целое число.");
            }

            if (!gender.equals("f") && !gender.equals("m")) {
                throw new IllegalArgumentException("Неверный формат пола. Требуется символ 'f' или 'm'.");
            }

            writeToFile(lastName, firstName, middleName, birthDate, phoneNumber, gender);
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Ошибка при работе с файлом: ");
            e.printStackTrace();
        }
    }

    private static void writeToFile(String lastName, String firstName, String middleName, String birthDate, String phoneNumber, String gender) throws IOException {
        String fileName = lastName + ".txt";
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(String.format("%s %s %s %s %s %s%n", lastName, firstName, middleName, birthDate, phoneNumber, gender));
        }
    }
}
