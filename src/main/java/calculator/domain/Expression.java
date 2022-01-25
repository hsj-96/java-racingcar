package calculator.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Expression {

    private static final String NUMBER_SPLIT_REGEX = "[-+*/]";
    private static final String OPERATOR_SPLIT_REGEX = "[0-9]+";

    private List<String> numbers = new ArrayList<>();
    private List<String> operators = new ArrayList<>();

    public Expression(String expression) {
        String newExpression = removeAllSpaces(expression);
        this.numbers = parseStringToListByRegex(newExpression, NUMBER_SPLIT_REGEX);
        this.operators = parseStringToListByRegex(newExpression, OPERATOR_SPLIT_REGEX);
    }

    public List<String> getNumbers() {
        return numbers;
    }

    public List<String> getOperators() {
        return operators;
    }

    private String removeAllSpaces(String expression) {
        return expression.replaceAll(" ", "");
    }

    private List<String> parseStringToListByRegex(String expression, String regex) {
        return Arrays.asList(expression.split(regex));
    }
}