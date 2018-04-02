/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.JobGrade;
import ojdbc.latihan.koneksi;

/**
 *
 * @author TAMU
 */
public class JobGradeDAO {

    public Connection kon;

    public JobGradeDAO() {
        this.kon = new koneksi().getkoneksi();
    }

    /**
     * fungsi memanggil semua data jobgrade
     *
     * @return getalldata
     */
//    public List<JobGrade> getAllData(){
//        List<JobGrade> datas=new ArrayList<>();
//        try {
//            PreparedStatement pst = kon.prepareStatement("select * from job_grades");
//            ResultSet rs = pst.executeQuery();
//            while (rs.next()){
//                  JobGrade jd = new JobGrade(rs.getString("grade_level"), rs.getInt("lowest_sal"), rs.getInt("highest_sal"));
//                JobGrade jd = new JobGrade();
//                jd.setGradelevel(rs.getString("grade_level"));
//                jd.setLowestSalary(rs.getInt("lowest_sal"));
//                jd.setHighestSalary(rs.getInt("highest_sal"));
//                datas.add(jd);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(JobGradeDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return datas;
//    }
    /**
     * fungsi mencari semua data jobgrade
     *
     * @return getalldata
     */
//    public List<JobGrade> search(String cari){
//        List<JobGrade> datas=new ArrayList<>();
//        try {
//            PreparedStatement pst = kon.prepareStatement("select * from job_grades where "
//            + "grade_level like '%"+cari+"%'"
//            + "OR lowest_sal like '%"+cari+"%'"
//            + "OR highest_sal like '%"+cari+"%'");
//            ResultSet rs = pst.executeQuery();
//            while (rs.next()){
//                JobGrade jd = new JobGrade(rs.getString("grade_level"), rs.getInt("lowest_sal"), rs.getInt("highest_sal"));
//                datas.add(jd);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(JobGradeDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return datas;
//    }
    public List<JobGrade> getAllData() {
        return getData("");
    }

    /**
     * menampilkan data by grade level
     *
     * @param gradelevel
     * @return list data sesuai grade level
     */
    public JobGrade getByGradeLevel(String gradelevel) {
        return getData("where grade_level = '" + gradelevel + "'").get(0);
    }

    /**
     * menampilkan pencarian
     */
    public List<JobGrade> search(String category, String cari) {
        return getData("where " + category + " like '%" + cari + "%'");
    }

    public List<JobGrade> getData(String query) {
        List<JobGrade> datas = new ArrayList<>();
        try {
            PreparedStatement pst = kon.prepareStatement("select * from job_grades " + query);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                JobGrade jd = new JobGrade(rs.getString("grade_level"), rs.getInt("lowest_sal"), rs.getInt("highest_sal"));
                datas.add(jd);
            }
        } catch (SQLException ex) {
            Logger.getLogger(JobGradeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datas;
    }

    public boolean insert(JobGrade jobgrade) {
        try {
            PreparedStatement pst = kon.prepareStatement("insert into job_grades values(?,?,?)");
            pst.setString(1, jobgrade.getGradelevel());
            pst.setInt(2, jobgrade.getHighestSalary());
            pst.setInt(3, jobgrade.getLowestSalary());
            pst.executeUpdate();
            return true;
        }
        catch (SQLException ex) {
            Logger.getLogger(JobGradeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean update(JobGrade jobgrade) {
        try {
            PreparedStatement pst = kon.prepareStatement("update job_grades set lowest_sal=?, highest_sal=? where grade_level=?");
            pst.setString(3, jobgrade.getGradelevel());
            pst.setInt(1, jobgrade.getHighestSalary());
            pst.setInt(2, jobgrade.getLowestSalary());
            pst.executeUpdate();
            return true;
        }
        catch (SQLException ex) {
            Logger.getLogger(JobGradeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean delete(String gradelevel) {
        try {
            PreparedStatement pst = kon.prepareStatement("delete from job_grades where grade_level=?");
            pst.setString(1,gradelevel);
            pst.executeUpdate();
            return true;
        }
        catch (SQLException ex) {
            Logger.getLogger(JobGradeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
