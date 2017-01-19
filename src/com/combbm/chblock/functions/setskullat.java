package com.combbm.chblock.functions;

import com.laytonsmith.PureUtilities.SimpleVersion;
import com.laytonsmith.PureUtilities.Version;
import com.laytonsmith.abstraction.MCLocation;
import com.laytonsmith.abstraction.MCPlayer;
import com.laytonsmith.abstraction.MCWorld;
import com.laytonsmith.abstraction.StaticLayer;
import com.laytonsmith.abstraction.blocks.MCBlock;
import com.laytonsmith.abstraction.blocks.MCMaterial;
import com.laytonsmith.annotations.api;
import com.laytonsmith.core.ObjectGenerator;
import com.laytonsmith.core.Static;
import com.laytonsmith.core.constructs.CArray;
import com.laytonsmith.core.constructs.CVoid;
import com.laytonsmith.core.constructs.Construct;
import com.laytonsmith.core.constructs.Target;
import com.laytonsmith.core.environments.CommandHelperEnvironment;
import com.laytonsmith.core.exceptions.CRE.CRECastException;
import com.laytonsmith.core.exceptions.CRE.CREFormatException;
import com.laytonsmith.core.exceptions.CRE.CREInvalidWorldException;
import com.laytonsmith.core.exceptions.CRE.CREThrowable;
import com.laytonsmith.core.exceptions.CancelCommandException;
import com.laytonsmith.core.exceptions.ConfigRuntimeException;
import com.laytonsmith.core.functions.AbstractFunction;
import com.laytonsmith.core.functions.Environment;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Skull;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.material.MaterialData;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

/**
 * Created by SkyLightQP on 2016-11-02.
 */
public class setskullat {
    @api
    public static class set_skull_at extends AbstractFunction {

        public Class<? extends CREThrowable>[] thrown() {
            return new Class[0];
        }

        public boolean isRestricted() {
            return false;
        }

        public Boolean runAsync() {
            return null;
        }

        @Override
        public Construct exec(Target t, com.laytonsmith.core.environments.Environment env, Construct... args) throws CancelCommandException, ConfigRuntimeException {
            int x = (int) java.lang.Math.floor(Static.getNumber(args[0], t));
            int y = (int) java.lang.Math.floor(Static.getNumber(args[1], t));
            int z = (int) java.lang.Math.floor(Static.getNumber(args[2], t));
            String w = args[3].val();
            String id = args[4].val();
            if(args.length <= 5){
                if(Bukkit.getWorld(w) != null) {
                    Location loc = new Location(Bukkit.getWorld(w), x, y, z);
                    loc.getBlock().setType(Material.SKULL);
                    loc.getBlock().setData((byte) 3);
                    Skull s = (Skull) loc.getBlock().getState();
                    s.setOwner(id);
                    s.update();
                }
                else{
                    throw new CREInvalidWorldException("없는 월드",t);
                }
            }
            else{ throw new CREFormatException("인자 이상함",t); }
            return CVoid.VOID;
        }

        public String getName() {
            return "set_skull_at";
        }

        public Integer[] numArgs() {
            return new Integer[]{5};
        }

        public String docs() {
            return "void set_skull_at()";
        }

        public Version since() {
            return new SimpleVersion(1, 0, 0);
        }
    }
}
