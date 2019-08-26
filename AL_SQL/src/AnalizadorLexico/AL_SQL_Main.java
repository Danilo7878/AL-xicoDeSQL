/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnalizadorLexico;

import java.io.File;

/**
 *
 * @author danil
 */
public class AL_SQL_Main {
    public static void main(String[] args) {
         File rootDir = new File("");
        String path = rootDir.getAbsolutePath();        
        path = path.concat("/src/AnalizadorLexico/Lexer.flex");
        File archivo = new File(path);                     
        jflex.Main.generate(archivo);
        
        MiniSQL abrir = new MiniSQL();
        abrir.setVisible(true);
    }
}
