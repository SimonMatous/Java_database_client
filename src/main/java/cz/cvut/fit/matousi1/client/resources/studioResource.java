package cz.cvut.fit.matousi1.client.resources;


import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import cz.cvut.fit.matousi1.dto.studioCreateDTO;
import cz.cvut.fit.matousi1.dto.studioDTO;

@Component
public class studioResource {

    private final RestTemplate restTemplate;

    public studioResource(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    private static final String ROOT = "http://localhost:8080/studio";
    private static final String CREATE = ROOT + "/create";
    private static final String UPDATE = ROOT + "/update/{id}";
    private static final String DELETE = ROOT + "/delete/{id}";
    private static final String BYID = ROOT + "/{id}";
    private static final String ALL = ROOT + "/all";

    public ResponseEntity<studioCreateDTO> create(studioCreateDTO data){
        return restTemplate.postForEntity(CREATE , data , studioCreateDTO.class);
    }

    public  ResponseEntity<studioDTO> delete(int id){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<studioCreateDTO> entity = new HttpEntity<>(headers);
        return restTemplate.exchange(DELETE, HttpMethod.DELETE, entity, studioDTO.class, id);
    }

    public ResponseEntity<studioDTO> update(studioCreateDTO data, int id){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<studioCreateDTO> entity = new HttpEntity<>(data, headers);
        return restTemplate.exchange(UPDATE, HttpMethod.PUT, entity, studioDTO.class, id);
    }

    public ResponseEntity<studioDTO> readById(int id){
        return restTemplate.getForEntity(BYID, studioDTO.class, id);
    }

    public ResponseEntity<studioDTO[]> readAll(){
        return restTemplate.exchange(ALL,
                HttpMethod.GET, null , studioDTO[].class);
    }

    public void deleteVoid(int id){
        restTemplate.delete(DELETE , id);
    }
    public void updateVoid(studioCreateDTO data, int id) {
        restTemplate.put(UPDATE, data, id);
    }


}
