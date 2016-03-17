package cn.boxfish.mall.service;

import cn.boxfish.mall.entity.Teacher;
import cn.boxfish.mall.entity.jpa.TeacherJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by LuoLiBing on 16/3/17.
 */
@Service
//@Transactional
public class Test1Service {

    @Autowired
    private TeacherJpaRepository teacherJpaRepository;

    public Teacher findTeacher(Long id) {
        Teacher teacher = teacherJpaRepository.findOne(id);
        // 加事务变成持久态
        teacher.setName("李镇洞");
        return teacher;
    }

    public void save(Teacher teacher) {
        final Teacher teacher1 = teacherJpaRepository.save(teacher);
        // 加事务变成持久态
        teacher1.setName("李振强");
    }
}
