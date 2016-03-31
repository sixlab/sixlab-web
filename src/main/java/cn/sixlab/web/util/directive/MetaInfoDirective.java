/*
 * Copyright (c) 1995 Sixlab. All rights reserved.
 *
 * Under the GPLv3(AKA GNU GENERAL PUBLIC LICENSE Version 3).
 * see http://www.gnu.org/licenses/gpl-3.0-standalone.html
 *
 * For more information, please see
 * http://sixlab.cn/
 */
package cn.sixlab.web.util.directive;

import cn.sixlab.web.bean.SixlabMeta;
import cn.sixlab.web.util.MetaUtil;
import com.alibaba.druid.support.json.JSONUtils;
import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author 六楼的雨/loki
 * @since 1.0.0(2016/1/15)
 */
public class MetaInfoDirective implements TemplateDirectiveModel {

    public static final String meta_type_link = "link";
    public static final String meta_type_links = "links";
    public static final String meta_type_string = "string";

    @Override
    public void execute(Environment env, Map map, TemplateModel[] templateModels,
            TemplateDirectiveBody templateDirectiveBody) throws TemplateException, IOException {
        String type = Objects.toString(map.get("type"));
        String str;
        switch (type) {
            case meta_type_link:
                str = link(map);
                break;
            case meta_type_links:
                str = links(map);
                break;
            case meta_type_string:
                str = string(map);
                break;
            default:
                str = "";
        }
        Writer out = env.getOut();
        out.write(str);
    }

    private String string(Map map) {
        String key = Objects.toString(map.get("key"));
        String value = MetaUtil.getValue(key);
        return value;
    }

    private String links(Map map) {
        String className = Objects.toString(map.get("class"));
        String flag = Objects.toString(map.get("flag"));

        SixlabMeta record = new SixlabMeta();
        record.setMetaFlag(flag);
        record.setMetaKey(MetaUtil.meta_link);
        List<SixlabMeta> metaList = MetaUtil.getMetas(record);

        String str = "";
        for (SixlabMeta sixlabMeta : metaList) {
            String remark = sixlabMeta.getMetaRemark();
            Map<String, String> obj = (Map<String, String>) JSONUtils.parse(remark);

            str += "<a class='";
            str += className;
            str += "' href='";
            str += obj.get("href");
            str += "' title='";
            str += obj.get("title");
            str += "' target='";
            str += obj.get("target");
            str += "'>";
            str += obj.get("name");
            str += "</a>";
        }
        return str;
    }

    private String link(Map map) {
        String key = Objects.toString(map.get("key"));
        return null;
    }

    public static void main(String[] args) {
        //Map<String, String> map = (Map<String, String>) JSONUtils.parse(a);
    }
}
