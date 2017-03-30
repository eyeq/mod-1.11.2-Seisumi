package eyeq.seisumi;

import eyeq.seisumi.event.SeisumiEventHandler;
import eyeq.util.common.Utils;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import static eyeq.seisumi.Seisumi.MOD_ID;

@Mod(modid = MOD_ID, version = "1.0", dependencies = "after:eyeq_util")
public class Seisumi {
    public static final String MOD_ID = "eyeq_seisumi";

    @Mod.Instance(MOD_ID)
    public static Seisumi instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        Utils.EVENT_BUS.register(new SeisumiEventHandler());
    }
}
