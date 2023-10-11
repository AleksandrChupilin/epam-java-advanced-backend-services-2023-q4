package com.chupilin.javaadvancedcource.module1.configuration;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;

import javax.sql.DataSource;

import static org.assertj.core.api.Assertions.assertThat;

class CustomDataSourceConfigTest {

    private final ApplicationContextRunner contextRunner = new ApplicationContextRunner()
            .withConfiguration(AutoConfigurations.of(CustomDataSourceConfig.class));

    @Test
    void customDataSourceShouldBePresent() {
        this.contextRunner.run(context -> {
                    assertThat(context).hasSingleBean(DataSource.class);
                    assertThat(context.getBeanNamesForType(DataSource.class))
                            .allMatch("customDataSource"::equals);
                }
        );
    }

}
