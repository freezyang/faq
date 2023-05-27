package com.faq.domain.category.event.handler;

import com.faq.domain.category.event.CategoryEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
public class CategoryEventListener {

    @TransactionalEventListener
    public void handle(CategoryEvent event) {
        System.out.println(event.categoryNo());
    }
}
