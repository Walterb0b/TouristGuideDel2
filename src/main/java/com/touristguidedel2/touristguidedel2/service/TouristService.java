package com.touristguidedel2.touristguidedel2.service;

import com.touristguidedel2.touristguidedel2.model.TouristAttraction;
import com.touristguidedel2.touristguidedel2.repository.TouristRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TouristService {
    private final TouristRepository repository;

    public TouristService(TouristRepository repository) {
        this.repository = repository;
    }

    public List<TouristAttraction> getAllAttractions() {
        return repository.getAllAttractions();
    }

    public TouristAttraction getAttractionByName(String name) {
        return repository.getAttractionByName(name);
    }

    public TouristAttraction addAttraction(TouristAttraction attraction) {
        return repository.addAttraction(attraction);
    }

    public TouristAttraction updateAttraction(TouristAttraction updatedAttraction) {
        return repository.updateAttraction(updatedAttraction);
    }

    public TouristAttraction deleteAttraction(String name) {
        return repository.deleteAttraction(name);
    }
}
