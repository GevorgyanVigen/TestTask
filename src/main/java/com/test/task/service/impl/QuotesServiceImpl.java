package com.test.task.service.impl;

import com.test.task.model.Quotes;
import com.test.task.model.User;
import com.test.task.model.requestdto.SaveQuotesDTO;
import com.test.task.repository.QuotesRepository;
import com.test.task.repository.UserRepository;
import com.test.task.service.QuotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuotesServiceImpl implements QuotesService {

    @Autowired
    private QuotesRepository quotesRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void saveQuotes(SaveQuotesDTO dto, String email) {

        Quotes quotes = new Quotes();

        quotes.setTitle(dto.getTitle());
        quotes.setQuote(dto.getQuote());
        quotes.setLikes(0);
        quotes.setDislike(0);

        User user = userRepository.getByUsername(email);
        quotes.setUser(user);

         quotesRepository.save(quotes);

    }

    @Override
    public void updateQuotes(String quotes, int id) {
        quotesRepository.updateQuotes(quotes, id);
    }

    @Override
    public void updateLikes(int id) {
        Quotes quotes = quotesRepository.getById(id);
        quotes.setLikes(quotes.getLikes() + 1);
        quotesRepository.saveAndFlush(quotes);
    }

    @Override
    public void updateDislikes(int id) {
        Quotes quotes = quotesRepository.getById(id);
        quotes.setDislike(quotes.getDislike() + 1);
        quotesRepository.saveAndFlush(quotes);
    }

    @Override
    public List<Quotes> topTen() {
       return quotesRepository.findAllByLikes();
    }


}
