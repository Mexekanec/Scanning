package Examplemod.examplemod.server.handlers;

import Examplemod.examplemod.managers.PacketManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.scoreboard.Score;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public final class TickHandler {

    @SubscribeEvent
    public void onTick(final TickEvent.PlayerTickEvent event) {
        final TickEvent.Phase phase = event.phase;

        if (phase == TickEvent.Phase.END) {
            final EntityPlayer entityPlayer = event.player;
            final Scoreboard scoreboard = entityPlayer.getWorldScoreboard();
            final ScoreObjective scoreObjective = scoreboard.getObjective("scan");
            final Score score = scoreboard.getOrCreateScore(entityPlayer.getName(), scoreObjective);
            final int value = score.getScorePoints();

            if (value == 1)
                PacketManager.sendScanUpdate(true, (EntityPlayerMP) entityPlayer);
            else if (value == 0)
                PacketManager.sendScanUpdate(false, (EntityPlayerMP) entityPlayer);
        }
    }
}
