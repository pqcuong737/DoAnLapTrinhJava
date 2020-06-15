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
public class DAO_Khac {

    public static ResultSet LayBangKhac(int ID) {
        String sql = "SELECT *FROM [dbo].[Khac] where ID=" + ID + "";
        return connection.Getdata(sql);
    }

    public static void Update(DTO.DTO_Khac a) {
        String sql = "UPDATE [dbo].[Khac] "
                + "   SET [GiaTriSo] = " + a.getMoc1() + " "
                + "      ,[GiaTriTG] = '" + a.getCheckIn() + "' "
                + "       "
                + " WHERE ID=3";
        String sql1 = "UPDATE [dbo].[Khac] "
                + "   SET [GiaTriSo] = " + a.getMoc2() + " "
                + "WHERE ID=4";
        String sql2 = "UPDATE [dbo].[Khac] "
                + "   SET [GiaTriSo] = " + a.getMoc3() + " "
                + "   ,[GiaTriTG]='" + a.getCheckOut() + "' "
                + "WHERE ID=6";
        String sql3 = "UPDATE [dbo].[Khac] "
                + "   SET [GiaTriSo] = " + a.getMoc4() + " "
                + "   ,[GiaTriTG]='" + a.getCheckOut() + "' "
                + "WHERE ID=5";
        String sql4 = "UPDATE [dbo].[Khac] "
                + "   SET [GiaTriSo] = " + a.getPhuthu2() + " "
                + "   WHERE ID=7";
        String sql5 = "UPDATE [dbo].[Khac] "
                + "   SET [GiaTriSo] = " + a.getPhuthu1() + " "
                + "   WHERE ID=8";
        String sql6 = "UPDATE [dbo].[Khac] "
                + "   SET [GiaTriSo] = " + a.getPhuthu4() + " "
                + "   WHERE ID=9";
        String sql7 = "UPDATE [dbo].[Khac] "
                + "   SET [GiaTriSo] = " + a.getPhuthu3() + " "
                + "   WHERE ID=10";
        connection.ExecuteTruyVan(sql);
        connection.ExecuteTruyVan(sql1);
        connection.ExecuteTruyVan(sql2);
        connection.ExecuteTruyVan(sql3);
        connection.ExecuteTruyVan(sql4);
        connection.ExecuteTruyVan(sql5);
        connection.ExecuteTruyVan(sql6);
        connection.ExecuteTruyVan(sql7);
        
    }
}
