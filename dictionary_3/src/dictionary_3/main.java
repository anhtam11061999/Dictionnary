/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary_3;

import java.io.FileNotFoundException;

/**
 *
 * @author AnhTam
 */
public class main {

    public static void main(String[] args) throws FileNotFoundException {
        dictionnary td = new dictionnary();
        td.readfile();
        try {
            td.readfile();
            td.use_menu();

        } catch (Exception e) {
        }

    }

}
