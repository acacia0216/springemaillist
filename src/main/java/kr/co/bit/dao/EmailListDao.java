package kr.co.bit.dao;

import kr.co.bit.vo.EmailListVO;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EmailListDao {

    public void insert(EmailListVO vo) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
//        ResultSet resultSet = null;
        int count;
        try {
            //1. JDBC 드라이버 (oracle) 로딩
            Class.forName("oracle.jdbc.OracleDriver");

            //2. Connection 얻어오기
            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            connection = DriverManager.getConnection(url, "webdb", "1234");

            //3. SQL문 준비 / 바인딩 / 실행
            String sql = "insert into EMAILLIST (NO, FIRST_NAME, LAST_NAME, EMAIL) values (SEQ_EMAILLIST_NO.nextval,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1,vo.getFirstName());
            preparedStatement.setString(2,vo.getLastName());
            preparedStatement.setString(3,vo.getEmail());

            count = preparedStatement.executeUpdate();

            //4. 결과처리
            System.out.println(count+"건 등록");

        } catch (ClassNotFoundException e) {
            System.out.println("error : 드라이버 로딩 실패- " + e);
        } catch (SQLException e) {
            System.out.println("error" + e);
        } finally {

            //5. 자원정리
            try {
                if (connection != null)
                    connection.close();

                if (preparedStatement != null)
                    preparedStatement.close();

//                if (resultSet != null)
//                    resultSet.close();

            } catch (SQLException e) {
                System.out.println("error" + e);
            }
        }
    }

    public List<EmailListVO> getList(){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
//        EmailListVO vo = null;
        List<EmailListVO> list = new ArrayList<>();
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            connection = DriverManager.getConnection(url, "webdb", "1234");
            String sql = "select * from EMAILLIST order by no desc";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                int no = resultSet.getInt("no");
                String fn = resultSet.getString(3);
                String ln = resultSet.getString(2);
                String email = resultSet.getString(4);

                EmailListVO vo = new EmailListVO(ln,fn,email);

//                vo.setNo(no);
//                vo.setFirstName(fn);
//                vo.setLastName(ln);
//                vo.setEmail(email);

                list.add(vo);
            }
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try {
                if(connection != null)
                connection.close();
                if(resultSet != null)
                resultSet.close();
                if(preparedStatement != null)
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}