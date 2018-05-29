package org.fiveware.dao;

import java.util.List;

import org.fiveware.beans.Cliente;
import org.fiveware.conexao.HibernateConectionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ClienteHibernateDao implements ClienteDao {

	private Session session;
	private Transaction tx = null;
	
	@Autowired
	public ClienteHibernateDao() {
		session = HibernateConectionFactory.getSessionFactory().openSession();
	}


	@Override
	public void insere(Cliente cliente) {
		try {
			if (cliente == null || cliente.getId() > 0) {
				throw new IllegalArgumentException(
						"Cliente não pode ser nulo e nem já cadastrado no sistema !" + this.getClass().getName());
			}
			tx = session.beginTransaction();
			if (!(cliente.getCelular() == null)) {
				session.persist(cliente.getCelular());
			}
			if (!(cliente.getComercial() == null)) {
				session.persist(cliente.getComercial());
			}
			if (!(cliente.getCpf() == null)) {
				session.persist(cliente.getCpf());
			}
			if (!(cliente.getFixo() == null)) {
				session.persist(cliente.getFixo());
			}
			if (!(cliente.getResidencial() == null)) {
				session.persist(cliente.getResidencial());
			}
			if (!(cliente.getRg() == null)) {
				session.persist(cliente.getRg());
			}
			session.persist(cliente);
			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
		}
	}

	@Override
	public void update(Cliente cliente) {
		try {

			if (!(cliente.getId() <= 0)) {
				tx = session.getTransaction();
				session.merge(cliente);
				tx.commit();
			} else {
				throw new IllegalArgumentException("Cliente não existe no sistema ! " + this.getClass().getName());
			}

		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
		}
	}

	@Override
	public void remove(Cliente cliente) {
		try {
			cliente = session.get(Cliente.class, cliente.getId());
			tx = session.getTransaction();
			tx.begin();
			session.delete(cliente);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> lista() {
		return (List<Cliente>) session.createQuery("FROM Cliente").list();
	}

}
