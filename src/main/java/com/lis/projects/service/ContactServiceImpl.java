package com.lis.projects.service;

import com.lis.projects.dao.ContactDao;
import com.lis.projects.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {
    @Autowired
    private ContactDao contactDao;

    @Override
    public List<Contact> get() {
        return contactDao.get();
    }

    @Override
    public Contact getById(Long id) {
        return contactDao.getById(id);
    }

    @Override
    public void save(Contact contact) {
        contactDao.save(contact);
    }

    @Override
    public void update(Contact contact) {
        contactDao.update(contact);
    }

    @Override
    public void delete(Long id) {
        contactDao.delete(id);
    }
}
