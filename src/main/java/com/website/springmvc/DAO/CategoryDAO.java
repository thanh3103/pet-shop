package com.website.springmvc.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.website.springmvc.entities.Category;

@Repository
public class CategoryDAO extends DAO<Category> {

	@Autowired
	private SessionFactory sessionFactory;

	public CategoryDAO(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public CategoryDAO() {

	}

	public List<Category> getAll() {
		Session session = this.sessionFactory.getCurrentSession();

		@SuppressWarnings("unchecked")
		List<Category> categories = session.createQuery("from Category").list();

		return categories;
	}

	@Override
	public List<Category> getAll(Integer offset) {
		Session session = this.sessionFactory.getCurrentSession();

		@SuppressWarnings("unchecked")
		List<Category> categories = session.createQuery("from Category").list();

		return categories;
	}

	@Override
	public Category getById(Long id) {
		Session session = this.sessionFactory.getCurrentSession();

		Query query = session.createQuery("select P from Category as P where id = :id");
		query.setParameter("id", id);
		Category category = (Category) query.uniqueResult();

		return category;
	}

	@Override
	public Category getByName(String categoryName) {
		Session session = this.sessionFactory.getCurrentSession();

		Query query = session.createQuery("select P from Category as P where categoryName = :categoryName");
		query.setParameter("categoryName", categoryName);
		Category category = (Category) query.uniqueResult();

		return category;
	}

	@Override
	public Category add(Category category) {
		Session session = this.sessionFactory.getCurrentSession();

		session.save(category);

		return category;
	}

	@Override
	public Boolean update(Category category) {
		Session session = this.sessionFactory.getCurrentSession();

		try {
			session.update(category);
			return Boolean.TRUE;
		} catch (Exception e) {
			return Boolean.FALSE;
		}
	}

	@Override
	public Boolean delete(Category category) {
		Session session = this.sessionFactory.getCurrentSession();

		try {
			session.delete(category);
			return Boolean.TRUE;
		} catch (Exception e) {
			return Boolean.FALSE;
		}
	}

	@Override
	public Boolean deleteById(Long id) {
		Session session = this.sessionFactory.getCurrentSession();

		Query query = session.createQuery("select P from Category as P where id = :id");
		query.setParameter("id", id);
		Category category = (Category) query.uniqueResult();

		try {
			session.delete(category);
			return Boolean.TRUE;
		} catch (Exception e) {
			return Boolean.FALSE;
		}
	}

	public Long count() {
		Session session = this.sessionFactory.getCurrentSession();

		Criteria criteria = session.createCriteria(Category.class);
		criteria.setProjection(Projections.rowCount());

		Long rowCount = (Long) criteria.uniqueResult();
		return rowCount;
	};

}
