package uz.pdp.SpringBootProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uz.pdp.SpringBootProject.AboutMeService;

@Controller
@RequestMapping("/aboutme")
public class AboutMeController {

    @Autowired
    private AboutMeService aboutMeService;

    @GetMapping
    public String showAboutMePage(Model model) {
        model.addAttribute("aboutMe", new AboutMe());
        model.addAttribute("aboutMeList", aboutMeService.getAllAboutMe());
        return "aboutme";
    }

    @PostMapping
    public String createOrUpdateAboutMe(@ModelAttribute AboutMe aboutMe) {
        aboutMeService.saveAboutMe(aboutMe);
        return "redirect:/aboutme";
    }

    @GetMapping("/edit/{id}")
    public String editAboutMe(@PathVariable Long id, Model model) {
        AboutMe aboutMe = aboutMeService.getAboutMeById(id);
        model.addAttribute("aboutMe", aboutMe);
        model.addAttribute("aboutMeList", aboutMeService.getAllAboutMe());
        return "aboutme";
    }

    @GetMapping("/delete/{id}")
    public String deleteAboutMe(@PathVariable Long id) {
        aboutMeService.deleteAboutMe(id);
        return "redirect:/aboutme";
    }
}
