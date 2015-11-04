package cn.boxfish.data.entity.jpa;

import cn.boxfish.data.entity.School;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by LuoLiBing on 15/10/31.
 */
public interface FirstSchoolJpaRepository extends CrudRepository<School, Long> {
}
