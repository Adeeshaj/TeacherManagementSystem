package com.vector.school.UI;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.vector.school.App;
import com.vector.school.Controller.Signup_controller;


import javax.swing.*;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;


public class User_sign_up {
    private JTextField fullNameTextField;
    private JTextField usernameTextField;
    private JButton submitButton;
    private JComboBox roleComboBox;
    private JPasswordField passwordField2;
    private JPasswordField passwordField1;
    private JPanel signupPanel;
    private JComboBox yearComboBox;
    private JComboBox monthComboBox;
    private JComboBox dateComboBox;
    private JPanel birthdayPanel;
    private JTextField adminSecretTextField;
    private JLabel adminSecretLabel;
    private JButton homeButton;
    private DatePicker date_birthday = new DatePicker();
    private Signup_controller controller = new Signup_controller();

    public User_sign_up() {

        yearComboBox.addPopupMenuListener(new PopupMenuListener() {
            public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
                yearComboBox.removeItem("Year");
                int[] years = date_birthday.getYearList(1900, 2018);
                for (int y = 0; y < years.length; y++) {
                    yearComboBox.addItem(years[y]);
                }
            }

            public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {

            }

            public void popupMenuCanceled(PopupMenuEvent e) {

            }

        });


        monthComboBox.addPopupMenuListener(new PopupMenuListener() {
            public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
                monthComboBox.removeItem("Month");
                String[] months = date_birthday.getMonthList();
                for (String month : months) {
                    monthComboBox.addItem(month);
                }
            }

            public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {

            }

            public void popupMenuCanceled(PopupMenuEvent e) {

            }
        });


        dateComboBox.addPopupMenuListener(new PopupMenuListener() {
            public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
                dateComboBox.removeItem("Date");
                int[] days = date_birthday.getDateList(monthComboBox.getSelectedIndex(), (Integer) yearComboBox.getSelectedItem());
                for (int d = 0; d < days.length; d++) {
                    dateComboBox.addItem(days[d]);
                }
            }

            public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {

            }

            public void popupMenuCanceled(PopupMenuEvent e) {

            }
        });
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if ((fullNameTextField.getText() == null || !fullNameTextField.getText().equals("")) && (usernameTextField.getText() == null || !usernameTextField.getText().equals(""))) {
                    if (passwordField1.getPassword().length > 3) {
                        if (passwordField1.getPassword() != passwordField2.getPassword()) {
                            if (yearComboBox.getSelectedItem() != "Year" && monthComboBox.getSelectedItem() != "Month" && dateComboBox.getSelectedItem() != "Date") {
                                Date birthday = new Date((Integer) yearComboBox.getSelectedItem(), monthComboBox.getSelectedIndex(), (Integer) dateComboBox.getSelectedItem());
                                if (controller.user_name_available(usernameTextField.getText())) {
                                    if (roleComboBox.getSelectedItem().toString().equals("Admin")) {
                                        if (adminSecretTextField.getText().equals("SchoolAdmin")) {
                                            if (controller.signup_user(fullNameTextField.getText(), usernameTextField.getText(), String.valueOf(passwordField1.getPassword()), birthday, (String) roleComboBox.getSelectedItem())) {
                                                JOptionPane.showMessageDialog(null, "Success");
                                                App.frame.setContentPane(new AdminHome().getAdminHomePanel());
                                                App.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                App.frame.pack();
                                                App.frame.setVisible(true);
                                            } else {
                                                JOptionPane.showMessageDialog(null, "Failed");
                                            }
                                        } else {
                                            JOptionPane.showMessageDialog(null, "Admin Secret is not Valid");
                                        }
                                    } else if (roleComboBox.getSelectedItem().toString().equals("Teacher")) {
                                        if (controller.signup_user(fullNameTextField.getText(), usernameTextField.getText(), String.valueOf(passwordField1.getPassword()), birthday, (String) roleComboBox.getSelectedItem())) {
                                            JOptionPane.showMessageDialog(null, "Success");
                                            App.frame.setContentPane(new TeacherHome().getTeacherHomePanel());
                                            App.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                            App.frame.pack();
                                            App.frame.setVisible(true);
                                        } else {
                                            JOptionPane.showMessageDialog(null, "Failed");
                                        }
                                    }

                                } else {
                                    JOptionPane.showMessageDialog(null, "Username is available");
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Add correct birthday");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Passwords are not match");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Minimum password length is 4");
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Please fill the form correctly");
                }

            }
        });

        roleComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (roleComboBox.getSelectedItem().toString().equals("Admin")) {
                    adminSecretLabel.setVisible(true);
                    adminSecretTextField.setVisible(true);
                    adminSecretTextField.setEnabled(true);
                } else {
                    adminSecretLabel.setVisible(false);
                    adminSecretTextField.setEnabled(false);
                    adminSecretTextField.setVisible(false);
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


    public JPanel getSignupPanel() {
        return signupPanel;
    }


    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        signupPanel = new JPanel();
        signupPanel.setLayout(new GridLayoutManager(9, 2, new Insets(0, 0, 0, 0), -1, -1));
        final JLabel label1 = new JLabel();
        label1.setText("Full Name");
        signupPanel.add(label1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        fullNameTextField = new JTextField();
        signupPanel.add(fullNameTextField, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("Username");
        signupPanel.add(label2, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        usernameTextField = new JTextField();
        signupPanel.add(usernameTextField, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label3 = new JLabel();
        label3.setText("Birthday");
        signupPanel.add(label3, new GridConstraints(4, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label4 = new JLabel();
        label4.setText("Password");
        signupPanel.add(label4, new GridConstraints(5, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label5 = new JLabel();
        label5.setText("Re-enter Password");
        signupPanel.add(label5, new GridConstraints(6, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        submitButton = new JButton();
        submitButton.setText("Submit");
        signupPanel.add(submitButton, new GridConstraints(7, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label6 = new JLabel();
        label6.setText("User role");
        signupPanel.add(label6, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        roleComboBox = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel1 = new DefaultComboBoxModel();
        defaultComboBoxModel1.addElement("Teacher");
        defaultComboBoxModel1.addElement("Admin");
        roleComboBox.setModel(defaultComboBoxModel1);
        signupPanel.add(roleComboBox, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        passwordField2 = new JPasswordField();
        passwordField2.setText("");
        signupPanel.add(passwordField2, new GridConstraints(6, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        passwordField1 = new JPasswordField();
        signupPanel.add(passwordField1, new GridConstraints(5, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        birthdayPanel = new JPanel();
        birthdayPanel.setLayout(new GridLayoutManager(1, 3, new Insets(0, 0, 0, 0), -1, -1));
        signupPanel.add(birthdayPanel, new GridConstraints(4, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        yearComboBox = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel2 = new DefaultComboBoxModel();
        defaultComboBoxModel2.addElement("Year");
        yearComboBox.setModel(defaultComboBoxModel2);
        birthdayPanel.add(yearComboBox, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        monthComboBox = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel3 = new DefaultComboBoxModel();
        defaultComboBoxModel3.addElement("Month");
        monthComboBox.setModel(defaultComboBoxModel3);
        birthdayPanel.add(monthComboBox, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        dateComboBox = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel4 = new DefaultComboBoxModel();
        defaultComboBoxModel4.addElement("Date");
        dateComboBox.setModel(defaultComboBoxModel4);
        birthdayPanel.add(dateComboBox, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        adminSecretTextField = new JTextField();
        adminSecretTextField.setEnabled(false);
        adminSecretTextField.setText("");
        adminSecretTextField.setVisible(false);
        signupPanel.add(adminSecretTextField, new GridConstraints(3, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        adminSecretLabel = new JLabel();
        adminSecretLabel.setText("Admin Secret");
        adminSecretLabel.setVisible(false);
        signupPanel.add(adminSecretLabel, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        homeButton = new JButton();
        homeButton.setText("Home");
        signupPanel.add(homeButton, new GridConstraints(8, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return signupPanel;
    }

}
