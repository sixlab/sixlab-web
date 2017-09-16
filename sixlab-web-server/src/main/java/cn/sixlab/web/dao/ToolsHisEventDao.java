/**
 * Copyright (c) 2017 Sixlab. All rights reserved.
 *
 * Under the GPLv3(AKA GNU GENERAL PUBLIC LICENSE Version 3).
 * see http://www.gnu.org/licenses/gpl-3.0-standalone.html
 *
 * For more information, please see
 * https://sixlab.cn/
 *
 * @time: 2017/6/20
 * @author: Patrick <root@sixlab.cn>
 */
package cn.sixlab.web.dao;

import cn.sixlab.web.bean.ToolsHisEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToolsHisEventDao extends JpaRepository<ToolsHisEvent, Integer> {

}
