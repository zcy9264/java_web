package xiaohei.tools;

import java.sql.*;

public class DBManager {
    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    private String user = "sa";
    private String password = "plb123plb";
    private String uri = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=exam;trustServerCertificate=true";
    public DBManager() {
        this.conn = this.getConnection();
    }

    // ��ȡ���Ӷ���
    private Connection getConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("������������");
            conn = DriverManager.getConnection(uri, user, password);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("������������쳣");

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("��ȡ���Ӵ���");
        }

        return conn;
    }

    //��ѯ����
    public ResultSet executeQuery(String sql) {
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println("SQLִ�в�ѯ����");
            e.printStackTrace();//��ӡ��ջ����
        }
        return rs;
    }

    //���·���
    public int executeUpdate(String sql) {
        int count = 0;
        try {
            stmt = conn.createStatement();
            count = stmt.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("SQLִ�и��´���");
            e.printStackTrace();//��ӡ��ջ����
        }
        return count;
    }

    // �ͷ���Դ
    public void releaseResource() {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
