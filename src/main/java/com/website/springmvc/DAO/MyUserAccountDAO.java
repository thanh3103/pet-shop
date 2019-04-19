package com.website.springmvc.DAO;

import java.util.UUID;

import javax.sql.DataSource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionKey;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.website.springmvc.entities.User;
import com.website.springmvc.form.MyUserAccountForm;

@Repository
@Transactional
public class MyUserAccountDAO extends JdbcDaoSupport {
	
	public MyUserAccountDAO() {
		
	}

	@Autowired
	public MyUserAccountDAO(DataSource dataSource) {
		this.setDataSource(dataSource);
	}

	@Autowired
	private SessionFactory sessionFactory;

	public User findById(Long id) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("select U from User as U where id =:id");
		query.setParameter("id", id);
		User user = (User) query.uniqueResult();
		return user;
	}

	public User findByEmail(String email) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("select U from User as U where email =:email");
		query.setParameter("email", email);
		User user = (User) query.uniqueResult();
		return user;
	}

	public User findByUserName(String userName) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("select U from User as U where userName =:userName");
		query.setParameter("userName", userName);
		User user = (User) query.uniqueResult();
		return user;
	}

	public User registerNewUserAccount(MyUserAccountForm accountForm) {
		String sql = "insert into user(USER_ID, AGE, EMAIL, FIRST_NAME, LAST_NAME, PASSWORD, PHONE_NO, USERNAME, USER_ROLE) values(?,?,?,?,?,?,?,?)";
		// String ngẫu nhiên 36 ký tự.
		String id = UUID.randomUUID().toString();
		this.getJdbcTemplate().update(sql, id, accountForm.getEmail(), //
				accountForm.getUserName(), //
				accountForm.getFirstName(), accountForm.getLastName(), //
				accountForm.getPassword(), User.ROLE_USER);
		// return findById(id);
		return null;
	}

	// Tự động tạo ra User Account.
	public User createUserAccount(Connection<?> connection) {
		Session session = this.sessionFactory.getCurrentSession();
		ConnectionKey key = connection.getKey();
		// (facebook,12345), (google,123) ...
		System.out.println("key= (" + key.getProviderId() + "," + key.getProviderUserId() + ")");

		if (key.getProviderId().equalsIgnoreCase("facebook")) {
			Facebook facebook = (Facebook) connection.getApi();
			String[] fields = { "id", "about", "age_range", "birthday", "context", "cover", "currency", "devices",
					"education", "email", "favorite_athletes", "favorite_teams", "first_name", "gender", "hometown",
					"inspirational_people", "installed", "install_type", "is_verified", "languages", "last_name",
					"link", "locale", "location", "meeting_for", "middle_name", "name", "name_format", "political",
					"quotes", "payment_pricepoints", "relationship_status", "religion", "security_settings",
					"significant_other", "sports", "test_group", "timezone", "third_party_id", "updated_time",
					"verified", "video_upload_limits", "viewer_can_send_gift", "website", "work" };
			org.springframework.social.facebook.api.User userProfile = facebook.fetchObject("me",
					org.springframework.social.facebook.api.User.class, fields);
			String email = userProfile.getEmail();
			
			String lastname = userProfile.getLastName();

			String userName_prefix = userProfile.getFirstName().trim().toLowerCase() + "_"
					+ userProfile.getLastName().trim().toLowerCase();

			String userName = this.findAvailableUserName(userName_prefix);

			User user = new User(Long.valueOf(userProfile.getId()), userName, "123", email, null, userProfile.getFirstName(), lastname,
					null, "ROLE_USER", true);
			session.save(user);
			return user;
		} else {
			UserProfile userProfile = connection.fetchUserProfile();
			String email = userProfile.getEmail();
			User account = this.findByEmail(email);
			if (account != null) {
				return account;
			}
			String userName_prefix = userProfile.getFirstName().trim().toLowerCase() + "_"
					+ userProfile.getLastName().trim().toLowerCase();
	
			String userName = this.findAvailableUserName(userName_prefix);
	
			User user = new User(0L, userName, "123", email, null, userProfile.getFirstName(), userProfile.getLastName(),
					null, "ROLE_USER", true);
			session.save(user);
			return user;
		}

	}

	private String findAvailableUserName(String userName_prefix) {
		User account = this.findByUserName(userName_prefix);
		if (account == null) {
			return userName_prefix;
		}
		int i = 0;
		while (true) {
			String userName = userName_prefix + "_" + i++;
			account = this.findByUserName(userName);
			if (account == null) {
				return userName;
			}
		}
	}
}
