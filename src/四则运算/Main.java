package 四则运算;

import java.util.List;

/**
 * <>
 *
 * @Author: chenxin
 * @Date: 2020/3/5
 */
public class Main {

    public static void main(String[] args) {
        OperationServiceImpl operationService = new OperationServiceImpl();
        List<String> equations = operationService.getEquations(10, 0);
        for (String equation : equations) {
            System.out.println("equation = " + equation);
        }

    }

}
