package koreatech.cse.controller.abandom;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;


/**
 * Created by hwangsanghyeok on 29/11/2016.
 */
@Controller
@RequestMapping("/api/abandom")
public class AbandomController {

    public static final String API_KEY = "psdfPy1sS6i9nBc4rJ4mRTXHCArp%2F8YUmbIb%2FZmnV3XCYoAsVfFb4fNNcwWP%2BnpY5SuREgRlpyrRousUu2iVQg%3D%3D";
    public static final String API_URL = "http://openapi.animal.go.kr:80/openapi/service/rest/abandonmentPublicSrvc";

    /**
     * 도, 광역시 리스트
     *
     * @param request
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/province", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public FileSystemResource getProvinceList(HttpServletRequest request) throws IOException {
        String path = request.getSession().getServletContext().getRealPath("/WEB-INF/resources/data") + "/province.json";

        File province = new File(path);

        return new FileSystemResource(province);
    }

    /*
     *  시군구 리스트
     */
    @RequestMapping(value = "/sigungu", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getCities(@RequestParam(value = "upr_cd") String upr_cd) throws IOException, URISyntaxException {


        String url = API_URL
                + "/sigungu"
                + "?serviceKey=" + API_KEY
                + "&upr_cd=" + upr_cd;


        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("accept", "application/json");
        HttpEntity<Object> requestEntity = new HttpEntity<Object>(httpHeaders);


        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.exchange(
                new URI(url),
                HttpMethod.GET,
                requestEntity,
                String.class);

        String body = responseEntity.getBody();

        return body;
    }

    /*      품종 리스트
             축종코드
            - 개 : 417000
            - 고양이 : 422400
            - 기타 : 429900
    */
    @RequestMapping(value = "/kind", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getKinds(@RequestParam(value = "up_kind_cd") String up_kind) throws IOException, URISyntaxException {

        String url = API_URL
                + "/kind"
                + "?serviceKey=" + API_KEY
                + "&up_kind_cd=" + up_kind;


        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("accept", "application/json");
        HttpEntity<Object> requestEntity = new HttpEntity<Object>(httpHeaders);


        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.exchange(
                new URI(url),
                HttpMethod.GET,
                requestEntity,
                String.class);

        String body = responseEntity.getBody();

        return body;
    }

}


