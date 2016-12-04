package koreatech.cse.controller.swagger;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by blood_000 on 2016-12-04.
 */
@Api(value = "스웨거 테스트", description = "스웨거를 테스트 하는 컨트롤러")
@RestController
@RequestMapping("/swagger")
public class SwaggerExampleController {

    @RequestMapping(value = "/hello/{name}", method = RequestMethod.GET)
    @ApiOperation(value = "API에 대한 요약을 적어줘요",
            notes = "API에 대한 상세 설명을 여기에 적으면 되요")
    public String hello(@PathVariable String name) {
        String result = "hello " + name;
        return result;
    }

}
