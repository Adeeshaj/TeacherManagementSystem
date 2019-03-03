package com.vector.school.UI;




import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.vector.school.App;
import com.vector.school.Controller.TeacherProfileEdit_controller;
import com.vector.school.model.Teacher;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;

public class TeacherProfileEdit {
    private JTextField fullNameTextField;
    private JPanel teacherProfileEditPanel;
    private JPanel chooseFilePanel;
    private JButton chooseFileButton;
    private JTextField chooseFiletextField;
    private JPanel birthdayPanel;
    private JComboBox bdyearComboBox;
    private JComboBox bdmonthComboBox;
    private JComboBox bddateComboBox;
    private JComboBox fadyearComboBox;
    private JComboBox fadmonthComboBox;
    private JComboBox faddateComboBox;
    private JComboBox sadyearComboBox;
    private JComboBox sadmonthComboBox;
    private JComboBox saddateComboBox;
    private JPanel fadPanel;
    private JPanel sadPanel;
    private JTextArea subjectstextArea;
    private JTextField eduQuaTextField;
    private JTextField profQuaTextField;
    private JTextField nidTextField;
    private JTextField addressTextField;
    private JTextField mobileTextField;
    private JButton saveButton;
    private JTextField aptTypeTextField;
    private JButton homeButton;
    private JFileChooser fileChooser;
    private String osname = System.getProperty("os.name", "").toLowerCase();
    private DatePicker dateBD = new DatePicker();
    private DatePicker dateFAD = new DatePicker();
    private DatePicker dateSAD = new DatePicker();
    private TeacherProfileEdit_controller controller = new TeacherProfileEdit_controller();
    private Teacher teacher;
    private File selectedFile;


    public TeacherProfileEdit() {
        teacher = controller.getTeacher(App.cacheUser);

        $$$setupUI$$$();
        chooseFiletextField.setEditable(false);
        chooseFiletextField.setEnabled(true);

        bdyearComboBox.removeItem("Year");
        int[] bdyears = dateBD.getYearList(1900, 2018);
        for (int y = 0; y < bdyears.length; y++) {
            bdyearComboBox.addItem(bdyears[y]);
        }

        bdmonthComboBox.removeItem("Month");
        String[] bdmonths = dateBD.getMonthList();
        for (String month : bdmonths) {
            bdmonthComboBox.addItem(month);
        }

        bddateComboBox.removeItem("Date");
        int[] bddays = dateBD.getDateList(bdmonthComboBox.getSelectedIndex(), (Integer) bdyearComboBox.getSelectedItem());
        for (int d = 0; d < bddays.length; d++) {
            bddateComboBox.addItem(bddays[d]);
        }

        fadyearComboBox.removeItem("Year");
        int[] fadyears = dateFAD.getYearList(1900, 2018);
        for (int y = 0; y < fadyears.length; y++) {
            fadyearComboBox.addItem(fadyears[y]);
        }

        fadmonthComboBox.removeItem("Month");
        String[] fadmonths = dateFAD.getMonthList();
        for (String month : fadmonths) {
            fadmonthComboBox.addItem(month);
        }

        faddateComboBox.removeItem("Date");
        int[] faddays = dateFAD.getDateList(fadmonthComboBox.getSelectedIndex(), (Integer) fadyearComboBox.getSelectedItem());
        for (int d = 0; d < faddays.length; d++) {
            faddateComboBox.addItem(faddays[d]);
        }

        sadyearComboBox.removeItem("Year");
        int[] sadyears = dateSAD.getYearList(1900, 2018);
        for (int y = 0; y < sadyears.length; y++) {
            sadyearComboBox.addItem(sadyears[y]);
        }

        sadmonthComboBox.removeItem("Month");
        String[] sadmonths = dateSAD.getMonthList();
        for (String month : sadmonths) {
            sadmonthComboBox.addItem(month);
        }

        saddateComboBox.removeItem("Date");
        int[] saddays = dateSAD.getDateList(sadmonthComboBox.getSelectedIndex(), (Integer) sadyearComboBox.getSelectedItem());
        for (int d = 0; d < saddays.length; d++) {
            saddateComboBox.addItem(saddays[d]);
        }

        if (teacher.getName() != null) {
            fullNameTextField.setText(teacher.getName());
        }

        if (teacher.getBirthday() != null) {
            bdyearComboBox.setSelectedItem(teacher.getBirthday().getYear());
            bdmonthComboBox.setSelectedItem(teacher.getBirthday().getMonth());
            bddateComboBox.setSelectedItem(teacher.getBirthday().getDate());
        }

        if (teacher.getFirst_apointment_date() != null) {
            fadyearComboBox.setSelectedItem(teacher.getFirst_apointment_date().getYear());
            fadmonthComboBox.setSelectedItem(teacher.getFirst_apointment_date().getMonth());
            faddateComboBox.setSelectedItem(teacher.getFirst_apointment_date().getDate());
        }

        if (teacher.getSchool_apointment_date() != null) {
            sadyearComboBox.setSelectedItem(teacher.getSchool_apointment_date().getYear());
            sadmonthComboBox.setSelectedItem(teacher.getSchool_apointment_date().getMonth());
            saddateComboBox.setSelectedItem(teacher.getSchool_apointment_date().getDate());
        }

        if (teacher.getSubjects() != null) {
            for (int i = 0; i < teacher.getSubjects().length; i++)
                subjectstextArea.append(teacher.getSubjects()[i]);
        }

        if (teacher.getEdu_qualification() != null) {
            eduQuaTextField.setText(teacher.getEdu_qualification());
        }

        if (teacher.getProf_qualification() != null) {
            profQuaTextField.setText(teacher.getProf_qualification());
        }

        if (teacher.getNid() != null) {
            nidTextField.setText(teacher.getNid());
        }

        if (teacher.getAddress() != null) {
            addressTextField.setText(teacher.getAddress());
        }
        if (teacher.getMobile() != null) {
            mobileTextField.setText(teacher.getMobile());
        }
        if (teacher.getTeacher_prof_pic() != null) {
            chooseFiletextField.setText(teacher.getTeacher_prof_pic());
        }
        if (teacher.getTeacher_appointment_type() != null) {
            aptTypeTextField.setText(teacher.getTeacher_appointment_type());
        }

        chooseFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileChooser = new JFileChooser();
                configureFileChooser(fileChooser);
                int retVal = fileChooser.showOpenDialog(chooseFilePanel);
                if (retVal == JFileChooser.APPROVE_OPTION) {
                    selectedFile = fileChooser.getSelectedFile();
                    chooseFiletextField.setText(selectedFile.getName().toLowerCase());
                    System.out.println(selectedFile.getName());
                    String fileExtention = selectedFile.getName().substring(selectedFile.getName().lastIndexOf(".") + 1);
                    Path to = null, targetFile;

                    if (osname.startsWith("windows")) {
                        to = Paths.get(System.getProperty("user.home") + "\\TeacherMangementSystem\\ProfilePictures\\");
                        if (!Files.exists(to)) {
                            try {
                                Files.createDirectories(to);
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                            targetFile = Paths.get(to.toString() + "\\" + App.cacheUser.get_id() + "." + fileExtention);
                            System.out.println("file copied");
                            try {
                                Files.copy(selectedFile.toPath(), targetFile, StandardCopyOption.REPLACE_EXISTING);
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }

                        } else {
                            targetFile = Paths.get(to.toString() + "\\" + App.cacheUser.get_id() + "." + fileExtention);
                            System.out.println("file copied");
                            try {
                                Files.copy(selectedFile.toPath(), targetFile, StandardCopyOption.REPLACE_EXISTING);
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        }
                    } else if (osname.startsWith("linux")) {
                        to = Paths.get(System.getProperty("user.home") + "/TeacherMangementSystem/ProfilePictures/");

                        System.out.println(to.toString());
                        if (!Files.exists(to)) {
                            try {
                                Files.createDirectories(to);
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                            targetFile = Paths.get(to.toString() + "/" + App.cacheUser.get_id() + "." + fileExtention);
                            System.out.println("file copied");
                            try {
                                Files.copy(selectedFile.toPath(), targetFile, StandardCopyOption.REPLACE_EXISTING);
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }

                        } else {
                            targetFile = Paths.get(to.toString() + "/" + App.cacheUser.get_id() + "." + fileExtention);
                            System.out.println("file copied");
                            try {
                                Files.copy(selectedFile.toPath(), targetFile, StandardCopyOption.REPLACE_EXISTING);
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "sorry! your operating system is different");
                    }

                }
                if (retVal == JFileChooser.CANCEL_OPTION) {
                    chooseFiletextField.setText("");
                }
            }
        });


        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (bdyearComboBox.getSelectedItem() != "Year" && bdmonthComboBox.getSelectedItem() != "Month" && bddateComboBox.getSelectedItem() != "Date") {
                    if (fadyearComboBox.getSelectedItem() != "Year" && fadmonthComboBox.getSelectedItem() != "Month" && faddateComboBox.getSelectedItem() != "Date") {
                        if (sadyearComboBox.getSelectedItem() != "Year" && sadmonthComboBox.getSelectedItem() != "Month" && saddateComboBox.getSelectedItem() != "Date") {
                            Date birthday = new Date((Integer) bdyearComboBox.getSelectedItem(), bdmonthComboBox.getSelectedIndex(), (Integer) bddateComboBox.getSelectedItem());
                            Date fad = new Date((Integer) fadyearComboBox.getSelectedItem(), fadmonthComboBox.getSelectedIndex(), (Integer) faddateComboBox.getSelectedItem());
                            Date sad = new Date((Integer) sadyearComboBox.getSelectedItem(), sadmonthComboBox.getSelectedIndex(), (Integer) saddateComboBox.getSelectedItem());
                            String[] subjects = subjectstextArea.getText().split("\\n");
                            if (controller.updateTeacher(fullNameTextField.getText(), selectedFile.getName(), birthday, fad, sad, aptTypeTextField.getText(), subjects, eduQuaTextField.getText(), profQuaTextField.getText(), nidTextField.getText(), addressTextField.getText(), mobileTextField.getText())) {
                                JOptionPane.showMessageDialog(null, "data saved");

                            }
                        }
                    }
                }


            }
        });

        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                App.frame.setContentPane(new Home().getHomeJpanel());
                App.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                App.frame.pack();
                App.frame.setVisible(true);
            }
        });
    }

    private static void configureFileChooser(JFileChooser fileChooser) {
        fileChooser.setDialogTitle("SelectProfileImages");
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Images", "png", "jpg"));

    }

    public JPanel getTeacherProfileEditPanel() {
        return teacherProfileEditPanel;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        teacherProfileEditPanel = new JPanel();
        teacherProfileEditPanel.setLayout(new GridLayoutManager(14, 2, new Insets(0, 0, 0, 0), -1, -1));
        final JLabel label1 = new JLabel();
        label1.setText("Full name");
        teacherProfileEditPanel.add(label1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        fullNameTextField = new JTextField();
        teacherProfileEditPanel.add(fullNameTextField, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("Profile Picture");
        teacherProfileEditPanel.add(label2, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label3 = new JLabel();
        label3.setText("Birthday");
        teacherProfileEditPanel.add(label3, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label4 = new JLabel();
        label4.setText("Firtst Appointment Date");
        teacherProfileEditPanel.add(label4, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label5 = new JLabel();
        label5.setText("School Appointment Date");
        teacherProfileEditPanel.add(label5, new GridConstraints(4, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label6 = new JLabel();
        label6.setText("Subjects");
        teacherProfileEditPanel.add(label6, new GridConstraints(6, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label7 = new JLabel();
        label7.setText("Educational Qualification");
        teacherProfileEditPanel.add(label7, new GridConstraints(7, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label8 = new JLabel();
        label8.setText("Profesional Qualification");
        teacherProfileEditPanel.add(label8, new GridConstraints(8, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label9 = new JLabel();
        label9.setText("National ID No.");
        teacherProfileEditPanel.add(label9, new GridConstraints(9, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label10 = new JLabel();
        label10.setText("Address");
        teacherProfileEditPanel.add(label10, new GridConstraints(10, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label11 = new JLabel();
        label11.setText("Mobile Number");
        teacherProfileEditPanel.add(label11, new GridConstraints(11, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        chooseFilePanel = new JPanel();
        chooseFilePanel.setLayout(new GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), -1, -1));
        teacherProfileEditPanel.add(chooseFilePanel, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        chooseFileButton = new JButton();
        chooseFileButton.setText("Choose File");
        chooseFilePanel.add(chooseFileButton, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        chooseFiletextField = new JTextField();
        chooseFilePanel.add(chooseFiletextField, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        birthdayPanel = new JPanel();
        birthdayPanel.setLayout(new GridLayoutManager(1, 3, new Insets(0, 0, 0, 0), -1, -1));
        teacherProfileEditPanel.add(birthdayPanel, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        bdyearComboBox = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel1 = new DefaultComboBoxModel();
        defaultComboBoxModel1.addElement("Year");
        bdyearComboBox.setModel(defaultComboBoxModel1);
        birthdayPanel.add(bdyearComboBox, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        bdmonthComboBox = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel2 = new DefaultComboBoxModel();
        defaultComboBoxModel2.addElement("Month");
        bdmonthComboBox.setModel(defaultComboBoxModel2);
        birthdayPanel.add(bdmonthComboBox, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        bddateComboBox = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel3 = new DefaultComboBoxModel();
        defaultComboBoxModel3.addElement("Date");
        bddateComboBox.setModel(defaultComboBoxModel3);
        birthdayPanel.add(bddateComboBox, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        fadPanel = new JPanel();
        fadPanel.setLayout(new GridLayoutManager(1, 3, new Insets(0, 0, 0, 0), -1, -1));
        teacherProfileEditPanel.add(fadPanel, new GridConstraints(3, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        fadyearComboBox = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel4 = new DefaultComboBoxModel();
        defaultComboBoxModel4.addElement("Year");
        fadyearComboBox.setModel(defaultComboBoxModel4);
        fadPanel.add(fadyearComboBox, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        fadmonthComboBox = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel5 = new DefaultComboBoxModel();
        defaultComboBoxModel5.addElement("Month");
        fadmonthComboBox.setModel(defaultComboBoxModel5);
        fadPanel.add(fadmonthComboBox, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        faddateComboBox = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel6 = new DefaultComboBoxModel();
        defaultComboBoxModel6.addElement("Date");
        faddateComboBox.setModel(defaultComboBoxModel6);
        fadPanel.add(faddateComboBox, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        sadPanel = new JPanel();
        sadPanel.setLayout(new GridLayoutManager(1, 3, new Insets(0, 0, 0, 0), -1, -1));
        teacherProfileEditPanel.add(sadPanel, new GridConstraints(4, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        sadyearComboBox = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel7 = new DefaultComboBoxModel();
        defaultComboBoxModel7.addElement("Year");
        sadyearComboBox.setModel(defaultComboBoxModel7);
        sadPanel.add(sadyearComboBox, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        sadmonthComboBox = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel8 = new DefaultComboBoxModel();
        defaultComboBoxModel8.addElement("Month");
        sadmonthComboBox.setModel(defaultComboBoxModel8);
        sadPanel.add(sadmonthComboBox, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        saddateComboBox = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel9 = new DefaultComboBoxModel();
        defaultComboBoxModel9.addElement("Date");
        saddateComboBox.setModel(defaultComboBoxModel9);
        sadPanel.add(saddateComboBox, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        subjectstextArea = new JTextArea();
        teacherProfileEditPanel.add(subjectstextArea, new GridConstraints(6, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        eduQuaTextField = new JTextField();
        teacherProfileEditPanel.add(eduQuaTextField, new GridConstraints(7, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        profQuaTextField = new JTextField();
        teacherProfileEditPanel.add(profQuaTextField, new GridConstraints(8, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        nidTextField = new JTextField();
        teacherProfileEditPanel.add(nidTextField, new GridConstraints(9, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        addressTextField = new JTextField();
        teacherProfileEditPanel.add(addressTextField, new GridConstraints(10, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        mobileTextField = new JTextField();
        teacherProfileEditPanel.add(mobileTextField, new GridConstraints(11, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        saveButton = new JButton();
        saveButton.setText("save");
        teacherProfileEditPanel.add(saveButton, new GridConstraints(12, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label12 = new JLabel();
        label12.setText("Appointment Type");
        teacherProfileEditPanel.add(label12, new GridConstraints(5, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        aptTypeTextField = new JTextField();
        teacherProfileEditPanel.add(aptTypeTextField, new GridConstraints(5, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        homeButton = new JButton();
        homeButton.setText("Home");
        teacherProfileEditPanel.add(homeButton, new GridConstraints(13, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return teacherProfileEditPanel;
    }

}
