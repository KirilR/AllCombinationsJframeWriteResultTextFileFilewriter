package com.company;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Filea extends Component {

    public  void print(Iterable<?> list) {
        for (Object element : list) {
            System.out.println(element);
        }
    }

public String getDirectoryPath(){
    JFileChooser chooser = new JFileChooser();
    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    File file = chooser.getSelectedFile();
    String fullPath = file.getAbsolutePath();
    return fullPath;
}

public void writeToFileFromList(List<String> lista) throws IOException {
    FileWriter writer = new FileWriter(getDirectoryPath());
    for(String str: lista) {
        try {
            writer.write(str + System.lineSeparator());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    try {
        writer.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}


public void testFileChooser(List<String> lista){
    JFileChooser chooser = new JFileChooser();
    chooser.addChoosableFileFilter(new FileNameExtensionFilter("*.txt", "txt"));
    chooser.showSaveDialog(this);
    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

    File file = chooser.getSelectedFile();
   // String fullPath = file.getAbsolutePath();
    try{
        FileWriter f = new FileWriter(file);
        String text = lista.toString();
        f.write(text);
        f.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}






}
