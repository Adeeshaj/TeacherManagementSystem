package com.vector.school.UI;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.vector.school.App;
import com.vector.school.Controller.TeacherProfile_controller;
import com.vector.school.DBquery.Teacher_db;
import com.vector.school.model.Teacher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Arrays;
import java.util.Date;


public class TeacherProfile {
    private JLabel namelabel;
    private JLabel DPlabel;
    private JLabel birthdaylabel;
    private JLabel firstAppointDateLabel;
    private JLabel sclAppointDateLabel;
    private JLabel SubjectsLabel;
    private JLabel eduQuaLabel;
    private JLabel profQua;
    private JLabel nidLabel;
    private JLabel addressLabel;
    private JLabel mobileLabel;
    private JLabel availbilityLabel;
    private JPanel teacherProfilePanel;
    private JButton editbutton;
    private String osname = System.getProperty("os.name", "").toLowerCase();

    public TeacherProfile() {
        $$$setupUI$$$();
        Teacher teacher = new TeacherProfile_controller().getTeacher(App.cacheUser);
        setAddressLabel(null);
        if (teacher != null) {

            setAddressLabel(teacher.getAddress());
            setAvailbilityLabel(teacher.getAvailablity());
            setBirthdaylabel(teacher.getBirthday());
            setDPlabel(teacher.getTeacher_prof_pic(), teacher.get_id());
            setEduQuaLabel(teacher.getEdu_qualification());
            setFirstAppointDateLabel(teacher.getFirst_apointment_date());
            setMobileLabel(teacher.getMobile());
            setNamelabel(teacher.getName());
            setNidLabel(teacher.getNid());
            setProfQua(teacher.getProf_qualification());
            setSclAppointDateLabel(teacher.getSchool_apointment_date());
            setSubjectsLabel(teacher.getSubjects());

        }

        editbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                App.frame.setContentPane(new TeacherProfileEdit().getTeacherProfileEditPanel());
                App.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                App.frame.pack();
                App.frame.setVisible(true);
            }
        });
    }

    private void setNamelabel(String namelabel) {
        this.namelabel.setText(namelabel);
    }

    private void setDPlabel(String DPlabel, String user_id) {
        String fileExtention = DPlabel.substring(DPlabel.lastIndexOf(".") + 1);
        ImageIcon profPic;
        if (osname.startsWith("windows")) {
            if (new File(System.getProperty("user.home") + "\\TeacherMangementSystem\\ProfilePictures\\" + user_id + "." + fileExtention).exists()) {
                profPic = new ImageIcon("/" + System.getProperty("user.home") + "\\TeacherMangementSystem\\ProfilePictures\\" + user_id + "." + fileExtention);
            } else {
                profPic = new ImageIcon(getClass().getResource("\\28059339_2020339611540354_546116633399078264_n.jpg"));
            }
        } else if (osname.startsWith("linux")) {
            if (new File(System.getProperty("user.home") + "/TeacherMangementSystem/ProfilePictures/" + user_id + "." + fileExtention).exists()) {
                profPic = new ImageIcon("/" + System.getProperty("user.home") + "/TeacherMangementSystem/ProfilePictures/" + user_id + "." + fileExtention);
            } else {
                profPic = new ImageIcon(getClass().getResource("/28059339_2020339611540354_546116633399078264_n.jpg"));
            }
        } else {
            profPic = new ImageIcon(getClass().getResource("/28059339_2020339611540354_546116633399078264_n.jpg"));
        }

        System.out.println(profPic.toString());
        this.DPlabel.setSize(profPic.getIconWidth(), profPic.getIconHeight());
        this.DPlabel.setMaximumSize(new Dimension(profPic.getIconWidth(), profPic.getIconHeight()));
        this.DPlabel.setIcon(profPic);
    }

    private void setBirthdaylabel(Date birthdaylabel) {
        if (birthdaylabel != null)
            this.birthdaylabel.setText(birthdaylabel.toString());
    }

    private void setFirstAppointDateLabel(Date firstAppointDateLabel) {
        if (firstAppointDateLabel != null)
            this.firstAppointDateLabel.setText(firstAppointDateLabel.toString());
    }

    private void setSclAppointDateLabel(Date sclAppointDateLabel) {
        if (sclAppointDateLabel != null)
            this.sclAppointDateLabel.setText(sclAppointDateLabel.toString());
    }

    private void setSubjectsLabel(String[] subjectsLabel) {
        if (subjectsLabel != null)
            SubjectsLabel.setText(Arrays.toString(subjectsLabel));
    }

    private void setEduQuaLabel(String eduQuaLabel) {
        this.eduQuaLabel.setText(eduQuaLabel);
    }

    private void setProfQua(String profQua) {
        this.profQua.setText(profQua);
    }

    private void setNidLabel(String nidLabel) {
        this.nidLabel.setText(nidLabel);
    }

    private void setAddressLabel(String addressLabel) {
        this.addressLabel.setText(addressLabel);
    }

    private void setMobileLabel(String mobileLabel) {
        this.mobileLabel.setText(mobileLabel);
    }

    private void setAvailbilityLabel(Boolean availbilityLabel) {
        if (availbilityLabel != null) {
            this.availbilityLabel.setText(availbilityLabel.toString());
        }

    }

    public JPanel getTeacherProfilePanel() {
        return teacherProfilePanel;
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
        teacherProfilePanel = new JPanel();
        teacherProfilePanel.setLayout(new GridBagLayout());
        final JLabel label1 = new JLabel();
        label1.setText("Full name");
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        teacherProfilePanel.add(label1, gbc);
        namelabel = new JLabel();
        namelabel.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        teacherProfilePanel.add(namelabel, gbc);
        final JLabel label2 = new JLabel();
        label2.setText("Profile picture");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        teacherProfilePanel.add(label2, gbc);
        DPlabel = new JLabel();
        DPlabel.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        teacherProfilePanel.add(DPlabel, gbc);
        final JLabel label3 = new JLabel();
        label3.setText("Birthday");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        teacherProfilePanel.add(label3, gbc);
        birthdaylabel = new JLabel();
        birthdaylabel.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        teacherProfilePanel.add(birthdaylabel, gbc);
        final JLabel label4 = new JLabel();
        label4.setText("First Appointment Date");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        teacherProfilePanel.add(label4, gbc);
        final JLabel label5 = new JLabel();
        label5.setText("School Appointment Date");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        teacherProfilePanel.add(label5, gbc);
        final JLabel label6 = new JLabel();
        label6.setText("Subjects");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        teacherProfilePanel.add(label6, gbc);
        final JLabel label7 = new JLabel();
        label7.setText("Educational Qualification");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        teacherProfilePanel.add(label7, gbc);
        final JLabel label8 = new JLabel();
        label8.setText("Profesional Qualification");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        teacherProfilePanel.add(label8, gbc);
        final JLabel label9 = new JLabel();
        label9.setText("National ID No.");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        teacherProfilePanel.add(label9, gbc);
        final JLabel label10 = new JLabel();
        label10.setText("Address");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        teacherProfilePanel.add(label10, gbc);
        final JLabel label11 = new JLabel();
        label11.setText("Mobile Number");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 11;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        teacherProfilePanel.add(label11, gbc);
        final JLabel label12 = new JLabel();
        label12.setText("Availbility");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 12;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        teacherProfilePanel.add(label12, gbc);
        firstAppointDateLabel = new JLabel();
        firstAppointDateLabel.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        teacherProfilePanel.add(firstAppointDateLabel, gbc);
        sclAppointDateLabel = new JLabel();
        sclAppointDateLabel.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        teacherProfilePanel.add(sclAppointDateLabel, gbc);
        SubjectsLabel = new JLabel();
        SubjectsLabel.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        teacherProfilePanel.add(SubjectsLabel, gbc);
        eduQuaLabel = new JLabel();
        eduQuaLabel.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        teacherProfilePanel.add(eduQuaLabel, gbc);
        profQua = new JLabel();
        profQua.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 8;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        teacherProfilePanel.add(profQua, gbc);
        nidLabel = new JLabel();
        nidLabel.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 9;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        teacherProfilePanel.add(nidLabel, gbc);
        addressLabel = new JLabel();
        addressLabel.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 10;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        teacherProfilePanel.add(addressLabel, gbc);
        mobileLabel = new JLabel();
        mobileLabel.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 11;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        teacherProfilePanel.add(mobileLabel, gbc);
        availbilityLabel = new JLabel();
        availbilityLabel.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 12;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        teacherProfilePanel.add(availbilityLabel, gbc);
        editbutton = new JButton();
        editbutton.setEnabled(true);
        editbutton.setText("Edit");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        teacherProfilePanel.add(editbutton, gbc);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return teacherProfilePanel;
    }
}
