package org.fiveware.conexao;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateConectionFactory {
	private static SessionFactory sessionFactory;

	private HibernateConectionFactory() {
		//evitar a instaciação do classe
	}

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			
			 StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
				        .configure( "hibernate.cfg.xml" )
				        .build();

				        Metadata metadata = new MetadataSources( standardRegistry )
				        .getMetadataBuilder()
				        .build();

				        return metadata.getSessionFactoryBuilder().build();
		}

		return sessionFactory;
	}
}