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
public class BLL_Khac {
    public static boolean KT_Sua(DTO.DTO_Khac a){
        if (a.getMoc2()>=a.getMoc1()) {
            thongbao.thongbao("Checkin 2 phải lớn hơn checkin 1", "");
            return false;
        }
        if (a.getMoc4()>=a.getMoc3()) {
            thongbao.thongbao("Checkout 2 phải lớn hơn checkout 1", "");
            return false;
        }
    return true;
    }
}
