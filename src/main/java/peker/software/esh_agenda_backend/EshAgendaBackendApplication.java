package peker.software.esh_agenda_backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import peker.software.esh_agenda_backend.dataAccess.CityDao;
import peker.software.esh_agenda_backend.entities.utils.City;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;



@SpringBootApplication
@EnableSwagger2
public class EshAgendaBackendApplication implements CommandLineRunner {

    @Autowired
    private  CityDao cityDao;

    public static void main(String[] args) {
        SpringApplication.run(EshAgendaBackendApplication.class, args);
    }


    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("peker.software.esh_agenda_backend"))
                .build();
    }

    @Override
    public void run(String... args) throws Exception {

        cityDao.save(new City(0, "KONYA"));
        cityDao.save(new City(0, "ANKARA"));
        cityDao.save(new City(0, "NİĞDE"));
        cityDao.save(new City(0, "ADANA"));
        cityDao.save(new City(0, "ANTALYA"));
        cityDao.save(new City(0, "HATAY"));
        cityDao.save(new City(0, "İSTANBUL"));
        cityDao.save(new City(0, "İZMİR"));
    }
}
