package com.owner.library.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import static com.owner.library.utils.ConfigReader.getValue;
import static com.owner.library.utils.KeyConstants.*;

public class Coon {
	public Connection c;
    Statement s;
    public Coon(){  
        try{  
            Class.forName(getValue(DRIVER_NAME));  
            c =DriverManager.getConnection(getValue(DB_URL), getValue(DB_USERID), getValue(DB_PWD));    
            s =c.createStatement();  
           
        }catch(Exception e){ 
            System.out.println(e);
        }  
    }  
}
