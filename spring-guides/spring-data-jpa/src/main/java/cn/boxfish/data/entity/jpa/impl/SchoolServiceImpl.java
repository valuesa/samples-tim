package cn.boxfish.data.entity.jpa.impl;

import cn.boxfish.data.entity.School;
import cn.boxfish.data.entity.Teacher;
import cn.boxfish.data.entity.jpa.FirstSchoolJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by LuoLiBing on 15/10/31.
 */

@Service
public class SchoolServiceImpl {

    @Autowired
    private FirstSchoolJpaRepository firstSchoolJpaRepository;

    public School find(Long id) {
        return firstSchoolJpaRepository.findOne(id);
    }

    public void save(Long id) {
        final School school = firstSchoolJpaRepository.findOne(id);
        final List<Teacher> teacherList = school.getTeacherList();
        teacherList.remove(0);
        final Teacher t = new Teacher();
        t.setName("luo");
        teacherList.add(t);
        firstSchoolJpaRepository.save(school);
    }
}
