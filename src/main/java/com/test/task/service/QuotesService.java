package com.test.task.service;

import com.test.task.model.Quotes;
import com.test.task.model.requestdto.SaveQuotesDTO;

import java.util.List;

public interface QuotesService {

    void saveQuotes(SaveQuotesDTO dto, String email);

    void updateQuotes(String quotes, int id);

    void updateLikes(int id);

    void updateDislikes(int id);

    List<Quotes> topTen();
}
