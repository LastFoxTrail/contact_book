package com.lis.projects.dao;

import com.lis.projects.model.Contact;
import java.util.List;

public interface ContactDao {
    List<Contact> get();
    Contact getById(Long id);
    void save(Contact contact);
    void update(Contact contact);
    void delete(Long id);
}
