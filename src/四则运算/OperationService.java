package 四则运算;

import java.util.List;

/**
 * 功能描述: 运算service
 *
 * @Author: chenxin
 * @Date: 2020/3/5
 */
public interface OperationService {

    /**
     * 功能描述: 获取等式
     *
     * @Author: chenxin
     * @Param: [num 数量, grade 年级]
     * @Date: 2020/3/5
     */
    List<String> getEquations(Integer num, Integer grade);

}
