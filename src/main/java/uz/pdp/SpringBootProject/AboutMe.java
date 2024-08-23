package uz.pdp.SpringBootProject;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AboutMe {


    private Long id;
    private String name;
    private String bio;
    private String hobbies;
    private String contact;

}
