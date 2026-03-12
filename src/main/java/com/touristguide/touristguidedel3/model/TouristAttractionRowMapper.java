package com.touristguide.touristguidedel3.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TouristAttractionRowMapper implements RowMapper<TouristAttraction> {


    @Override
    public TouristAttraction mapRow(ResultSet rs, int rowNum) throws SQLException {

        TouristAttraction touristAttraction = new TouristAttraction();
        touristAttraction.setId(rs.getLong("id"));
        touristAttraction.setName(rs.getString("name"));
        touristAttraction.setDescription(rs.getString("description"));
        touristAttraction.setPrice(rs.getBigDecimal("price"));
        touristAttraction.setCity(City.fromDb(rs.getString("city"))); // robust mapping
        touristAttraction.setTags(new ArrayList<>());

        return touristAttraction;
    }
}
