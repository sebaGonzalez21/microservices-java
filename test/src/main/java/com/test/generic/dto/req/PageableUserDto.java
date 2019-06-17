package com.test.generic.dto.req;

import java.io.Serializable;

/**
 *
 * Sebastian Gonzalez
 *
 */
public class PageableUserDto implements Serializable {

    private static final long serialVersionUID = 521351017577704959L;
    private int actualPage;
    private int quantityRows;

    public int getActualPage() {
        return actualPage;
    }

    public void setActualPage(int actualPage) {
        this.actualPage = actualPage;
    }

    public int getQuantityRows() {
        return quantityRows;
    }

    public void setQuantityRows(int quantityRows) {
        this.quantityRows = quantityRows;
    }


}
