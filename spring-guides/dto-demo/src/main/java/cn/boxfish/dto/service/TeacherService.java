package cn.boxfish.dto.service;

import cn.boxfish.dto.entity.Teacher;
import cn.boxfish.dto.entity.jpa.TeacherJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by LuoLiBing on 16/3/17.
 */
@Service
public class TeacherService {

    @Autowired
    private TeacherJpaRepository teacherJpaRepository;

    public Teacher findTeacher(Long id) {
        return teacherJpaRepository.findOne(id);
    }


    public void save(Teacher teacher) {
        System.out.println(teacher);
    }
}
