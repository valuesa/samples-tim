package cn.boxfish.mail.entity.jpa;

import cn.boxfish.mail.entity.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by LuoLiBing on 16/3/2.
 */
public interface OrderProductJpaRepository extends JpaRepository<OrderProduct, Long> {
}
