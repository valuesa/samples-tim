package cn.boxfish.mall.entity.jpa;

import cn.boxfish.mall.entity.WorkOrder;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by LuoLiBing on 16/3/1.
 */
public interface WorkOrderJpaRepository extends JpaRepository<WorkOrder, Long> {
}
