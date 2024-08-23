package uz.pdp.SpringBootProject;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class AboutMeDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final RowMapper<AboutMe> rowMapper = new RowMapper<AboutMe>() {

        @Override
        public AboutMe mapRow(ResultSet rs, int rowNum) throws SQLException {
            AboutMe aboutMe = new AboutMe();
            aboutMe.setId(rs.getLong("id"));
            aboutMe.setName(rs.getString("name"));
            aboutMe.setBio(rs.getString("bio"));
            aboutMe.setHobbies(rs.getString("hobbies"));
            aboutMe.setContact(rs.getString("contact"));
            return aboutMe;
        }
    };

    public List<AboutMe> findAll() {
        String sql = "SELECT * FROM about_me";
        return jdbcTemplate.query(sql, rowMapper);
    }

    public AboutMe findById(Long id) {
        String sql = "SELECT * FROM about_me WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, rowMapper);
    }

    public int save(AboutMe aboutMe) {
        String sql = "INSERT INTO about_me (name, bio, hobbies, contact) VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(sql, aboutMe.getName(), aboutMe.getBio(), aboutMe.getHobbies(), aboutMe.getContact());
    }

    public int update(AboutMe aboutMe) {
        String sql = "UPDATE about_me SET name = ?, bio = ?, hobbies = ?, contact = ? WHERE id = ?";
        return jdbcTemplate.update(sql, aboutMe.getName(), aboutMe.getBio(), aboutMe.getHobbies(), aboutMe.getContact(), aboutMe.getId());
    }

    public int deleteById(Long id) {
        String sql = "DELETE FROM about_me WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }
}
