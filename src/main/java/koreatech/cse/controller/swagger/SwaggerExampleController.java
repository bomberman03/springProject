package koreatech.cse.controller.swagger;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by blood_000 on 2016-12-04.
 */
@RestController
@RequestMapping("/swagger")
public class SwaggerExampleController {

    @RequestMapping(value = "/hello/{name}", method = RequestMethod.GET)
    public String hello(@PathVariable String name) {
        String result = "hello " + name;
        return result;
    }

}
