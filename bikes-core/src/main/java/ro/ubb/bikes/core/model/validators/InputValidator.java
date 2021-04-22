package ro.ubb.bikes.core.model.validators;

import ro.ubb.bikes.core.model.exceptions.ValidatorException;

import java.util.Optional;

public class InputValidator{

    public InputValidator() {
    }

    /**
     * Validates the ID transmitted by the user.
     * An ID is valid if:
     * - is not empty/null;
     * - can be changed into type Long from type String;
     *
     * @param inputLine the String read from the console
     * @return an {@code Long} the resulted Long if it can be obtained
     * @throws ValidatorException if the ID is not valid
     */
    public Long validateId(String inputLine) throws ValidatorException {
        Optional<String> optionalInputLine = Optional.ofNullable(inputLine.strip());
        optionalInputLine.orElseThrow(() -> new ValidatorException("ID can't be null!"));
        optionalInputLine.filter(x -> x.equals("")).ifPresent(e -> { throw new ValidatorException("ID can't be empty!"); });

        long result;
        try{
            result = Long.parseLong(inputLine);
        } catch(Exception exception){
            throw new ValidatorException("ID must be a number!");
        }
        return result;
    }

    /**
     * Validates the input transmitted by the user that has to be of type Integer.
     *
     * @param inputLine the String read from the console
     * @return an {@code Integer} the resulted Integer if it can be obtained
     * @throws ValidatorException if the input is not valid
     */
    public Integer validateIntegerValues(String inputLine) throws ValidatorException {
        Optional<String> optionalInputLine = Optional.ofNullable(inputLine.strip());
        optionalInputLine.orElseThrow(() -> new ValidatorException("This field can't be null!"));
        optionalInputLine.filter(x -> x.equals("")).ifPresent(e -> { throw new ValidatorException("This field can't be empty!"); });

        int result;
        try{
            result = Integer.parseInt(inputLine);
        } catch (Exception exception){
            throw new ValidatorException("This field must be a number!");
        }
        return result;
    }

    /**
     * Validates the input transmitted by the user that has to be of type String.
     *
     * @param inputLine the String read from the console
     * @return an {@code String} the resulted String if it can be obtained
     * @throws ValidatorException if the input is not valid
     */
    public String validateStringValues(String inputLine) throws ValidatorException {
        Optional<String> optionalInputLine = Optional.ofNullable(inputLine.strip());
        optionalInputLine.orElseThrow(() -> new ValidatorException("This field can't be null!"));
        optionalInputLine.filter(x -> x.equals("")).ifPresent(e -> { throw new ValidatorException("This field can't be empty!"); });
        return inputLine;
    }

//    /**
//     * Checks if exists a Bike with a given ID exists in the bikeRepository;
//     *
//     * @param bikeID - the ID that needs to be found
//     * @throws ValidatorException if the bike does not exist in the repo
//     */
//    public void existBikeWithID(Long bikeID, BikeService bikeService) throws ValidatorException {
//        bikeService.exist(bikeID);
//    }
//
//
//    /**
//     * Checks if exists a Client with a given ID exists in the clientRepository;
//     *
//     * @param clientID - the ID that needs to be found;
//     * @throws ValidatorException if the client does not exist in the repo
//     */
//    public void existClientWithID(Long clientID, ClientService clientService) throws ValidatorException {
//        clientService.exist(clientID);
//    }
//
//    /**
//     * Checks if exists an Employee with a given ID exists in the employeeRepository;
//     *
//     * @param employeeID - the ID that needs to be found;
//     * @throws ValidatorException if the employee does not exist in the repo
//     */
//    public void existEmployeeWithID(Long employeeID, EmployeeService employeeService) throws ValidatorException {
//        employeeService.exist(employeeID);
//    }
}