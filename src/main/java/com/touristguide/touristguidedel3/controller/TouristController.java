package com.touristguide.touristguidedel3.controller;

import com.touristguide.touristguidedel3.model.City;
import com.touristguide.touristguidedel3.model.Tag;
import com.touristguide.touristguidedel3.model.TouristAttraction;
import com.touristguide.touristguidedel3.service.TouristService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/attractions")
public class TouristController {

    private final TouristService touristService;

    public TouristController(TouristService touristService) {
        this.touristService = touristService;
    }

    @GetMapping
    public String getAllAttractions(Model model) {
        List<TouristAttraction> attractions = touristService.getAllAttractions();
        model.addAttribute("attractions", attractions);

        return "attractionsList";
    }

    @GetMapping("/{id}/tags")
    public String getAttractionTags(Model model, @PathVariable Long id) {
        TouristAttraction touristAttraction = touristService.getAttractionById(id);
        if(touristAttraction == null) {
            throw new IllegalArgumentException("Invalid attraction!" + id);
        }

        model.addAttribute("touristAttraction", touristAttraction);
        model.addAttribute("tags", touristAttraction.getTags());
        return "tags";
    }

    //Display the Attraction edit form
    @GetMapping("/{id}/edit")
    public String editAttraction(@PathVariable Long id, Model model) {
        TouristAttraction touristAttraction = touristService.getAttractionById(id);

        if(touristAttraction == null) {
            throw new IllegalArgumentException("Invalid attraction! " + id);
        }

        model.addAttribute("touristAttraction", touristAttraction);
        model.addAttribute("cities", City.values());
        model.addAttribute("tags", Tag.values());

        return "updateAttraction";
    }

    //Handle the form submission
    @PostMapping("/update")
    public String editAttraction(@ModelAttribute TouristAttraction touristAttraction) {
        touristService.updateAttraction(touristAttraction);
        return "redirect:/attractions";
    }

    @GetMapping("/add")
    public String addAttraction(Model model) {
        TouristAttraction touristAttraction = new TouristAttraction();
        model.addAttribute("touristAttraction", touristAttraction);
        model.addAttribute("cities", City.values());
        model.addAttribute("tags", Tag.values());
        return "addAttraction";
    }

    @PostMapping("/save")
    public String saveAttraction(@ModelAttribute TouristAttraction touristAttraction) {
        touristService.addAttraction(touristAttraction);
        return "redirect:/attractions";
    }

    @PostMapping("/{id}/delete")
    public String deleteAttraction(@PathVariable Long id) {
        touristService.deleteAttraction(id);
        return "redirect:/attractions";
    }
}
