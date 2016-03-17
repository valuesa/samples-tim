package cn.boxfish.dto.web;

import cn.boxfish.dto.service.TeacherService;
import cn.boxfish.dto.view.TeacherView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by LuoLiBing on 16/3/17.
 */
@RestController
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @RequestMapping(value = "/save")
    public TeacherView save(TeacherView teacherView) {
        return null;
    }

    @RequestMapping(value = "/teacher/{id}", method = RequestMethod.GET)
    public TeacherView findTeacher(@PathVariable Long id) {
        return teacherService.findTeacher(id);
    }

}
