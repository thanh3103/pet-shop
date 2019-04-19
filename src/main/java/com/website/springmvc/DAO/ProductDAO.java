package com.website.springmvc.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.website.springmvc.entities.Category;
import com.website.springmvc.entities.Product;

@Repository
public class ProductDAO extends DAO<Product> {

	@Autowired
	private SessionFactory sessionFactory;

	public ProductDAO(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public ProductDAO() {

	}

	@Override
	public List<Product> getAll(Integer offset) {
		Session session = this.sessionFactory.getCurrentSession();

		// SQLQuery query = session.createSQLQuery("call getAllProduct");
		// query.addEntity(Product.class);
		Query query = session.createQuery("from Product");
		query.setFirstResult(offset != null ? offset : 0);
		query.setMaxResults(5);
		List<Product> products = query.list();

		return products;
	}

	@Override
	public Product getById(Long id) {
		Session session = this.sessionFactory.getCurrentSession();

		// Query query = session.createQuery("select P from Product as P where id =
		// :id");
		// query.setParameter("id", id);
		// Product product = (Product) query.uniqueResult();

		SQLQuery query = session.createSQLQuery("call getProductById(:id)");
		query.addEntity(Product.class);
		query.setParameter("id", id);
		Product product = (Product) query.uniqueResult();

		return product;
	}

	public List<Product> getByCategory(Category category, Integer offset) {
		Session session = this.sessionFactory.getCurrentSession();

		Query query = session.createQuery("select P from Product as P where category = :category");
		query.setParameter("category", category);
		query.setFirstResult(offset);
		query.setMaxResults(6);

		List<Product> products = query.list();

		// Iterator<Product> productIter = products.iterator();
		// while(productIter.hasNext()) {
		// Product product = productIter.next();
		// }

		// Long id = category.getId();
		// SQLQuery query = session.createSQLQuery("select * from products where
		// CATEGORY_ID =:id");
		// query.setParameter("id", id);
		// query.addEntity(Product.class);
		// ResultSet rs = (ResultSet) query.list();
		// Long userId;
		// try {
		// userId = rs.getLong("USER_ID");
		// System.out.println(userId);
		// } catch (SQLException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		return products;
	}

	@Override
	public Product getByName(String name) {
		Session session = this.sessionFactory.getCurrentSession();

		Query query = session.createQuery("select P from Product as P where name = :name");
		query.setParameter("name", name);
		Product product = (Product) query.uniqueResult();

		return product;
	}

	@Override
	public Product add(Product product) {
		Session session = this.sessionFactory.getCurrentSession();

		session.save(product);

		return product;
	}

	@Override
	public Boolean update(Product product) {
		Session session = this.sessionFactory.getCurrentSession();

		try {
			session.update(product);
			return Boolean.TRUE;
		} catch (Exception e) {
			return Boolean.FALSE;
		}
	}

	@Override
	public Boolean delete(Product product) {
		Session session = this.sessionFactory.getCurrentSession();

		try {
			session.delete(product);
			return Boolean.TRUE;
		} catch (Exception e) {
			return Boolean.FALSE;
		}
	}

	@Override
	public Boolean deleteById(Long id) {
		Session session = this.sessionFactory.getCurrentSession();

		Query query = session.createQuery("select P from Product as P where id = :id");
		query.setParameter("id", id);
		Product product = (Product) query.uniqueResult();

		try {
			session.delete(product);
			return Boolean.TRUE;
		} catch (Exception e) {
			return Boolean.FALSE;
		}
	}

	public List<Product> getList(Long id) {
		Session session = this.sessionFactory.getCurrentSession();

		SQLQuery query = session.createSQLQuery("SELECT * FROM PRODUCT WHERE category_CATEGORY_ID = :id");
		query.addEntity(Product.class);
		query.setParameter("id", id);
		List<Product> products = (List<Product>) query.list();
		return products;
	}

	public List<Product> getProductListByLocation(String location) {
		Session session = this.sessionFactory.getCurrentSession();

		Query query = session.createQuery("from Product where location = :location");
		query.setParameter("location", location);

		List<Product> products = query.list();
		return products;
	}

	public Long count() {
		Session session = this.sessionFactory.getCurrentSession();

		Criteria criteria = session.createCriteria(Product.class);
		criteria.setProjection(Projections.rowCount());

		Long rowCount = (Long) criteria.uniqueResult();
		return rowCount;
	}

	@SuppressWarnings("unused")
	public static boolean isNumeric(String str) {
		try {
			Integer d = Integer.parseInt(str);
			return Boolean.TRUE;
		} catch (NumberFormatException nfe) {
			return Boolean.FALSE;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Product> getProductSearchCriteria(String search, Long id) {
		Session session = this.sessionFactory.getCurrentSession();

		StringBuilder query = new StringBuilder("SELECT * FROM products");

		if (search != null) {
			if (isNumeric(search) == true) {
				query.append(" WHERE PRICE = " + search);
			} else {
				query.append(" WHERE PRODUCT_NAME LIKE '" + search + "'");
			}
		} else {
			query.append("");
		}

		if (id > 0) {
			query.append(" AND CATEGORY_ID = " + id);
		} else if (id < 0) {
			query.append("");
		}

		SQLQuery result = session.createSQLQuery(query.toString());
		result.addEntity(Product.class);

		System.out.println(result);

		List<Product> products = (List<Product>) result.list();

		System.out.println(products.toString());

		return products;

	}

}
