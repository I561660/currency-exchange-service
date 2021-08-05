package com.anthony.currencyExchange.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anthony.currencyExchange.pojo.ExchangeValue;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long> {

	ExchangeValue findByFromAndTo(String from, String to);
}
