package cz.cvut.fit.matousi1.client;


import cz.cvut.fit.matousi1.client.GUI.*;
import cz.cvut.fit.matousi1.client.resources.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class CClient implements ApplicationRunner  {
    @Autowired
    private gameResource GameResource;
    @Autowired
    private locationResource LocationResource;
    @Autowired
    private savefileResource SavefileResource;
    @Autowired
    private softwareResource SoftwareResource;
    @Autowired
    private studioResource StudioResource;

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(CClient.class);
        springApplication.setDefaultProperties(Collections.singletonMap("server.port", "8081"));;
        springApplication.run();
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        GUIController guiController = new GUIController(GameResource,LocationResource,SavefileResource,StudioResource,SoftwareResource);
        guiController.activateGUI();
        System.out.println("\tClient app finished.");
    }
}
