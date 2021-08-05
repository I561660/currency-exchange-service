package com.anthony.currencyExchange.controllor;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.anthony.currencyExchange.pojo.ExchangeValue;
import com.anthony.currencyExchange.repository.ExchangeValueRepository;

@RestController
@RequestMapping("/currency-exchange")
public class CurrencyExchangeControllor {
	
	@Autowired
	private Environment enviroument;
	
	@Autowired
	private ExchangeValueRepository repository;
	
	private Logger logger = LoggerFactory.getLogger(CurrencyExchangeControllor.class);

	@RequestMapping(path="/from/{from}/to/{to}", method= RequestMethod.GET)
	public ExchangeValue retriveExchangeValue(@PathVariable String from, @PathVariable String to) {
		
		ExchangeValue res = repository.findByFromAndTo(from, to);
		res.setPort(Integer.parseInt(enviroument.getProperty("local.server.port")));
		repository.findByFromAndTo(from, to);
		
		logger.info("{}", res);
		
		return res;
	}
}
