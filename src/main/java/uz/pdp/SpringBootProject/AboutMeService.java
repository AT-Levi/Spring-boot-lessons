package uz.pdp.SpringBootProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.SpringBootProject.AboutMe;
import uz.pdp.SpringBootProject.AboutMeDAO;

import java.util.List;

@Service
public class AboutMeService {

    @Autowired
    private AboutMeDAO aboutMeDAO;

    public List<AboutMe> getAllAboutMe() {
        return aboutMeDAO.findAll();
    }

    public AboutMe getAboutMeById(Long id) {
        return aboutMeDAO.findById(id);
    }

    public int saveAboutMe(AboutMe aboutMe) {
        return aboutMeDAO.save(aboutMe);
    }

    public int updateAboutMe(Long id, AboutMe aboutMeDetails) {
        aboutMeDetails.setId(id);
        return aboutMeDAO.update(aboutMeDetails);
    }

    public int deleteAboutMe(Long id) {
        return aboutMeDAO.deleteById(id);
    }
}
