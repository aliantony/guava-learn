/**
 * @projectName guava
 * @package com.antony.learn.java
 * @className com.antony.learn.java.Clothes
 * @copyright Copyright 2018 Thuisoft, Inc. All rights reserved.
 */
package com.antony.learn.java;

/**
 * 
 * @description TODO
 * @author wangqian
 * @date 2018年5月31日 上午10:20:25
 * @version 1.0
 */
public class Clothes {
    private String no;
    private Color color;

    /**
     * Clothes
     * 
     * @description TODO
     * @param no
     * @param color
     * @author wangqian
     * @date 2018年5月31日 上午10:21:54
     * @version TODO
     */
    public Clothes(String no, Color color) {
        super();
        this.no = no;
        this.color = color;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

}
