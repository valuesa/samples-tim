package cn.boxfish.data.entity.jpa.impl;

import cn.boxfish.data.entity.School;
import cn.boxfish.data.entity.jpa.FirstSchoolJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
