/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ojdbc.latihan;

import dao.JobGradeDAO;
import java.util.List;
import model.JobGrade;

/**
 *
 * @author TAMU
 */
public class OJDBCLatihan {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(new koneksi().getkoneksi());
        
//        System.out.println(new JobGradeDAO().getAllData().size());
//        List <JobGrade> datas= new JobGradeDAO().getAllData();
//        datas=new JobGradeDAO().search("A");
//        for (int i=0; i<datas.size();i++){
//            System.out.println(datas.get(i).getGradelevel() + ", gaji tertinggi:" + datas.get(i).getHighestSalary());
//        }
//        System.out.println("ini fore cari");
//        for(JobGrade data : datas){
//            System.out.println(data.getGradelevel() + ", gaji tertinggi:" + data.getHighestSalary());
//        }
//          mencari data berdasarkan kategori
//          List <JobGrade> datas= new JobGradeDAO().search("highest_sal", "2999");
//          for (int i=0; i<datas.size();i++){
//          System.out.println(datas.get(i).getGradelevel() + ", gaji tertinggi:" + datas.get(i).getHighestSalary());
//        }
//          mencari data berdasarkan grade
//          datas=new JobGradeDAO().getAllData();
//          JobGrade jg = new JobGradeDAO().getByGradeLevel("A");
//          System.out.println(jg.getLowestSalary());
//          
//            insert
//          JobGrade jb = new JobGrade();
//          jb.setGradelevel("E");
//          jb.setHighestSalary(1000);
//          jb.setLowestSalary(9);
//          System.out.println(new JobGradeDAO().insert(jb));
//        
//            update
//          JobGrade ju = new JobGrade();
//          ju.setGradelevel("E");
//          ju.setHighestSalary(1000);
//          ju.setLowestSalary(9);
//          System.out.println(new JobGradeDAO().update(ju));
//          
          JobGrade Delete = new JobGrade();
          System.out.println(new JobGradeDAO().delete("A"));
    }
}
