package com.testapi.generic.dto.req;

import java.io.Serializable;

public class PageableUserDto implements Serializable {

    private static final long serialVersionUID = 2616855659774245442L;
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
