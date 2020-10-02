package smartcardDemo.dao;

import java.util.Date;
import java.util.List;

import smartcardDemo.entity.Customer;

public class CustomerDAO implements IGenericDAO<Customer> {

	public CustomerDAO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Customer create(Customer customer) {
		customer.setRegisterDate(new Date());
		return customer;
	}

	@Override
	public Customer update(Customer t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer get(Object id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Object id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Customer> getAll() {
		// TODO Auto-generated method stub
		//collection.find(new Document("email", "youremail"))
		return null;
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return null;
	}

}
