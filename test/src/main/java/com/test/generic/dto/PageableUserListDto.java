package com.test.generic.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PageableUserListDto implements Serializable {


    private static final long serialVersionUID = 8661053040048447266L;
    private List<UserDto> userDtoList;
    private int currentPage;
    private int quantityRecords;
    private int itemPerPage;
    private int totalPages;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getQuantityRecords() {
        return quantityRecords;
    }

    public void setQuantityRecords(int quantityRecords) {
        this.quantityRecords = quantityRecords;
    }

    public int getItemPerPage() {
        return itemPerPage;
    }

    public void setItemPerPage(int itemPerPage) {
        this.itemPerPage = itemPerPage;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
    public void setUserDtoList(List<UserDto> userDtoList) {
        this.userDtoList = userDtoList;
    }
    public PageableUserListDto(){
        userDtoList = new ArrayList<>();
    }
    public List<UserDto> getUserDtoList() {
        return userDtoList;
    }

}
