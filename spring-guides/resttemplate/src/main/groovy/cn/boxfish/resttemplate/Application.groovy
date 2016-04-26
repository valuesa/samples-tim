package cn.boxfish.resttemplate

import com.boxfishedu.beans.view.JsonResultModel
import groovy.util.logging.Slf4j
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate

/**
 * Created by LuoLiBing on 15/9/30.
 */
@SpringBootApplication
@Slf4j
@RestController
class Application implements CommandLineRunner {


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args)
    }


    /**
     * httpClient
     * @param args
     * @throws Exception
     */
    @Override
    void run(String... args) throws Exception {
        /*RestTemplate restTemplate = new RestTemplate()
        // 异常处理
        restTemplate.setErrorHandler(new MyCustomException())
        try {
            def value = restTemplate.getForObject(
                    "http://localhost:8080/genericException?name=luolibing", Value.class)
            log.info("id:$value.id,name:$value.content")
        } catch (Exception e) {
            println e.cause
        }*/

        /*BASE64Encoder encoder = new BASE64Encoder();

        def result = [:]
        result.put("base", encoder.encode(new File("/share/资源/图片/looks of complete distain 不屑的表情.jpg").bytes))

        HttpEntity entity = new HttpEntity(result);

        RestTemplate template = new RestTemplate()
        def response = template.postForEntity("http://localhost:8080/upload", entity, String.class)
        println response*/

        /*RestTemplate template = new RestTemplate()
        def html = template.getForEntity("https://www.baidu.com/s?wd=NBA", String.class)
        println html.body*/

        //template.setErrorHandler(new MyCustomException())

        /*RestTemplate restTemplate = new RestTemplate();

        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
        requestFactory.setConnectTimeout(60000);
        requestFactory.setReadTimeout(60000);

        restTemplate.setRequestFactory(requestFactory);

        def exchange = restTemplate.exchange("http://localhost:8080/upload", HttpMethod.PATCH, new HttpEntity<>(), String.class)
        println  exchange.getBody()*/

        /*JsonResultModel jsonResultModel = new RestTemplate().getForObject("http://localhost:8070/order/page?page=0&size=20", JsonResultModel.class)
        println jsonResultModel*/
    }

    @RequestMapping(value = "/page")
    public Object page() {
        new RestTemplate().getForObject("http://192.168.66.176:8088/teacher/page/1?page=0&size=20", JsonResultModel.class)
    }

}
