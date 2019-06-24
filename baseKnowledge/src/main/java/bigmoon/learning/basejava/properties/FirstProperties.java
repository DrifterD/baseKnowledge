/*
 * Copyright (c) 2004- 2019 All Rights Reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 * FileName: FirstProperties.java
 * Author:   bigmoon
 * Date:     19-6-18 下午3:28
 * Description: baseKnowledge
 *
 */

package bigmoon.learning.basejava.properties;

import java.util.Properties;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author 17081794
 * @see [相关类/方法]（可选）
 * @since 0628
 */
public class FirstProperties {

    public static void main(String[] args) {

        Properties properties = System.getProperties();
        properties.forEach((item1, item2) -> {
            System.out.println(item1 + "=" + item2);
        });
    }
}
