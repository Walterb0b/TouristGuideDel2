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
        populate();
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

    private void populate() {
        attractions.add(new TouristAttraction(
                "Nyhavn",
                "En historisk havn med farverige huse, restauranter og caféer",
                Cities.COPENHAGEN,
                List.of(Tags.FREE, Tags.HISTORY),
                0.0
        ));

        attractions.add(new TouristAttraction(
                "ARoS Kunstmuseum",
                "Et moderne kunstmuseum kendt for den cirkulære regnbue på taget",
                Cities.AARHUS,
                List.of(Tags.MUSEUM, Tags.ENTERTAINMENT),
                150.0
        ));

        attractions.add(new TouristAttraction(
                "Den Gamle By",
                "Et frilandsmuseum der viser dansk byliv gennem historien",
                Cities.AARHUS,
                List.of(Tags.MUSEUM, Tags.HISTORY, Tags.KID_FRIENDLY),
                120.0
        ));

        attractions.add(new TouristAttraction(
                "Odense Zoo",
                "En populær zoologisk have med dyr fra hele verden",
                Cities.ODENSE,
                List.of(Tags.KID_FRIENDLY, Tags.ENTERTAINMENT),
                100.0
        ));

        attractions.add(new TouristAttraction(
                "Aalborg Zoo",
                "En familievenlig zoologisk have med fokus på naturbevarelse",
                Cities.AALBORG,
                List.of(Tags.KID_FRIENDLY, Tags.ENTERTAINMENT),
                150.0
        ));

        attractions.add(new TouristAttraction(
                "Legoland Billund",
                "En forlystelsespark bygget af LEGO-klodser for hele familien",
                Cities.VEJLE,
                List.of(Tags.KID_FRIENDLY, Tags.ENTERTAINMENT),
                299.0
        ));

        attractions.add(new TouristAttraction(
                "Ribe Vikingecenter",
                "Et levende museum der genskaber vikingernes liv og hverdag",
                Cities.ESBJERG,
                List.of(Tags.HISTORY, Tags.MUSEUM, Tags.KID_FRIENDLY),
                150.0
        ));

        attractions.add(new TouristAttraction(
                "Frederiksborg Slot",
                "Et imponerende renæssanceslot omgivet af søer og haver",
                Cities.HILLEROED,
                List.of(Tags.HISTORY, Tags.MUSEUM),
                99.95
        ));

        attractions.add(new TouristAttraction(
                "Himmelbjerget",
                "Et af Danmarks højeste punkter med flot udsigt over landskabet",
                Cities.SILKEBORG,
                List.of(Tags.FREE, Tags.HISTORY),
                0.0
        ));

        attractions.add(new TouristAttraction(
                "H.C. Andersens Hus",
                "Et museum dedikeret til forfatteren H.C. Andersens liv og værker",
                Cities.ODENSE,
                List.of(Tags.MUSEUM, Tags.HISTORY),
                115.0
        ));
    }
}
