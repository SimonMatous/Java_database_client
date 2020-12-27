package cz.cvut.fit.matousi1.client.resources;


import cz.cvut.fit.matousi1.dto.savefileCreateDTO;
import cz.cvut.fit.matousi1.dto.savefileDTO;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class savefileResource {

    private final RestTemplate restTemplate;

    public savefileResource(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    private static final String ROOT = "http://localhost:8080/savefile";
    private static final String CREATE = ROOT + "/create";
    private static final String UPDATE = ROOT + "/update/{id}";
    private static final String DELETE = ROOT + "/delete/{id}";
    private static final String BYID = ROOT + "/{id}";
    private static final String ALL = ROOT + "/all";

    public ResponseEntity<savefileCreateDTO> create(savefileCreateDTO data){
        return restTemplate.postForEntity(CREATE , data , savefileCreateDTO.class);
    }

    public  ResponseEntity<savefileDTO> delete(int id){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<savefileCreateDTO> entity = new HttpEntity<>(headers);
        return restTemplate.exchange(DELETE, HttpMethod.DELETE, entity, savefileDTO.class, id);
    }

    public ResponseEntity<savefileDTO> update(savefileCreateDTO data, int id){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<savefileCreateDTO> entity = new HttpEntity<>(data, headers);
        return restTemplate.exchange(UPDATE, HttpMethod.PUT, entity, savefileDTO.class, id);
    }

    public ResponseEntity<savefileDTO> readById(int id){
        return restTemplate.getForEntity(BYID, savefileDTO.class, id);
    }

    public ResponseEntity<savefileDTO[]> readAll(){
        return restTemplate.exchange(ALL,
                HttpMethod.GET, null , savefileDTO[].class);
    }

    public void deleteVoid(int id){
        restTemplate.delete(DELETE , id);
    }
    public void updateVoid(savefileCreateDTO data, int id) {
        restTemplate.put(UPDATE, data, id);
    }


}
