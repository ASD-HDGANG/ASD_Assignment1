package smartcardDemo.dao;

import java.util.Date;
import java.util.List;

import smartcardDemo.entity.SmartCard;

public class SmartCardDAO implements IGenericDAO<SmartCard> {

	@Override
	public SmartCard create(SmartCard smartcard) {
		smartcard.setTimeCreated(new Date());
		return create(smartcard);
	}

	@Override
	public SmartCard update(SmartCard t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SmartCard get(Object id) {
		// TODO get balance
		return null;
	}

	@Override
	public void delete(Object id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<SmartCard> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return null;
	}

}
