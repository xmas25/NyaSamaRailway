package club.nsdn.nyasamarailway.block;

/**
 * Created by drzzm32 on 2016.5.5.
 */

import club.nsdn.nyasamaoptics.api.LightBeam;
import club.nsdn.nyasamarailway.block.rail.*;
import club.nsdn.nyasamarailway.block.rail.special.*;
import club.nsdn.nyasamarailway.tileblock.decoration.*;
import club.nsdn.nyasamarailway.tileblock.decoration.sign.*;
import club.nsdn.nyasamarailway.tileblock.functional.*;
import club.nsdn.nyasamarailway.tileblock.rail.*;
import club.nsdn.nyasamarailway.tileblock.rail.mono.*;
import club.nsdn.nyasamarailway.tileblock.signal.deco.*;
import club.nsdn.nyasamarailway.tileblock.signal.light.AbsSignalLight;
import club.nsdn.nyasamarailway.tileblock.signal.light.*;
import club.nsdn.nyasamarailway.tileblock.signal.core.BlockSignalBox;
import club.nsdn.nyasamarailway.tileblock.signal.core.BlockSignalBoxSender;
import club.nsdn.nyasamarailway.tileblock.signal.core.BlockTriStateSignalBox;
import club.nsdn.nyasamarailway.tileblock.signal.trackside.*;
import net.minecraft.block.Block;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class BlockLoader {

    public static Block blockSign;
    public static Block blockNSDNLogo;
    public static Block blockNSRLogo;
    public static Block blockTrackPlate;
    public static Block blockTrackShelf;
    public static Block blockTrackShelfLow;
    public static Block blockRailStoneSleeper;
    public static Block blockRailNoSleeper;
    public static Block blockRailStoneSleeperPowered;
    public static Block blockRailNoSleeperPowered;
    public static Block blockRailStoneSleeperDetector;
    public static Block blockRailNoSleeperDetector;
    public static Block blockRailRFID;
    public static Block blockRailNoSleeperRFID;

    /*------*/
    public static Block blockRailStoneSleeperDetector5s;
    public static Block blockRailNoSleeperDetector5s;
    public static Block blockRailStoneSleeperDetector15s;
    public static Block blockRailNoSleeperDetector15s;
    public static Block blockRailStoneSleeperDetector30s;
    public static Block blockRailNoSleeperDetector30s;
    /*------*/

    public static Block blockRailProtectBody;
    public static Block blockRailProtectHead;
    public static Block blockRailProtectHeadAnti;
    public static Block blockRailReception;
    public static Block blockRailReceptionAnti;
    public static Block blockRailSignalTransfer;
    public static Block blockRailSpeedLimit;
    public static Block blockRailDirectional;
    public static Block blockRailDirectionalAnti;
    public static Block blockRailBlocking;
    public static Block blockRailNoSleeperBlocking;
    public static Block blockRailSniffer;
    public static Block blockRailRedStone;

    public static Block blockBumperStoneSleeper;
    public static Block blockBumperNoSleeper;

    public static Block blockPierTag;

    public static Block blockIronBars;
    public static Block blockIronWeb;
    public static Block blockTBridgeHead;
    public static Block blockTBridgeHeadNoRib;
    public static Block blockTBridgeBody;
    public static Block blockTBridgeBodyNoRib;
    public static Block blockTBridgeShoulder;
    public static Block blockHalfBlock;
    public static Block blockHalfHalfBlock;
    public static Block blockPlatform;
    public static Block blockEdge;
    public static Block blockRailSignBody;
    public static Block blockRailSignHeadBeep;
    public static Block blockRailSignHeadCut;
    public static Block blockRailSignHeadJoe;
    public static Block blockRailSignHeadLink;
    public static Block blockRailSignHeadCutLink;
    public static Block blockRailSignHeadT;

    public static Block blockRailSignVertical1;
    public static Block blockRailSignVertical2;
    public static Block blockRailSignVertical3;
    public static Block blockRailSignVertical4;
    public static Block blockRailSignVertical5;
    public static Block blockRailSignVertical6;
    public static Block blockRailSignVertical7;
    public static Block blockRailSignVertical8;
    public static Block blockRailSignVertical9;
    public static Block blockRailSignVertical10;
    public static Block blockRailSignVertical11;

    public static Block railNoSleeperStraight;
    public static Block convWireMono;

    public static Block rail3rd;
    public static Block rail3rdSwitch;
    public static Block railMagnetSwitch;
    public static Block railMono;
    public static Block railMonoBumper;
    public static Block railMonoMagnet;
    public static Block railMonoSwitch;
    public static Block railMonoMagnetPowered;
    public static Block railMonoMagnetDetector;
    public static Block railMonoMagnetDetector5s;
    public static Block railMonoMagnetDetector15s;
    public static Block railMonoMagnetDetector30s;
    public static Block railMonoMagnetReception;
    public static Block railMonoMagnetReceptionAnti;
    public static Block railMonoMagnetDirectional;
    public static Block railMonoMagnetDirectionalAnti;
    public static Block railMonoMagnetSpeedLimit;
    public static Block railMonoMagnetSignalTransfer;
    public static Block railMonoMagnetBlocking;
    public static Block railMonoMagnetRFID;
    public static Block railMonoMagnetSniffer;
    public static Block railMonoMagnetRedStone;

    public static Block railTriSwitch;

    public static Block blockStationSign;

    public static Block blockPillar;
    public static Block blockSignalLight;
    public static Block blockSignalLamp;
    public static Block blockSignalStick;
    public static Block blockBiSignalLight;
    public static Block blockTriSignalLight;

    public static Block blockSignalPillar;
    public static Block blockPillarSignalOne;
    public static Block blockPillarSignalBi;
    public static Block blockPillarSignalTri;

    public static Block blockSignalBox;
    public static Block blockSignalBoxSender;
    public static Block blockTriStateSignalBox;

    public static Block blockGateBase;
    public static Block blockGateDoor;
    public static Block blockGateFront;
    public static Block blockGateFrontN;

    public static Block blockGlassShield;
    public static Block blockGlassShieldHalf;
    public static Block blockGlassShield1x1;
    public static Block blockGlassShield3x1;
    public static Block blockGlassShield3x1d5;
    public static Block blockGlassShieldAl;
    public static Block blockGlassShieldAlHalf;
    public static Block blockGlassShieldAlBase;
    public static Block blockGlassShieldCorner;
    public static Block blockGlassShieldCornerHalf;

    public static Block blockTicketOnce;
    public static Block blockTicketCard;
    public static Block blockCoin;

    public static LightBeam dotBeam;
    public static LightBeam lineBeam;

    public static Block blockNSTest;
    public static Block blockTrackSideBlocking;
    public static Block blockTrackSideReception;
    public static Block blockTrackSideRFID;
    public static Block blockTrackSideSniffer;
    public static Block blockTrackSideBlockingHs;
    public static Block blockTrackSideRFIDHs;
    public static Block blockTrackSideSnifferHs;

    private static void register(Block block, String name) {
        GameRegistry.registerBlock(block, name);
    }

    public BlockLoader(FMLPreInitializationEvent event) {
        blockSign = new BlockSign();
        register(blockSign, "nyasamarailway_block_sign");

        blockNSDNLogo = new BlockNSDNLogo();
        register(blockNSDNLogo, "nyasamarailway_nsdn_logo");

        blockNSRLogo = new BlockNSRLogo();
        register(blockNSRLogo, "nyasamarailway_logo");

        blockTrackPlate = new BlockTrackPlate();
        register(blockTrackPlate, "block_track_plate");

        blockTrackShelf = new BlockTrackShelf();
        register(blockTrackShelf, "block_track_shelf");

        blockTrackShelfLow = new BlockTrackShelfLow();
        register(blockTrackShelfLow, "block_track_shelf_low");

        blockRailStoneSleeper = new BlockRailStoneSleeper();
        register(blockRailStoneSleeper, "block_rail_stone_sleeper");

        blockRailNoSleeper = new BlockRailNoSleeper();
        register(blockRailNoSleeper, "block_rail_no_sleeper");

        blockRailStoneSleeperPowered = new BlockRailStoneSleeperPowered();
        register(blockRailStoneSleeperPowered, "block_rail_stone_sleeper_powered");

        blockRailNoSleeperPowered = new BlockRailNoSleeperPowered();
        register(blockRailNoSleeperPowered, "block_rail_no_sleeper_powered");

        blockRailStoneSleeperDetector = new BlockRailStoneSleeperDetector();
        register(blockRailStoneSleeperDetector, "block_rail_stone_sleeper_detector");

        blockRailNoSleeperDetector = new BlockRailNoSleeperDetector();
        register(blockRailNoSleeperDetector, "block_rail_no_sleeper_detector");

        blockRailRFID = new BlockRailRFID();
        register(blockRailRFID, "block_rail_rfid");

        blockRailNoSleeperRFID = new BlockRailNoSleeperRFID();
        register(blockRailNoSleeperRFID, "block_rail_no_sleeper_rfid");

        /*------*/
        blockRailStoneSleeperDetector5s = new BlockRailStoneSleeperDetector(5);
        register(blockRailStoneSleeperDetector5s, "block_rail_stone_sleeper_detector_5s");
        blockRailNoSleeperDetector5s = new BlockRailNoSleeperDetector(5);
        register(blockRailNoSleeperDetector5s, "block_rail_no_sleeper_detector_5s");
        blockRailStoneSleeperDetector15s = new BlockRailStoneSleeperDetector(15);
        register(blockRailStoneSleeperDetector15s, "block_rail_stone_sleeper_detector_15s");
        blockRailNoSleeperDetector15s = new BlockRailNoSleeperDetector(15);
        register(blockRailNoSleeperDetector15s, "block_rail_no_sleeper_detector_15s");
        blockRailStoneSleeperDetector30s = new BlockRailStoneSleeperDetector(30);
        register(blockRailStoneSleeperDetector30s, "block_rail_stone_sleeper_detector_30s");
        blockRailNoSleeperDetector30s = new BlockRailNoSleeperDetector(30);
        register(blockRailNoSleeperDetector30s, "block_rail_no_sleeper_detector_30s");
        /*------*/

        blockRailProtectHead = new BlockRailProtectHead();
        register(blockRailProtectHead, "block_rail_protect_head");

        blockRailProtectHeadAnti = new BlockRailProtectHeadAnti();
        register(blockRailProtectHeadAnti, "block_rail_protect_head_anti");

        blockRailProtectBody = new BlockRailProtectBody();
        register(blockRailProtectBody, "block_rail_protect_body");

        blockRailReception = new BlockRailReception();
        register(blockRailReception, "block_rail_reception");

        blockRailReceptionAnti = new BlockRailReceptionAnti();
        register(blockRailReceptionAnti, "block_rail_reception_anti");

        blockRailSignalTransfer = new BlockRailSignalTransfer();
        register(blockRailSignalTransfer, "block_rail_signal_transfer");

        blockRailSpeedLimit = new BlockRailSpeedLimit();
        register(blockRailSpeedLimit, "block_rail_speed_limit");

        blockRailDirectional = new BlockRailDirectional();
        register(blockRailDirectional, "block_rail_dir");

        blockRailDirectionalAnti = new BlockRailDirectionalAnti();
        register(blockRailDirectionalAnti, "block_rail_dir_anti");

        blockRailBlocking = new BlockRailBlocking();
        register(blockRailBlocking, "block_rail_blocking");

        blockRailNoSleeperBlocking = new BlockRailNoSleeperBlocking();
        register(blockRailNoSleeperBlocking, "block_rail_no_sleeper_blocking");

        blockRailSniffer = new BlockRailSniffer();
        register(blockRailSniffer, "block_rail_sniffer");

        blockRailRedStone = new BlockRailRedStone();
        register(blockRailRedStone, "block_rail_redstone");


        blockBumperStoneSleeper = new BumperStoneSleeper();
        register(blockBumperStoneSleeper, "block_bumper_stone_sleeper");

        blockBumperNoSleeper = new BumperNoSleeper();
        register(blockBumperNoSleeper, "block_bumper_no_sleeper");


        blockPierTag = new BlockPierTag();
        register(blockPierTag, "block_pier_tag");


        blockIronBars = new BlockIronBars();
        register(blockIronBars, "rail_iron_bars");

        blockIronWeb = new BlockIronWeb();
        register(blockIronWeb, "rail_iron_web");

        blockTBridgeHead = new BlockTBridgeHead();
        register(blockTBridgeHead, "block_t_bridge_head");

        blockTBridgeHeadNoRib = new BlockTBridgeHeadNoRib();
        register(blockTBridgeHeadNoRib, "block_t_bridge_head_no_rib");

        blockTBridgeBody = new BlockTBridgeBody();
        register(blockTBridgeBody, "block_t_bridge_body");

        blockTBridgeBodyNoRib = new BlockTBridgeBodyNoRib();
        register(blockTBridgeBodyNoRib, "block_t_bridge_body_no_rib");

        blockTBridgeShoulder = new BlockTBridgeShoulder();
        register(blockTBridgeShoulder, "block_t_bridge_shoulder");

        blockHalfBlock = new BlockHalfBlock();
        register(blockHalfBlock, "block_half_block");

        blockHalfHalfBlock = new BlockHalfHalfBlock();
        register(blockHalfHalfBlock, "block_half_half_block");

        blockPlatform = new BlockPlatform();
        register(blockPlatform, "block_platform");

        blockEdge = new BlockEdge();
        register(blockEdge, "block_edge");

        blockRailSignBody = new TileEntityRailSignBody();
        register(blockRailSignBody, "block_rail_sign_body");

        blockRailSignHeadBeep = new TileEntityRailSignHeadBeep();
        register(blockRailSignHeadBeep, "block_rail_sign_head_beep");

        blockRailSignHeadCut = new TileEntityRailSignHeadCut();
        register(blockRailSignHeadCut, "block_rail_sign_head_cut");

        blockRailSignHeadJoe = new TileEntityRailSignHeadJoe();
        register(blockRailSignHeadJoe, "block_rail_sign_head_joe");

        blockRailSignHeadLink = new TileEntityRailSignHeadLink();
        register(blockRailSignHeadLink, "block_rail_sign_head_link");

        blockRailSignHeadCutLink = new TileEntityRailSignHeadCutLink();
        register(blockRailSignHeadCutLink, "block_rail_sign_head_cutlink");

        blockRailSignHeadT = new TileEntityRailSignHeadT();
        register(blockRailSignHeadT, "block_rail_sign_head_t");

        blockRailSignVertical1 = new TileEntityRailSignVertical(
                "RailSignVertical1", "rail_sign_vertical_head_1", "rail_sign_vertical_1"
        );
        register(blockRailSignVertical1, "block_rail_sign_vertical_1");

        blockRailSignVertical2 = new TileEntityRailSignVertical(
                "RailSignVertical2", "rail_sign_vertical_head_2", "rail_sign_vertical_2"
        );
        register(blockRailSignVertical2, "block_rail_sign_vertical_2");

        blockRailSignVertical3 = new TileEntityRailSignVertical(
                "RailSignVertical3", "rail_sign_vertical_head_3", "rail_sign_vertical_3"
        );
        register(blockRailSignVertical3, "block_rail_sign_vertical_3");

        blockRailSignVertical4 = new TileEntityRailSignVertical(
                "RailSignVertical4", "rail_sign_vertical_head_4", "rail_sign_vertical_4"
        );
        register(blockRailSignVertical4, "block_rail_sign_vertical_4");

        blockRailSignVertical5 = new TileEntityRailSignVertical(
                "RailSignVertical5", "rail_sign_vertical_head_5", "rail_sign_vertical_5"
        );
        register(blockRailSignVertical5, "block_rail_sign_vertical_5");

        blockRailSignVertical6 = new TileEntityRailSignVertical(
                "RailSignVertical6", "rail_sign_vertical_head_6", "rail_sign_vertical_6"
        );
        register(blockRailSignVertical6, "block_rail_sign_vertical_6");

        blockRailSignVertical7 = new TileEntityRailSignVertical(
                "RailSignVertical7", "rail_sign_vertical_head_7", "rail_sign_vertical_7"
        );
        register(blockRailSignVertical7, "block_rail_sign_vertical_7");

        blockRailSignVertical8 = new TileEntityRailSignVertical(
                "RailSignVertical8", "rail_sign_vertical_head_8", "rail_sign_vertical_8"
        );
        register(blockRailSignVertical8, "block_rail_sign_vertical_8");

        blockRailSignVertical9 = new TileEntityRailSignVertical(
                "RailSignVertical9", "rail_sign_vertical_head_9", "rail_sign_vertical_9"
        );
        register(blockRailSignVertical9, "block_rail_sign_vertical_9");

        blockRailSignVertical10 = new TileEntityRailSignVertical(
                "RailSignVertical10", "rail_sign_vertical_head_10", "rail_sign_vertical_10"
        );
        register(blockRailSignVertical10, "block_rail_sign_vertical_10");

        blockRailSignVertical11 = new TileEntityRailSignVertical(
                "RailSignVertical11", "rail_sign_vertical_head_11", "rail_sign_vertical_11"
        );
        register(blockRailSignVertical11, "block_rail_sign_vertical_11");

        //railNoSleeperStraight = new RailNoSleeperStraight();
        //register(railNoSleeperStraight, "rail_ns_s");

        convWireMono = new ConvWireMono();
        register(convWireMono, "conv_wire_mono");

        blockStationSign = new BlockStationSign();
        register(blockStationSign, "block_station_sign");

        rail3rd = new Rail3rd();
        register(rail3rd, "rail_3rd");

        rail3rdSwitch = new Rail3rdSwitch();
        register(rail3rdSwitch, "rail_3rd_switch");

        railMagnetSwitch = new RailMagnetSwitch();
        register(railMagnetSwitch, "rail_magnet_switch");

        railMono = new RailMono();
        register(railMono, "rail_mono");

        railMonoBumper = new RailMonoBumper();
        register(railMonoBumper, "rail_mono_bumper");

        railMonoMagnet = new RailMonoMagnet();
        register(railMonoMagnet, "rail_mono_magnet");

        railMonoSwitch = new RailMonoSwitch();
        register(railMonoSwitch, "rail_mono_switch");

        railMonoMagnetDetector = new RailMonoMagnetDetector();
        register(railMonoMagnetDetector, "rail_mono_magnet_detector");

        railMonoMagnetDetector5s = new RailMonoMagnetDetector(5);
        register(railMonoMagnetDetector5s, "rail_mono_magnet_detector_5s");

        railMonoMagnetDetector15s = new RailMonoMagnetDetector(15);
        register(railMonoMagnetDetector15s, "rail_mono_magnet_detector_15s");

        railMonoMagnetDetector30s = new RailMonoMagnetDetector(30);
        register(railMonoMagnetDetector30s, "rail_mono_magnet_detector_30s");

        railMonoMagnetPowered = new RailMonoMagnetPowered();
        register(railMonoMagnetPowered, "rail_mono_magnet_powered");

        railMonoMagnetReception = new RailMonoMagnetReception();
        register(railMonoMagnetReception, "rail_mono_magnet_reception");

        railMonoMagnetReceptionAnti = new RailMonoMagnetReceptionAnti();
        register(railMonoMagnetReceptionAnti, "rail_mono_magnet_reception_anti");

        railMonoMagnetDirectional = new RailMonoMagnetDirectional();
        register(railMonoMagnetDirectional, "rail_mono_magnet_directional");

        railMonoMagnetDirectionalAnti = new RailMonoMagnetDirectionalAnti();
        register(railMonoMagnetDirectionalAnti, "rail_mono_magnet_directional_anti");

        railMonoMagnetSpeedLimit = new RailMonoMagnetSpeedLimit();
        register(railMonoMagnetSpeedLimit, "rail_mono_magnet_speed_limit");

        railMonoMagnetSignalTransfer = new RailMonoMagnetSignalTransfer();
        register(railMonoMagnetSignalTransfer, "rail_mono_magnet_signal_transfer");

        railMonoMagnetBlocking = new RailMonoMagnetBlocking();
        register(railMonoMagnetBlocking, "rail_mono_magnet_blocking");

        railMonoMagnetRFID = new RailMonoMagnetRFID();
        register(railMonoMagnetRFID, "rail_mono_magnet_rfid");

        railMonoMagnetSniffer = new RailMonoMagnetSniffer();
        register(railMonoMagnetSniffer, "rail_mono_magnet_sniffer");

        railMonoMagnetRedStone = new RailMonoMagnetRedStone();
        register(railMonoMagnetRedStone, "rail_mono_magnet_redstone");

        railTriSwitch = new RailTriSwitch();
        register(railTriSwitch, "rail_tri_switch");


        blockPillar = new BlockPillar();
        register(blockPillar, "block_pillar");

        blockSignalLight = new BlockSignalLight();
        register(blockSignalLight, "block_signal_light");

        blockSignalLamp = new BlockSignalLamp();
        register(blockSignalLamp, "block_signal_lamp");

        blockSignalStick = new BlockSignalStick();
        register(blockSignalStick, "block_signal_stick");

        blockBiSignalLight = new BlockBiSignalLight();
        register(blockBiSignalLight, "block_bi_signal_light");

        blockTriSignalLight = new BlockTriSignalLight();
        register(blockTriSignalLight, "block_tri_signal_light");


        blockSignalPillar = new BlockSignalPillar();
        register(blockSignalPillar, "block_signal_pillar");

        blockPillarSignalOne = new BlockPillarSignalOne();
        register(blockPillarSignalOne, "block_pillar_signal_one");

        blockPillarSignalBi = new BlockPillarSignalBi();
        register(blockPillarSignalBi, "block_pillar_signal_bi");

        blockPillarSignalTri = new BlockPillarSignalTri();
        register(blockPillarSignalTri, "block_pillar_signal_tri");


        blockSignalBox = new BlockSignalBox();
        register(blockSignalBox, "block_signal_box");

        blockSignalBoxSender = new BlockSignalBoxSender();
        register(blockSignalBoxSender, "block_signal_box_sender");

        blockTriStateSignalBox = new BlockTriStateSignalBox();
        register(blockTriStateSignalBox, "block_tri_state_signal_box");

        blockGateBase = new BlockGateBase();
        register(blockGateBase, "block_gate_base");

        blockGateDoor = new BlockGateDoor();
        register(blockGateDoor, "block_gate_door");

        blockGateFront = new BlockGateFront();
        register(blockGateFront, "block_gate_front");

        blockGateFrontN = new BlockGateFrontN();
        register(blockGateFrontN, "block_gate_front_n");

        blockGlassShield = new BlockGlassShield();
        register(blockGlassShield, "block_glass_shield");

        blockGlassShield1x1 = new BlockGlassShield1X1();
        register(blockGlassShield1x1, "block_glass_shield_1x1");

        blockGlassShield3x1 = new BlockGlassShield3X1();
        register(blockGlassShield3x1, "block_glass_shield_3x1");

        blockGlassShield3x1d5 = new BlockGlassShield3X1D5();
        register(blockGlassShield3x1d5, "block_glass_shield_3x1d5");

        blockGlassShieldHalf = new BlockGlassShieldHalf();
        register(blockGlassShieldHalf, "block_glass_shield_half");

        blockGlassShieldAl = new BlockGlassShieldAl();
        register(blockGlassShieldAl, "block_glass_shield_al");

        blockGlassShieldAlHalf = new BlockGlassShieldAlHalf();
        register(blockGlassShieldAlHalf, "block_glass_shield_al_half");

        blockGlassShieldAlBase = new BlockGlassShieldAlBase();
        register(blockGlassShieldAlBase, "block_glass_shield_albase");

        blockGlassShieldCorner = new BlockGlassShieldCorner();
        register(blockGlassShieldCorner, "block_glass_shield_corner");

        blockGlassShieldCornerHalf = new BlockGlassShieldCornerHalf();
        register(blockGlassShieldCornerHalf, "block_glass_shield_corner_half");

        blockTicketOnce = new BlockTicketBlockOnce();
        register(blockTicketOnce, "block_ticket_once");

        blockTicketCard = new BlockTicketBlockCard();
        register(blockTicketCard, "block_ticket_card");

        blockCoin = new BlockCoinBlock();
        register(blockCoin, "block_coin");

        dotBeam = new LightBeam(AbsSignalLight.class, LightBeam.TYPE_DOT);
        register(dotBeam, "signal_dot_beam");

        lineBeam = new LightBeam(AbsSignalLight.class, LightBeam.TYPE_LINE, 0.75F);
        register(lineBeam, "signal_line_beam");

        blockNSTest = new BlockNSTest();
        register(blockNSTest, "nst_test");

        blockTrackSideBlocking = new TrackSideBlocking();
        register(blockTrackSideBlocking, "track_side_blocking");

        blockTrackSideReception = new TrackSideReception();
        register(blockTrackSideReception, "track_side_reception");

        blockTrackSideRFID = new TrackSideRFID();
        register(blockTrackSideRFID, "track_side_rfid");

        blockTrackSideSniffer = new TrackSideSniffer();
        register(blockTrackSideSniffer, "track_side_sniffer");

        blockTrackSideBlockingHs = new TrackSideBlockingHs();
        register(blockTrackSideBlockingHs, "track_side_blocking_hs");

        blockTrackSideRFIDHs = new TrackSideRFIDHs();
        register(blockTrackSideRFIDHs, "track_side_rfid_hs");

        blockTrackSideSnifferHs = new TrackSideSnifferHs();
        register(blockTrackSideSnifferHs, "track_side_sniffer_hs");

    }

}