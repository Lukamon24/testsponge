package com.github.Lukamon24.testsponge;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameInitializationEvent;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.event.game.state.GameStoppedServerEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.text.Text;
import com.github.Lukamon24.testsponge.Commands.testfly;
// import org.spongepowered.api.plugin.PluginContainer;
// import org.spongepowered.api.text.Text;
// import org.spongepowered.api.command.spec.CommandSpec;
// import org.spongepowered.api.Sponge;

import com.google.inject.Inject;
import org.slf4j.Logger;
import com.google.common.collect.Lists;

@Plugin(id = "testsponge", name = "TestSponge", version = "1.0.0", description = "Testing the Sponge API with Gradle..." )
public class main {

    @Inject
    private Logger logger;

    @Listener
    public void onInitialization(GameInitializationEvent event) {

        CommandSpec testCommandSpec = CommandSpec.builder()
                .description(Text.of("Fly Command"))
                .permission("testsponge.fly")
                .executor(new testfly())
                .build();

        Sponge.getCommandManager().register(this, testCommandSpec, Lists.newArrayList("testsponge", "fly"));
        logger.info("Enabled!");
    }

    @Listener
    public void onServerStart(GameStartedServerEvent event) {
        logger.info("TestSponge Success!!");
    }

    @Listener
    public  void onServerStop(GameStoppedServerEvent event) {
        logger.info("TestSponge plugin disabled successfully!!");
    }

}
