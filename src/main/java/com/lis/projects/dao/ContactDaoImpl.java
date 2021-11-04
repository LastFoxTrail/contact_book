package com.lis.projects.dao;

import com.lis.projects.model.Contact;
import com.lis.projects.util.ConnectionManager;
import org.springframework.stereotype.Repository;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ContactDaoImpl implements ContactDao {
    private static Connection connection = null;

    static {
        try {
            connection = ConnectionManager.getConnection();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ContactDaoImpl() {}

    @Override
    public List<Contact> get() {
        List<Contact> resultList = new ArrayList<>();

        try (Statement statement = connection.createStatement()) {
            ResultSet contactsList = statement.executeQuery("SELECT * FROM contacts");

            while (contactsList.next()) {
                Contact contact = new Contact();
                contact.setId(contactsList.getLong("id"));
                contact.setName(contactsList.getString("name"));
                contact.setSurname(contactsList.getString("surname"));
                contact.setAdress(contactsList.getString("adress"));
                contact.setPhone(contactsList.getString("phone_number"));
                resultList.add(contact);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return resultList;
    }

    @Override
    public Contact getById(Long id) {
        String query = "SELECT * FROM contacts WHERE id=?";
        Contact contact = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            contact = new Contact();
            resultSet.next();
            contact.setId(resultSet.getLong("id"));
            contact.setName(resultSet.getString("name"));
            contact.setSurname(resultSet.getString("surname"));
            contact.setAdress(resultSet.getString("adress"));
            contact.setPhone(resultSet.getString("phone_number"));

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return contact;
    }

    @Override
    public void save(Contact contact) {
        String query = "INSERT INTO contacts(name, surname, adress, phone_number) VALUES (?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, contact.getName());
            preparedStatement.setString(2, contact.getSurname());
            preparedStatement.setString(3, contact.getAdress());
            preparedStatement.setString(4, contact.getPhone());
            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void update(Contact contact) {
        String query = "UPDATE contacts SET name=?, surname=?, adress=?, phone_number=? WHERE id=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, contact.getName());
            preparedStatement.setString(2, contact.getSurname());
            preparedStatement.setString(3, contact.getAdress());
            preparedStatement.setString(4, contact.getPhone());
            preparedStatement.setLong(5, contact.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {
        String query = "DELETE FROM contacts WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
