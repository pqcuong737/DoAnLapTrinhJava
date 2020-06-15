/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import GUI.thongbao;

/**
 *
 * @author ADMIN
 */
public class BLL_ThuePhong {
    public static boolean KT_Them(DTO.DTO_ThuePhong add){
         String ktNgay = "\\d{1,2}[-|/]\\d{1,2}[-|/]\\d{4}";//biểu thức chính qua kt ngày
         String kt = "[0-9]{1,99}";

      
        if (!add.getSoNguoi().matches(kt)) {
            thongbao.thongbao("Nhập số vào số người", "");
        }
        return true;
    }
}
