package co.agital.fundraiser.services;

import co.agital.fundraiser.entities.Site;
import co.agital.fundraiser.helpers.RequestResponseLoggingInterceptor;
import co.agital.fundraiser.json.GeoResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Collections;

@Service
public class GeocoderService {

    private static final String KEY = "AIzaSyDw_d6dfxDEI7MAvqfGXEIsEMwjC1PWRno";

//    private WebClient client;
//
//    public GeocoderService(WebClient.Builder builder) {
//        client = builder.baseUrl("https://maps.googleapis.com")
//                .build();
//    }
//
//    private String encodeString(String s) {
//        return URLEncoder.encode(s, StandardCharsets.UTF_8);
//    }
//
//    public Site getLatLng(String... address) {
//        String encoded = Stream.of(address)
//                .map(this::encodeString)
//                .collect(Collectors.joining(","));
//        String path = "/maps/api/geocode/json";
//        GeoResponse response = client.get()
//                .uri(uriBuilder -> uriBuilder.path(path)
//                        .queryParam("address", encoded)
//                        .queryParam("key", KEY)
//                        .build()
//                )
//                .retrieve()
//                .bodyToMono(GeoResponse.class)
//                .block(Duration.ofSeconds(2));
//        assert response != null;
//        System.out.println(String.format("Response: %s > %s", path, response.getStatus()));
//        return new Site(response.getFormattedAddress(),
//                response.getLocation().getLat(),
//                response.getLocation().getLng());
//    }

    private static final String BASE = "https://maps.googleapis.com/maps/api/geocode/json";

    private RestTemplate restTemplate;
    private Logger logger = LoggerFactory.getLogger(GeocoderService.class);


    @Autowired
    public GeocoderService(RestTemplateBuilder builder) {
        ClientHttpRequestFactory factory = new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory());
        //restTemplate = builder.build();
        restTemplate = new RestTemplate(factory);
        restTemplate.setInterceptors(Collections.singletonList(new RequestResponseLoggingInterceptor()));
    }

    public Site getLatLng(String... address) {
        String joinedAddress = String.join(",", address);
        String encodedAddress = "";

        encodedAddress = URLEncoder.encode(joinedAddress, StandardCharsets.UTF_8);
        String url = BASE + "?address=" + encodedAddress + "&key=" + KEY;
        logger.info("URL to call is: " + url);
        GeoResponse response = restTemplate.getForObject(url, GeoResponse.class);
        logger.info("Response is: " + response.toString());

        return new Site(response.getPlaceId(), response.getFormattedAddress(), response.getLocation().getLat(), response.getLocation().getLng());
    }


}
