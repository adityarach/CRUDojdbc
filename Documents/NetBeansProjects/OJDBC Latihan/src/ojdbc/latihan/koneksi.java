/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ojdbc.latihan;

import java.sql.Connection;
import oracle.jdbc.pool.OracleDataSource;

/**
 *
 * @author TAMU
 */
public class koneksi {

    public Connection koneksi;

    public Connection getkoneksi() {
        try {
            OracleDataSource ods = new OracleDataSource();
            ods.setDriverType("thin");
            ods.setUser("System");
            ods.setPassword("2429");
            ods.setPortNumber(1521);
            ods.setServiceName("XE");
            ods.setServerName("localhost");
            koneksi = ods.getConnection();
            koneksi.createStatement().execute("alter session set current_schema=hr");
        }catch(Exception e){
                    System.out.println(e.getMessage());
                    e.printStackTrace();
                    }
        return koneksi;
        }
}

