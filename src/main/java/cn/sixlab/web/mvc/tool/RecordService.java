/*
 * Copyright (c) 2016 Sixlab. All rights reserved.
 *
 * Under the GPLv3(AKA GNU GENERAL PUBLIC LICENSE Version 3).
 * see http://www.gnu.org/licenses/gpl-3.0-standalone.html
 *
 * For more information, please see
 * http://sixlab.cn/
 * 
 * @author 六楼的雨/loki
 * @since 1.0.0(2016/3/9)
 */
package cn.sixlab.web.mvc.tool;

import cn.sixlab.web.bean.ToolsRecordItem;
import cn.sixlab.web.bean.ToolsRecordVal;
import cn.sixlab.web.mapper.ToolsRecordItemMapper;
import cn.sixlab.web.mapper.ToolsRecordValMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.Date;
import java.util.List;

/**
 * @author 六楼的雨/loki
 * @since 1.0.0(2016/3/9)
 */
@Service
public class RecordService {
    //private static Logger logger = LoggerFactory.getLogger(RecordService.class);

    @Autowired
    private ToolsRecordItemMapper itemMapper;

    @Autowired
    private ToolsRecordValMapper valMapper;

    public void index(ModelMap model) {
        List<ToolsRecordVal> valList = valMapper.queryTimes();
        model.put("valList",valList);
    }

    public void compare(Date date1, Date date2, ModelMap model) {
        List<ToolsRecordItem> itemList = itemMapper.queryEnableItems();
        model.put("itemList", itemList);

        List<ToolsRecordItem> date1List = itemMapper.queryByTime(date1);
        model.put("date1List", date1List);
        model.put("date1",date1);

        List<ToolsRecordItem> date2List = itemMapper.queryByTime(date2);
        model.put("date2List", date2List);
        model.put("date2", date2);

    }

    public void edit(ModelMap model) {
        List<ToolsRecordItem> enableItems = itemMapper.queryEnableItems();
        model.put("enableItems", enableItems);

        List<ToolsRecordItem> delItems = itemMapper.queryDelItems();
        model.put("delItems", delItems);
        int itemSize = enableItems.size();
        itemSize = ((delItems.size()>itemSize)? delItems.size():itemSize);
        model.put("itemSize", itemSize);
    }
}
