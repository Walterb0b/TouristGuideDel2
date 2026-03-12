package com.touristguide.touristguidedel3.repository;

import com.touristguide.touristguidedel3.model.Tag;
import com.touristguide.touristguidedel3.model.TouristAttraction;
import com.touristguide.touristguidedel3.model.TouristAttractionRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TouristRepository {
    private final List<TouristAttraction> attractions = new ArrayList<>();

    private final JdbcTemplate jdbcTemplate;

    public TouristRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //======
    //Create
    //======
    public void addAttraction(TouristAttraction attraction) {
        String sql = "INSERT INTO tourist_attraction (name, description, city, price) VALUES (?, ?, ?, ?)";

        jdbcTemplate.update(sql,
                attraction.getName(),
                attraction.getDescription(),
                attraction.getCity().name(),
                attraction.getPrice());

        Long id = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Long.class);

        String insertTag = "INSERT INTO tourist_attraction_tag (attraction_id, tag_id) VALUES (?, ?)";

        for(Tag tag : attraction.getTags()) {
            Long tagId = jdbcTemplate.queryForObject(
                    "SELECT id FROM tag WHERE name = ?",
                    Long.class,
                    tag.name()
            );
            jdbcTemplate.update(insertTag, id, tagId);
        }
    }

    //=====
    //Read
    //=====

    public List<TouristAttraction> getAllAttractions() {

        String sqlAttractions = "SELECT * FROM tourist_attraction ORDER BY id";
        List<TouristAttraction> attractions = jdbcTemplate.query(sqlAttractions, new TouristAttractionRowMapper());

        // Hent tags for hver attraktion via join-tabel
        String sqlTags = """
        SELECT t.name
        FROM tag t
        JOIN tourist_attraction_tag tat ON t.id = tat.tag_id
        WHERE tat.attraction_id = ?
    """;

        for (TouristAttraction ta : attractions) {
            List<Tag> tags = jdbcTemplate.query(sqlTags,
                    (rs, rowNum) -> Tag.valueOf(rs.getString("name")),
                    ta.getId());
            ta.setTags(tags);
        }

        return attractions;
    }


    public TouristAttraction getAttractionById(Long id) {
        String sql = "SELECT * FROM tourist_attraction WHERE id = ?";
        TouristAttraction attraction = jdbcTemplate.queryForObject(sql, new TouristAttractionRowMapper(), id);

        attraction.setTags(findTagsByAttractionId(id));
        return attraction;
    }

    public List<Tag> findTagsByAttractionId(Long id) {
        String sql = """
                SELECT t.name
                FROM tag t
                JOIN tourist_attraction_tag tat ON t.id = tat.tag_id
                WHERE tat.attraction_id = ?
                """;

        return jdbcTemplate.query(sql, (rs, rowNum) -> Tag.valueOf(rs.getString("name").trim().toUpperCase()), id);
    }


    //======
    //Update
    //======

    public void updateAttraction(TouristAttraction updatedAttraction) {
        String sql = "UPDATE tourist_attraction SET name = ?, description = ?, city = ?, price = ? WHERE id = ?";
        jdbcTemplate.update(sql,
                updatedAttraction.getName(),
                updatedAttraction.getDescription(),
                updatedAttraction.getCity().name(),
                updatedAttraction.getPrice(),
                updatedAttraction.getId());

        jdbcTemplate.update("DELETE FROM tourist_attraction_tag WHERE attraction_id = ?", updatedAttraction.getId());

        String insertTag = "INSERT INTO tourist_attraction_tag (attraction_id, tag_id) VALUES (?, ?)";
        for (Tag tag : updatedAttraction.getTags()) {
            Long tagId = jdbcTemplate.queryForObject(
                    "SELECT id FROM tag WHERE name = ?",
                    Long.class,
                    tag.name()
            );
            jdbcTemplate.update(insertTag, updatedAttraction.getId(), tagId);
        }
    }

    //======
    //Delete
    //======

    public void deleteAttraction(Long id) {
        // Slet join-tabel entries først
        jdbcTemplate.update("DELETE FROM tourist_attraction_tag WHERE attraction_id = ?", id);
        // Slet attraction
        jdbcTemplate.update("DELETE FROM tourist_attraction WHERE id = ?", id);
    }

}
