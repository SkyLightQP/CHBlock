package com.combbm.chblock;

import com.laytonsmith.PureUtilities.SimpleVersion;
import com.laytonsmith.PureUtilities.Version;
import com.laytonsmith.commandhelper.CommandHelperPlugin;
import com.laytonsmith.core.extensions.AbstractExtension;
import com.laytonsmith.core.extensions.MSExtension;

/**
 * Created by SkyLightQP on 2016-11-02.
 */
@MSExtension("CHBlock")
public class CHBlock extends AbstractExtension {
    public static CommandHelperPlugin chp;


    public Version getVersion() {
        return new SimpleVersion(1, 0, 0);
    }

    public void onStartup() {
        chp = CommandHelperPlugin.self;
        System.out.println("CHBlock " + this.getVersion() + " has Sucessfully been enabled!");
    }

    public void onShutdown() {
        System.out.println("CHBlock " + this.getVersion() + " has Sucessfully been disable!");
    }
}
