package 四则运算;

import 表达式计算.Computer;

import java.util.ArrayList;
import java.util.List;

/**
 * <运算Service>
 *
 * @Author: chenxin
 * @Date: 2020/3/5
 */
public class OperationServiceImpl implements OperationService {

    // 年级
    public static final int THIRD_GRADE = 3;
    public static final int FOURTH_GRADE = 4;
    public static final int FIFTH_GRADE = 5;
    public static final int SIXTH_GRADE = 6;

    @Override public List<String> getEquations(Integer num, Integer grade) {
        List<String> resultData;
        if (num == null) {
            return null;
        }

        switch (grade) {
            case THIRD_GRADE:
                resultData = this.getEquationsThirdGrade(num);
                break;
            case FOURTH_GRADE:
                resultData = this.getEquationsFourthGrade(num);
                break;
            case FIFTH_GRADE:
                resultData = this.getEquationsFifthGrade(num);
                break;
            case SIXTH_GRADE:
                resultData = this.getEquationsSixthGrade(num);
                break;
            default:
                // 不限难度
                resultData = this.getEquationsAllGrade(num);
        }
        return resultData;
    }

    private List<String> getEquationsAllGrade(Integer num) {
        List<String> resultData = new ArrayList<>();
        while (num > 0) {

            // 获取一个算式
            String equation = this.getEquationStr();

            // 计算算式结果
            // int sum = Computer.calPostfixExp(equation);
            equation += " = ?";

            resultData.add(equation);
            num--;
        }
        return resultData;
    }

    /**
     * 功能描述: 获取一个随机算式
     *
     * @Author: chenxin
     * @Date: 2020/3/5
     */
    public static String getEquationStr() {
        String equation = "";

        // 拿到一个2~8的随机数
        int count = RandomUtil.getRandomNum(2, 8);
        Character old = null, c;
        Integer oldNum = 0, n = 0;
        for (int i = 0; i < count; i++) {
            // 如果上一个运算符为除法 要确保下一个数字能被上一个数字整除（避免出现小数）
            if (old != null && old == '/') {
                while (true) {
                    if (oldNum == 1) {
                        n = 1;
                    } else {
                        n = RandomUtil.getRandomNum(1, oldNum);
                    }
                    if (oldNum % n == 0) {
                        n = oldNum / n;
                        break;
                    }
                }
                equation += n;

                // 避免出现两次以上的连续除法（避免出现小数）
                while (true) {
                    c = RandomUtil.getEquationChar();
                    if (c != '/') {
                        break;
                    }
                }
                equation += c;
            } else {
                n = RandomUtil.getRandomNum(1, 100);
                equation += n;

                c = RandomUtil.getEquationChar();
                equation += c;
            }

            old = c;
            oldNum = n;
        }
        equation = equation.substring(0, equation.length() - 1);
        return equation;
    }

    /**
     * 三年级难度
     */
    private List<String> getEquationsThirdGrade(Integer num) {

        return null;
    }

    /**
     * 四年级难度
     */
    private List<String> getEquationsFourthGrade(Integer num) {

        return null;
    }

    /**
     * 五年级难度
     */
    private List<String> getEquationsFifthGrade(Integer num) {

        return null;
    }

    /**
     * 六年级难度
     */
    private List<String> getEquationsSixthGrade(Integer num) {

        return null;
    }

}
