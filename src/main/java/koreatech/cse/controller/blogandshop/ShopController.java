package koreatech.cse.controller.blogandshop;

import koreatech.cse.domain.blogandshop.daum.blog.DaumBlog;
import koreatech.cse.domain.blogandshop.daum.shop.DaumShop;
import koreatech.cse.domain.blogandshop.daum.shop.Item;
import koreatech.cse.domain.blogandshop.meshup.Shop;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

    private Shop getShop(String searchWord) {
        RestTemplate restTemplate = new RestTemplate();
        Shop shop = null;
        try {
            ResponseEntity<Shop> shopResponseEntity
                    = restTemplate.getForEntity(daum_shop_url + "?q=" + searchWord + "&output=json" + "&apikey=" + daum_rest_api_key, Shop.class);
            shop = shopResponseEntity.getBody();
            for(koreatech.cse.domain.blogandshop.meshup.Item item : shop.getChannel().getItem()) {
                ResponseEntity<DaumBlog> daumBlogResponseEntity
                        = restTemplate.getForEntity(daum_blog_url + "?q=" + item.getTitle() +"&output=json" + "&apikey=" + daum_rest_api_key, DaumBlog.class);
                DaumBlog daumBlog = daumBlogResponseEntity.getBody();
                item.setBlogs(daumBlog);
            }
        } catch(HttpClientErrorException e) {
            System.out.println(e.getStatusCode() + ": " + e.getStatusText());
        }
        return shop;
    }

    @RequestMapping(value = "/api/shop", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Shop> getShopWithJustAPIKey(@RequestParam(name = "searchWord") String searchWord) {
        Shop shop = getShop(searchWord);
        return new ResponseEntity<Shop>(shop, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/shop", params = "format=xml", method = RequestMethod.GET, produces=MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Shop> getShopWithJustAPIKeyXML(@RequestParam(name = "searchWord") String searchWord) {
        Shop shop = getShop(searchWord);
        return new ResponseEntity<Shop>(shop, HttpStatus.OK);
    }

    @ApiIgnore
    @RequestMapping(value = "/shop_request", method = RequestMethod.GET)
    public String shopRequest() {
        return "shopRequest";
    }

    @ApiIgnore
    @RequestMapping("/shop")
    public String getShopWithJustAPIKey(Model model,
                                            @RequestParam(name = "searchWord") String searchWord) {
        Shop shop = getShop(searchWord);
        model.addAttribute("searchWord", searchWord);
        model.addAttribute("shop", shop);
        return "shop";
    }
}
