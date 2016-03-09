package com.entrevista.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.entrevista.model.Formulario;

@Repository("FormularioDao")
public class FormularioDaoImpl extends AbstractDao<Integer, Formulario> implements FormularioDao {
 
    
 
    public void saveFormulario(Formulario formulario) {
        persist(formulario);
    }
 
    public void deleteFormularioBySsn(String ssn) {
        Query query = getSession().createSQLQuery("delete from formulario where ssn = :ssn");
        query.setString("ssn", ssn);
        query.executeUpdate();
    }
 
    @SuppressWarnings("unchecked")
    public List<Formulario> findAllFormulario() {
        Criteria criteria = createEntityCriteria();
        return (List<Formulario>) criteria.list();
    }
 
    public Formulario findFormularioBySsn(String ssn) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("ssn", ssn));
        return (Formulario) criteria.uniqueResult();
    }


}