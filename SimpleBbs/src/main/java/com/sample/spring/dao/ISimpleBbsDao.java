package com.sample.spring.dao;

import com.sample.spring.dto.SimpleBbsDto;

import java.util.List;

public interface ISimpleBbsDao {
    public List<SimpleBbsDto> listDao();
    public Integer countDao();
    public SimpleBbsDto viewDao(String id);
    public int writeDao(String writer, String title, String content);
    public int delete(String id); // delete?id=1

}
