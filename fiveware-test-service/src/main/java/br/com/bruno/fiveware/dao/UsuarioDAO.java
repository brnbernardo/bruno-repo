package br.com.bruno.fiveware.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import br.com.bruno.fiveware.model.Usuario;
import br.com.bruno.fiveware.utils.HibernateUtils;

public class UsuarioDAO {

	private static SessionFactory sessionFactory;
	
	static {
		sessionFactory = HibernateUtils.getSessionFactory();
	}

	public static Usuario save(Usuario usuario) {
		Session session = sessionFactory.openSession();

		session.beginTransaction();

		session.save(usuario);

		session.getTransaction().commit();

		return usuario;
	}

}
