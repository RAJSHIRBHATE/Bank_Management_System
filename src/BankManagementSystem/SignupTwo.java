package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;


public class SignupTwo extends JFrame implements ActionListener {

    JTextField pan, Aadhar;
    JRadioButton syes, sno, eyes, eno;
    JButton next;
    JComboBox religion, category, income, occupation, education;
    String formno;


    SignupTwo(String formno) {

        this.formno = formno;

        setLayout(null);


        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");



        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(290, 80, 300, 30);
        add(additionalDetails);

        JLabel name = new JLabel("Religion: ");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 160, 100, 30);
        add(name);

        String valReligion[] = {"Hindu", "Muslim", "Sikh", "Christian", "Other"};
        religion = new JComboBox(valReligion);
        religion.setBounds(300, 160, 400, 30);
        religion.setBackground(Color.white);
        add(religion);


        JLabel Fname = new JLabel("Category: ");
        Fname.setFont(new Font("Raleway", Font.BOLD, 20));
        Fname.setBounds(100, 210, 200, 30);
        add(Fname);

        String valCategory[] = {"General", "OBC", "SC", "ST", "Other"};
        category = new JComboBox(valCategory);
        category.setBounds(300, 210, 400, 30);
        category.setBackground(Color.white);
        add(category);

        JLabel dob = new JLabel("Income: ");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100, 260, 200, 30);
        add(dob);

        String incomeCategory[] = {"Null", "< 1,50,500 ", "< 2,50,000", "< 5,00,000", "Upto 10,00,000"};
        income = new JComboBox(incomeCategory);
        income.setBounds(300, 260, 400, 30);
        income.setBackground(Color.white);
        add(income);


        JLabel gender = new JLabel("Educational");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100, 310, 200, 30);
        add(gender);

        JLabel email = new JLabel("Qualification: ");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100, 335, 200, 30);
        add(email);

        String educationValues[] = {"Non Graduation", "Graduate", "Post Graduate", "Doctrate", "Others"};
        education = new JComboBox(educationValues);
        education.setBounds(300, 335, 400, 30);
        education.setBackground(Color.white);
        add(education);


        JLabel mstatus = new JLabel("Occupation: ");
        mstatus.setFont(new Font("Raleway", Font.BOLD, 20));
        mstatus.setBounds(100, 410, 200, 30);
        add(mstatus);

        String occupationValues[] = {"Salaried", "Self Employed", "Bussiness", "Student", "Retired" , "Others"};
        occupation = new JComboBox(occupationValues);
        occupation.setBounds(300, 410, 400, 30);
        occupation.setBackground(Color.white);
        add(occupation);


        JLabel address = new JLabel("PAN No: ");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100, 460, 200, 30);
        add(address);

        pan = new JTextField();
        pan.setFont(new Font("Raleway", Font.BOLD, 14));
        pan.setBounds(300, 460, 400, 30);
        add(pan);

        JLabel city = new JLabel("Aadhar No: ");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100, 510, 200, 30);
        add(city);

        Aadhar = new JTextField();
        Aadhar.setFont(new Font("Raleway", Font.BOLD, 14));
        Aadhar.setBounds(300, 510, 400, 30);
        add(Aadhar);

        JLabel state = new JLabel("Senior Citizen: ");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100, 560, 200, 30);
        add(state);

        syes = new JRadioButton("Yes");
        syes.setBounds(300, 560, 100, 30);
        syes.setBackground(Color.white);
        add(syes);

        sno = new JRadioButton("No");
        sno.setBounds(450, 560, 100, 30);
        sno.setBackground(Color.white);
        add(sno);

        ButtonGroup mstatusGroup = new ButtonGroup();
        mstatusGroup.add(syes);
        mstatusGroup.add(sno);



        JLabel pincode = new JLabel("Existing Account: ");
        pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        pincode.setBounds(100, 610, 200, 30);
        add(pincode);

        eyes = new JRadioButton("Yes");
        eyes.setBounds(300, 610, 100, 30);
        eyes.setBackground(Color.white);
        add(eyes);

        eno = new JRadioButton("No");
        eno.setBounds(450, 610, 100, 30);
        eno.setBackground(Color.white);
        add(eno);

        ButtonGroup mastatusGroup = new ButtonGroup();
        mastatusGroup.add(eyes);
        mastatusGroup.add(eno);

        next = new JButton("Next");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 650, 80, 30);
        next.addActionListener(this);
        add(next);


        getContentPane().setBackground(Color.white);

        setSize(850, 850);
        setLocation(350, 10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        String sreligion = (String) religion.getSelectedItem();
        String scategory = (String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();
        String sseniorCitizen = null;
        if (syes.isSelected()) {
            sseniorCitizen = "Yes";
        } else if (sno.isSelected()) {
            sseniorCitizen = "No";
        }


        String existingaccount = null;
        if (eyes.isSelected()) {
            existingaccount = "Yes";
        } else if (eno.isSelected()) {
            existingaccount = "No";
        }

        String span = pan.getText();
        String saadhar = Aadhar.getText();



        try {
                Conn c = new Conn();
                String query = "insert into signupTwo values('"+formno+"', '"+sreligion+"' , '"+scategory+"' , '"+sincome+"', '"+seducation+"', '"+soccupation+"', '"+span+"', '"+saadhar+"' , '"+sseniorCitizen+"' ,'"+existingaccount+"')";
                c.s.executeUpdate(query);

                setVisible(false);
                new SignupThree(formno).setVisible(true);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main (String args[]){

        new SignupTwo("");
    }

}

