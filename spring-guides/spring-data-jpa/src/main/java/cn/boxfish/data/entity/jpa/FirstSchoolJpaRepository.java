package cn.boxfish.data.entity.jpa;

import cn.boxfish.data.entity.School;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by LuoLiBing on 15/10/31.
 */
public interface FirstSchoolJpaRepository extends CrudRepository<School, Long> {

    //@Query("select s from School s join s.teacherList t")
//    List<School> findSchoolByName();
}
