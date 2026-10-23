package com.example.scheduler;

import org.springframework.ai.mcp.annotation.McpTool;
import org.springframework.ai.mcp.annotation.McpToolParam;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@SpringBootApplication
public class SchedulerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchedulerApplication.class, args);
	}

}

@Service
class Scheduler {

	@McpTool(description = "schedules a dog for adoption at a Pooch Palace location")
	Instant schedule(@McpToolParam int dogId) {
		var i = Instant.now().plus(3, ChronoUnit.DAYS);
		IO.println("scheduling " + dogId + " for " + i + " for user "
				+ SecurityContextHolder.getContextHolderStrategy().getContext().getAuthentication().getName());
		return i;
	}

}