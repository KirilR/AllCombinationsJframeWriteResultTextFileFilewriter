package com.company;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.LinkedList;
import javax.swing.*;
import java.util.List;


public class Swingtest extends JFrame implements ActionListener {


    JTextField txtdata;
    JTextField txdataResult;
    JButton calbtn = new JButton("Calculate");
    JButton calbtn2 = new JButton("Clear List");
    JButton calbtn3 = new JButton("write to file");
    public static List<String> lista = new LinkedList<String>();
    Filea filea = new Filea();
    public Swingtest() {
        JPanel myPanel = new JPanel();
        this.add(myPanel);
        // myPanel.setLayout(new GridLayout(3, 2));
        myPanel.setSize(400, 600);
        myPanel.add(calbtn);
        myPanel.add(calbtn2);
        myPanel.add(calbtn3);
        calbtn.addActionListener(this);
        calbtn2.addActionListener(this);
        calbtn3.addActionListener(this);
        txtdata = new JTextField(20);
        txdataResult = new JTextField(20);
        myPanel.add(txtdata);
        myPanel.add(txdataResult);
        myPanel.setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calbtn) {
            String data = txtdata.getText(); //perform your operation
            permute(data,0,data.length()-1);
            txdataResult.setText(lista.toString());
        }
        if(e.getSource()==calbtn2){
            lista.clear();
            txdataResult.setText(" ");
        }
        if(e.getSource()==calbtn3){
            filea.testFileChooser(lista);
        }

    }



    
    
    
    
    


    static void permute(String str, int l, int r) {
        if (l == r)
            lista.add(str);
        else {
            for (int i = l; i <= r; i++) {
                str = swap(str, l, i);
                permute(str, l + 1, r);
                str = swap(str, l, i);
            }
        }
    }

    /**
     * Swap Characters at position
     *
     * @param a string value
     * @param i position 1
     * @param j position 2
     * @return swapped string
     */
    public static String swap(String a, int i, int j) {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
}

