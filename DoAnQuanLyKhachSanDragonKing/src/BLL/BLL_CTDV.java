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
public class BLL_CTDV {
    public static boolean KT_Them(DTO.DTO_CTDV ctdv){
        if (ctdv.getMaDV().trim().equals("")) {
            thongbao.thongbao("Chưa chọn dịch vụ", "");
            return false;
        }
        return true;
    }
}
