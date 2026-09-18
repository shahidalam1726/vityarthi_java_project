package hostel.service;

import hostel.model.Student;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
    private static final String DATA_FILE = "students.txt";

    public static void saveStudentsToFile(List<Student> students) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DATA_FILE))) {
            for (Student s : students) {
                writer.write(s.getStudentId() + "," + s.getName() + "," + s.getAcademicYear() + "," + s.getGpa() + "," + s.getPreferredRoomType() + "\n");
            }
        } catch (IOException e) {
            System.err.println("Error saving student data: " + e.getMessage());
        }
    }

    public static List<String> loadRawStudentRecords() {
        List<String> records = new ArrayList<>();
        File file = new File(DATA_FILE);
        if (!file.exists()) return records;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                records.add(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading student data: " + e.getMessage());
        }
        return records;
    }
}