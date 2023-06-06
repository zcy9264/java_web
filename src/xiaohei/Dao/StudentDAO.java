package xiaohei.Dao;

import xiaohei.tools.DBManager;

import java.sql.ResultSet;

public class StudentDAO {
    public DBManager db;
    public StudentDAO(){
        db = new DBManager();
    }
    public Boolean AddStudent(String id, String name, String age, String jspScore) {
        boolean flag = false;
        String sql = "insert into student values('" + id + "','" + name + "','" + age + "','" + jspScore + "')";
        int count = db.executeUpdate(sql);
        if (count > 0){
            flag = true;
        }
        db.releaseResource();
        return flag;
    }

    public ResultSet QueryStudent(){
        return db.executeQuery("SELECT id,name,age,jspScore FROM student ORDER BY student.id;");
    }

    public Boolean ChangeStudent(String id, String name, String age, String jspScore){
        boolean flag = false;
        String sql = "UPDATE student SET name = '"+name+"',age = '"+age+"', jspScore = '"+jspScore+"' where id = '"+id+"';";
        int count = db.executeUpdate(sql);
        if (count > 0){
            flag = true;
        }
        db.releaseResource();
        return flag;
    }

    public Boolean DeleteStudent(String id){
        boolean flag = false;
        String sql = "DELETE student where id = '"+id+"';";
        int count = db.executeUpdate(sql);
        if (count > 0) {
            flag = true;
        }
        db.releaseResource();
        return flag;
    }

    public Boolean AllDeleteStudent(String[] ids){
        boolean flag = false;
        for (String id : ids) {
            String sql = "DELETE student where id = '" + id + "'";
            DBManager db = new DBManager();
            int count = db.executeUpdate(sql);
            if (count > 0) {
                flag = true;
            }
            db.releaseResource();
        }
        return flag;
    }
}
