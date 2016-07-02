package utils;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;


/**
 * Created by cxspace on 16-7-1.
 *
 *
 *
 */
public class JdbcUtils {


        private static String driver = null;
        private static String url = null;
        private static String username = null;
        private static String password = null;
        private static Connection conn = null;
        private static PreparedStatement ps = null;
        private static ResultSet rs = null;

        static {
            try {
                // 读取db.properties文件中的数据库配置信息
                InputStream in = JdbcUtils.class.getClassLoader()
                        .getResourceAsStream("utils/db.properties");
                Properties prop = new Properties();
                prop.load(in);

                // 获取数据库链接驱动
                driver = prop.getProperty("driver");
                url = prop.getProperty("url");
                username = prop.getProperty("username");
                password = prop.getProperty("password");

                // 加载数据库驱动
                Class.forName(driver);

                conn = JdbcUtils.getConnection();

            } catch (Exception e) {
                // TODO: handle exception
                throw new ExceptionInInitializerError(e);
            }
        }

        /*
         * @Method:getConnection
         *
         * @Dedcription:获取数据库链接对象
         *
         * @Anthor:cx
         *
         * @return Connection对象
         */
        public static Connection getConnection() throws SQLException {
            return DriverManager.getConnection(url, username, password);
        }

	/*
	 * @Metohod：release
	 *
	 * @Description:释放资源
	 *
	 * @Author:cx
	 *
	 * @param conn
	 *
	 * @param ps
	 *
	 * @param rs
	 */

        public static void release() {
            //
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                    // TODO: handle exception
                    e.printStackTrace();
                }

                rs = null;

            }

            if (ps != null) {
                try {
                    ps.close();
                } catch (Exception e) {
                    // TODO: handle exception
                    e.printStackTrace();
                }

            }

            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e) {
                    // TODO: handle exception
                    e.printStackTrace();
                }

            }
        }


	/*
	 * @Metohod：exeSql
	 *
	 * @Description:执行数据更新语句
	 *
	 * @Author:cx
	 *
	 * @param strSql
	 *
	 */

        public static boolean exeSql(String strSql) {
            try {
                ps =  conn.prepareStatement(strSql);

                //执行更新
                ps.executeUpdate(strSql);

                return true;
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
                return false;
            }
        }

	/*
	 * @Metohod：exeSqlQuery
	 *
	 * @Description:执行查询
	 *
	 * @Author:cx
	 *
	 * @param strSql
	 */

        public static ResultSet exeSqlQuery(String strSql) {
            try {
                ps =  conn.prepareStatement(strSql);
                rs = ps.executeQuery();

            } catch (Exception e) {
                e.printStackTrace();
            }
            return rs;
        }

}

