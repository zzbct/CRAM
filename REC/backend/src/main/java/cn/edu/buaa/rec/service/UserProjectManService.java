package cn.edu.buaa.rec.service;

import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: suruo
 * @Email: csuruo@gmail.com
 * @Date: Created on 下午4:40 2018/02/06
 * @Modified by:
 */

public interface UserProjectManService {

    List<Map<String,Object>> manProject(Long sysUserId);
}