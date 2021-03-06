package com.github.olaleyeone.dataupload.configuration;

import com.github.olaleyeone.configuration.EntitySearchConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan({
        "com.github.olaleyeone.dataupload.data.entity",
        "com.olaleyeone.audittrail.entity"
})
@EnableJpaRepositories({
        "com.github.olaleyeone.dataupload.repository",
        "com.olaleyeone.audittrail.repository"
})
@Import(EntitySearchConfiguration.class)
public class DataConfiguration {
}
