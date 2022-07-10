package biz.mcplay.changelegacyprotocolversion;

import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.proxy.ProxyPingEvent;
import com.velocitypowered.api.network.ProtocolVersion;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.proxy.server.ServerPing;

@Plugin(
        id = "changelegacyprotocolversion",
        name = "LegacyProtocolVersionChanger",
        version = "1.0",
        authors = {"ViaSnake"}
)
public class ChangeLegacyProtocolVersion {
    @Subscribe
    public void onProxyInitialization(ProxyPingEvent e) {
        if(e.getPing().getVersion().getProtocol() == -2) {
            e.setPing(e.getPing().asBuilder().version(new ServerPing.Version(4,"MCPlayNetwork " + ProtocolVersion.SUPPORTED_VERSION_STRING)).build());
        }
    }
}
