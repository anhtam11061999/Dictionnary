/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary_java_2;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/**
 * 
 * 
 
 * @author AnhTam
 */
public class dictionary {
    ArrayList <String> words= new ArrayList<>();
  
    public void addword(String word, String mean, String type){    
        String add = ""+word+"\t"+mean+"\t"+type;
        words.add(add);
//        return "Đã thêm thành công";
//       
    }
   public String search(String a){
       int i;
       String s = null;
         for(i = 0;i<words.size();i++){
             if(words.get(i).startsWith(a))
             {  
                String[] str = words.get(i).split("\t");
                s = "Từ: "+str[0]+"\t Nghĩa: "+str[1]+"\t Loại: "+str[2];
             }else s = "Khong tim thay tu.";
         }      
       return s;
   }
    
   public String delete(String a){
         int i ;
         String s = null;
             for(i = 0;i<words.size();i++){
             if(words.get(i).startsWith(a))
             {
                 words.remove(i);
                 s = "Da xoa thanh cong.";
             }
             else s = "Khong tim thay tu muon xoa.";
        }
             return s;
   }
   
   public String edit(String a, String type, String newword, String newmean){
       
        int i;
        String s = null;
        for(i=0;i<words.size();i++){
            if(words.get(i).startsWith(a))
            {       
                    String add;
                    add = newword+newmean+type;
                    words.remove(i);
                    words.add(add);
                   s = words.get(i);
                } else s = "Không tìm thấy từ cần sửa.";
        }
              return s;
            
   }
     public void print(){
        for (String obj : words) {
            System.out.print("" + obj + " ");
        }
        System.out.println();
    }
}
