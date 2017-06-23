package com.bizi.hystrix;

import com.bizi.hystrix.service.HelloWorld;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rx.Observable;
import java.util.concurrent.Future;

/**
 * Created by guofangbi on 2017/6/6.
 */
@RestController
public class TestController {
    @RequestMapping("/hello")
    public String hello() throws Exception {
        String result1 = new HelloWorld("Bob").execute();
        Future<String> result2 = new HelloWorld("LiLei").queue();
        Observable<String> result3 = new HelloWorld("HanMeimei").observe();

        return result1+" " + result2.get()+" "+result3.toBlocking().single();
    }
}
