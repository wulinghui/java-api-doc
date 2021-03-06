package com.apidoc.entity;


import cn.hutool.core.util.ReflectUtil;
import cn.hutool.db.sql.SqlExecutor;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.SqlMethod;
import com.baomidou.mybatisplus.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.SqlHelper;
import com.baomidou.mybatisplus.mapper.SqlRunner;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.toolkit.StringUtils;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.toolkit.TableInfoHelper;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;
import javax.sql.DataSource;

@Component
public abstract class Model<T extends com.apidoc.entity.Model> implements Serializable {
    @JsonIgnore
    public static ApplicationContext WEB_APPLICATION_CONTEXT;
    @JsonIgnore
    private Connection getConnection() throws SQLException {
        return WEB_APPLICATION_CONTEXT.getBean(DataSource.class).getConnection();
    }
    /*
      "insert into apidoc_info (id, title, ",
        "description, version, ",
        "packageName)",
        "values (#{id,jdbcType=INTEGER}, #{title,jdbcType=VARCHAR}, ",
        "#{description,jdbcType=VARCHAR}, #{version,jdbcType=VARCHAR}, ",
        "#{packagename,jdbcType=VARCHAR})"
     */
    public  void insert1()  {
        try {
            StringBuilder sb = getInsertSql();
            SqlExecutor.execute(getConnection(),sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *  "update apidoc_info",
     *         "set title = #{title,jdbcType=VARCHAR},",
     *           "description = #{description,jdbcType=VARCHAR},",
     *           "version = #{version,jdbcType=VARCHAR},",
     *           "packageName = #{packagename,jdbcType=VARCHAR}",
     *         "where id = #{id,jdbcType=INTEGER}"
     */
    public  boolean updateById1() {
        try {
            StringBuilder sb = getUpdateSql();
            SqlExecutor.execute(getConnection(), sb.toString());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public StringBuilder getInsertSql(){
        Field[] fields = ReflectUtil.getFields(this.getClass());
        StringBuilder sb =new StringBuilder(" INSERT INTO ");
        TableName annotation = this.getClass().getAnnotation(TableName.class);
        sb.append(annotation.value());
        sb.append(" ( ");
        StringBuilder sb2 =new StringBuilder(" )VALUES( ");
        for (Field field : fields) {
            Object o = getObjectForApiDoc(field);
            String name = field.getName();
            if( "serialVersionUID".equalsIgnoreCase(name) ) continue;
            if( "WEB_APPLICATION_CONTEXT".equalsIgnoreCase(name) ) continue;
            if ( o == null) continue;;
            field.setAccessible(true);
            sb.append("`");
            sb.append(name);
            sb.append("`");
            sb.append( ',' );
            //
            sb2.append("'");
            sb2.append(o.toString());
            sb2.append("',");
        }
        sb.deleteCharAt(sb.length()-1);
        sb2.deleteCharAt(sb2.length()-1);
        sb2.append(')');
        sb.append(sb2.toString());
//        System.out.println("insert== " +sb );
        return sb;
    }


    public StringBuilder getUpdateSql()  {
        Field[] fields = ReflectUtil.getFields(this.getClass());
        StringBuilder sb = new StringBuilder(" UPDATE ");
        TableName annotation = this.getClass().getAnnotation(TableName.class);
        sb.append(annotation.value());
        sb.append(" set ");
        String name = null;
        Object o = null;
        for (Field field : fields) {
            field.setAccessible(true);
            name = field.getName();
            if ("id".equalsIgnoreCase(name)) continue;
            if ("serialVersionUID".equalsIgnoreCase(name)) continue;
            if ("WEB_APPLICATION_CONTEXT".equalsIgnoreCase(name)) continue;
            if( "list".equalsIgnoreCase(name) ) continue;
            o = getObjectForApiDoc(field);
            if (o == null) continue;
            sb.append("`");
            sb.append(name);
            sb.append("`");
            sb.append(" = ");
            sb.append("'");
            sb.append(o.toString());
            sb.append("',");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(" WHERE ID='");
        Field field = ReflectUtil.getField(this.getClass(), "id");
        o = getObjectForApiDoc(field);
        sb.append(o);
        sb.append("'");
//        System.out.println("updateById== " + sb);
        return sb;
    }

    private Object getObjectForApiDoc(Field field)  {
        Object o = null;
        try {
            if( field == null ) return o;
            field.setAccessible(true);
            o = field.get(this);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        ;
        if( o != null && (o.getClass().equals(Boolean.class) || o.getClass().equals(boolean.class) ) ){
            Boolean a = (Boolean) o;
            if( a ){
                o = 1;
            }else{
                o = 0;
            }
        }
        return o;
    }

    public static void main(String[] args) {
        Object abc = true;
        System.out.println(abc.getClass());
        if( !abc.getClass().isPrimitive() && abc.getClass().equals(Boolean.class) ){
            System.out.println(1111111111);
        }
    }
}