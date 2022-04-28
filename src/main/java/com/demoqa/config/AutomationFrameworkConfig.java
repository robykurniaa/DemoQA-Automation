package com.demoqa.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;

@Configurable
@ComponentScan("com.demoqa")
public class AutomationFrameworkConfig {

	public AutomationFrameworkConfig() {

	}
}
