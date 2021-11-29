import com.demo.entity.Person;
import com.demo.entity.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan("com.demo")
public class Example {
    @Resource
    private Person person;

    @RequestMapping("/username/get")
    public String home(@RequestParam String username) {
        return username;
    }

    //prosuces：也可以在注解中指定内容协商的类型，即告诉客户端，我这个接口只能返回xml格式的数据
    //具体应用：返回自定义区模板内容接口，直接指定了返回给前端的是xml格式的数据
    @RequestMapping(value = "/person/get", produces = MediaType.APPLICATION_XML_VALUE)
    public Person getPerson() {
        return person;
    }

    @RequestMapping("/student/get")
    public Student getStudent() {
        Student student = new Student();
        student.setName("mcdull");
        student.setAge(18);
        return student;
    }

    public static void main(String[] args) {
        SpringApplication.run(Example.class, args);
    }
}
