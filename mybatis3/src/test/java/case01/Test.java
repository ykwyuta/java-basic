package case01;

import mapper.Sample;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;

public class Test {

    /**
     * アノテーションでSQLを指定する
     */
    @org.junit.jupiter.api.Test
    public void getCurrentTime() throws IOException {
        try (Reader config = Resources.getResourceAsReader("mybatis-config.xml")) {
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(config);
            try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
                System.out.println(sqlSession.getMapper(Sample.class).getCurrentTime());
            }
        }
    }

    /**
     * MyBatis Exceptionの中身はSQLExceptionを取り出して確認しないと分からない…
     */
    @org.junit.jupiter.api.Test
    public void throwException() throws IOException {
        try (Reader config = Resources.getResourceAsReader("mybatis-config.xml")) {
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(config);
            try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
                System.out.println(sqlSession.getMapper(Sample.class).throwException());
            } catch (Exception e) {
                if (e.getCause() instanceof SQLException) {
                    System.out.println(e.getCause().getMessage());
                }
            }
        }
    }
}
