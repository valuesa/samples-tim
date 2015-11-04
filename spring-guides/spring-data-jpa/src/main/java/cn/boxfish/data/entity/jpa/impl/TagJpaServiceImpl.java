package cn.boxfish.data.entity.jpa.impl;

import cn.boxfish.data.entity.Tag;
import cn.boxfish.data.entity.jpa.TagJpaRepository;
import org.springframework.stereotype.Service;

/**
 * Created by LuoLiBing on 15/10/30.
 */
@Service
public class TagJpaServiceImpl  {

    /*@Autowired
    private EntityManager entityManager;*/


    private TagJpaRepository tagJpaRepository;

    public Tag tag(Long id) {
        return tagJpaRepository.findOne(id);
    }
}
