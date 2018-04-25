package kr.co.bit.dao;

import kr.co.bit.vo.EmailListVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmailListDao {

    @Autowired
    private SqlSession sqlSession;

    public int insert(EmailListVO emailListVO) {

        return sqlSession.insert("emaillist.insert", emailListVO);
    }

    public List<EmailListVO> getList(){
        return sqlSession.selectList("emaillist.list");
    }
}
