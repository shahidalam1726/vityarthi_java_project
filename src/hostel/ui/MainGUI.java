package hostel.ui;

import hostel.model.*;
import hostel.service.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MainGUI extends JFrame {
    private List<Student> students = new ArrayList<>();
    private List<Room> rooms = new ArrayList<>();
    private AllocationEngine allocationEngine;

    private JTextField txtId, txtName, txtGpa;
    private JComboBox<String> cbYear, cbRoomType, cbMessPlan;
    private JTextArea txtOutput;

    public MainGUI() {
        seedRooms();
        allocationEngine = new AllocationEngine(rooms);

        setTitle("Hostel & Mess Allocation System");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Form Panel
        JPanel formPanel = new JPanel(new GridLayout(6, 2, 5, 5));
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        formPanel.add(new JLabel("Student ID:"));
        txtId = new JTextField();
        formPanel.add(txtId);

        formPanel.add(new JLabel("Student Name:"));
        txtName = new JTextField();
        formPanel.add(txtName);

        formPanel.add(new JLabel("Academic Year:"));
        cbYear = new JComboBox<>(new String[]{"1", "2", "3", "4"});
        formPanel.add(cbYear);

        formPanel.add(new JLabel("GPA (0.0 - 10.0):"));
        txtGpa = new JTextField();
        formPanel.add(txtGpa);

        formPanel.add(new JLabel("Room Type:"));
        cbRoomType = new JComboBox<>(new String[]{"Single", "Double"});
        formPanel.add(cbRoomType);

        formPanel.add(new JLabel("Mess Plan:"));
        cbMessPlan = new JComboBox<>(new String[]{"Regular Veg", "Special Non-Veg"});
        formPanel.add(cbMessPlan);

        add(formPanel, BorderLayout.NORTH);

        // Output Panel
        txtOutput = new JTextArea();
        txtOutput.setEditable(false);
        add(new JScrollPane(txtOutput), BorderLayout.CENTER);

        // Action Buttons
        JPanel btnPanel = new JPanel();
        JButton btnRegister = new JButton("Allocate & Generate Receipt");
        btnRegister.addActionListener(e -> processAllocation());
        btnPanel.add(btnRegister);

        add(btnPanel, BorderLayout.SOUTH);
    }

    private void seedRooms() {
        rooms.add(new Room("A101", "Single", 1200.0));
        rooms.add(new Room("A102", "Single", 1200.0));
        rooms.add(new Room("B201", "Double", 800.0));
        rooms.add(new Room("B202", "Double", 800.0));
    }

    private void processAllocation() {
        try {
            String id = txtId.getText().trim();
            String name = txtName.getText().trim();
            int year = Integer.parseInt((String) cbYear.getSelectedItem());
            double gpa = Double.parseDouble(txtGpa.getText().trim());
            String roomPref = (String) cbRoomType.getSelectedItem();
            
            String messType = (String) cbMessPlan.getSelectedItem();
            double messFee = messType.contains("Special") ? 250.0 : 180.0;
            MessPlan messPlan = new MessPlan(messType, messFee);

            if (id.isEmpty() || name.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Student student = new Student(id, name, year, gpa, roomPref, messPlan);
            students.add(student);

            Room assignedRoom = allocationEngine.allocateRoom(student);
            DatabaseManager.saveStudentsToFile(students);

            String receipt = BillingService.generateReceipt(student, assignedRoom, 5);
            txtOutput.setText(receipt);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid numeric GPA.", "Input Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Allocation Error", JOptionPane.WARNING_MESSAGE);
        }
    }
}