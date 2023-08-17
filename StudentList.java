import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {
    public static void main(String[] args) {
        // Check if an argument is provided
        if (args.length == 0) {
            System.out.println("Please enter a valid argument. (a, r, c, +WORD, ?WORD)");
            return;
        }

        String operation = args[0];

        if (operation.equals("a")) {
            // Load and display all student data
            System.out.println("Loading data ...");
            try {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("students.txt")));
                String dataLine = reader.readLine();
                String students[] = dataLine.split(",");
                for (String student : students) {
                    System.out.println(student);
                }
                reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("Data Loaded.");
        } else if (operation.equals("r")) {
            // Load data and display a random student
            System.out.println("Loading data ...");
            try {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("students.txt")));
                String dataLine = reader.readLine();
                String students[] = dataLine.split(",");
                int bound = students.length;
                Random random = new Random();
                int randomIndex = random.nextInt(bound);
                System.out.println(students[randomIndex]);

                reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("Data Loaded.");
        } else if (operation.startsWith("+")) {
            // Add a new student to the list
            System.out.println("Loading data ...");
            try {
                BufferedWriter writer = new BufferedWriter(
                        new FileWriter("students.txt", true));
                String newStudent = operation.substring(1);
                Date currentDate = new Date();
                String dateFormatPattern = "dd/MM/yyyy - hh:mm:ss a";
                DateFormat dateFormat = new SimpleDateFormat(dateFormatPattern);
                String formattedDate = dateFormat.format(currentDate);
                writer.write(", " + newStudent + "\nList last updated on " + formattedDate);
                writer.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("Data Loaded.");
        } else if (operation.startsWith("?")) {
            // Search for a specific student
            System.out.println("Loading data ...");
            try {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("students.txt")));
                String dataLine = reader.readLine();
                String students[] = dataLine.split(",");
                String searchQuery = operation.substring(1);
                int index = dataLine.indexOf(searchQuery);
                if (index == -1) {
                    System.out.println("Student not found!");
                } else {
                    System.out.println("Student found!");
                }
                reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("Data Loaded.");
        } else if (operation.equals("c")) {
            // Count the number of words in the data
            System.out.println("Loading data ...");
            try {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("students.txt")));
                String dataLine = reader.readLine();
                char characters[] = dataLine.toCharArray();
                int wordCount = 1;
                for (char character : characters) {
                    if (character == ' ') {
                        wordCount++;
                    }
                }
                System.out.println(wordCount + " word(s) found " + characters.length);
                reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("Data Loaded.");
        } else {
            System.out.println("Please enter a valid argument. (a, r, c, +WORD, ?WORD)");
        }
    }
}
