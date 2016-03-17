package cn.boxfish.dto.service;

import cn.boxfish.dto.entity.jpa.TeacherJpaRepository;
import cn.boxfish.dto.view.TeacherView;
import org.jdto.DTOBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by LuoLiBing on 16/3/17.
 */
@Service
public class TeacherService {

    @Autowired
    private TeacherJpaRepository teacherJpaRepository;

    @Autowired
    private DTOBinder binder;

    public TeacherView findTeacher(Long id) {
        return binder.bindFromBusinessObject(TeacherView.class, teacherJpaRepository.findOne(id));
    }
}
