package GUI;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ADMIN
 */
public class mycombobox {
    Object value;//lưu mã
    Object text;// lưu tên

    

   

    public mycombobox(Object value, Object text) {
        this.value = value;
        this.text = text;
    }
    
    
    @Override
    public String toString(){
    return text.toString();
        
    }
    

}