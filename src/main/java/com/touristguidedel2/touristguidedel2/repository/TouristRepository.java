package com.touristguidedel2.touristguidedel2.repository;

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
                "Copenhagen",
                List.of(Tags.KID_FRIENDLY, Tags.ENTERTAINMENT)));

        attractions.add(new TouristAttraction("The Little Mermaid Statue",
                "A statue depicting the little mermaid",
                "Copenhagen",
                List.of(Tags.MUSEUM, Tags.HISTORY)));

        attractions.add(new TouristAttraction("Rosenborg Castle",
                "A renaissance castle built in the early 1600s",
                "Copenhagen",
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


    public TouristAttraction addAttraction(TouristAttraction attraction) {
        attractions.add(attraction);
        return attraction;
    }


    public TouristAttraction updateAttraction(TouristAttraction updatedAttraction) {
        for (int i = 0; i < attractions.size(); i++) {
            if (attractions.get(i).getName().equals(updatedAttraction.getName())) {
                attractions.set(i, updatedAttraction);
                return updatedAttraction;
            }
        }
        return null;
    }


    public TouristAttraction deleteAttraction(String name) {
        for (TouristAttraction t : attractions) {
            if (t.getName().equals(name)) {
                attractions.remove(t);
                return t;
            }
        }
        return null;
    }
}
