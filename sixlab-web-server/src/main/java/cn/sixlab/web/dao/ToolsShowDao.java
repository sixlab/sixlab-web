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

import cn.sixlab.web.bean.ToolsShow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ToolsShowDao extends JpaRepository<ToolsShow, Integer> {

    List<ToolsShow> findByViewStatus(String status);
    
    @Query(
            " select u from ToolsShow u where" +
                    "       u.tv like concat('%',?1,'%') " +
                    "    OR u.showName like concat('%',?1,'%') " +
                    "    OR u.remark like concat('%',?1,'%') "
    )
    List<ToolsShow> findByKeyword(String keyword);
    
    @Query(
            " select u from ToolsShow u where" +
                    " u.viewStatus = ?1 " +
                    " and ( " +
                    "       u.tv like concat('%',?2,'%') " +
                    "    OR u.showName like concat('%',?2,'%') " +
                    "    OR u.remark like concat('%',?2,'%') " +
                    "     ) "
    )
    List<ToolsShow> findByStatus(String status, String keyword);
}
