package ro.ubb.bikes.core.model.validators;

import ro.ubb.bikes.core.model.exceptions.ValidatorException;

import java.util.Optional;

public class InputValidator {

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
        optionalInputLine.filter(x -> x.equals("")).ifPresent(e -> {
            throw new ValidatorException("ID can't be empty!");
        });

        long result;
        try {
            result = Long.parseLong(inputLine);
        } catch (Exception exception) {
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
        optionalInputLine.filter(x -> x.equals("")).ifPresent(e -> {
            throw new ValidatorException("This field can't be empty!");
        });

        int result;
        try {
            result = Integer.parseInt(inputLine);
        } catch (Exception exception) {
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
        optionalInputLine.filter(x -> x.equals("")).ifPresent(e -> {
            throw new ValidatorException("This field can't be empty!");
        });
        return inputLine;
    }
}