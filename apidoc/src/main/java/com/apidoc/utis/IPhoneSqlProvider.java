package com.apidoc.utis;

import org.apache.ibatis.jdbc.SQL;

public class IPhoneSqlProvider {

    public String insertSelective(IPhone record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("iPhone");
        
        if (record.getItem() != null) {
            sql.VALUES("Item", "#{item,jdbcType=VARCHAR}");
        }
        
        if (record.getDescription() != null) {
            sql.VALUES("Description", "#{description,jdbcType=VARCHAR}");
        }
        
        if (record.getQty() != null) {
            sql.VALUES("Qty", "#{qty,jdbcType=VARCHAR}");
        }
        
        if (record.getRate() != null) {
            sql.VALUES("Rate", "#{rate,jdbcType=VARCHAR}");
        }
        
        if (record.getAmount() != null) {
            sql.VALUES("Amount", "#{amount,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(IPhone record) {
        SQL sql = new SQL();
        sql.UPDATE("iPhone");
        
        if (record.getItem() != null) {
            sql.SET("Item = #{item,jdbcType=VARCHAR}");
        }
        
        if (record.getDescription() != null) {
            sql.SET("Description = #{description,jdbcType=VARCHAR}");
        }
        
        if (record.getQty() != null) {
            sql.SET("Qty = #{qty,jdbcType=VARCHAR}");
        }
        
        if (record.getRate() != null) {
            sql.SET("Rate = #{rate,jdbcType=VARCHAR}");
        }
        
        if (record.getAmount() != null) {
            sql.SET("Amount = #{amount,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}