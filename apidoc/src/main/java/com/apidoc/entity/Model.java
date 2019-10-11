package com.apidoc.entity;


import com.baomidou.mybatisplus.enums.SqlMethod;
import com.baomidou.mybatisplus.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.SqlHelper;
import com.baomidou.mybatisplus.mapper.SqlRunner;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.toolkit.StringUtils;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.toolkit.TableInfoHelper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;

@Component
public abstract class Model<T extends com.apidoc.entity.Model> implements Serializable {

    private static final long serialVersionUID = 1L;

    public Model() {
        TableInfoHelper.initTableInfo(null, this.getClass());
    }

    @Transactional
    public boolean insert() {
        return SqlHelper.retBool(this.sqlSession().insert(this.sqlStatement(SqlMethod.INSERT_ONE), this));
    }

    @Transactional
    public boolean insertAllColumn() {
        return SqlHelper.retBool(this.sqlSession().insert(this.sqlStatement(SqlMethod.INSERT_ONE_ALL_COLUMN), this));
    }

    @Transactional
    public boolean insertOrUpdate() {
        if (StringUtils.checkValNull(this.pkVal())) {
            return this.insert();
        } else {
            return this.updateById() || this.insert();
        }
    }

    @Transactional
    public boolean deleteById(Serializable id) {
        return SqlHelper.delBool(this.sqlSession().delete(this.sqlStatement(SqlMethod.DELETE_BY_ID), id));
    }

    @Transactional
    public boolean deleteById() {
        if (StringUtils.checkValNull(this.pkVal())) {
            throw new MybatisPlusException("deleteById primaryKey is null.");
        } else {
            return this.deleteById(this.pkVal());
        }
    }

    @Transactional
    public boolean delete(String whereClause, Object... args) {
        return this.delete(Condition.create().where(whereClause, args));
    }

    @Transactional
    public boolean delete(Wrapper wrapper) {
        Map<String, Object> map = new HashMap();
        map.put("ew", wrapper);
        return SqlHelper.delBool(this.sqlSession().delete(this.sqlStatement(SqlMethod.DELETE), map));
    }

    @Transactional
    public boolean updateById() {
        if (StringUtils.checkValNull(this.pkVal())) {
            throw new MybatisPlusException("updateById primaryKey is null.");
        } else {
            Map<String, Object> map = new HashMap();
            map.put("et", this);
            return SqlHelper.retBool(this.sqlSession().update(this.sqlStatement(SqlMethod.UPDATE_BY_ID), map));
        }
    }

    @Transactional
    public boolean updateAllColumnById() {
        if (StringUtils.checkValNull(this.pkVal())) {
            throw new MybatisPlusException("updateAllColumnById primaryKey is null.");
        } else {
            Map<String, Object> map = new HashMap();
            map.put("et", this);
            return SqlHelper.retBool(this.sqlSession().update(this.sqlStatement(SqlMethod.UPDATE_ALL_COLUMN_BY_ID), map));
        }
    }

    @Transactional
    public boolean update(String whereClause, Object... args) {
        return this.update(Condition.create().where(whereClause, args));
    }

    @Transactional
    public boolean update(Wrapper wrapper) {
        Map<String, Object> map = new HashMap();
        map.put("et", this);
        map.put("ew", wrapper);
        return SqlHelper.retBool(this.sqlSession().update(this.sqlStatement(SqlMethod.UPDATE), map));
    }

    public List<T> selectAll() {
        return this.sqlSession().selectList(this.sqlStatement(SqlMethod.SELECT_LIST));
    }

    public T selectById(Serializable id) {
        return (T)this.sqlSession().selectOne(this.sqlStatement(SqlMethod.SELECT_BY_ID), id);
    }

    public T selectById() {
        if (StringUtils.checkValNull(this.pkVal())) {
            throw new MybatisPlusException("selectById primaryKey is null.");
        } else {
            return this.selectById(this.pkVal());
        }
    }

    public List<T> selectList(Wrapper wrapper) {
        Map<String, Object> map = new HashMap();
        map.put("ew", wrapper);
        return this.sqlSession().selectList(this.sqlStatement(SqlMethod.SELECT_LIST), map);
    }

    public List<T> selectList(String whereClause, Object... args) {
        return this.selectList(Condition.create().where(whereClause, args));
    }

    public T selectOne(Wrapper wrapper) {
        return (T)SqlHelper.getObject(this.selectList(wrapper));
    }

    public T selectOne(String whereClause, Object... args) {
        return this.selectOne(Condition.create().where(whereClause, args));
    }

    public Page<T> selectPage(Page<T> page, Wrapper<T> wrapper) {
        Map<String, Object> map = new HashMap();
        wrapper = (Wrapper<T>) SqlHelper.fillWrapper(page, wrapper);
        map.put("ew", wrapper);
        List<T> tl = this.sqlSession().selectList(this.sqlStatement(SqlMethod.SELECT_PAGE), map, page);
        page.setRecords(tl);
        return page;
    }

    public Page<T> selectPage(Page<T> page, String whereClause, Object... args) {
        return this.selectPage(page, Condition.create().where(whereClause, args));
    }

    public int selectCount(String whereClause, Object... args) {
        return this.selectCount(Condition.create().where(whereClause, args));
    }

    public int selectCount(Wrapper wrapper) {
        Map<String, Object> map = new HashMap();
        map.put("ew", wrapper);
        return SqlHelper.retCount((Integer)this.sqlSession().selectOne(this.sqlStatement(SqlMethod.SELECT_COUNT), map));
    }

    public SqlRunner sql() {
        return new SqlRunner(this.getClass());
    }
    public static ApplicationContext WEB_APPLICATION_CONTEXT;
    protected SqlSession sqlSession() {
        SqlSessionFactory sqlSessionFactory = WEB_APPLICATION_CONTEXT.getBean(SqlSessionFactory.class);
        return  sqlSessionFactory.openSession();
    }

    protected String sqlStatement(SqlMethod sqlMethod) {
        return this.sqlStatement(sqlMethod.getMethod());
    }

    protected String sqlStatement(String sqlMethod) {
        return SqlHelper.table(this.getClass()).getSqlStatement(sqlMethod);
    }

    protected abstract Serializable pkVal();
}