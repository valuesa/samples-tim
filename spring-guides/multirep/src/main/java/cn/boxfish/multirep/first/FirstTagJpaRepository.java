package cn.boxfish.multirep.first;


import org.springframework.data.repository.CrudRepository;

/**
 * Created by LuoLiBing on 15/10/31.
 */
public interface FirstTagJpaRepository extends CrudRepository<cn.boxfish.multirep.first.entity.Tag, Long> {
}
