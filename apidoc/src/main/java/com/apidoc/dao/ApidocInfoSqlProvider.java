package com.apidoc.dao;

import com.apidoc.entity.ApidocAction;
import com.apidoc.entity.ApidocInfo;
import com.apidoc.entity.ApidocModule;
import com.apidoc.entity.ApidocParam;
import org.apache.ibatis.jdbc.SQL;

public class ApidocInfoSqlProvider {
    public String insertAction(ApidocAction record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("apidoc_action");

        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }

        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }

        if (record.getModuleId() != null) {
            sql.VALUES("moduleId", "#{moduleId,jdbcType=INTEGER}");
        }

        if (record.getOrder() != null) {
            sql.VALUES("order", "#{order,jdbcType=INTEGER}");
        }

        if (record.getMethodUUID() != null) {
            sql.VALUES("methodUUID", "#{methodUUID,jdbcType=VARCHAR}");
        }

        if (record.getDescription() != null) {
            sql.VALUES("description", "#{description,jdbcType=LONGVARCHAR}");
        }

        if (record.getRequestDescription() != null) {
            sql.VALUES("requestDescription", "#{requestDescription,jdbcType=LONGVARCHAR}");
        }

        if (record.getResponseDescription() != null) {
            sql.VALUES("responseDescription", "#{responseDescription,jdbcType=LONGVARCHAR}");
        }
        return record.getInsertSql().toString();//sql.toString();
    }

    public String insertInfo(ApidocInfo record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("apidoc_info");

        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }

        if (record.getTitle() != null) {
            sql.VALUES("title", "#{title,jdbcType=VARCHAR}");
        }

        if (record.getDescription() != null) {
            sql.VALUES("description", "#{description,jdbcType=VARCHAR}");
        }

        if (record.getVersion() != null) {
            sql.VALUES("`version`", "#{version,jdbcType=VARCHAR}");
        }

        if (record.getPackageName() != null) {
            sql.VALUES("packageName", "#{packageName,jdbcType=VARCHAR}");
        }

        return record.getInsertSql().toString();//.toString();
    }

    public String insertModule(ApidocModule record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("apidoc_module");

        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }

        if (record.getName() != null) {
            sql.VALUES("`name`", "#{name,jdbcType=VARCHAR}");
        }

        if (record.getOrder() != null) {
            sql.VALUES("`order`", "#{order,jdbcType=INTEGER}");
        }

        if (record.getPackageName() != null) {
            sql.VALUES("packageName", "#{packageName,jdbcType=VARCHAR}");
        }

        if (record.getClassList() != null) {
            sql.VALUES("classList", "#{classList,jdbcType=VARCHAR}");
        }

        return record.getInsertSql().toString();//sql.toString();
    }
    public String insertParam(ApidocParam record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("apidoc_param");

        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }

        if (record.getName() != null) {
            sql.VALUES("`name`", "#{name,jdbcType=VARCHAR}");
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

        return record.getInsertSql().toString();//sql.toString();
    }
}
