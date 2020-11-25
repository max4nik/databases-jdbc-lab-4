package ua.lviv.iot.passive.view;

import ua.lviv.iot.passive.controller.implementation.*;
import ua.lviv.iot.passive.model.entity.*;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class MyView {
    private final AircraftController aircraftController = new AircraftController();
    private final AirportController airportController = new AirportController();
    private final AviacompanyController aviacompanyController = new AviacompanyController();
    private final FlightController flightController = new FlightController();
    private final PilotController pilotController = new PilotController();

    private final LinkedHashMap<String, Printable> menu = new LinkedHashMap<>();
    private static final Scanner SCANNER = new Scanner(System.in);

    public MyView() {
        System.out.println("Welcome user!\n");
        menu.put("11", this::getAllAircrafts);
        menu.put("12", this::getAircraftById);
        menu.put("13", this::createAircraft);
        menu.put("14", this::updateAircraft);
        menu.put("15", this::deleteAircraftById);

        menu.put("21", this::getAllAirports);
        menu.put("22", this::getAirportById);
        menu.put("23", this::createAirport);
        menu.put("24", this::updateAirport);
        menu.put("25", this::deleteAirportById);

        menu.put("31", this::getAllAviacompanies);
        menu.put("32", this::getAviacompanyById);
        menu.put("33", this::createAviacompany);
        menu.put("34", this::updateAviacompany);
        menu.put("35", this::deleteAviacompanyById);

        menu.put("41", this::getAllFlights);
        menu.put("42", this::getFlightById);
        menu.put("43", this::createFlight);
        menu.put("44", this::updateFlight);
        menu.put("45", this::deleteFlightById);

        menu.put("51", this::getAllPilots);
        menu.put("52", this::getPilotById);
        menu.put("53", this::createPilot);
        menu.put("54", this::updatePilot);
        menu.put("55", this::deletePilotById);

    }

    public void showMenu() throws SQLException {
        String userChoice = "";
        System.out.println("Choose table you want to work with: ");
        System.out.println("1 - aircraft ✈");
        System.out.println("2 - airport \uD83C\uDFE2");
        System.out.println("3 - aviacompany \uD83D\uDCBC");
        System.out.println("4 - flight \uD83D\uDDFA");
        System.out.println("5 - pilot \uD83D\uDC68\u200D");
        System.out.println("\nEnter table: ");
        userChoice += SCANNER.next();
        System.out.println();
        System.out.println("Now choose crud option you want to use on this table: ");
        System.out.println("1 - get all records from table");
        System.out.println("2 - get one record by its id");
        System.out.println("3 - create record");
        System.out.println("4 - update record");
        System.out.println("5 - delete record");
        System.out.println("\nEnter option: ");
        userChoice += SCANNER.next();
        menu.get(userChoice).print();
        System.out.println();
        exitProgramOrContinue();
        showMenu();
    }

    private void exitProgramOrContinue() {
        System.out.println("\n\nDo you want to continue: y/n");
        String answer = SCANNER.next();
        if (answer.equals("y")) {
            System.out.println('\n');
        } else if (answer.equals("n")) {
            System.exit(0);
        } else {
            System.out.println("Enter \"y\" (as yes) or \"n\" (as no) please");
            exitProgramOrContinue();
        }
    }

    private void getAllAircrafts() throws SQLException {
        List<Aircraft> aircrafts = aircraftController.findAll();
        System.out.println("Here are your aircrafts:\n");
        for (Aircraft aircraft : aircrafts) {
            System.out.println(aircraft.toString() + "\n");
        }
    }

    private void getAircraftById() throws SQLException {
        System.out.println("Enter please aircraft id you want to get: ");
        Integer id = SCANNER.nextInt();
        System.out.println("Here is your aircraft: " + aircraftController.findOne(id).toString());
    }

    private void createAircraft() throws SQLException {
        System.out.println("Enter please aircraft model name: ");
        String modelName = SCANNER.next();
        System.out.println("Enter please aircraft type: ");
        String type = SCANNER.next();
        System.out.println("Enter please aircraft years in use: ");
        Integer yearsInUse = SCANNER.nextInt();
        System.out.println("Enter please aircraft max seats: ");
        Integer maxSeats = SCANNER.nextInt();
        System.out.println("Enter please aircraft aviacompany id: ");
        Integer aviacompanyId = SCANNER.nextInt();
        Aircraft aircraft = new Aircraft(modelName, type, yearsInUse, maxSeats, aviacompanyId);
        aircraftController.create(aircraft);
        System.out.println("Record created successfully");
    }

    private void updateAircraft() throws SQLException {
        System.out.println("Enter please aircraft id you want to change: ");
        Integer id = SCANNER.nextInt();
        if (aircraftController.findOne(id) == null) {
            System.out.println("Record with such id does not exist in this table");
            return;
        }
        System.out.println("Enter please aircraft model name: ");
        String modelName = SCANNER.next();
        System.out.println("Enter please aircraft type: ");
        String type = SCANNER.next();
        System.out.println("Enter please aircraft years in use: ");
        Integer yearsInUse = SCANNER.nextInt();
        System.out.println("Enter please aircraft max seats: ");
        Integer maxSeats = SCANNER.nextInt();
        System.out.println("Enter please aircraft aviacompany id: ");
        Integer aviacompanyId = SCANNER.nextInt();
        Aircraft aircraft = new Aircraft(modelName, type, yearsInUse, maxSeats, aviacompanyId);
        aircraftController.update(id, aircraft);
        System.out.println("Record updated successfully");
    }

    private void deleteAircraftById() throws SQLException {
        System.out.println("Enter please aircraft id you want to delete: ");
        Integer id = SCANNER.nextInt();
        if (aircraftController.findOne(id) == null) {
            System.out.println("Record with such id does not exist in this table");
            return;
        }
        aircraftController.delete(id);
        System.out.println("Deleted successfully");
    }


    private void getAllAirports() throws SQLException {
        List<Airport> airports = airportController.findAll();
        System.out.println("Here are your airports:\n");
        for (Airport airport : airports) {
            System.out.println(airport.toString() + "\n");
        }
    }

    private void getAirportById() throws SQLException {
        System.out.println("Enter please airport id you want to get: ");
        Integer id = SCANNER.nextInt();
        System.out.println("Here is your airport: " + airportController.findOne(id).toString());
    }

    private void createAirport() throws SQLException {
        System.out.println("Enter please airport name: ");
        String name = SCANNER.next();
        System.out.println("Enter please airport amount of workers: ");
        Integer amountOfWorkers = SCANNER.nextInt();
        System.out.println("Enter please airport city: ");
        String city = SCANNER.next();

        Airport airport = new Airport(name, amountOfWorkers, city);
        airportController.create(airport);
        System.out.println("Record created successfully");
    }

    private void updateAirport() throws SQLException {
        System.out.println("Enter please airport id you want to change: ");
        Integer id = SCANNER.nextInt();
        if (airportController.findOne(id) == null) {
            System.out.println("Record with such id does not exist in this table");
            return;
        }
        System.out.println("Enter please airport name: ");
        String name = SCANNER.next();
        System.out.println("Enter please airport amount of workers: ");
        Integer amountOfWorkers = SCANNER.nextInt();
        System.out.println("Enter please airport city: ");
        String city = SCANNER.next();

        Airport airport = new Airport(name, amountOfWorkers, city);
        airportController.update(id, airport);
        System.out.println("Record updated successfully");
    }

    private void deleteAirportById() throws SQLException {

        System.out.println("Enter please airport id you want to delete: ");
        Integer id = SCANNER.nextInt();
        if (airportController.findOne(id) == null) {
            System.out.println("Record with such id does not exist in this table");
            return;
        }
        airportController.delete(id);
        System.out.println("Deleted successfully");
    }

    private void getAllAviacompanies() throws SQLException {
        List<Aviacompany> aviacompanies = aviacompanyController.findAll();
        System.out.println("Here are your aviacompanies:\n");
        for (Aviacompany aviacompany : aviacompanies) {
            System.out.println(aviacompany.toString() + "\n");
        }
    }

    private void getAviacompanyById() throws SQLException {
        System.out.println("Enter please aviacompany id you want to get: ");
        Integer id = SCANNER.nextInt();
        System.out.println("Here is your aviacompany: " + aviacompanyController.findOne(id).toString());
    }

    private void createAviacompany() throws SQLException {
        System.out.println("Enter please aviacompany name: ");
        String name = SCANNER.next();
        System.out.println("Enter please aviacompany creation date in string format: ");
        String creationDate = SCANNER.next();

        Aviacompany aviacompany = new Aviacompany(name, creationDate);
        aviacompanyController.create(aviacompany);
        System.out.println("Record created successfully");
    }

    private void updateAviacompany() throws SQLException {
        System.out.println("Enter please aviacompany id you want to change: ");
        Integer id = SCANNER.nextInt();
        if (aviacompanyController.findOne(id) == null) {
            System.out.println("Record with such id does not exist in this table");
            return;
        }
        System.out.println("Enter please aviacompany name: ");
        String name = SCANNER.next();
        System.out.println("Enter please aviacompany creation date in string format: ");
        String creationDate = SCANNER.next();

        Aviacompany aviacompany = new Aviacompany(name, creationDate);
        aviacompanyController.update(id, aviacompany);
        System.out.println("Record updated successfully");
    }

    private void deleteAviacompanyById() throws SQLException {
        System.out.println("Enter please aviacompany id you want to delete: ");
        Integer id = SCANNER.nextInt();
        if (aviacompanyController.findOne(id) == null) {
            System.out.println("Record with such id does not exist in this table");
            return;
        }
        aviacompanyController.delete(id);
        System.out.println("Deleted successfully");
    }

    private void getAllFlights() throws SQLException {
        List<Flight> flights = flightController.findAll();
        System.out.println("Here are your flights:\n");
        for (Flight flight : flights) {
            System.out.println(flight.toString() + "\n");
        }
    }

    private void getFlightById() throws SQLException {
        System.out.println("Enter please flight id you want to get: ");
        Integer id = SCANNER.nextInt();
        System.out.println("Here is your flight: " + flightController.findOne(id).toString());
    }

    private void createFlight() throws SQLException {
        System.out.println("Enter please flight from airport id: ");
        Integer fromAirportId = SCANNER.nextInt();
        System.out.println("Enter please flight to airport id: ");
        Integer toAirportId = SCANNER.nextInt();
        System.out.println("Enter please flight departure time in string format: ");
        String departureTime = SCANNER.next();
        System.out.println("Enter please flight arrival time in string format: ");
        String arrivalTime = SCANNER.next();
        System.out.println("Enter please flight pilot id: ");
        Integer pilotId = SCANNER.nextInt();
        System.out.println("Enter please flight aircraft id: ");
        Integer aircraftId = SCANNER.nextInt();
        System.out.println("Enter please if flight is available: ");
        Boolean isAvailable = SCANNER.nextBoolean();
        System.out.println("Enter please flight aviacompany id: ");
        Integer aviacompanyId = SCANNER.nextInt();
        System.out.println("Enter please flight available seats: ");
        Integer availableSeats = SCANNER.nextInt();
        Flight flight = new Flight(fromAirportId, toAirportId, departureTime, arrivalTime, pilotId, aircraftId, isAvailable, aviacompanyId, availableSeats);
        flightController.create(flight);
        System.out.println("Record created successfully");
    }

    private void updateFlight() throws SQLException {
        System.out.println("Enter please flight id you want to change: ");
        Integer id = SCANNER.nextInt();
        if (flightController.findOne(id) == null) {
            System.out.println("Record with such id does not exist in this table");
            return;
        }
        System.out.println("Enter please flight from airport id: ");
        Integer fromAirportId = SCANNER.nextInt();
        System.out.println("Enter please flight to airport id: ");
        Integer toAirportId = SCANNER.nextInt();
        System.out.println("Enter please flight departure time in string format: ");
        String departureTime = SCANNER.next();
        System.out.println("Enter please flight arrival time in string format: ");
        String arrivalTime = SCANNER.next();
        System.out.println("Enter please flight pilot id: ");
        Integer pilotId = SCANNER.nextInt();
        System.out.println("Enter please flight aircraft id: ");
        Integer aircraftId = SCANNER.nextInt();
        System.out.println("Enter please if flight is available: ");
        Boolean isAvailable = SCANNER.nextBoolean();
        System.out.println("Enter please flight aviacompany id: ");
        Integer aviacompanyId = SCANNER.nextInt();
        System.out.println("Enter please flight available seats: ");
        Integer availableSeats = SCANNER.nextInt();
        Flight flight = new Flight(fromAirportId, toAirportId, departureTime, arrivalTime, pilotId, aircraftId, isAvailable, aviacompanyId, availableSeats);
        flightController.update(id, flight);
        System.out.println("Record updated successfully");
    }

    private void deleteFlightById() throws SQLException {
        System.out.println("Enter please flight id you want to delete: ");
        Integer id = SCANNER.nextInt();
        if (flightController.findOne(id) == null) {
            System.out.println("Record with such id does not exist in this table");
            return;
        }
        flightController.delete(id);
        System.out.println("Deleted successfully");
    }

    private void getAllPilots() throws SQLException {
        List<Pilot> pilots = pilotController.findAll();
        System.out.println("Here are your flights:\n");
        for (Pilot pilot : pilots) {
            System.out.println(pilot.toString() + "\n");
        }
    }

    private void getPilotById() throws SQLException {
        System.out.println("Enter please pilot id you want to get: ");
        Integer id = SCANNER.nextInt();
        System.out.println("Here is your pilot: " + pilotController.findOne(id).toString());
    }

    private void createPilot() throws SQLException {
        System.out.println("Enter please pilot surname: ");
        String surname = SCANNER.next();
        System.out.println("Enter please pilot name: ");
        String name = SCANNER.next();
        System.out.println("Enter please pilot position: ");
        String position = SCANNER.next();

        Pilot pilot = new Pilot(surname, name, position);
        pilotController.create(pilot);
        System.out.println("Record created successfully");

    }

    private void updatePilot() throws SQLException {
        System.out.println("Enter please pilot id you want to change: ");
        Integer id = SCANNER.nextInt();
        if (pilotController.findOne(id) == null) {
            System.out.println("Record with such id does not exist in this table");
            return;
        }
        System.out.println("Enter please pilot surname: ");
        String surname = SCANNER.next();
        System.out.println("Enter please pilot name: ");
        String name = SCANNER.next();
        System.out.println("Enter please pilot position: ");
        String position = SCANNER.next();

        Pilot pilot = new Pilot(surname, name, position);
        pilotController.update(id, pilot);
        System.out.println("Record updated successfully");
    }

    private void deletePilotById() throws SQLException {
        System.out.println("Enter please pilot id you want to delete: ");
        Integer id = SCANNER.nextInt();
        if (pilotController.findOne(id) == null) {
            System.out.println("Record with such id does not exist in this table");
            return;
        }
        pilotController.delete(id);
        System.out.println("Deleted successfully");
    }
}
