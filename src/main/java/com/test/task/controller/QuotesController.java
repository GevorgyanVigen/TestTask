package com.test.task.controller;

import com.test.task.model.requestdto.SaveQuotesDTO;
import com.test.task.service.QuotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/quotes")
public class QuotesController {
    @Autowired
    private QuotesService quotesService;


    @PostMapping("/save-quotes")
    public ResponseEntity<?> saveQuotes(@RequestBody SaveQuotesDTO quotesDTO, Principal principal) {
        String email = principal.getName();
        quotesService.saveQuotes(quotesDTO, email);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/update-quotes")
    public ResponseEntity<?> updateQuotes(@RequestParam String quotes, @RequestParam int id) {
        quotesService.updateQuotes(quotes, id);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/update-like")
    public ResponseEntity<?> updateLikes(@RequestParam  int id) {
        quotesService.updateLikes(id);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/update-dislike")
    public ResponseEntity<?> updateDisLikes(@RequestParam  int id) {
        quotesService.updateDislikes(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("top-ten")
    public ResponseEntity<?> topTenLikes() {
        return ResponseEntity.ok(quotesService.topTen());
    }

}
