package cn.boxfish.multirep.second;

import cn.boxfish.multirep.second.entity.Tag;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by LuoLiBing on 15/10/31.
 */
public interface SecondTagJpaRepository extends CrudRepository<Tag, Long> {
}
