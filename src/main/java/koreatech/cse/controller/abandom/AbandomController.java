package koreatech.cse.controller.abandom;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import koreatech.cse.domain.abandom.abandonment.Abandonment;
import koreatech.cse.domain.abandom.abandonment.Item;
import koreatech.cse.domain.abandom.map.Map;
import koreatech.cse.domain.abandom.map.Point;
import koreatech.cse.domain.abandom.province.Province;
import koreatech.cse.domain.abandom.recordAgency.RecordAgency;
import koreatech.cse.domain.abandom.shelter.Shelter;
import koreatech.cse.domain.abandom.sigungu.Sigungu;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.annotations.ApiIgnore;

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

@Api(value = "유기동물 조회", description = "유기동물 조회 API")
@Controller
@RequestMapping("/api/abandom")
public class AbandomController {

    public static final String API_KEY = "psdfPy1sS6i9nBc4rJ4mRTXHCArp%2F8YUmbIb%2FZmnV3XCYoAsVfFb4fNNcwWP%2BnpY5SuREgRlpyrRousUu2iVQg%3D%3D";
    public static final String API_URL = "http://openapi.animal.go.kr:80/openapi/service/rest/abandonmentPublicSrvc";
    public static final String NAVER_URL = "https://openapi.naver.com/v1/map/geocode?query=";
    public static final String AGENCY_URL = "http://openapi.animal.go.kr/openapi/service/rest/recordAgencySrvc/recordAgency";

    @ApiIgnore
    @RequestMapping("/example")
    public String exampleView(Model model) {
        model.addAttribute("API_KEY", API_KEY);
        return "abandom";
    }


    /**
     * 도, 광역시 리스트
     *
     * @param request
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/province", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ApiOperation(value = "도, 광역시 리스트",
            notes = "검색조건에 필요한 도, 광역시의 코드를 가져옵니다.",
            response = Province.class)
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
    @ApiOperation(value = "시, 군, 구 리스트",
            notes = "검색조건에 필요한 시,군,구의 코드를 가져옵니다.",
            response = Sigungu.class)
    @ApiImplicitParam(name = "upr_cd", value = "도, 광역시의 코드 ex)6110000", paramType = "query", required = true)
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

    //보호소 리스트
    @RequestMapping(value = "/shelter", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    @ApiOperation(value = "보호소 리스트",
            notes = "특정 지역의 보호소 리스트를 가져옵니다.",
            response = Shelter.class)
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
    @ApiOperation(value = "유기동물 리스트",
            notes = "검색조건에 해당하는 유기동물의 리스트를 가져옵니다.",
            response = Abandonment.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "bgnde", value = "시작 날짜 ex)20161003", paramType = "query", required = true),
            @ApiImplicitParam(name = "endde", value = "종료 날짜 ex)20161003", paramType = "query", required = true),
            @ApiImplicitParam(name = "upkind", value = "품종코드", defaultValue = "417000", paramType = "query", required = true),
            @ApiImplicitParam(name = "pageNo", value = "가져올 페이지 번호", defaultValue = "1", paramType = "query", required = true),
            @ApiImplicitParam(name = "numOfRows", value = "한 페이지당 가져올 데이터의 수", defaultValue = "10", paramType = "query", required = true)
    })

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
    @ApiOperation(value = "등록대행업체 리스트",
            notes = "검색조건에 해당하는 등록대행업체의 리스트를 가져옵니다.",
            response = Abandonment.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "addr", value = "경기도", paramType = "query", required = true),
            @ApiImplicitParam(name = "pageNo", value = "가져올 페이지 번호", defaultValue = "1", paramType = "query", required = true),
            @ApiImplicitParam(name = "numOfRows", value = "한 페이지당 가져올 데이터의 수", defaultValue = "10", paramType = "query", required = true),
    })
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

            if (agencyDtl == null) {

            }
            String query = URLEncoder.encode(agencyAddr + " " + agencyDtl, "UTF-8");
            String naverUrl = NAVER_URL + query;

            Point point = getPoint(naverUrl);


            item.setAdditionalProperty("point", point);
        }

        ObjectMapper objectMapper = new ObjectMapper();
        String response = objectMapper.writeValueAsString(recordAgency);

        return response;
    }

    public Point getPoint(String url) throws URISyntaxException {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("X-Naver-Client-Id", "D5LcoutzZs2RrUP3cy8X");
        httpHeaders.add("X-Naver-Client-Secret", "EI0ZyB0ljz");
        httpHeaders.add("accept", "application/json");

        HttpEntity<Object> requestEntity = new HttpEntity<Object>(httpHeaders);
        RestTemplate restTemplate = new RestTemplate();



        try {
            ResponseEntity<Map> responseEntity = restTemplate.exchange(
                    new URI(url),
                    HttpMethod.GET,
                    requestEntity,
                    Map.class);

            Map map = responseEntity.getBody();
            return map.getResult().getItems().get(0).getPoint();
        } catch (HttpClientErrorException e){
            //404 : 요청 쿼리로 좌표를 가져오지 못하면 임의로 0, 0 좌표를 설정
            Point point = new Point();
            point.setX(0.0);
            point.setY(0.0);

            return point;
        }
    }

}


