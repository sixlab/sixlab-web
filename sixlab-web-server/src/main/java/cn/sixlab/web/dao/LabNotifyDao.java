/**
 * Copyright (c) 2017 Sixlab. All rights reserved.
 * <p>
 * Under the GPLv3(AKA GNU GENERAL PUBLIC LICENSE Version 3).
 * see http://www.gnu.org/licenses/gpl-3.0-standalone.html
 * <p>
 * For more information, please see
 * https://sixlab.cn/
 *
 * @time: 2017/9/21 22:12
 * @author: Patrick <root@sixlab.cn>
 */
package cn.sixlab.web.dao;

import cn.sixlab.web.bean.LabNotify;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LabNotifyDao extends JpaRepository<LabNotify, Integer> {

}
