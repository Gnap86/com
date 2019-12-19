package com.app.dao;

import com.app.sms.reader.impl.SimpleSmsReader;

import java.io.IOException;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.app.sms.reader.impl.ClientReadingSms.clientReadingSms;

public  class DaoImpl extends SimpleSmsReader implements Dao {



    DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Override
    public void save(String Phone, String TextMessages,String Data) throws IOException {
        try (Connection c = getConnection()) {
            String sql = "INSERT INTO sms.log (Phone,TextMessages,Date ) VALUES (?,?,?)";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, Phone);
            ps.setString(2, TextMessages);
            Date date =  format.parse(Data);
            ps.setTimestamp(3, new Timestamp(date.getTime()));
            ps.execute();
        } catch (Exception ex) {
            throw new RuntimeException(ex);

        }




    }
    private Connection getConnection() throws SQLException {



        return DriverManager.getConnection("jdbc:mysql://localhost:3306/sms", "root", "530433");


    }

    // Если номер Администратора
    @Override
    public boolean isadminNamber(String phoneanmber) {
        try(Connection c = getConnection()){
            String sql = "Select Count(*) From sms.phones WHERE PhoneNumber = ? AND Admin = 1";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, phoneanmber);
            ResultSet rs =   ps.executeQuery();
            while (rs.next()){
                int COUNTphonenanmber =   rs.getInt(1);

                if (COUNTphonenanmber > 0){
                    readSmsAdministrator();
                }else {



                    clientReadingSms();

                }
                return COUNTphonenanmber > 0;


            }
            rs.next();

        }catch(Exception ex){
            throw new RuntimeException(ex);

        }


        return false;
    }

    // Номер в чорном Списке ?
    @Override
    public boolean blackList(String phoneanmberblackList) {
        try(Connection c = getConnection()){
            String sql = "Select Count(*) From sms.blacklist WHERE Phone =  ? ";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, phoneanmberblackList);
            ResultSet rs =   ps.executeQuery();
            while (rs.next()){
                int COUNTphonenanmber =   rs.getInt(1);

                if (COUNTphonenanmber > 0){
                    System.out.println("Номер в чорном списке");

                }else {



                    String sms= "bash";
                    String asd= "-c";
                    String s2 = "sendsms ";
                    String s4 = " ";
                    String s3= "79827956841";
                    String s6 = "nnnn|nnnn? nnnn dd.mm.yy|nnnn on/off";
                    String s1 =  s2+s4+s3+s4 + "'" + s6 + "'";
                   // smsSend5(sms,asd,s1);



                }
                return COUNTphonenanmber > 0;




            }
            rs.next();

        }catch(Exception ex){
            throw new RuntimeException(ex);

        }


        return false;
    }


    public boolean numberOfSMSDay(String phoneanmberblackList  ) throws SQLException {
        try(Connection c = getConnection()){
            String sql = "SELECT Phone FROM sms.log WHERE date > (NOW() - INTERVAL 24 hour) group by Phone having count(*)> 5 = ? ";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1,phoneanmberblackList );
            ResultSet rs =   ps.executeQuery();
            while (rs.next()){
                int COUNTphonenanmber =   rs.getInt(1);

                if (COUNTphonenanmber > 0){


                    clientReadingSms();

                }else {



                     send1SMS();
                }
                return COUNTphonenanmber > 0;


            }
            rs.next();

        }catch(Exception ex){
            throw new RuntimeException(ex);

        }


        return false;
    }


    //Номер есть в базе?
    @Override
    public boolean smsSearch(String keyn) {
        try(Connection c = getConnection()){
            String sql = "Select Count(*) From sms.keynambers WHERE keyn = ? ";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, keyn);
            ResultSet rs =   ps.executeQuery();
            while (rs.next()){
                int COUNTphonenanmber =   rs.getInt(1);

                if (COUNTphonenanmber > 0){


                    System.out.println(keyn);


                }else {



                    send1SMS();
                }
                return COUNTphonenanmber > 0;


            }
            rs.next();

        }catch(Exception ex){
            throw new RuntimeException(ex);

        }


        return false;
    }

    public String keyType (String code) {
        try (Connection c = getConnection()) {
            String sql = "select type from key_type where idKeyType = (select idKeyType from last_key_type   where idLastKeyType = (select idLastKeyType from keys where code = ?) ) ";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, code);

            String keyType = null;
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                keyType = resultSet.getString(1);
            }

            return keyType;

        } catch (Exception ex) {
            throw new RuntimeException(ex);

        }


        // Количество смс за сутки




    }
}







