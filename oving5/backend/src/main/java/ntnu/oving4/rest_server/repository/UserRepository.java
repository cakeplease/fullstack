package ntnu.oving4.rest_server.repository;

import ntnu.oving4.rest_server.model.User;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserRepository {
    public JdbcTemplate jdbcTemplate;
    public String save(User user) {
        jdbcTemplate.update("INSERT INTO user (column1, column2) VALUES (?, ?)", user.getUsername(), user.getPassword());
        return user.getUsername();
    }
}
