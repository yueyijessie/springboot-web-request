# springboot-web-request
> ### 请求
> 
- 简单参数
    - `@RestController` @RestController = @Controller + @ResponseBody
    - `@RequestMapping("/simpleParam")` 在方法上指定访问路径
    - `@RequestParam("name") String username` 注明这个参数必须传递，不传会400，可以设置required = false来可选传递，默认是true。 name="name"， 将从请求中寻找名为 "name" 的参数
- 数组参数
    - 参数名与传递数组名字保持一致
    - list集合接收，`@RequestParam`将多个参数的值封装到list集合
- 日期参数， `@DateTimeFormat` 指定传递的参数格式
- json参数，`@RequestBody`封装
- 路径参数， `@PathVariable`获取路径参数

[Request Controller](src/main/java/com/example/springbootwebrequest/controller/RequestController.java)



> ### 响应
定义一个统一的返回结果, 使用类来描述，在这个结果中包含：
- 响应状态码：当前请求是成功，还是失败
- 状态码信息：给页面的提示信息
- 返回的数据：给前端响应的数据（字符串、对象、集合）

[Response Controller](src/main/java/com/example/springbootwebrequest/controller/ResponseController.java)

[Result](src/main/java/com/example/springbootwebrequest/pojo/Result.java)





> ### 分层解耦（三层架构，IOC，DI）
**三层架构**
1. controller： 控制层，接收前端请求，对请求处理，给出response
2. service：业务逻辑层，处理业务逻辑
3. dao：数据访问层，持久层，负责数据访问操作，数据增删改查

> [!TIP]
> 用户请求执行顺序1-2-3-2-1
>
> 好处：复用性强，便于维护，利于扩展

IOC容器中创建、管理的对象，称之为：**bean对象**

**控制反转 Inversion Of Control**，简称IOC。对象的创建控制权由程序自身转移到外部（容器），这种思想称为控制反转。
- `@Component` 声明bean的基础注解，作用是把某个对象交给IOC容器管理，需要在类上添加，默认bean的名字为类名首字母小写（不属于以下三类时，用此注解） 
- `@Controller` （标注在控制层类上， @RestController包含@Controller，用得少） 
- `@Service` （标注在业务层类上） 
- `@Repository` （标注在数据访问层类上，由于与mybatis整合，用得少）

**依赖注入 Dependency Injection**，简称DI。容器为应用程序提供运行时，所依赖的资源， 称之为依赖注入。
- `@Autowired` 运行时,从IOC容器中获取该类型对象,赋值给该变量
- 存在多个相同类型的bean对象
    - 使用`@Primary`注解，让当前bean生效 [EmpServiceB](src/main/java/com/example/springbootwebrequest/service/impl/EmpServiceB.java)
    - 使用`@Resource`注解，通过name属性指定要注入的bean的名称 [EmpController](src/main/java/com/example/springbootwebrequest/controller/EmpController.java)
    - 二者区别：
        - @Autowired 是spring框架提供的注解，而@Resource是JDK提供的注解
        - @Autowired 默认是按照类型注入，而@Resource是按照名称注入
