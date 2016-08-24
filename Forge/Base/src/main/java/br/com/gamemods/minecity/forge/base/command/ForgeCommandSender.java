package br.com.gamemods.minecity.forge.base.command;

import br.com.gamemods.minecity.api.PlayerID;
import br.com.gamemods.minecity.api.Server;
import br.com.gamemods.minecity.api.command.CommandSender;
import br.com.gamemods.minecity.api.command.Message;
import br.com.gamemods.minecity.api.world.Direction;
import br.com.gamemods.minecity.api.world.EntityPos;
import br.com.gamemods.minecity.forge.base.MineCityForge;
import net.minecraft.command.ICommandSender;
import org.jetbrains.annotations.NotNull;

public abstract class ForgeCommandSender<S extends ICommandSender> implements CommandSender
{
    public final MineCityForge mod;
    public final S sender;

    public ForgeCommandSender(MineCityForge mod, S sender)
    {
        this.mod = mod;
        this.sender = sender;
    }

    @NotNull
    @Override
    public Server getServer()
    {
        return mod;
    }

    @Override
    public EntityPos getPosition()
    {
        return null;
    }

    @Override
    public boolean isPlayer()
    {
        return false;
    }

    @Override
    public PlayerID getPlayerId()
    {
        return null;
    }

    @Override
    public boolean hasPermission(String perm)
    {
        return true;
    }

    @Override
    public void send(Message[] message)
    {
        for(Message msg : message)
            send(msg);
    }

    @Override
    public Direction getCardinalDirection()
    {
        return null;
    }
}
