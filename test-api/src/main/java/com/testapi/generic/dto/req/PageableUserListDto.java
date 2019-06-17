package com.testapi.generic.dto.req;

import com.testapi.generic.dto.UserDto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PageableUserListDto implements Serializable {

    private static final long serialVersionUID = -7835159883112158971L;

    private int currentPage;
    private int quantityRecords;
    private int itemPerPage;
    private int totalPages;
    private List<UserDto> userDtoList;


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
