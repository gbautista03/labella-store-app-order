package com.labella.store.order.service.impl;

import com.labella.store.order.service.LineItemService;
import com.labella.store.order.domain.LineItem;
import com.labella.store.order.repository.LineItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link LineItem}.
 */
@Service
@Transactional
public class LineItemServiceImpl implements LineItemService {

    private final Logger log = LoggerFactory.getLogger(LineItemServiceImpl.class);

    private final LineItemRepository lineItemRepository;

    public LineItemServiceImpl(LineItemRepository lineItemRepository) {
        this.lineItemRepository = lineItemRepository;
    }

    @Override
    public LineItem save(LineItem lineItem) {
        log.debug("Request to save LineItem : {}", lineItem);
        return lineItemRepository.save(lineItem);
    }

    @Override
    @Transactional(readOnly = true)
    public List<LineItem> findAll() {
        log.debug("Request to get all LineItems");
        return lineItemRepository.findAll();
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<LineItem> findOne(Long id) {
        log.debug("Request to get LineItem : {}", id);
        return lineItemRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete LineItem : {}", id);
        lineItemRepository.deleteById(id);
    }
}
