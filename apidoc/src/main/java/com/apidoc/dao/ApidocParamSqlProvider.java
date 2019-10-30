package com.apidoc.dao;

import com.apidoc.entity.ApidocParam;
import org.apache.ibatis.jdbc.SQL;

public class ApidocParamSqlProvider {

    public String insertSelective(ApidocParam record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("apidoc_param");
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getDataType() != null) {
            sql.VALUES("dataType", "#{dataType,jdbcType=VARCHAR}");
        }
        
        if (record.getDescription() != null) {
            sql.VALUES("description", "#{description,jdbcType=VARCHAR}");
        }
        
        if (record.getDefaultValue() != null) {
            sql.VALUES("defaultValue", "#{defaultValue,jdbcType=VARCHAR}");
        }
        
        if (record.getRequired() != null) {
            sql.VALUES("required", "#{required,jdbcType=TINYINT}");
        }
        
        if (record.getActionId() != null) {
            sql.VALUES("actionId", "#{actionId,jdbcType=INTEGER}");
        }
        
        if (record.getReturnd() != null) {
            sql.VALUES("returnd", "#{returnd,jdbcType=TINYINT}");
        }
        
        if (record.getPid() != null) {
            sql.VALUES("pid", "#{pid,jdbcType=INTEGER}");
        }
        
        if (record.getPclassName() != null) {
            sql.VALUES("pclassName", "#{pclassName,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(ApidocParam record) {
        SQL sql = new SQL();
        sql.UPDATE("apidoc_param");
        
        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getDataType() != null) {
            sql.SET("dataType = #{dataType,jdbcType=VARCHAR}");
        }
        
        if (record.getDescription() != null) {
            sql.SET("description = #{description,jdbcType=VARCHAR}");
        }
        
        if (record.getDefaultValue() != null) {
            sql.SET("defaultValue = #{defaultValue,jdbcType=VARCHAR}");
        }
        
        if (record.getRequired() != null) {
            sql.SET("required = #{required,jdbcType=TINYINT}");
        }
        
        if (record.getActionId() != null) {
            sql.SET("actionId = #{actionId,jdbcType=INTEGER}");
        }
        
        if (record.getReturnd() != null) {
            sql.SET("returnd = #{returnd,jdbcType=TINYINT}");
        }
        
        if (record.getPid() != null) {
            sql.SET("pid = #{pid,jdbcType=INTEGER}");
        }
        
        if (record.getPclassName() != null) {
            sql.SET("pclassName = #{pclassName,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}