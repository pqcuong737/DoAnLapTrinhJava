/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.ResultSet;

/**
 *
 * @author ADMIN
 */
public class DAO_DangNhap {

    public static ResultSet LayTaiKhoanTheoMa(String TK) {
        String sql = "SELECT * FROM [dbo].[User] where TenUser =N'" + TK + "'";
        return connection.Getdata(sql);
    }

    public static ResultSet LayTaiKhoan() {

        String sql = "SELECT * FROM [dbo].[User]";
        return connection.Getdata(sql);
    }
}
