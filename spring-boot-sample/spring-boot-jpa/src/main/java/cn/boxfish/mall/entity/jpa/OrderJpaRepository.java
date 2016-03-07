package cn.boxfish.mall.entity.jpa;

import cn.boxfish.mall.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by LuoLiBing on 16/3/2.
 */
public interface OrderJpaRepository extends JpaRepository<Order, Long> {
}
