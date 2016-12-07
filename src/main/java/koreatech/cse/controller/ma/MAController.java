package koreatech.cse.controller.ma;

import koreatech.cse.domain.ma.FileList;
import koreatech.cse.domain.ma.Item;
import koreatech.cse.domain.ma.MachineAnchor;
import koreatech.cse.domain.ma.NaverNews;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.annotations.ApiIgnore;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class MAController {
    private String naver_client_id = "1V8OqGVhLmkUE0IgTYYH";
    private String naver_client_secret = "S6SeE9q6PV";
    private String naver_news_url = "https://openapi.naver.com/v1/search/news.json";
    private String naver_vs_url = "https://openapi.naver.com/v1/voice/tts.bin";
    private String [] newsOrders = {"첫번째", "두번째", "세번째", "네번째", "다섯번째", "여섯번째", "일곱번째", "여덟번째", "아홉번째", "열번째"};


    @ApiIgnore
    @RequestMapping(value = "/maRequest", method = RequestMethod.GET)
    public String maRequest(){
        return "maRequest";
    }

    @ApiIgnore
    @RequestMapping(value = "/machine_anchor")
    public String MachineAnchor(Model model, @RequestParam(name = "searchWord") String searchWord, HttpServletRequest request) {
        //System.out.println("받은 숫자 : " + number);
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Naver-Client-Id", naver_client_id);
        headers.add("X-Naver-Client-Secret", naver_client_secret);

        NaverNews naverNews= null;

        try {
            ResponseEntity<NaverNews> naverNewsResponseEntity
                    = restTemplate.exchange(naver_news_url + "?query=" + searchWord + "&sort=date",
                                                            HttpMethod.GET, new HttpEntity(headers),NaverNews.class);
            naverNews = naverNewsResponseEntity.getBody();
            System.out.println(naverNews);
        } catch (HttpClientErrorException e) {
            System.out.println(e.getStatusCode() + ": " + e.getStatusText());
        }

        ////////////////////////////////////////
        List<Item> items = naverNews.getItems();
        String text = "";
        text += searchWord + "에 관련된 뉴스입니다. ";
        for (int i = 0; i < 10; i++){
            text += newsOrders[i] + "입니다. ";
            text += items.get(i).getTitle().replaceAll("<(/)?([a-zA-Z]*)(\\\\s[a-zA-Z]*=[^>]*)?(\\\\s)*(/)?>", "").replaceAll("&quot;", "") + ".";
            //System.out.println(items.get(i).getTitle().replaceAll("<(/)?([a-zA-Z]*)(\\\\s[a-zA-Z]*=[^>]*)?(\\\\s)*(/)?>", "").replaceAll("&quot;", ""));
        }

        String path = request.getSession().getServletContext().getRealPath("/WEB-INF/resources/audio/");


        //System.out.println("Size of items : " + items.size());
        model.addAttribute("filename", getVSData(text, path, searchWord));
        return "ma";
    }

    @RequestMapping(value = "/api/machine_anchor", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MachineAnchor> getMachineAnchorAPIwithJSON(HttpServletRequest request){
        String path = request.getSession().getServletContext().getRealPath("/WEB-INF/resources/audio/");
        System.out.println("URI : " + request.getRequestURI());
        System.out.println("URL : " + request.getRequestURL());
        System.out.println("Server Port : " + request.getServerPort());
        System.out.println("Server Name : " + request.getServerName());
        System.out.println(path);
        MachineAnchor machineAnchor = new MachineAnchor();
        List<FileList> fileLists = new ArrayList<FileList>();

        File file = new File(path);
        String [] filelist = file.list();
        System.out.println("length : " + filelist.length);
        for (int i=0; i < filelist.length; i++){
            File temp = new File(path, filelist[i]);
            if(!temp.isDirectory()){
                String name = temp.getName();
                System.out.println("file length  : " + temp.length());
                System.out.println("file_name : " + name);
                fileLists.add(new FileList(name, "http://" + request.getServerName() + ":" + request.getServerPort() + "/machine_anchor/download/" + name));
                //(request.getRequestURL().toString() + "/ma_download/" + name);
            }
        }
    machineAnchor.setList(fileLists);
        return new ResponseEntity<MachineAnchor>(machineAnchor, HttpStatus.OK);
    }


    private String getVSData(String text, String path, String searchWord){
        String filename = searchWord + ".mp3";
        System.out.println(path);
        try {
            URL url = new URL(naver_vs_url);

            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("POST"); //POST 방식으로 요청
            //요청 헤더를 정의
            con.setRequestProperty("X-Naver-Client-Id", naver_client_id);
            con.setRequestProperty("X-Naver-Client-Secret", naver_client_secret);

            // post request
            String postParams = "speaker=jinho&speed=0&text=" + URLEncoder.encode(text, "UTF-8");
            //OutputStream으로 POST 데이터를 넘겨주겠다는 옵션
            con.setDoOutput(true);
            //요청할 OutputStream을 넣는다
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            //작성된 파라미터 정보를 바이트 단위로 인코딩해서 요청
            wr.writeBytes(postParams); //실질적인 요청 부분
            wr.flush(); //스트림의 버퍼 비우기
            wr.close(); //스트림 닫기

            int responseCode = con.getResponseCode();

            BufferedReader br;

            if(responseCode==200) { // 정상 호출
                InputStream is = con.getInputStream(); //InputStream을 연다
                int read = 0;
                byte[] bytes = new byte[1024];

                System.out.println(filename);
                //파일이 저장되는 경로
                File f = new File(path + filename);
                //System.out.println(f.getAbsolutePath());
                f.createNewFile(); //파일 생성
                //파일 출력스트림 생성
                OutputStream outputStream = new FileOutputStream(f);
                while ((read =is.read(bytes)) != -1) {
                    //파일에 쓰기
                    outputStream.write(bytes, 0, read);
                }
                System.out.println("음성합성 호출 완료");
                //출력 스트림 닫기
                is.close();
            } else {   // 에러 발생
                filename = "error";
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();
                while ((inputLine = br.readLine()) != null) {
                    response.append(inputLine);
                }
                br.close();
                System.out.println(response.toString());
            }

        }catch (Exception e){
            System.out.println(e);
        }

        return filename;
    }
}
