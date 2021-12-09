# SpringCloud-demo

## 基于Eureka进行服务发现的SpringCloudDemo
- 启动`Eureka-Server`注册中心
- 启动`Eureka-Provider`客户端
- 启动`Eureka-Consumer`消费者

## 使用OpenFeign替代RestTemplate
- `consumer`添加`OpenFeign`依赖
```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-openfeign</artifactId>
</dependency>
```
- `consumer`添加`interface`并使用`@FeignCLient`注解，指定提供方的应用名称
```java
@FeignClient(name = "eureka-producer")
public interface EurekaFeignService {

    @RequestMapping(value = "sayHello", headers = {"Content-Type=application/json"})
    String sayHello(@RequestParam String user);

    @RequestMapping(value = "hello")
    String hello();
}
```
- `consumer`修改请求对应API接口的方式
```java
@RestController
@Slf4j
public class HelloController {

    @Autowired
    private EurekaFeignService eurekaFeignService;

    @RequestMapping("greet")
    public String greet(){
        log.info("receive a greet request");
        return eurekaFeignService.hello();
    }

    @RequestMapping(value = "sayGreet")
    public String sayGreet(@RequestParam String user){
        log.info("receive a sayGreet request, user={}", user);
        return eurekaFeignService.sayHello(user);
    }

}
```
