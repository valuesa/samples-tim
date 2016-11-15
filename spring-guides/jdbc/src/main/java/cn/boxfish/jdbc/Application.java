package cn.boxfish.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by LuoLiBing on 15/9/30.
 */
@RestController
@SpringBootApplication
public class Application implements CommandLineRunner {

    private final static Logger log = LoggerFactory.getLogger(Application.class);

    @Override
    public void run(String... args) throws Exception {
        log.info("创建表");
//        jdbcTemplate.execute("DROP TABLE customers IF EXISTS");
//        jdbcTemplate.execute("CREATE TABLE customers(id SERIAL, first_name VARCHAR(255), last_name VARCHAR(255),score BIGINT)");
        jdbcTemplate.update("INSERT INTO customers(first_name, last_name,score) VALUES (?,?,?)", "luolibing", "good like", 100);

        log.info("Querying for customer records where first_name = 'Josh':");
    }

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /*@Autowired
    public void setJdbcTemplate(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
    }*/

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @RequestMapping(value = "/decrement", method = RequestMethod.POST)
    public Object decrement() {
        int flag = jdbcTemplate.update("UPDATE customers SET score=(score-10) WHERE id=1 and (score-10)>60");
        System.out.println("flag=" + flag);
        return ResponseEntity.ok().build();
    }

}
