package com.app.dao;

import java.io.IOException;
import java.sql.SQLException;

public   interface Dao    {

 public abstract void save(String Phone, String TextMessages,String Data) throws IOException;
 public  abstract boolean isadminNamber(String phoneanmber);
 public abstract boolean blackList(String phoneanmberblackList);
 public abstract boolean smsSearch(String keyn);
 //public abstract void numberOfSMSDay() throws SQLException;




}
