package buct.qianqianjun.create;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("buct.qianqianjun.create.dao")
public class CreateApplication {

    public static void main(String[] args) {
        SpringApplication.run(CreateApplication.class, args);
    }

}
