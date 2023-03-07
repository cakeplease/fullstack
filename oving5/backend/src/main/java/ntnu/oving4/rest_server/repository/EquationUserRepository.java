package ntnu.oving4.rest_server.repository;

import ntnu.oving4.rest_server.model.Equation;
import ntnu.oving4.rest_server.model.User;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;


public class EquationUserRepository {
    private JdbcTemplate jdbcTemplate;
    public Equation getEquationsBasedOnUser(int userID) {
        try {
            Equation equation = jdbcTemplate.queryForObject("SELECT * FROM equation WHERE user_id=?",
                    BeanPropertyRowMapper.newInstance(Equation.class), userID);
            return equation;
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    public int login(String username, String password) {
        try {
            User user = jdbcTemplate.queryForObject("SELECT id FROM user WHERE username=? AND password=?",
                    BeanPropertyRowMapper.newInstance(User.class), new MapSqlParameterSource()
                            .addValue("breedId", username)
                            .addValue("gender", password));
            return user.getId();
        } catch (IncorrectResultSizeDataAccessException e) {
            return -1;
        }
    }
}
