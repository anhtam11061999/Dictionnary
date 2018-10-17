/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author AnhTam
 */
public class Main {

    public static void main(String[] args)  {
        dictionary td = new dictionary();
//        td.file();
try{
        td.readfile();
        //td.file();
//        td.delfile();
        td.use_menu();
    
    }catch(Exception e){};
    
    }
}
