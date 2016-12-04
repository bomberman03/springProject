package koreatech.cse.controller.blogandshop;

import koreatech.cse.domain.blogandshop.daum.blog.DaumBlog;
import koreatech.cse.domain.blogandshop.daum.shop.DaumShop;
import koreatech.cse.domain.blogandshop.daum.shop.Item;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.annotations.ApiIgnore;

import java.util.HashMap;

@Controller
@RequestMapping("/")
public class ShopController {

    private static String daum_shop_url = "https://apis.daum.net/shopping/search";
    private static String daum_blog_url = "https://apis.daum.net/search/blog";

    private static String daum_rest_api_key = "9cae039e021379f226d87b0f814c635b";   //본인 것으로 추가하기

    @ApiIgnore
    @RequestMapping(value = "/shop_request", method = RequestMethod.GET)
    public String shopRequest() {
        return "shopRequest";
    }

    @ApiIgnore
    @RequestMapping("/shop")
    public String getShopWithJustAPIKey(Model model,
                                            @RequestParam(name = "searchWord") String searchWord) {
        RestTemplate restTemplate = new RestTemplate();
        DaumShop daumShop = null;
        HashMap<String, DaumBlog> blogHashMap = new HashMap<String, DaumBlog>();
        try {
            ResponseEntity<DaumShop> daumShopResponseEntity
                    = restTemplate.getForEntity(daum_shop_url + "?q=" + searchWord + "&output=json" + "&apikey=" + daum_rest_api_key, DaumShop.class);
            daumShop = daumShopResponseEntity.getBody();
            System.out.println(daumShop);
            for(Item item : daumShop.getChannel().getItem()) {
                ResponseEntity<DaumBlog> daumBlogResponseEntity
                        = restTemplate.getForEntity(daum_blog_url + "?q=" + item.getTitle() +"&output=json" + "&apikey=" + daum_rest_api_key, DaumBlog.class);
                DaumBlog daumBlog = daumBlogResponseEntity.getBody();
                System.out.println(daumBlog);
                blogHashMap.put(item.getTitle(), daumBlog);
            }
        } catch (HttpClientErrorException e) {
            System.out.println(e.getStatusCode() + ": " + e.getStatusText());
        }
        model.addAttribute("searchWord", searchWord);
        model.addAttribute("daumShop", daumShop);
        model.addAttribute("daumBlogHash", blogHashMap);
        return "shop";
    }
}
