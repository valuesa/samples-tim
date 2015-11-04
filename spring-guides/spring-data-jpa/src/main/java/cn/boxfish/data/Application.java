package cn.boxfish.data;

import cn.boxfish.data.entity.School;
import cn.boxfish.data.entity.Tag;
import cn.boxfish.data.entity.jpa.impl.SchoolServiceImpl;
import cn.boxfish.data.entity.jpa.impl.TagJpaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    private SchoolServiceImpl schoolService;

    @Autowired
    private TagJpaServiceImpl tagJpaService;

    @RequestMapping(value = "/tag/{id}", method = RequestMethod.GET)
    public Tag tag(@PathVariable Long id) {
        return tagJpaService.tag(id);
    }

    @RequestMapping(value = "/school/{id}", method = RequestMethod.GET)
    public School school(@PathVariable Long id) {
        School school = schoolService.find(id);
        return school;
    }
}
