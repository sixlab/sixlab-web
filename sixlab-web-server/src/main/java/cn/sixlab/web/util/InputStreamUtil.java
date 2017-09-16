/**
 * Copyright (c) 2017 Sixlab. All rights reserved.
 *
 * Under the GPLv3(AKA GNU GENERAL PUBLIC LICENSE Version 3).
 * see http://www.gnu.org/licenses/gpl-3.0-standalone.html
 *
 * For more information, please see
 * https://sixlab.cn/
 *
 * @time: 2017
 * @author: Patrick <root@sixlab.cn>
 */
package cn.sixlab.web.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;

public class InputStreamUtil {
    
    public static String readString(InputStream input) throws IOException {
        StringWriter writer = new StringWriter();
    
        InputStreamReader reader = new InputStreamReader(input, "UTF-8");
        char[] buffer = new char[4096];
    
        int n;
        while (-1 != (n = reader.read(buffer))) {
            writer.write(buffer, 0, n);
        }
    
        return writer.toString();
    }
}
