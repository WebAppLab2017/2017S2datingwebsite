/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import db.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import model.*;

/**
 *
 * @author thanh_000
 */
public class DAO {

    public DAO() {

    }

    DatabaseConnection db = new DatabaseConnection();
    Connection con = null;

    public boolean checkLogin(String username, String password) throws SQLException {
        ResultSet rs = null;
        con = db.setConnection();
        try {

            String sql = "Select * From webproject.account Where username='" + username + "' and password='" + password + "'";
            rs = db.getResult(sql, con);
            boolean result = rs.next();

            if (result) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rs.close();
            con.close();
        }
        return false;
    }

//    public boolean register(String username, String pass, String fullname, String email, String phone, int role) {
//        con = db.setConnection();
//        try {
//
//            String sql = "Insert Into account (Fullname,Username,Pass_word,Email,Phone_Num,Role_ID)" + "values(?,?,?,?,?,?)";
//            PreparedStatement ps = con.prepareStatement(sql);
//            ps.setString(1, fullname);
//            ps.setString(2, username);
//            ps.setString(3, pass);
//            ps.setString(4, email);
//            ps.setString(5, phone);
//            ps.setInt(6, role);
//            int result = ps.executeUpdate();
//            ps.close();
//            con.close();
//            if (result > 0) {
//                return true;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return false;
//    }
    public boolean updatePerson(String username, String pass, String fullname, String email, String phone) {
        con = db.setConnection();
        try {

            String sql = "update account set Fullname ='" + fullname + "',Email = '" + email + "',Phone_Num = '" + phone + "',Pass_word = '" + pass + "' where Username ='" + username + "'";
            db.getResultDo(sql, con);
            con.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean addGenre(String genreName) {

        con = db.setConnection();
        try {

            String sql = "Insert Into genre (Genre_Name) values('" + genreName + "')";
            PreparedStatement ps = con.prepareStatement(sql);
            int result = ps.executeUpdate();
            ps.close();
            con.close();
            if (result > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean insertReal(String street, String ward, String district, int price, int id_range, int id_user, int id_transaction_type,
            String description, String owner_email, int phone, String[] url, int bed, int toilet, int category, String fullname) {
        con = db.setConnection();
        try {
            String sql = "Insert Into project.realestate (street,wart,district,price,id_range,id_transaction_type,id_user,description,owner_email, phone,category,full_name) values(?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, street);
            ps.setString(2, ward);
            ps.setString(3, district);
            ps.setInt(4, price);
            ps.setInt(5, id_range);
            ps.setInt(6, id_transaction_type);
            ps.setInt(7, id_user);
            ps.setString(8, description);
            ps.setString(9, owner_email);
            ps.setInt(10, phone);
            ps.setInt(11, category);
            ps.setString(12, fullname);
            int result = ps.executeUpdate();
            System.out.print(sql);
            //
            ps.close();
            con.close();

            if (result > 0) {

                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean insertPicture(String street, String ward, String district, int price, int id_range, int id_user, int id_transaction_type,
            String description, String owner_email, int phone, String[] url, int bed, int toilet, int category) {
        con = db.setConnection();
        try {
            String sql4 = "Select * from project.realestate where wart = '" + ward + "' and district = '" + district + "' and street = '" + street + "' and phone = '" + phone + "' and price = '" + price + "' and id_range = '" + id_range + "'";
            PreparedStatement stmt = con.prepareStatement(sql4);
            //stmt.setString(1, term + "%");
            ResultSet rs4 = stmt.executeQuery();
            //ResultSet rs4 = db.getResult(sql4, con);
            System.out.printf(sql4);
            int id_real = 0;
            //boolean abc = rs4.next();
            //System.out.print("jujuj " + abc);
            while (rs4.next()) {
                id_real = rs4.getInt("id_real");
            }
            PreparedStatement ps1 = null;
            System.out.println(id_real);

            for (int i = 0; i < url.length; ++i) {
                System.out.print(url[i]);
                String sql1 = "Insert Into project.real_has_picture(id_picture,id_real, url) values(?,?,?)";
                ps1 = con.prepareStatement(sql1);
                ps1.setInt(1, i + 1);
                ps1.setInt(2, id_real);
                ps1.setString(3, url[i]);
                int result = ps1.executeUpdate();
            }

            ps1.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();;

        }

        return false;
    }

    public boolean insertRoom(String street, String ward, String district, int price, int id_range, int id_user, int id_transaction_type,
            String description, String owner_email, int phone, String[] url, int bed, int toilet, int category) {
        con = db.setConnection();
        try {
            String sql4 = "Select * from project.realestate where wart = '" + ward + "' and district = '" + district + "' and street = '" + street + "' and phone = '" + phone + "' and price = '" + price + "' and id_range = '" + id_range + "'";
            PreparedStatement stmt = con.prepareStatement(sql4);
            //stmt.setString(1, term + "%");
            ResultSet rs4 = stmt.executeQuery();
            //ResultSet rs4 = db.getResult(sql4, con);
            System.out.printf(sql4);
            int id_real = 0;
            //boolean abc = rs4.next();
            //System.out.print("jujuj " + abc);
            while (rs4.next()) {
                id_real = rs4.getInt("id_real");
            }
            PreparedStatement ps1 = null;
            System.out.println(id_real);

            for (int i = 0; i < 2; ++i) {

                String sql1 = "Insert Into project.real_has_room(id_real, id_room_type, number_room) values(?,?,?)";
                ps1 = con.prepareStatement(sql1);
                ps1.setInt(1, id_real);
                ps1.setInt(2, i + 1);
                if (i == 0) {
                    ps1.setInt(3, bed);
                } else {
                    ps1.setInt(3, toilet);
                }
                int result = ps1.executeUpdate();

            }

            ps1.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateGenre(String newGenre, String oldGenre) {
        con = db.setConnection();
        try {

            String sql = "update genre set Genre_Name ='" + newGenre + "' where Genre_Name ='" + oldGenre + "'";
            db.getResultDo(sql, con);
            con.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateReal(int id_real, int price, int id_transaction_type, String description, int id_range) {
        con = db.setConnection();
        try {

            String sql = "update project.realestate set price ='" + price + "', id_transaction_type ='" + id_transaction_type + "', description ='" + description + "', id_range ='" + id_range + "'  where id_real ='" + id_real + "'";
            System.out.print(sql);
            db.getResultDo(sql, con);
            con.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean insertCareer(String content, String daytime) {
        con = db.setConnection();
        try {

            String sql = "Insert Into project.career (daytime,content) values(?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, daytime);
            ps.setString(2, content);
            int result = ps.executeUpdate();

            ps.close();
            con.close();

            if (result > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateUser(String id, String fullname, String user, String pass, String email, String phone, String role) {
        con = db.setConnection();
        try {

            String sql = "update project.account set Fullname ='" + fullname + "', Username ='" + user + "', Pass_word ='" + pass
                    + "', Email ='" + email + "', Phone_Num ='" + phone + "', Role_ID ='" + role + "' where User_ID ='" + id + "'";
            db.getResultDo(sql, con);
            con.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateMovie(String oldName, String name, String actor, String infor, String genre,
            String director, String length, String year, String place, String id, String picture, String view, String links) {
        con = db.setConnection();
        try {

            String sql = "update movie set Movie_ID ='" + id + "',Movie_Name ='" + name + "',Movie_Picture ='" + picture + "',Movie_Actor='" + actor + "',"
                    + "Movie_Information='" + infor + "',Movie_Genre='" + genre + "',Movie_Director='" + director + "',"
                    + "Movie_Length='" + length + "',Movie_Year='" + year + "',Movie_Place='" + place + "',Movie_Views='" + view + "',Movie_Links='" + links + "'"
                    + " where Movie_Name ='" + oldName + "'";
            db.getResultDo(sql, con);
            con.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteGenre(String genreName) {
        con = db.setConnection();
        try {

            String sql = "Delete from genre where Genre_Name ='" + genreName + "'";
            db.getResultDo(sql, con);
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deletereal(int id_real) {
        con = db.setConnection();
        try {

            String sql = "Delete from project.real_has_picture where id_real ='" + id_real + "'";
            db.getResultDo(sql, con);
            System.out.print(sql);
            String sq2 = "Delete from project.real_has_room where id_real ='" + id_real + "'";
            db.getResultDo(sq2, con);
            String sq3 = "Delete from project.realestate where id_real ='" + id_real + "'";
            System.out.print(sq3);
            db.getResultDo(sq3, con);
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteMovie(String movieName) {
        con = db.setConnection();
        try {

            String sql = "Delete from movie where Movie_Name ='" + movieName + "'";
            db.getResultDo(sql, con);
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteUser(String id) {
        con = db.setConnection();
        try {

            String sql = "Delete from account where User_ID ='" + id + "'";
            db.getResultDo(sql, con);
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean checkPassMD5(String username, String pass) {
        con = db.setConnection();

        try {

            String sql = "Select * From User Where Username='" + username + "' and Password='" + pass + "'";
            ResultSet rs = db.getResult(sql, con);
            boolean result = rs.next();
            rs.close();
            con.close();
            if (result) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<String> getDataForSearch(String term) {
        con = db.setConnection();
        ArrayList<String> list = new ArrayList<>();
        String SELECT = "SELECT * FROM Problem where Header like '%" + term + "%'";
        String data;
        try {

            PreparedStatement stmt = con.prepareStatement(SELECT);
            //stmt.setString(1, term + "%");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                data = rs.getString("Header");
                list.add(data);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return list;

    }

    //register
    public boolean register(String username, String password, String birthday, String phone, String email, String name, int role) {
        con = db.setConnection();
        try {

            String sql = "Insert Into webproject.account (username,password,birthday,phone,email,name, ID_role)" + "values(?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, birthday);
            ps.setString(4, phone);
            ps.setString(5, email);
            ps.setString(6, name);
            ps.setInt(7, role);
            int result = ps.executeUpdate();
            ps.close();
            con.close();
            if (result > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    //check user
    public boolean checkUser(String username) {
        con = db.setConnection();
        try {
            String sql = "Select * from webproject.account Where username='" + username + "'";
            ResultSet rs = db.getResult(sql, con);
            boolean result = rs.next();

            System.out.println(sql);
            System.out.println(result);
            rs.close();
            if (result) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<pro> getProduct(String type) {
        ArrayList<pro> products = new ArrayList<>();
        con = db.setConnection();
        try {
            String sql = "Select * from web.pro where pro.type = '" + type + "'";
            ResultSet rs = db.getResult(sql, con);
            int i = 0;
            while (rs.next()) {
                pro temp = new pro();
                temp.setID_product(rs.getInt("ID_pro"));
                temp.setName(rs.getString("name"));
                temp.setPrice(rs.getDouble("price"));
                temp.setQuantity(rs.getInt("quantity"));
                temp.setUrl(rs.getString("url"));
                temp.setType("type");
                products.add(i, temp);
                ++i;
            }
            rs.close();
            System.out.println(i);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }

    public pro productDetail(int id) {
        pro temp = new pro();
        con = db.setConnection();
        try {
            String sql = "Select * from web.pro where ID_pro ='" + id + "'";
            System.out.println(sql);
            ResultSet rs = db.getResult(sql, con);
            int i = 0;
            while (rs.next()) {

                temp.setID_product(rs.getInt("ID_pro"));
                temp.setName(rs.getString("name"));
                temp.setPrice(rs.getDouble("price"));
                temp.setQuantity(rs.getInt("quantity"));
                temp.setUrl(rs.getString("url"));
                temp.setType("type");
                ++i;
            }
            rs.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return temp;
    }

    public boolean order(shoppingCart cart, String accid) {
        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int year = localDate.getYear();
        int month = localDate.getMonthValue();
        int day = localDate.getDayOfMonth();
        con = db.setConnection();
        try {
            String sql = "Insert Into web.myorder (accid,  total) values(? , ?)";
            System.out.println(sql);
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, accid);
            ps.setDouble(2, cart.getTotal());

            int result = ps.executeUpdate();
            System.out.print(sql);
            //
            for (int i = 0; i < cart.getProducts().size(); ++i) {
                System.out.println("i " + i);
                pro temp = cart.getProducts().get(i);
                String sql1 = "update web.pro set quantity ='" + temp.getQuantity() + "' where ID_pro ='" + temp.getID_product() + "'";
                System.out.println(sql1);
                db.getResultDo(sql1, con);
                con.close();
            }
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    

    

    
    public void inserPro(String name, String price, String quantity, String type, String url)
    {
        con = db.setConnection();
        try {
            String sql = "Insert Into web.pro (name,  price, quantity, url, type) values(? , ?, ?, ? , ?)";
            System.out.println(sql);
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setDouble(2, Double.parseDouble(price));
            ps.setInt(3, Integer.parseInt(quantity));
            ps.setString(4, url);
            ps.setString(5, type);

            int result = ps.executeUpdate();
            System.out.print(sql);
            //
            
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
