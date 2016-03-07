package cn.boxfish.mall.web;

import cn.boxfish.mall.entity.*;
import cn.boxfish.mall.entity.jpa.OrderJpaRepository;
import cn.boxfish.mall.entity.jpa.OrderProductJpaRepository;
import cn.boxfish.mall.entity.jpa.ServiceJpaRepository;
import cn.boxfish.mall.entity.jpa.WorkOrderJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Random;

/**
 * Created by LuoLiBing on 16/3/4.
 */
@RestController
public class Test1Controller {

    @Autowired
    ServiceJpaRepository serviceJpaRepository;

    @Autowired
    WorkOrderJpaRepository workOrderJpaRepository;

    @Autowired
    OrderJpaRepository orderJpaRepository;

    @Autowired
    OrderProductJpaRepository orderProductJpaRepository;

    @Autowired
    EntityManager entityManager;

    @RequestMapping(value = "/service/{id}", method = RequestMethod.GET)
    public Service service(@PathVariable Long id) {
        return serviceJpaRepository.findOne(id);
    }

    @RequestMapping(value = "/workorder/{id}", method = RequestMethod.GET)
    public WorkOrder workorder(@PathVariable Long id) {
        return workOrderJpaRepository.findOne(id);
    }

    @RequestMapping(value = "/service/save", method = RequestMethod.GET)
    public Service serviceSave() {

        Service service = new Service();
        service.setProductSkuName("测试" + new Random().nextInt(100));
        final WorkOrder workOrder = new WorkOrder();
        workOrder.setStatus("服务完成");
        service.addWorkOrder(workOrder);
        return serviceJpaRepository.save(service);
    }

    @RequestMapping(value = "/order/update/{id}", method = RequestMethod.GET)
    public Order orderSave(@PathVariable Long id) {
        Order order = orderJpaRepository.findOne(id);
        order.setCode(2000111l);
        order.removeOrderProduct(98l);
        order.removeOrderProduct(99l);

        OrderProduct product1 = new OrderProduct();
        product1.setName("商品1");
        order.addOrderProduct(product1);

        OrderProduct product2 = new OrderProduct();
        product2.setName("商品2");
        order.addOrderProduct(product2);
        return orderJpaRepository.save(order);
    }

    /**
     * hateoas 模式
     * localhost:8080/services?pageNumber=1&pageSize=10&sort=id,desc&sort=name,asc
     * {
         "_embedded": {
         "serviceList": [
         {
         "id": 2,
         "productSkuName": "外教",
         "workOrders": []
         },
         {
         "id": 1,
         "productSkuName": "中教",
         "workOrders": []
         }
         ]
         },
         "_links": {
         "self": {
         "href": "http://localhost:8080/services"
         }
         },
         "page": {
         "size": 20,
         "totalElements": 2,
         "totalPages": 1,
         "number": 0
         }
         }
     * @param pageable
     * @param assembler
     * @return
     */
    @RequestMapping(value = "/services", method = RequestMethod.GET)
    public HttpEntity<PagedResources<Service>> services(Pageable pageable, PagedResourcesAssembler assembler) {
        Page<Service> services = serviceJpaRepository.findAll(pageable);
        return new ResponseEntity<>(assembler.toResource(services), HttpStatus.OK);
    }

    /*@RequestMapping(value = "/services/query", method = RequestMethod.GET)
    public Object servicesQuery(@QuerydslPredicate(root = Service.class) Predicate predicate,
                                Pageable pageable, @RequestParam MultiValueMap<String, String> parameterMap) {
        serviceJpaRepository.findAll(predicate, pageable);
    }*/

    @RequestMapping(value = "/services/query", method = RequestMethod.GET)
    public Object servicesQuery(Pageable pageable, ServiceSearchCriteria serviceSearchCriteria) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Service> criteria = builder.createQuery(Service.class);
        Root<Service> entityRoot = criteria.from(Service.class);
        criteria.select(entityRoot);

        if(serviceSearchCriteria.getId() != null) {
            criteria.where(builder.equal(entityRoot.get("id"), serviceSearchCriteria.getId()));
        } else {
            if(!StringUtils.isEmpty(serviceSearchCriteria.getProductSkuName())) {
                criteria.where(builder.like(entityRoot.get("productSkuName"), serviceSearchCriteria.getProductSkuName() + "%"));
            }
        }

        final List<Service> list = entityManager.createQuery(criteria).getResultList();


        /**
         * jackson转泛型list方法.http://stackoverflow.com/questions/19666115/jackson-2-and-json-to-arraylist
         * JavaType type = objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, Sku.class);
           ArrayList<Sku> skuList = objectMapper.readValue(orderProduct.getProductSkuDescription(), type);
         */
        System.out.println(list);
        return list;
    }

}
