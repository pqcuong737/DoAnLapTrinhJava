package DAO;


import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

//class connection để
//kết nối csdl 
//thực hiện các lệnh truy vấn 
//insert update delete
//select
public class connection {
//    tạo chuỗi hết nối

    private static String DB_URL = "jdbc:sqlserver://GLYWUL-PC;databaseName=QuanLyKhachSan;integratedSecurity=true";
    private static String USER_NAME = "";
    private static String PASSWORD = "";
    public static Connection conn = null;

    static PreparedStatement preparedStatement(String cauTruyVan) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public connection() {
        try {

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            System.out.println("connect successfully(kết nối thành công)");
        } catch (ClassNotFoundException ex) {
            System.out.println("lỗi thiếu thư viện");
        } catch (SQLException ex) {
            System.out.println("lỗi kết nối csdl");
        }

    }


    //hàm thực thi câu lệnh select
    public static ResultSet Getdata(String cauTruyVan){
        try {
            Statement stm=conn.createStatement();
            //thực thicaau truy vấn select dc truyền vào từ
            //tham số cautruyvan
            //trả về kết quả là ResultSet
            ResultSet rs=stm.executeQuery(cauTruyVan);
            return rs;//trả về resultset nếu thành công
        } catch (SQLException ex) {
            System.out.println("lỗi truy vấn");
            return null;
        }
    
    }
    // hàm thực thi 3 câu lệnh insert delete update
    public static int ExecuteTruyVan(String cauTruyVan){
        try {
            Statement stm= conn.createStatement();
            return stm.executeUpdate(cauTruyVan);
            
        } catch (SQLException ex) {
            System.out.println("lỗi thực thi truy vấn");
            return -1;
        }
    }
}
