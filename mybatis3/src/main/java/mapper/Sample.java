package mapper;

import org.apache.ibatis.annotations.Select;

public interface Sample {

    @Select("SELECT CONVERT(NVARCHAR,  GETDATE(), 111) AS NOW;")
    String getCurrentTime();

    @Select("SELECT CONVERT(NVAR CHAR,  GETDATE(), 111) AS NOW;")
    String throwException();
}
