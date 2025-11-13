/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.testcarro;

import java.util.Scanner;
import javax.swing.JFrame;

import javax.swing.SwingUtilities;

public class TestCarro {

    public static void main(String[] args) {
       
          SwingUtilities.invokeLater(() -> {
            new ExecultCarro();  // chama a GUI
        });
    }
        
    }

