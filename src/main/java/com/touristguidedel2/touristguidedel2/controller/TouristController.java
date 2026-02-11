package com.touristguidedel2.touristguidedel2.controller;

import com.touristguidedel2.touristguidedel2.model.Tags;
import com.touristguidedel2.touristguidedel2.model.TouristAttraction;
import com.touristguidedel2.touristguidedel2.service.TouristService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/attractions")
public class TouristController {

    private TouristService touristService;

    public TouristController(TouristService touristService) {
        this.touristService = touristService;
    }

    @GetMapping
    public String getAllAttractions(Model model) {
        List<TouristAttraction> attractions = touristService.getAllAttractions();
        model.addAttribute("attractions", attractions);

        return "attractionsList";
    }

    @GetMapping("/{name}/tags")
    public String getAttractionTags(Model model, @PathVariable String name) {
        TouristAttraction touristAttraction = touristService.getAttractionByName(name);

        model.addAttribute("touristAttraction", touristAttraction);
        model.addAttribute("tags", touristAttraction.getTags());

        return "tags";

    }
}
