package cn.boxfish.multirep.second;

import cn.boxfish.multirep.second.entity.School;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by LuoLiBing on 15/10/31.
 */
public interface SecondSchoolJpaRepository extends CrudRepository<School, Long> {
}
