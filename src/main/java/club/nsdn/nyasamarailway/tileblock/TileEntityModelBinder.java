package club.nsdn.nyasamarailway.tileblock;

/**
 * Created by drzzm32 on 2016.5.5.
 */

import club.nsdn.nyasamarailway.block.BlockEdge;
import club.nsdn.nyasamarailway.block.BlockPlatform;
import club.nsdn.nyasamarailway.renderer.tileentity.*;
import club.nsdn.nyasamarailway.renderer.tileentity.rail.*;
import club.nsdn.nyasamarailway.tileblock.decoration.*;
import club.nsdn.nyasamarailway.tileblock.decoration.sign.*;
import club.nsdn.nyasamarailway.tileblock.functional.*;
import club.nsdn.nyasamarailway.tileblock.rail.*;
import club.nsdn.nyasamarailway.tileblock.rail.mono.*;
import club.nsdn.nyasamarailway.tileblock.signal.deco.*;
import club.nsdn.nyasamarailway.tileblock.signal.light.*;
import club.nsdn.nyasamarailway.tileblock.signal.core.BlockSignalBox;
import club.nsdn.nyasamarailway.tileblock.signal.core.BlockSignalBoxSender;
import club.nsdn.nyasamarailway.tileblock.signal.core.BlockTriStateSignalBox;
import club.nsdn.nyasamarailway.tileblock.signal.trackside.*;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.event.FMLInitializationEvent;

public class TileEntityModelBinder {

    public TileEntityModelBinder(FMLInitializationEvent event) {

        BlockPlatform.renderType = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(BlockPlatform.renderType, new PlatformRenderer());

        BlockEdge.renderType = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(BlockEdge.renderType, new EdgeRenderer());

        ClientRegistry.bindTileEntitySpecialRenderer(
                BlockTrackPlate.TrackPlate.class,
                new TrackPlateRenderer());

        ClientRegistry.bindTileEntitySpecialRenderer(
                BlockTrackShelf.TrackShelf.class,
                new BaseRenderer(new TrackShelfModel(), "textures/blocks/BrushedAluminum.png"));

        ClientRegistry.bindTileEntitySpecialRenderer(
                BlockTrackShelfLow.TrackShelfLow.class,
                new BaseRenderer(new TrackShelfLowModel(), "textures/blocks/BrushedAluminum.png"));

        ClientRegistry.bindTileEntitySpecialRenderer(
                BlockTBridgeHead.TBridgeHead.class,
                new BaseRenderer(new TBridgeHeadModel(true)));

        ClientRegistry.bindTileEntitySpecialRenderer(
                BlockTBridgeHeadNoRib.TBridgeHeadNoRib.class,
                new BaseRenderer(new TBridgeHeadModel(false)));

        ClientRegistry.bindTileEntitySpecialRenderer(
                BlockTBridgeBody.TBridgeBody.class,
                new BaseRenderer(new TBridgeBodyModel(true)));

        ClientRegistry.bindTileEntitySpecialRenderer(
                BlockTBridgeBodyNoRib.TBridgeBodyNoRib.class,
                new BaseRenderer(new TBridgeBodyModel(false)));

        ClientRegistry.bindTileEntitySpecialRenderer(
                BlockTBridgeShoulder.TBridgeShoulder.class,
                new BaseRenderer(new TBridgeShoulderModel()));

        ClientRegistry.bindTileEntitySpecialRenderer(
                BlockHalfBlock.HalfBlock.class,
                new BaseRenderer(new HalfBlockModel()));

        ClientRegistry.bindTileEntitySpecialRenderer(
                BlockHalfHalfBlock.HalfHalfBlock.class,
                new BaseRenderer(new HalfHalfBlockModel()));

        ClientRegistry.bindTileEntitySpecialRenderer(
                TileEntityRailSignBody.RailSignBody.class,
                new BaseRenderer(new RailSignBodyModel(), "textures/blocks/BrushedAluminum.png"));

        ClientRegistry.bindTileEntitySpecialRenderer(
                TileEntityRailSignHeadBeep.RailSignHeadBeep.class,
                new BaseRenderer(new RailSignHeadModel(), "textures/blocks/rail_sign_beep.png"));

        ClientRegistry.bindTileEntitySpecialRenderer(
                TileEntityRailSignHeadCut.RailSignHeadCut.class,
                new BaseRenderer(new RailSignHeadModel(), "textures/blocks/rail_sign_cut.png"));

        ClientRegistry.bindTileEntitySpecialRenderer(
                TileEntityRailSignHeadJoe.RailSignHeadJoe.class,
                new BaseRenderer(new RailSignHeadModel(), "textures/blocks/rail_sign_joe.png"));

        ClientRegistry.bindTileEntitySpecialRenderer(
                TileEntityRailSignHeadLink.RailSignHeadLink.class,
                new BaseRenderer(new RailSignHeadModel(), "textures/blocks/rail_sign_link.png"));

        ClientRegistry.bindTileEntitySpecialRenderer(
                TileEntityRailSignHeadCutLink.RailSignHeadCutLink.class,
                new BaseRenderer(new RailSignHeadModel(), "textures/blocks/rail_sign_cutlink.png"));

        ClientRegistry.bindTileEntitySpecialRenderer(
                TileEntityRailSignHeadT.RailSignHeadT.class,
                new BaseRenderer(new RailSignHeadModel(), "textures/blocks/rail_sign_t.png"));

        ClientRegistry.bindTileEntitySpecialRenderer(
                BlockStationSign.StationSign.class, new StationSignRenderer());

        ClientRegistry.bindTileEntitySpecialRenderer(
                RailBase.TileEntityRail.class, new RailRenderer(new RailNoSleeperStraightModel(), "textures/rails/rail_ns_s.png"));

        ClientRegistry.bindTileEntitySpecialRenderer(
                RailMono.TileEntityRail.class,
                new RailMonoRenderer()
        );

        ClientRegistry.bindTileEntitySpecialRenderer(
                RailMonoBumper.Bumper.class,
                new RailMonoBumperRenderer()
        );

        ClientRegistry.bindTileEntitySpecialRenderer(
                RailMonoMagnet.TileEntityRail.class,
                new RailMonoRenderer(new String[] { "textures/rails/RailMonoMagnetStraight.png", "textures/rails/RailMonoMagnetSlope.png", "textures/rails/RailMonoMagnetTurned.png" })
        );

        ClientRegistry.bindTileEntitySpecialRenderer(
                RailMonoMagnetDetector.TileEntityRail.class,
                new RailMonoRenderer(new String[] { "textures/rails/RailMonoMagnetStraightDetector.png", "textures/rails/RailMonoMagnetSlopeDetector.png", "textures/rails/RailMonoMagnetTurnedDetector.png" })
        );

        ClientRegistry.bindTileEntitySpecialRenderer(
                RailMonoMagnetDirectional.TileEntityRail.class,
                new RailMonoRenderer(new String[] { "textures/rails/RailMonoMagnetStraightDirectional.png", "textures/rails/RailMonoMagnetSlopeDirectional.png", "textures/rails/RailMonoMagnetTurnedDirectional.png" })
        );

        ClientRegistry.bindTileEntitySpecialRenderer(
                RailMonoMagnetDirectionalAnti.TileEntityRail.class,
                new RailMonoRenderer(new String[] { "textures/rails/RailMonoMagnetStraightDirectionalAnti.png", "textures/rails/RailMonoMagnetSlopeDirectionalAnti.png", "textures/rails/RailMonoMagnetTurnedDirectionalAnti.png" })
        );

        ClientRegistry.bindTileEntitySpecialRenderer(
                RailMonoMagnetPowered.TileEntityRail.class,
                new RailMonoRenderer(new String[] { "textures/rails/RailMonoMagnetStraightPowered.png", "textures/rails/RailMonoMagnetSlopePowered.png", "textures/rails/RailMonoMagnetTurnedPowered.png" })
        );

        ClientRegistry.bindTileEntitySpecialRenderer(
                RailMonoMagnetReception.TileEntityRail.class,
                new RailMonoRenderer(new String[] { "textures/rails/RailMonoMagnetStraightReception.png", "textures/rails/RailMonoMagnetSlopeReception.png", "textures/rails/RailMonoMagnetTurnedReception.png" })
        );

        ClientRegistry.bindTileEntitySpecialRenderer(
                RailMonoMagnetReceptionAnti.TileEntityRail.class,
                new RailMonoRenderer(new String[] { "textures/rails/RailMonoMagnetStraightReceptionAnti.png", "textures/rails/RailMonoMagnetSlopeReceptionAnti.png", "textures/rails/RailMonoMagnetTurnedReceptionAnti.png" })
        );

        ClientRegistry.bindTileEntitySpecialRenderer(
                RailMonoMagnetSignalTransfer.TileEntityRail.class,
                new RailMonoRenderer(new String[] { "textures/rails/RailMonoMagnetStraightSignalTransfer.png", "textures/rails/RailMonoMagnetSlopeSignalTransfer.png", "textures/rails/RailMonoMagnetTurnedSignalTransfer.png" })
        );

        ClientRegistry.bindTileEntitySpecialRenderer(
                RailMonoMagnetSpeedLimit.TileEntityRail.class,
                new RailMonoRenderer(new String[] { "textures/rails/RailMonoMagnetStraightSpeedLimit.png", "textures/rails/RailMonoMagnetSlopeSpeedLimit.png", "textures/rails/RailMonoMagnetTurnedSpeedLimit.png" })
        );

        ClientRegistry.bindTileEntitySpecialRenderer(
                RailMonoMagnetBlocking.TileEntityRail.class,
                new RailMonoRenderer(new String[] { "textures/rails/RailMonoMagnetStraightBlocking.png", "textures/rails/RailMonoMagnetSlopeBlocking.png", "textures/rails/RailMonoMagnetTurnedBlocking.png" })
        );

        ClientRegistry.bindTileEntitySpecialRenderer(
                RailMonoMagnetRFID.RailRFID.class,
                new RailMonoRenderer(new String[] { "textures/rails/RailMonoMagnetStraightRFID.png", "textures/rails/RailMonoMagnetSlopeRFID.png", "textures/rails/RailMonoMagnetTurnedRFID.png" })
        );

        ClientRegistry.bindTileEntitySpecialRenderer(
                RailMonoMagnetSniffer.RailSniffer.class,
                new RailMonoRenderer(new String[] { "textures/rails/RailMonoMagnetStraightSniffer.png", "textures/rails/RailMonoMagnetSlopeSniffer.png", "textures/rails/RailMonoMagnetTurnedSniffer.png" })
        );

        ClientRegistry.bindTileEntitySpecialRenderer(
                RailMonoMagnetRedStone.RailRedStone.class,
                new RailMonoRenderer(new String[] { "textures/rails/RailMonoMagnetStraightRedStone.png", "textures/rails/RailMonoMagnetSlopeRedStone.png", "textures/rails/RailMonoMagnetTurnedRedStone.png" })
        );

        ClientRegistry.bindTileEntitySpecialRenderer(
                BlockSignalLight.SignalLight.class, new SignalLightRenderer());

        ClientRegistry.bindTileEntitySpecialRenderer(
                BlockSignalBox.TileEntitySignalBox.class, new SignalBoxRenderer(false));

        ClientRegistry.bindTileEntitySpecialRenderer(
                BlockSignalBoxSender.TileEntitySignalBoxSender.class, new SignalBoxRenderer(true));

        ClientRegistry.bindTileEntitySpecialRenderer(
                BumperStoneSleeper.Bumper.class, new BumperRenderer("rail"));

        ClientRegistry.bindTileEntitySpecialRenderer(
                BumperNoSleeper.Bumper.class, new BumperRenderer("rail_ns"));

        ClientRegistry.bindTileEntitySpecialRenderer(
                BlockTriStateSignalBox.TileEntityTriStateSignalBox.class, new TriStateSignalBoxRenderer());

        ClientRegistry.bindTileEntitySpecialRenderer(
                RailMonoSwitch.MonoSwitch.class, new RailMonoSwitchRenderer());

        ClientRegistry.bindTileEntitySpecialRenderer(
                BlockGateBase.GateBase.class, new GateRenderer(GateRenderer.GATE_BASE));

        ClientRegistry.bindTileEntitySpecialRenderer(
                BlockGateDoor.GateDoor.class, new GateRenderer(GateRenderer.GATE_DOOR));

        ClientRegistry.bindTileEntitySpecialRenderer(
                BlockGateFront.GateFront.class, new GateRenderer(GateRenderer.GATE_FRONT));

        ClientRegistry.bindTileEntitySpecialRenderer(
                BlockGateFrontN.GateFrontN.class, new GateRenderer(GateRenderer.GATE_FRONT_N));

        ClientRegistry.bindTileEntitySpecialRenderer(
                BlockTicketBlockOnce.TicketBlock.class,
                new TicketBlockRenderer(TicketBlockRenderer.TICKET_ONCE)
        );

        ClientRegistry.bindTileEntitySpecialRenderer(
                BlockTicketBlockCard.TicketBlock.class,
                new TicketBlockRenderer(TicketBlockRenderer.TICKET_CARD)
        );

        ClientRegistry.bindTileEntitySpecialRenderer(
                BlockCoinBlock.CoinBlock.class,
                new TicketBlockRenderer(TicketBlockRenderer.COIN)
        );

        ClientRegistry.bindTileEntitySpecialRenderer(
                BlockGlassShield.GlassShield.class,
                new GlassShieldRenderer(GlassShieldRenderer.SHIELD)
        );

        ClientRegistry.bindTileEntitySpecialRenderer(
                BlockGlassShieldHalf.GlassShield.class,
                new GlassShieldRenderer(GlassShieldRenderer.SHIELD_HALF)
        );

        ClientRegistry.bindTileEntitySpecialRenderer(
                BlockGlassShield1X1.GlassShield.class,
                new GlassShieldRenderer(GlassShieldRenderer.SHIELD_1X1)
        );

        ClientRegistry.bindTileEntitySpecialRenderer(
                BlockGlassShield3X1.GlassShield.class,
                new GlassShieldRenderer(GlassShieldRenderer.SHIELD_3X1)
        );

        ClientRegistry.bindTileEntitySpecialRenderer(
                BlockGlassShield3X1D5.GlassShield.class,
                new GlassShieldRenderer(GlassShieldRenderer.SHIELD_3X1D5)
        );

        ClientRegistry.bindTileEntitySpecialRenderer(
                BlockGlassShieldAl.GlassShieldAl.class,
                new GlassShieldRenderer(GlassShieldRenderer.SHIELD_AL)
        );

        ClientRegistry.bindTileEntitySpecialRenderer(
                BlockGlassShieldAlHalf.GlassShieldAl.class,
                new GlassShieldRenderer(GlassShieldRenderer.SHIELD_AL_HALF)
        );

        ClientRegistry.bindTileEntitySpecialRenderer(
                BlockGlassShieldAlBase.GlassShieldAl.class,
                new GlassShieldRenderer(GlassShieldRenderer.SHIELD_AL_BASE)
        );

        ClientRegistry.bindTileEntitySpecialRenderer(
                BlockGlassShieldCorner.GlassShieldAl.class,
                new GlassShieldRenderer(GlassShieldRenderer.SHIELD_CORNER)
        );

        ClientRegistry.bindTileEntitySpecialRenderer(
                BlockGlassShieldCornerHalf.GlassShieldAl.class,
                new GlassShieldRenderer(GlassShieldRenderer.SHIELD_CORNER_HALF)
        );

        ClientRegistry.bindTileEntitySpecialRenderer(
                TileEntityRailSignVertical.RailSignVertical.class,
                new RailSignVerticalRenderer()
        );

        ClientRegistry.bindTileEntitySpecialRenderer(
                RailTriSwitch.TriSwitch.class, new RailTriSwitchRenderer());

        ClientRegistry.bindTileEntitySpecialRenderer(
                BlockPierTag.PierTag.class, new PierTagRenderer());

        ClientRegistry.bindTileEntitySpecialRenderer(
                BlockPillar.Pillar.class, new PillarRenderer());

        ClientRegistry.bindTileEntitySpecialRenderer(
                BlockBiSignalLight.BiSignalLight.class, new BiSignalLightRenderer("bi_signal_light"));

        ClientRegistry.bindTileEntitySpecialRenderer(
                BlockTriSignalLight.TriSignalLight.class, new TriSignalLightRenderer("tri_signal_light"));

        ClientRegistry.bindTileEntitySpecialRenderer(
                BlockSignalLamp.SignalLight.class, new SignalLightRenderer("models/blocks/signal_lamp.obj"));

        ClientRegistry.bindTileEntitySpecialRenderer(
                BlockSignalStick.SignalLight.class, new SignalLightRenderer("models/blocks/signal_stick.obj"));

        ClientRegistry.bindTileEntitySpecialRenderer(
                Rail3rd.TileEntityRail.class, new Rail3rdRenderer());

        ClientRegistry.bindTileEntitySpecialRenderer(
                Rail3rdSwitch.MonoSwitch.class, new RailMonoSwitchRenderer(true));

        ClientRegistry.bindTileEntitySpecialRenderer(
                RailMagnetSwitch.MagnetSwitch.class, new RailMonoSwitchRenderer(false));

        ClientRegistry.bindTileEntitySpecialRenderer(
                BlockSignalPillar.Pillar.class, new SignalPillarRenderer());

        ClientRegistry.bindTileEntitySpecialRenderer(
                BlockPillarSignalOne.SignalLight.class, new SignalLightRenderer("models/blocks/signal_pillar_one.obj"));

        ClientRegistry.bindTileEntitySpecialRenderer(
                BlockPillarSignalBi.BiSignalLight.class, new BiSignalLightRenderer("signal_pillar_bi"));

        ClientRegistry.bindTileEntitySpecialRenderer(
                BlockPillarSignalTri.TriSignalLight.class, new TriSignalLightRenderer("signal_pillar_tri"));

        ClientRegistry.bindTileEntitySpecialRenderer(
                ConvWireMono.Conv.class, new ConvWireMonoRenderer());

        ClientRegistry.bindTileEntitySpecialRenderer(
                TrackSideBlocking.Blocking.class, new TrackSideRenderer("track_side_blocking_sign"));

        ClientRegistry.bindTileEntitySpecialRenderer(
                TrackSideReception.Reception.class, new TrackSideRenderer("track_side_reception_sign"));

        ClientRegistry.bindTileEntitySpecialRenderer(
                TrackSideRFID.RFID.class, new TrackSideRenderer("track_side_rfid_sign"));

        ClientRegistry.bindTileEntitySpecialRenderer(
                TrackSideSniffer.Sniffer.class, new TrackSideRenderer("track_side_sniffer_sign"));

        ClientRegistry.bindTileEntitySpecialRenderer(
                TrackSideBlockingHs.Blocking.class, new TrackSideRenderer("track_side_blocking_hs_sign"));

        ClientRegistry.bindTileEntitySpecialRenderer(
                TrackSideRFIDHs.RFID.class, new TrackSideRenderer("track_side_rfid_hs_sign"));

        ClientRegistry.bindTileEntitySpecialRenderer(
                TrackSideSnifferHs.Sniffer.class, new TrackSideRenderer("track_side_sniffer_hs_sign"));
    }

}
