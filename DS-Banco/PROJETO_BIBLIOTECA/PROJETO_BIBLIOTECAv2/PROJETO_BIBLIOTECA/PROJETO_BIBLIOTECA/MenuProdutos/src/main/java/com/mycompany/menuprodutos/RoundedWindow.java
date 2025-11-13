/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.menuprodutos;

// RoundedWindow.java
import java.awt.geom.RoundRectangle2D;
import java.awt.Shape;

public class RoundedWindow {
    public static Shape createRoundedWindowShape(int width, int height, int cornerRadius) {
        return new RoundRectangle2D.Double(0, 0, width, height, cornerRadius, cornerRadius);
    }
}