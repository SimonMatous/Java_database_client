package cz.cvut.fit.matousi1.client.resources;


import cz.cvut.fit.matousi1.dto.gameCreateDTO;
import cz.cvut.fit.matousi1.dto.gameDTO;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class gameResource {

    private final RestTemplate restTemplate;

    public gameResource(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    private static final String ROOT = "http://localhost:8080/game";
    private static final String CREATE = ROOT + "/create";
    private static final String UPDATE = ROOT + "/update/{id}";
    private static final String DELETE = ROOT + "/delete/{id}";
    private static final String BYID = ROOT + "/{id}";
    private static final String ALL = ROOT + "/all";

    public ResponseEntity<gameCreateDTO> create(gameCreateDTO data){
        return restTemplate.postForEntity(CREATE , data , gameCreateDTO.class);
    }

    public  ResponseEntity<gameDTO> delete(int id){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<gameCreateDTO> entity = new HttpEntity<>(headers);
        return restTemplate.exchange(DELETE, HttpMethod.DELETE, entity, gameDTO.class, id);
    }

    public ResponseEntity<gameDTO> update(gameCreateDTO data, int id){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<gameCreateDTO> entity = new HttpEntity<>(data, headers);
        return restTemplate.exchange(UPDATE, HttpMethod.PUT, entity, gameDTO.class, id);
    }

    public ResponseEntity<gameDTO> readById(int id){
        return restTemplate.getForEntity(BYID, gameDTO.class, id);
    }

    public ResponseEntity<gameDTO[]> readAll(){
        return restTemplate.exchange(ALL,
                HttpMethod.GET, null , gameDTO[].class);
    }

    public void deleteVoid(int id){
        restTemplate.delete(DELETE , id);
    }
    public void updateVoid(gameCreateDTO data, int id) {
        restTemplate.put(UPDATE, data, id);
    }


}
