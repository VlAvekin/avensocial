package com.vladavekin.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.vladavekin.domain.Message;
import com.vladavekin.domain.Views;
import com.vladavekin.repo.MessageRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("message")
public class MessageController {

    private MessageRepo messageRepo;

    @Autowired
    public MessageController(MessageRepo messageRepo) {
        this.messageRepo = messageRepo;
    }


    @GetMapping
    @JsonView(Views.IdName.class)
    public List<Message> list() {
        return messageRepo.findAll();
    }

    // Получения лист пользователей
    @GetMapping("{id}")
    @JsonView(Views.FulMessage.class)
    public Message getOne(@PathVariable("id") Message message) {
        return message;
    }

    // Добавления нового обекта
    @PostMapping
    public Message create(@RequestBody Message message) {
        message.setCreationData(LocalDateTime.now());

        return messageRepo.save(message);
    }

    // Обновления тикушей записи
    @PutMapping("{id}")
    public Message update(@PathVariable("id") Message messageFromDB,
                          @RequestBody Message message) {

        BeanUtils.copyProperties(message, messageFromDB, "id");

        return messageRepo.save(messageFromDB);
    }

    // Удаления записи
    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Message message) {

        messageRepo.delete(message);
    }

}