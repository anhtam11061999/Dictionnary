/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary_java_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author AnhTam
 */
public class file {
    public void ghi(ArrayList <String> list){
        try (PrintWriter pw = new PrintWriter(new File("word.txt"))){
            for(String s: list){
                pw.println(s);                   
            }
        } catch (Exception e) {
        }
    }
   public ArrayList doc() throws FileNotFoundException{
        ArrayList<String> list = new ArrayList<>();
        Scanner sc = new Scanner(new File("word.txt"));
        try{
            while(sc.hasNextLine()){
               
                String s = new String();
                s = sc.nextLine();
                list.add(s);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public void delfile() {
        File file = new File("word.txt");
        file.delete();

    }
    
   
   
    
}
