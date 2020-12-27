package cz.cvut.fit.matousi1.client.resources;


import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import cz.cvut.fit.matousi1.dto.locationCreateDTO;
import cz.cvut.fit.matousi1.dto.locationDTO;

@Component
public class locationResource {

    private final RestTemplate restTemplate;

    public locationResource(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    private static final String ROOT = "http://localhost:8080/location";
    private static final String CREATE = ROOT + "/create";
    private static final String UPDATE = ROOT + "/update/{id}";
    private static final String DELETE = ROOT + "/delete/{id}";
    private static final String BYID = ROOT + "/{id}";
    private static final String ALL = ROOT + "/all";

    public ResponseEntity<locationCreateDTO> create(locationCreateDTO data){
        return restTemplate.postForEntity(CREATE , data , locationCreateDTO.class);
    }

    public  ResponseEntity<locationDTO> delete(int id){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<locationCreateDTO> entity = new HttpEntity<>(headers);
        return restTemplate.exchange(DELETE, HttpMethod.DELETE, entity, locationDTO.class, id);
    }

    public ResponseEntity<locationDTO> update(locationCreateDTO data, int id){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<locationCreateDTO> entity = new HttpEntity<>(data, headers);
        return restTemplate.exchange(UPDATE, HttpMethod.PUT, entity, locationDTO.class, id);
    }

    public ResponseEntity<locationDTO> readById(int id){
        return restTemplate.getForEntity(BYID, locationDTO.class, id);
    }

    public ResponseEntity<locationDTO[]> readAll(){
        return restTemplate.exchange(ALL,
                HttpMethod.GET, null , locationDTO[].class);
    }

    public void deleteVoid(int id){
        restTemplate.delete(DELETE , id);
    }
    public void updateVoid(locationCreateDTO data, int id) {
        restTemplate.put(UPDATE, data, id);
    }


}
