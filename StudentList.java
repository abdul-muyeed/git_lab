import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {
    public static void main(String[] args) {
        // Check if an argument is provided
        if (args.length == 0) {
            System.out.println(Constant.INVALID_MESSAGE);
            return;
        }

        String operation = args[0];

        if (operation.equals("a")) {
            // Load and display all student data
            System.out.println(Constant.LOADING);
            try {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream(Constant.FILE_NAME)));
                String dataLine = reader.readLine();
                String students[] = dataLine.split(",");
                for (String student : students) {
                    System.out.println(student);
                }
                reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(Constant.LOADED);
        } else if (operation.equals("r")) {
            // Load data and display a random student
            System.out.println(Constant.LOADING);
            try {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream(Constant.FILE_NAME)));
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
            System.out.println(Constant.LOADED);
        } else if (operation.startsWith("+")) {
            // Add a new student to the list
            System.out.println(Constant.LOADING);
            try {
                BufferedWriter writer = new BufferedWriter(
                        new FileWriter(Constant.FILE_NAME, true));
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
            System.out.println(Constant.LOADED);
        } else if (operation.startsWith("?")) {
            // Search for a specific student
            System.out.println(Constant.LOADING);
            try {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream(Constant.FILE_NAME)));
                String dataLine = reader.readLine();
                String searchQuery = operation.substring(1);
                boolean index = dataLine.contains(searchQuery);
                if (index) {
                    System.out.println("Student found!");
                } else {
                    System.out.println("Student not found!");
                }
                reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(Constant.LOADED);
        } else if (operation.equals("c")) {
            // Count the number of words in the data
            System.out.println(Constant.LOADING);
            try {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream(Constant.FILE_NAME)));
                String dataLine = reader.readLine();
                String students[] = dataLine.split(",");
                System.out.println(students.length + " word(s) found ");
                reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(Constant.LOADED);
        } else {
            System.out.println(Constant.INVALID_MESSAGE);
        }
    }
}
