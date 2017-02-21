package cn.boxfish.db.sample1.service;

import cn.boxfish.db.sample1.entity.Person;
import cn.boxfish.db.sample1.jpa.PersonJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by LuoLiBing on 17/2/21.
 */
@Service
public class PersonService {

    @Autowired
    private PersonJpaRepository personJpaRepository;

    /**
     * InnoDB在可重复读的情况下, 如果一个字段加了索引会使用行锁 + 间隙锁的组合来解决幻读的发生
     * 在扫描索引记录的时候, 会首先对选中的索引记录加上行锁, 再对索引记录两边的间隙(第一个比参数小的, 第一个比参数大的值, 构成一个区间)加上间隙锁(Gap Lock).
     * 如果一个间隙被事务T1加了锁, 其他事务是不能在这个间隙插入记录的.
     *
     * 在并发的情况下有可能会发生死锁, 间隙锁在InnoBD唯一作用就是防止其它事务的插入操作, 防止幻读的发生, 所以不分共享锁与排它锁.
     * 如果扫描的是一个主键或者是一个唯一索引的话, InnoDB只会采用行锁方式加锁.
     *
     * 禁止间隙锁的话, 可以把隔离级别降为读已提交, 或者开启参数innodb_locks_unsafe_for_binlog
     * Deadlock found when trying to get lock; try restarting transaction
     * @param person
     * @param age
     * @param num
     */
    @Transactional
    public void gapLock(Person person, Integer age, int num) {
        System.out.println(num);
        personJpaRepository.deleteByAge(age);
        personJpaRepository.save(person);
    }


    /**
     * 读提交, 可以解决间隙锁, 但是同样解决不了死锁的问题
     * @param person
     * @param age
     * @param num
     */
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void save2(Person person, Integer age, int num) {
        System.out.println(num);
        personJpaRepository.deleteByAge(age);
        personJpaRepository.save(person);
    }


    @Transactional
    public void pessimistic(Person person, Integer age, int num) {
        System.out.println(num);
        List<Person> list = personJpaRepository.findByAgePessimistic(age);
    }
}
