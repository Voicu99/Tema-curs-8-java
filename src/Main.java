import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Task 1: Create a shopping list with Array and print the values
        System.out.println("Shopping List:");
        String[] shoppingList = {"Milk", "Eggs", "Bread", "Butter", "Cheese"};
        for (String item : shoppingList) {
            System.out.println(item);
        }

        // Task 2: Create a wishlist for Christmas with ArrayList and print the values
        System.out.println("\nChristmas Wishlist:");
        ArrayList<String> wishlist = new ArrayList<>();
        wishlist.add("New Phone");
        wishlist.add("Laptop");
        wishlist.add("Video Game Console");
        wishlist.add("Bicycle");
        wishlist.add("Smart Watch");
        for (String item : wishlist) {
            System.out.println(item);
        }

        // Task 3: Create 2 empty ArrayLists for students
        ArrayList<String> studentList = new ArrayList<>();
        ArrayList<String> graduateStudentList = new ArrayList<>();

        // Populate studentList with 10 students
        for (int i = 1; i <= 10; i++) {
            studentList.add("Student" + i);
        }

        // Copy values from studentList to graduateStudentList
        graduateStudentList.addAll(studentList);

        // Print graduated students
        System.out.println("\nGraduated Students:");
        for (String student : graduateStudentList) {
            System.out.println(student);
        }

        // Task 4: Count even and odd numbers in an array
        System.out.println("\nCounting Even and Odd Numbers:");
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int evenCount = 0;
        int oddCount = 0;

        for (int number : numbers) {
            if (number % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }
        System.out.println("Even Count: " + evenCount);
        System.out.println("Odd Count: " + oddCount);

        // Task 5: Add city names and check for duplicates
        System.out.println("\nCity List Management:");
        ArrayList<String> cityNames = new ArrayList<>();
        cityNames.add("New York");
        cityNames.add("Los Angeles");
        cityNames.add("Chicago");
        cityNames.add("Houston");
        cityNames.add("Phoenix");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a city name: ");
        String cityName = scanner.nextLine();

        if (cityNames.contains(cityName)) {
            System.out.println("This city name is a duplicate.");
        } else {
            cityNames.add(cityName);
            System.out.println("City added: " + cityName);
        }

        System.out.println("Current city names: " + cityNames);

        // Task 6: LinkedList storing student names and removing a name
        System.out.println("\nStudent Name Management:");
        LinkedList<String> studentNames = new LinkedList<>();
        studentNames.add("Alice");
        studentNames.add("Bob");
        studentNames.add("Charlie");
        studentNames.add("David");

        String nameToRemove = "Bob";
        if (studentNames.contains(nameToRemove)) {
            studentNames.remove(nameToRemove);
            System.out.println("Removed student: " + nameToRemove);
        } else {
            System.out.println("Student not found: " + nameToRemove);
        }
        System.out.println("Remaining students: " + studentNames);

        // Task 7: Sort fruits by length and then alphabetically
        System.out.println("\nSorting Fruits:");
        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("Banana");
        fruits.add("Apple");
        fruits.add("Kiwi");
        fruits.add("Strawberry");
        fruits.add("Grape");

        Collections.sort(fruits, (f1, f2) -> {
            int lengthComparison = Integer.compare(f2.length(), f1.length());
            return lengthComparison != 0 ? lengthComparison : f1.compareTo(f2);
        });

        System.out.println("Sorted fruits:");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }

        // Task 8: Linear search for a movie title
        System.out.println("\nSearching for a Movie Title:");
        String[] movies = {"Inception", "Interstellar", "The Matrix", "Titanic", "Avatar"};
        String movieToFind = "Titanic";

        int position = linearSearch(movies, movieToFind);
        if (position != -1) {
            System.out.println("Movie found at position: " + position);
        } else {
            System.out.println("Movie not found.");
        }

        // Task 9: Convert binary string to Integer
        System.out.println("\nBinary to Decimal Conversion:");
        String binaryString = "1011";
        int decimalValue = Integer.parseInt(binaryString, 2);
        System.out.println("Decimal representation of binary " + binaryString + " is: " + decimalValue);

        // Task 10: Personal Diary Management
        System.out.println("\nDiary Management:");
        ArrayList<DiaryEntry> diaryEntries = new ArrayList<>();

        while (true) {
            System.out.println("\nDiary Menu: 1. Add Entry, 2. Edit Entry, 3. Delete Entry, 4. Display All, 5. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            if (choice == 1) { // Add Entry
                System.out.print("Enter date (YYYY-MM-DD): ");
                String date = scanner.nextLine();
                System.out.print("Enter diary entry: ");
                String entry = scanner.nextLine();

                if (!isDuplicate(diaryEntries, date)) {
                    diaryEntries.add(new DiaryEntry(date, entry));
                    System.out.println("Diary entry added.");
                } else {
                    System.out.println("Duplicate date entry not added.");
                }
            } else if (choice == 2) { // Edit Entry
                System.out.print("Enter date (YYYY-MM-DD) of entry to edit: ");
                String date = scanner.nextLine();
                int index = findEntryIndex(diaryEntries, date);

                if (index != -1) {
                    System.out.println("Current entry: " + diaryEntries.get(index).entry);
                    System.out.print("Enter new diary entry: ");
                    String newEntry = scanner.nextLine();
                    diaryEntries.get(index).entry = newEntry;
                    System.out.println("Entry updated.");
                } else {
                    System.out.println("Entry not found.");
                }
            } else if (choice == 3) { // Delete Entry
                System.out.print("Enter date (YYYY-MM-DD) of entry to delete: ");
                String date = scanner.nextLine();
                int index = findEntryIndex(diaryEntries, date);

                if (index != -1) {
                    diaryEntries.remove(index);
                    System.out.println("Entry deleted.");
                } else {
                    System.out.println("Entry not found.");
                }
            } else if (choice == 4) { // Display All
                System.out.println("Diary Entries (Latest First):");
                for (int i = diaryEntries.size() - 1; i >= 0; i--) {
                    DiaryEntry entry = diaryEntries.get(i);
                    System.out.println(entry.date + ": " + entry.entry);
                }
            } else if (choice == 5) { // Exit
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static int linearSearch(String[] movies, String target) {
        for (int i = 0; i < movies.length; i++) {
            if (movies[i].equals(target)) {
                return i; // Return the index where the movie is found
            }
        }
        return -1; // Return -1 if not found
    }

    private static boolean isDuplicate(ArrayList<DiaryEntry> diaryEntries, String date) {
        for (DiaryEntry entry : diaryEntries) {
            if (entry.date.equals(date)) {
                return true;
            }
        }
        return false;
    }

    private static int findEntryIndex(ArrayList<DiaryEntry> diaryEntries, String date) {
        for (int i = 0; i < diaryEntries.size(); i++) {
            if (diaryEntries.get(i).date.equals(date)) {
                return i;
            }
        }
        return -1;
    }

    static class DiaryEntry {
        String date;
        String entry;

        DiaryEntry(String date, String entry) {
            this.date = date;
            this.entry = entry;
        }
    }
}