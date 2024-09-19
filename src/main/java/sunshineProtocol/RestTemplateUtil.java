package sunshineProtocol;



import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import java.net.MalformedURLException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.*;

@Slf4j
public class RestTemplateUtil {

    private static final String APP_KEY = "B795775376B5";
    private static final String APP_SECRET = "01caecde57ff41338369b39f1c2134e9";
    private static final String HMAC_ALGORITHM = "hmac-sha256";

    public static String sendRequestWithSignature(String url, Map<String, String> params, String method,Map<String, String> headers) {
        RestTemplate restTemplate = new RestTemplate();

        // 构建URI
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(url);

        // 构建请求体
        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<>();
        if (method.equalsIgnoreCase("POST")) {
            params.forEach(requestBody::add);
        } else {
            params.forEach(uriBuilder::queryParam);
        }

        // 设置请求头
        HttpHeaders header = new HttpHeaders();
//        將headers添加到header中
        headers.forEach(header::add);
        System.out.printf("header = %s",header);
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(requestBody, header);

        // 发起请求
        ResponseEntity<String> response = restTemplate.exchange(
                uriBuilder.toUriString(),
                HttpMethod.valueOf(method.toUpperCase()),
                entity,
                String.class
        );
        // 返回响应结果
        return response.getBody();
    }


    public static void main(String[] args) throws MalformedURLException, NoSuchAlgorithmException, InvalidKeyException {
        Map<String, String> params = new HashMap<>();
        params.put("startUpdateTime", "2022-01-01 10:10:10");
        params.put("page", "1");
        params.put("size", "10");
        params.put("endUpdateTime", "2024-01-01 10:10:10");
        String appKey = "B795775376B5";
        String appSecret = "01caecde57ff41338369b39f1c2134e9";
        String uri = "https://gwapi.gwm.cn/sandbox/public/mdm/sun/blackcompany/searchPage";
        String method = "post";
        Map<String, String> header = HmacSignUtil.createSignHeader(appKey, appSecret, uri, method);
        header.put("Content-Type", "application/json");
        System.out.println(header);
        RestTemplateUtil.sendRequestWithSignature(uri, params, "POST",header);
    }
}
