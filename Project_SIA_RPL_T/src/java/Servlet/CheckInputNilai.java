/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

/**
 *
 * @author Lycorice
 */
public class CheckInputNilai {
    public int ChedckNilai(String i1,String i2,String i3,String i4){
        double a = Double.parseDouble(i1);
        double b = Double.parseDouble(i2);
        double c = Double.parseDouble(i3);
        double d = Double.parseDouble(i4);
        if (0<=a&&a<=100&&0<=b&&b<=100&&0<=c&&c<=100&&0<=d&&d<=100) {
            return 0;
        }
        else return 1;
    }
    public String CheckTandaBaca(String word){
        if (word.contains(",")) {
            return word.replace(",", ".");
        }
        return word;
    }
    public boolean CheckTypeDataInteger(String data){
        try {
            int a=Integer.parseInt(data);
        } catch (Exception ex){
            return false;
        }
        return true;
    }
}
