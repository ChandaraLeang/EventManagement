package mum.ea.service;

import java.sql.Types;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import mum.ea.domain.Role;
import mum.ea.domain.User;
import mum.ea.repository.RoleRepository;
import mum.ea.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public void saveUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        Role userRole = roleRepository.findByRole("ADMIN");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		userRepository.save(user);
	}

/*	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}
	*/
	 
	 @Override
	 public List<User> findAll() {

	    TypedQuery query = em.createQuery("select u from User u where status = 3", User.class);

/*	    query.setFirstResult(1 * 10);
	    query.setMaxResults(10);
*/
	    return query.getResultList();
	}

	
	@Override
	public void deleteUser(long id) {
		User user = userRepository.findOne(id);
		userRepository.delete(user);
		
		/*JdbcTemplate template = new JdbcTemplate(dataSource);
		Object[] params = { id };
		long[] types = {Types.BIGINT};
		delete from eadb.user_roles where eadb.user_roles.user_user_id =3;
		delete from eadb.user_groups where eadb.user_groups.user_user_id =3;
		String deleteSql = "DELETE FROM eadb.user_roles where eadb.user_roles.user_user_id = ?";
		int rows = template.update(deleteSql, params, types);
		deleteSql = "DELETE FROM eadb.user_groups where eadb.user_groups.user_user_id = ?";
		rows = template.update(deleteSql, params, types);
		userRepository.delete(id);*/
	}

}
