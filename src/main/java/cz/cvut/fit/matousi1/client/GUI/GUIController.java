package cz.cvut.fit.matousi1.client.GUI;


import org.hibernate.cache.spi.support.SimpleTimestamper;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import cz.cvut.fit.matousi1.dto.*;
import cz.cvut.fit.matousi1.client.resources.*;
import java.util.Scanner;
import static java.lang.System.out;


enum Entity{
    GAME,
    LOCATION,
    SAVEFILE,
    SOFTWARE,
    STUDIO;
}


public class GUIController {

    Entity           current         ;
    private int      input           ;
    gameResource     GameResource    ;
    locationResource LocationResource;
    savefileResource SavefileResource;
    studioResource   StudioResource  ;
    softwareResource SoftwareResource;
    Scanner          Scanner         ;

    public GUIController( gameResource     gameResource    , locationResource locationResource,
                          savefileResource savefileResource, studioResource   studioResource  ,
                          softwareResource softwareResource)
    {
        GameResource     = gameResource          ;
        LocationResource = locationResource      ;
        SavefileResource = savefileResource      ;
        StudioResource   = studioResource        ;
        SoftwareResource = softwareResource      ;
        this.Scanner     = new Scanner(System.in);
    }

    public void activateGUI(){
        while(true)
            if (!EvaluateMainMenu())
                return;
            else
                GetActionInput();
    }

    private boolean EvaluateMainMenu() {
        out.println("\n  Pick an entity to use:\n");
        out.println(" 1 - GAME"    );
        out.println(" 2 - LOCATION");
        out.println(" 3 - SAVEFILE");
        out.println(" 4 - SOFTWARE");
        out.println(" 5 - STUDIO"  );
        out.println(" -1 - END"    );

        while (true){
            boolean result = GetInput();
            if ( !result && input == -1)
                break;
            else if ( !result )
                out.println("Invalid input, please try again.");
            else {
                PickEnum();
                return true;
            }
        }
        return false;
    }

    private void PickEnum() {
        if (input == 1)
            current = Entity.GAME;
        if (input == 2)
            current = Entity.LOCATION;
        if (input == 3)
            current = Entity.SAVEFILE;
        if (input == 4)
            current = Entity.SOFTWARE;
        if (input == 5)
            current = Entity.STUDIO;
    }

    private boolean GetActionInput() {
        while(true){
            out.println(" 0 - FIND BY ID");
            out.println(" 1 - FIND ALL");
            out.println(" 2 - CREATE");
            out.println(" 3 - UPDATE");
            out.println(" 4 - DELETE");

            Scanner scanner = new Scanner(System.in);
            input = Integer.parseInt(scanner.nextLine());

            if      (input == 0)
                FindAll();
            else if (input == 1)
                FindById();
            else if (input == 2)
                Create();
            else if (input == 3)
                Update();
            else if (input == 4)
                Delete();
            else if (input == -1)
                return false;
            else
                out.println("Invalid input, please try again.");
        }
    }

    private boolean GetInput() {
        Scanner scanner = new Scanner(System.in);
        try{
            input = Integer.parseInt(scanner.nextLine());
        } catch (Exception e){
            return true;
        }
        return input >= 0 && input <= 5;
    }

    private void FindAll() {
        if (current == Entity.GAME)
            try{
                PrintArray(GameResource.readAll().getBody());
            } catch (Exception e){
                out.println("ERROR");
            }
        else if (current == Entity.LOCATION)
            try{
                PrintArray(LocationResource.readAll().getBody());
            } catch (Exception e){
                out.println("ERROR");
            }
        else if (current == Entity.SAVEFILE)
            try{
                PrintArray(SavefileResource.readAll().getBody());
            } catch (Exception e){
                out.println("ERROR");
            }
        else if (current == Entity.SOFTWARE)
            try{
                PrintArray(SoftwareResource.readAll().getBody());
            } catch (Exception e){
                out.println("ERROR");
            }
        else if (current == Entity.STUDIO)
            try{
                PrintArray(StudioResource.readAll().getBody());
            } catch (Exception e){
                out.println("ERROR");
            }
    }

    private void PrintArray(Object[] all){
        out.println("[");
        for (Object i : all)
            out.println(i.toString());
        out.println("]");
        out.println();
    }

    private void FindById() {
        if (current == Entity.GAME){
            out.print("Enter ID: ");
            int id = Integer.parseInt(Scanner.nextLine());
            ResponseEntity<gameDTO> output;
            try{
                output = GameResource.readById(id);
                out.println(output.getBody().toString());
            } catch (Exception e) {
                out.println("ERROR");
            }
        }
        else if (current == Entity.LOCATION){
            out.print("Enter ID: ");
            int id = Integer.parseInt(Scanner.nextLine());
            ResponseEntity<locationDTO> output;
            try{
                output = LocationResource.readById(id);
                out.println(output.getBody().toString());
            } catch (Exception e) {
                out.println("ERROR");
            }
        }
        else if (current == Entity.SAVEFILE){
            out.print("Enter ID: ");
            int id = Integer.parseInt(Scanner.nextLine());
            ResponseEntity<savefileDTO> output;
            try{
                output = SavefileResource.readById(id);
                out.println(output.getBody().toString());
            } catch (Exception e) {
                out.println("ERROR");
            }
        }
        else if (current == Entity.SOFTWARE){
            out.print("Enter ID: ");
            int id = Integer.parseInt(Scanner.nextLine());
            ResponseEntity<softwareDTO> output;
            try{
                output = SoftwareResource.readById(id);
                out.println(output.getBody().toString());
            } catch (Exception e) {
                out.println("ERROR");
            }
        }
        else if (current == Entity.STUDIO){
            out.print("Enter ID: ");
            int id = Integer.parseInt(Scanner.nextLine());
            ResponseEntity<studioDTO> output;
            try{
                output = StudioResource.readById(id);
                out.println(output.getBody().toString());
            } catch (Exception e) {
                out.println("ERROR");
            }
        }
    }

    private void Create() {
        if (current == Entity.GAME)
            try {
                GameResource.create(CreateGame());
            } catch (Exception e){
                out.println(e.getLocalizedMessage());
            }
        else if (current == Entity.LOCATION)
            try{
                LocationResource.create(CreateLocation());
            } catch (Exception e){
                out.println(e.getLocalizedMessage());
            }
        else if (current == Entity.SAVEFILE)
            try{
                SavefileResource.create(CreateSavefile());
            } catch (Exception e){
                out.println(e.getLocalizedMessage());
            }
        else if (current == Entity.SOFTWARE)
            try{
                SoftwareResource.create(CreateSoftware());
            } catch (Exception e){
                out.println(e.getLocalizedMessage());
            }
        else if (current == Entity.STUDIO)
            try{
                StudioResource.create(CreateStudio());
            } catch (Exception e){
                out.println(e.getLocalizedMessage());
            }

    }

    private void Update(){
        if (current == Entity.GAME){
            out.print("Enter id to update: ");
            int id = Integer.parseInt(Scanner.nextLine());
            try{
                GameResource.update(CreateGame(), id);
            } catch (Exception e){
                out.println(e.getLocalizedMessage());
            }
        }
        else if (current == Entity.LOCATION){
            out.print("Enter id to update: ");
            int id = Integer.parseInt(Scanner.nextLine());
            try{
                LocationResource.update(CreateLocation(), id);
            } catch (Exception e){
                out.println(e.getLocalizedMessage());
            }
        }
        else if (current == Entity.SAVEFILE){
            out.print("Enter id to update: ");
            int id = Integer.parseInt(Scanner.nextLine());
            try{
                SavefileResource.update(CreateSavefile(), id);
            } catch (Exception e){
                out.println(e.getLocalizedMessage());
            }
        }
        else if (current == Entity.SOFTWARE){
            out.print("Enter id to update: ");
            int id = Integer.parseInt(Scanner.nextLine());
            try{
                SoftwareResource.update(CreateSoftware(), id);
            } catch (Exception e){
                out.println(e.getLocalizedMessage());
            }
        }
        else if (current == Entity.STUDIO){
            out.print("Enter id to update: ");
            int id = Integer.parseInt(Scanner.nextLine());
            try{
                StudioResource.update(CreateStudio(), id);
            } catch (Exception e){
                out.println(e.getLocalizedMessage());
            }
        }
    }

    private void Delete(){
        if (current == Entity.GAME){
            out.print("Enter ID: ");
            int id = Integer.parseInt(Scanner.nextLine());
            ResponseEntity<gameDTO> result;
            try{
                result = GameResource.delete(id);
                out.println("Finished with exitCode: #" + result.getStatusCode().value() );
            } catch (Exception e) {
                out.println("ERROR");
            }
        }
        else if (current == Entity.LOCATION){
            out.print("Enter ID: ");
            int id = Integer.parseInt(Scanner.nextLine());
            ResponseEntity<locationDTO> result;
            try{
                result = LocationResource.delete(id);
                out.println("Finished with exitCode: #" + result.getStatusCode().value() );
            } catch (Exception e) {
                out.println("ERROR");
            }
        }
        else if (current == Entity.SAVEFILE){
            out.print("Enter ID: ");
            int id = Integer.parseInt(Scanner.nextLine());
            ResponseEntity<savefileDTO> result;
            try{
                result = SavefileResource.delete(id);
                out.println("Finished with exitCode: #" + result.getStatusCode().value() );
            } catch (Exception e) {
                out.println("ERROR");
            }
        }
        else if (current == Entity.SOFTWARE){
            out.print("Enter id: ");
            int id = Integer.parseInt(Scanner.nextLine());
            ResponseEntity<softwareDTO> result;
            try{
                result = SoftwareResource.delete(id);
                out.println("Finished with exitCode: #" + result.getStatusCode().value() );
            } catch (Exception e) {
                out.println("ERROR");
            }
        }
        else if (current == Entity.STUDIO){
            out.print("Enter ID: ");
            int id = Integer.parseInt(Scanner.nextLine());
            ResponseEntity<studioDTO> result;
            try{
                result = StudioResource.delete(id);
                out.println("Finished with exitCode: #" + result.getStatusCode().value() );
            } catch (Exception e) {
                out.println("ERROR");
            }
        }
    }

    private locationCreateDTO CreateLocation(){
        out.println("Enter state:");
        String state = Scanner.nextLine();
        out.println("Enter town:");
        String town = Scanner.nextLine();
        out.println("Enter address:");
        String address = Scanner.nextLine();
        return new locationCreateDTO(state,town,address);
    }

    private studioCreateDTO CreateStudio() {
        out.println("Enter name:");
        String name = Scanner.nextLine();
        out.println("Enter founding date (dd-mm-yyyy):");
        String date = Scanner.nextLine();
        Timestamp founding_date = new Timestamp(0);
        try {
            SimpleDateFormat newFormat = new SimpleDateFormat("dd-mm-yyyy");
            founding_date = new Timestamp((newFormat.parse(date)).getTime());
        } catch (Exception e){
            out.println("ERROR");
        }
        out.println("Enter locationID:");
        String locationID = Scanner.nextLine();
        return new studioCreateDTO(name,founding_date,Integer.parseInt(locationID));
    }

    private savefileCreateDTO CreateSavefile() {
        out.println("Enter name:");
        String name = Scanner.nextLine();
        out.println("Enter time of save (dd-mm-yyyy):");
        String date = Scanner.nextLine();
        Timestamp saved_at = new Timestamp(0);
        try {
            SimpleDateFormat newFormat = new SimpleDateFormat("dd-mm-yyyy");
            saved_at = new Timestamp((newFormat.parse(date)).getTime());
        } catch (Exception e){
            out.println("ERROR");
        }
        out.println("Enter how much % of the game is finished ( 0-100 ):");
        String percOfGameFinished = Scanner.nextLine();
        int percOfGameFinishedInt = Integer.parseInt(percOfGameFinished);
        try{
            if ( (percOfGameFinishedInt < 0) || (percOfGameFinishedInt > 100) )
                throw new Exception("number must be 0-100");
        } catch (Exception e) {
            out.println("ERROR");
        }
        out.println("Enter gameID:");
        String gameID = Scanner.nextLine();
        return new savefileCreateDTO(name,saved_at,percOfGameFinishedInt,Integer.parseInt(gameID));
    }

    private softwareCreateDTO CreateSoftware() {
        out.println("Enter name:");
        String name = Scanner.nextLine();
        out.println("Enter founding date (dd-mm-yyyy):");
        String date = Scanner.nextLine();
        Timestamp founding_date = new Timestamp(0);
        try {
            SimpleDateFormat newFormat = new SimpleDateFormat("dd-mm-yyyy");
            founding_date = new Timestamp((newFormat.parse(date)).getTime());
        } catch (Exception e){
            out.println("ERROR");
        }
        return new softwareCreateDTO(name,founding_date);
    }

    private gameCreateDTO CreateGame() {
        out.println("Enter name:");
        String name = Scanner.nextLine();
        out.println("Enter hardware:");
        String hardware = Scanner.nextLine();
        out.println("Enter release date (dd-mm-yyyy):");
        String date = Scanner.nextLine();
        Timestamp release_date = new Timestamp(0);
        try {
            SimpleDateFormat newFormat = new SimpleDateFormat("dd-mm-yyyy");
            release_date = new Timestamp((newFormat.parse(date)).getTime());
        } catch (Exception e){
            out.println("ERROR");
        }
        out.println("Enter number on how many softwares is the game available:");
        String amount = Scanner.nextLine();
        List<Integer> softwares = new ArrayList<>();
        out.println("Enter locations:");
        for (int i = 0 ; i < Integer.parseInt(amount) ; i++){
            softwares.add(Integer.parseInt(Scanner.nextLine()));
        }
        out.println("Enter studioID:");
        String studioID = Scanner.nextLine();
        return new gameCreateDTO(name,hardware,release_date,softwares,Integer.parseInt(studioID));
    }
}