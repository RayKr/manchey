package com.manchey.mapper;

import com.manchey.model.vo.mcos.Operator;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * Created by Ray on 2016/6/2.
 */
@Repository("userMapper")
public interface UserMapper {
    @Select("select * from operator where operno = #{operno} and password = #{password}")
    Operator getOperator(@Param("operno") String operno, @Param("password") String password);
}
