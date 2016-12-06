package koreatech.cse.controller.abandom;

import com.fasterxml.jackson.databind.ObjectMapper;
import koreatech.cse.domain.abandom.abandonment.Abandonment;
import koreatech.cse.domain.abandom.abandonment.Item;
import koreatech.cse.domain.abandom.map.Map;
import koreatech.cse.domain.abandom.map.Point;
import koreatech.cse.domain.abandom.recordAgency.RecordAgency;
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
import java.net.URLEncoder;
import java.util.List;


/**
 * Created by hwangsanghyeok on 29/11/2016.
 */
@Controller
@RequestMapping("/api/abandom")
public class AbandomController {

    public static final String API_KEY = "psdfPy1sS6i9nBc4rJ4mRTXHCArp%2F8YUmbIb%2FZmnV3XCYoAsVfFb4fNNcwWP%2BnpY5SuREgRlpyrRousUu2iVQg%3D%3D";
    public static final String API_URL = "http://openapi.animal.go.kr:80/openapi/service/rest/abandonmentPublicSrvc";
    public static final String NAVER_URL = "https://openapi.naver.com/v1/map/geocode?query=";
    public static final String AGENCY_URL = "http://openapi.animal.go.kr/openapi/service/rest/recordAgencySrvc/recordAgency";

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

    //보호소 리스트
    @RequestMapping(value = "/shelter", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getShelters(@RequestParam(value = "upr_cd") String upr_cd,
                              @RequestParam(value = "org_cd") String org_cd) throws IOException, URISyntaxException {

        String url = API_URL
                + "/kind"
                + "?serviceKey=" + API_KEY
                + "&upr_cd=" + upr_cd
                + "&org_cd=" + org_cd;

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("accept", "application/json");
        HttpEntity<Object> requestEntity = new HttpEntity<Object>(httpHeaders);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.exchange(
                new URI(url),
                HttpMethod.GET,
                requestEntity,
                String.class);

        String response = responseEntity.getBody();

        return response;
    }

    /*
     *  유기동물 리스트 API
     */
    @RequestMapping(value = "/abandonment", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getAbandonmentList(HttpServletRequest request,
                                     @RequestParam(value = "bgnde") int bgnde,
                                     @RequestParam(value = "endde") int endde,
                                     @RequestParam(value = "upkind", defaultValue = "417000") int upkind,
                                     @RequestParam(value = "pageNo", defaultValue = "1") int pageNo,
                                     @RequestParam(value = "numOfRows", defaultValue = "10") int numOfRows
    ) throws IOException, URISyntaxException {


        String url = API_URL + "/abandonmentPublic"
                + "?serviceKey=" + API_KEY
                + "&bgnde=" + bgnde
                + "&endde=" + endde
                + "&upkind=" + upkind
                + "&pageNo=" + pageNo
                + "&numOfRows=" + numOfRows;

        System.out.println("url = " + url);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("accept", "application/json");
        HttpEntity<Object> requestEntity = new HttpEntity<Object>(httpHeaders);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Abandonment> responseEntity = restTemplate.exchange(
                new URI(url),
                HttpMethod.GET,
                requestEntity,
                Abandonment.class);

        Abandonment abandonment = responseEntity.getBody();
        List<Item> itemList = abandonment.getResponse().getBody().getItems().getItem();


        for (Item item : itemList) {
            String agencyUrl =
                    "http://"
                            + request.getServerName()
                            + ":"
                            + request.getServerPort()
                            + "/api/abandom/agency"
                            + "?addr=" + URLEncoder.encode(item.getOrgNm().trim(), "UTF-8");
            item.setAdditionalProperty("recordAgency", agencyUrl);
        }


        ObjectMapper objectMapper = new ObjectMapper();
        String response = objectMapper.writeValueAsString(abandonment);

        return response;
    }


    @RequestMapping(value = "/agency", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getAgencyList(@RequestParam(value = "addr") String addr,
                                @RequestParam(value = "pageNo", defaultValue = "1") int pageNo,
                                @RequestParam(value = "numOfRows", defaultValue = "10") int numOfRows
    ) throws IOException, URISyntaxException {


        String url = AGENCY_URL
                + "?serviceKey=" + API_KEY
                + "&addr=" + URLEncoder.encode(addr, "UTF-8")
                + "&pageNo=" + pageNo
                + "&numOfRows=" + numOfRows;


        System.out.println("url = " + url);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("accept", "application/json");
        HttpEntity<Object> requestEntity = new HttpEntity<Object>(httpHeaders);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<RecordAgency> responseEntity = restTemplate.exchange(
                new URI(url),
                HttpMethod.GET,
                requestEntity,
                RecordAgency.class);

        RecordAgency recordAgency = responseEntity.getBody();
        List<koreatech.cse.domain.abandom.recordAgency.Item> itemList =
                recordAgency.getResponse().getBody().getItems().getItem();


        for (koreatech.cse.domain.abandom.recordAgency.Item item : itemList) {
            String agencyAddr = item.getAddr(); //**구 **동
            String agencyDtl = item.getAddrDtl(); // ***번지

            String query = URLEncoder.encode(agencyAddr + " " + agencyDtl, "UTF-8");
            String naverUrl = NAVER_URL + query;

            Map map = getMap(naverUrl);
            Point point = map.getResult().getItems().get(0).getPoint();

            item.setAdditionalProperty("point", point);
        }

        ObjectMapper objectMapper = new ObjectMapper();
        String response = objectMapper.writeValueAsString(recordAgency);

        return response;
    }

    public Map getMap(String url) throws URISyntaxException {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("X-Naver-Client-Id", "D5LcoutzZs2RrUP3cy8X");
        httpHeaders.add("X-Naver-Client-Secret", "EI0ZyB0ljz");
        HttpEntity<Object> requestEntity = new HttpEntity<Object>(httpHeaders);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Map> responseEntity = restTemplate.exchange(
                new URI(url),
                HttpMethod.GET,
                requestEntity,
                Map.class);

        Map map = responseEntity.getBody();

        return map;
    }

}


