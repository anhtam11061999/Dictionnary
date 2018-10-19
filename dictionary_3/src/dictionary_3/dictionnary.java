/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary_3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/**
 *
 * @author AnhTam
 */
public class dictionnary {
     public  String fname = "word.txt";
    ArrayList <String> words= new ArrayList<>();
    public void Menu() {
        System.out.println("1. Them tu");
        System.out.println("2. Tim kiem");
        System.out.println("3. Xoa tu");
        System.out.println("4. Sua tu");
        System.out.println("5. In ra tat ca cac tu");
        System.out.println("6. Luu");
        System.out.println("7. Thoat");
        System.out.println("Lua chon: ");
    }
    public void addword(){
        addwords:
        while(true){
        String word;
        String mean;
        String type;
        Scanner input = new Scanner(System.in);
        int n = words.size();
        System.out.println("STT: "+(n+1));
        System.out.println("Nhap tu: ");
        word = input.next().toLowerCase();
        System.out.println("Nhap nghia: ");
        Scanner input2 = new Scanner(System.in);
        mean = input2.nextLine();
        System.out.println("Nhap loai cua tu: ");
        Scanner input1 = new Scanner(System.in);
        type = input1.nextLine();
        String add = "$"+word+"$"+mean+"$"+type;
        words.add(n, add);
        
          String yeucau;
            do {
                System.out.println("Ban co muon nhap them tu(Y/N): ");
                input = new Scanner(System.in);
                yeucau = input.next().toUpperCase();
                if (yeucau.equals("N")) {
                    break addwords;
                }
            } while (!yeucau.equals("Y") && !yeucau.equals("N"));}
    }
   public void search(){
       int i;
        Scanner input = new Scanner(System.in);
        String searchword;
        if (words.size() == 0) {
            System.out.println("Tu Dien Hien Dang Khong Co Tu Nao");
        } else {
            System.out.println("Nhap tu ban muon tim: ");
            searchword = input.next().toLowerCase();
         for(i = 0;i<words.size();i++){
             if(words.get(i).startsWith(searchword))
             {
                 System.out.println(""+words.get(i));
             }else System.out.println("Khong tim thay tu ban muon tim.");
         }      
       }
   }
    
   public void delete(){
         String deleteword;
         int i ;
         Scanner input = new Scanner(System.in);
        if (words.size() == 0) {
            System.out.println("Tu dien khong co tu.");

        } else {
            System.out.println("Nhap tu muon xoa: ");
            deleteword = input.next().toLowerCase();
             for(i = 0;i<words.size();i++){
             if(words.get(i).startsWith(deleteword))
             {
                 words.remove(i);
             }
             else System.out.println("Khong tim thay tu can xoa trong tu dien.");}
        }
   }
   
   public void edit(){
        String editword;
        String newword;
        String newmean;
        String newtype;
        Scanner input = new Scanner(System.in);
        System.out.println("Nhap tu can sua: ");
        editword = input.next().toLowerCase();
        int i;
        int a;
        for(i=0;i<words.size();i++){
            if(words.get(i).startsWith(editword))
            {   
                 a = i;
                System.out.println(""+words.get(i));
                System.out.print("Nhap thong tin cua tu thay the: ");
                System.out.println("Nhap tu: ");
                newword = input.next().toLowerCase();
                System.out.println("Nhap nghia: ");
                newmean = input.next().toLowerCase();
                System.out.println("Nhap loai cua tu: ");
                newtype = input.next().toLowerCase();
                String add = "$"+newword+"$"+newmean+"$"+newtype;
                String yeucau;
                 do {
                System.out.println("Xac nhan sua tu(Y/N): ");
                input = new Scanner(System.in);
                yeucau = input.next().toUpperCase();
                if (yeucau.equals("N")) {
                    break;
                }
                else {
                    words.remove(a);
                    words.add(add);
                    System.out.println("Da cap nhat tu thanh cong.");
                }
                    
            } while (!yeucau.equals("Y") && !yeucau.equals("N"));}
         
                }
            }
        
     public void file() {
        BufferedWriter Bu = null;
        FileWriter Fi = null;
        try {
            String dt = "";
            File file = new File(fname);
            if (!file.exists()) {
                file.createNewFile();
            }
            Fi = new FileWriter(file.getAbsoluteFile(), true);
            Bu = new BufferedWriter(Fi);
            int i;
            for (i = 0; i < words.size(); i++) {
                dt = words.get(i)+"\r";
                Bu.write(dt);
                dt = "";

            }
            Bu.write(dt);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (Bu != null) {
                    Bu.close();
                }
                if (Fi != null) {
                    Fi.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    } 
    public void readfile() { 
        ArrayList <String> words = new ArrayList<>();
        File f = new File(fname);
        try {
            Scanner sc = new Scanner(f);
            try {
                while (sc.hasNextLine()) {
                	String[] str = sc.nextLine().split("$",3);
                        words.add("$"+str[0]+"$"+str[1]+"$"+str[2]);
           
                }
            } catch (Exception e) {
            } finally {
                Collections.sort(words);
                if (sc != null) {
                    sc.close();
                }
            }
        } catch (Exception ep) {
        }
    }

    public void delfile() {
        File file = new File(fname);

        file.delete();

    }
    
    public void print(){
        for (String obj : words) {
            System.out.print("" + obj + " ");
        }
        System.out.println();
    }
    public void use_menu()  {
   dictionnary td = new dictionnary();
        while (true) {
            td.Menu();
            int chon;
            Scanner input = new Scanner(System.in);
            chon = input.nextInt();
            switch (chon) {
                case 1:
                    td.addword();
                    break;
                case 2:
                    td.search();
                    break;
                case 3:
                    td.delete();
                    break;
                case 4:
                    td.edit();
                    break;
                case 5:
                    td.print();
                    break;
                case 6:
                    td.delfile();
                    td.file();
                    System.out.println("da luu vao file");
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Nhap so tu 1->7");
                    break;
            }
        }
}
   
}
