package com.touristguidedel2.touristguidedel2.repository;

import com.touristguidedel2.touristguidedel2.model.Cities;
import com.touristguidedel2.touristguidedel2.model.Tags;
import com.touristguidedel2.touristguidedel2.model.TouristAttraction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TouristRepository {
    private final List<TouristAttraction> attractions = new ArrayList<>();


    public TouristRepository() {
        attractions.add(new TouristAttraction("Tivoli",
                "An amusement park in the middle of Copenhagen",
                Cities.COPENHAGEN,
                List.of(Tags.KID_FRIENDLY, Tags.ENTERTAINMENT)));

        attractions.add(new TouristAttraction("The Little Mermaid Statue",
                "A statue depicting the little mermaid",
                Cities.COPENHAGEN,
                List.of(Tags.MUSEUM, Tags.HISTORY)));

        attractions.add(new TouristAttraction("Rosenborg Castle",
                "A renaissance castle built in the early 1600s",
                Cities.COPENHAGEN,
                List.of(Tags.HISTORY, Tags.MUSEUM)));
    }

    public List<TouristAttraction> getAllAttractions() {
        return attractions;
    }


    public TouristAttraction getAttractionByName(String name) {
        for (TouristAttraction attraction : attractions) {
            if (attraction.getName().equalsIgnoreCase(name)) {
                return attraction;
            }
        }
        return null;
    }


    public void addAttraction(TouristAttraction attraction) {
        attractions.add(attraction);
    }


    public void updateAttraction(TouristAttraction updatedAttraction) {
        for (TouristAttraction touristAttraction : attractions) {
            if (touristAttraction.getName().equals(updatedAttraction.getName())) {
                touristAttraction.setDescription(updatedAttraction.getDescription());
                touristAttraction.setCity(updatedAttraction.getCity());
                touristAttraction.setTags(updatedAttraction.getTags());
                return;
            }
        }
    }


    public void deleteAttraction(String name) {
        attractions.removeIf(t -> t.getName().equals(name));
    }
}
