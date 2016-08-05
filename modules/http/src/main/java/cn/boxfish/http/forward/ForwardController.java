package cn.boxfish.http.forward;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by LuoLiBing on 16/8/3.
 * 通信数据转发程序: 代理\网关\隧道
 */
@RestController
@RequestMapping(value = "/forward")
public class ForwardController {

    /**
     * 代理会在响应头中加上Via: 经过的代理服务器
     * 代理的作用 缓存代理\访问控制\获取日志
     * 代理分为两种,一种是是否使用缓存, 另一种是是否会修改报文
     *
     * @return
     */
    @RequestMapping(value = "proxy")
    public Object proxy() {
        return ResponseEntity.ok().header("via", "BJ-Y-NX-103(HIT)").build();
    }

}
