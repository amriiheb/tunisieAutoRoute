package tn.Proxym.ProxymAcademy.dao.user.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tn.Proxym.ProxymAcademy.dao.user.UserDao;
import tn.Proxym.ProxymAcademy.model.User;
import tn.Proxym.ProxymAcademy.repository.UserRepository;

import java.util.List;
import java.util.Optional;
@Repository
public class AccountDaoImpl implements UserDao {
    @Autowired
	private UserRepository UserRepository;


	@Override
	public Optional<User> findByUsernameOrEmail(String username, String email) {
		return UserRepository.findByUsernameOrEmail(username,email) ;
	}

	@Override
	public Optional<User> findByEmail(String mail) {
		return UserRepository.findByEmail(mail);
	}

	@Override
	public Optional<User> findByUsername(String username) {
		return UserRepository.findByUsername(username);
	}

	@Override
	public Optional<User> findById(long id) {
		return UserRepository.findById(id) ;
	}

	@Override
	public List<User> findAll() {
		return  UserRepository.findAll();
	}

	@Override
	public User create(User entity) {
		return UserRepository.save(entity);
	}

	@Override
	public User update(User entity) {
		return UserRepository.save(entity);
	}

	@Override
	public void delete(User entity) {
          UserRepository.delete(entity);
	}

	@Override
	public void deleteById(long entityId) {
         UserRepository.deleteById(entityId);
	}
}
