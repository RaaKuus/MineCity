package br.com.gamemods.minecity.forge.base.accessors.block;

import br.com.gamemods.minecity.forge.base.Referenced;
import br.com.gamemods.minecity.forge.base.accessors.item.IItem;
import br.com.gamemods.minecity.forge.base.core.transformer.forge.ForgeInterfaceTransformer;
import net.minecraft.block.BlockNetherWart;
import net.minecraft.init.Items;

@Referenced(at = ForgeInterfaceTransformer.class)
public interface IBlockNetherWart extends SimpleCrop
{
    @Override
    default BlockNetherWart getForgeBlock()
    {
        return (BlockNetherWart) this;
    }

    @Override
    default IItem getISeed()
    {
        return (IItem) Items.NETHER_WART;
    }

    @Override
    default boolean isHarvestAge(int age)
    {
        return age >= 3;
    }
}
