package cz.cvut.fit.matousi1.client.resources;


import cz.cvut.fit.matousi1.dto.softwareCreateDTO;
import cz.cvut.fit.matousi1.dto.softwareDTO;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class softwareResource {

    private final RestTemplate restTemplate;

    public softwareResource(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    private static final String ROOT = "http://localhost:8080/software";
    private static final String CREATE = ROOT + "/create";
    private static final String UPDATE = ROOT + "/update/{id}";
    private static final String DELETE = ROOT + "/delete/{id}";
    private static final String BYID = ROOT + "/{id}";
    private static final String ALL = ROOT + "/all";

    public ResponseEntity<softwareCreateDTO> create(softwareCreateDTO data){
        return restTemplate.postForEntity(CREATE , data , softwareCreateDTO.class);
    }

    public  ResponseEntity<softwareDTO> delete(int id){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<softwareCreateDTO> entity = new HttpEntity<>(headers);
        return restTemplate.exchange(DELETE, HttpMethod.DELETE, entity, softwareDTO.class, id);
    }

    public ResponseEntity<softwareDTO> update(softwareCreateDTO data, int id){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<softwareCreateDTO> entity = new HttpEntity<>(data, headers);
        return restTemplate.exchange(UPDATE, HttpMethod.PUT, entity, softwareDTO.class, id);
    }

    public ResponseEntity<softwareDTO> readById(int id){
        return restTemplate.getForEntity(BYID, softwareDTO.class, id);
    }

    public ResponseEntity<softwareDTO[]> readAll(){
        return restTemplate.exchange(ALL,
                HttpMethod.GET, null , softwareDTO[].class);
    }

    public void deleteVoid(int id){
        restTemplate.delete(DELETE , id);
    }
    public void updateVoid(softwareCreateDTO data, int id) {
        restTemplate.put(UPDATE, data, id);
    }


}
