package com.touristguide.touristguidedel3.service;

import com.touristguide.touristguidedel3.model.TouristAttraction;
import com.touristguide.touristguidedel3.repository.TouristRepository;
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

    public TouristAttraction getAttractionById(Long id) {
        return repository.getAttractionById(id);
    }

    public void addAttraction(TouristAttraction attraction) {
        repository.addAttraction(attraction);
    }

    public void updateAttraction(TouristAttraction updatedAttraction) {
        repository.updateAttraction(updatedAttraction);
    }

    public void deleteAttraction(Long id) {
        repository.deleteAttraction(id);
    }
}
