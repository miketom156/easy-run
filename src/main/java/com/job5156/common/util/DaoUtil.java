package com.job5156.common.util;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.type.Type;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class DaoUtil {

    private Session session = null;

    public DaoUtil(Session s){
        this.session = s;
    }

    @SuppressWarnings("rawtypes")
    public Object query(final String hql, final Object... paramlist) {
        Query query = this.session.createQuery(hql);
        setParameters(query, paramlist);

        Object result = query.uniqueResult();
        if(result != null) {
            return result;
        } else {
            return new Integer(0);
        }

    }

    @SuppressWarnings("rawtypes")
    public Object queryBySql(final String natvieSQL, final List<Map.Entry<String, Type>> scalarList, final Object... paramlist) {
        SQLQuery query = this.session.createSQLQuery(natvieSQL);
        if (scalarList != null) {
            for (Map.Entry<String, Type> entity : scalarList) {
                query.addScalar(entity.getKey(), entity.getValue());
            }
        }
        setParameters(query, paramlist);

        Object result = query.uniqueResult();
        if(result != null) {
            return result;
        } else {
            return new Integer(0);
        }
    }
    @SuppressWarnings("rawtypes")
    protected void setParameters(Query query, Object[] paramlist) {
        if (paramlist != null) {
            for (int i = 0; i < paramlist.length; i++) {
                if(paramlist[i] instanceof Date) {
                    query.setTimestamp(i, (Date)paramlist[i]);
                } else if(paramlist[i] instanceof Collection) {
                    query.setParameterList("params", (Collection)paramlist[i]);
                } else {
                    query.setParameter(i, paramlist[i]);
                }
            }
        }
    }


}
