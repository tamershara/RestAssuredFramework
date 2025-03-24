package com.qacart.todo.configs;
import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "system:env",
        "file:${user.dir}/src/test/resources/config.properties"
})
public interface FrameworkConfiguration extends Config {
    @DefaultValue("https://todo.qacart.com/api/v1")
    String baseUri();
}
