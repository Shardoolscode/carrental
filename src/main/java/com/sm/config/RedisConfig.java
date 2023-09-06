package com.sm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.sm.binding.User;

@Configuration
public class RedisConfig {

	@Bean
	public JedisConnectionFactory getJedisConnection() {
		JedisConnectionFactory factory=new JedisConnectionFactory();
//		factory.setHostName(hostname);
//		factory.setPassword(password);
//		factory.setPort(port);
		return factory;
	}
		@Bean
		@Primary
		public 	RedisTemplate<String , User >getreRedisTemplate(JedisConnectionFactory factory){
		RedisTemplate<String, User>rt=new RedisTemplate<>();
		rt.setConnectionFactory(factory);
			
			return rt;
		}
		
	}

