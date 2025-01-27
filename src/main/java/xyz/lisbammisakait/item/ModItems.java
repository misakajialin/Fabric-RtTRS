package xyz.lisbammisakait.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import xyz.lisbammisakait.skill.LiuBeiASkill;
import xyz.lisbammisakait.skill.TieJiTaChuanSkill;
import xyz.lisbammisakait.RelightTheThreePointStrategy;
import xyz.lisbammisakait.skill.YinFengLaiXiangSkill;
import xyz.lisbammisakait.compoennt.RtTPSComponents;

public class ModItems {
    //创建技能物品组
    public static final RegistryKey<ItemGroup> SKILL_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(RelightTheThreePointStrategy.MOD_ID, "skill_group"));
    public static final ItemGroup SKILL_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.HUTOUZHANJINQIANG))
            .displayName(Text.translatable("skillGroup.RelightTheThreePointStrategy"))
            .build();
    //创建武器物品组
    public static final RegistryKey<ItemGroup> RTTPS_ITEM_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(RelightTheThreePointStrategy.MOD_ID, "rttps_group"));
    public static final ItemGroup RTTPS_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.FEILONGDUOFENG))
            .displayName(Text.translatable("rttpsGroup.RelightTheThreePointStrategy"))
            .build();

//    public static final Item FEILONGDUOFENG = register("feilongduofeng", Item::new, new Item.Settings());
//    public static final Item FEILONGDUOFENG = register();
//    public static Item register(String path, Function<Item.Settings, Item> factory, Item.Settings settings) {
//        final RegistryKey<Item> registryKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(RelightTheThreePointStrategy.MOD_ID, path));
//        return Items.register(registryKey, factory, settings);
//    }
    //注册飞龙夺凤
    public static final RegistryKey<Item> FEILONGDUOFENG_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(RelightTheThreePointStrategy.MOD_ID, "feilongduofeng"));
    public static final Item FEILONGDUOFENG = register(new FeilongduofengItem(ToolMaterial.GOLD, 4f, 20f, new Item.Settings().registryKey(FEILONGDUOFENG_KEY)), FEILONGDUOFENG_KEY);
    //注册虎头湛金枪
    public static final RegistryKey<Item> HUTOUZHANJINQIANG_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(RelightTheThreePointStrategy.MOD_ID, "hutouzhanjinqiang"));
    public static final Item HUTOUZHANJINQIANG = register(new HutouzhanjinqiangItem(ToolMaterial.GOLD, 6f, 20f, new Item.Settings().registryKey(HUTOUZHANJINQIANG_KEY).component(RtTPSComponents.COOLDOWN_TYPE,HutouzhanjinqiangItem.COOLDOWN)), HUTOUZHANJINQIANG_KEY);
    //注册神威虎头湛金枪
    public static final RegistryKey<Item> SHENWEIHUTOUZHANJINQIANG_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(RelightTheThreePointStrategy.MOD_ID, "shenweihutouzhanjinqiang"));
    public static final Item SHENWEIHUTOUZHANJINQIANG = register(new ShenweihutouzhanjianjinqiangItem(ToolMaterial.GOLD, 8f, 20f, new Item.Settings().registryKey(SHENWEIHUTOUZHANJINQIANG_KEY)), SHENWEIHUTOUZHANJINQIANG_KEY);
    //-----------------------------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------------------
    //注册引凤来翔
    public static final RegistryKey<Item> YINFENGLAIXIANG_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(RelightTheThreePointStrategy.MOD_ID, "yinfenglaixiang"));
    public static final Item YINFENGLAIXIANG = register(new YinFengLaiXiangSkill( new Item.Settings().registryKey(YINFENGLAIXIANG_KEY)), YINFENGLAIXIANG_KEY);
    //注册铁骑踏川
    public static final RegistryKey<Item> TIEJITACHUAN_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(RelightTheThreePointStrategy.MOD_ID, "tiejitachuan"));
    public static final Item TIEJITACHUAN = register(new TieJiTaChuanSkill( new Item.Settings().registryKey(TIEJITACHUAN_KEY)), TIEJITACHUAN_KEY);
    //注册刘备A技能
    public static final RegistryKey<Item> LIUBEIASKILL_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(RelightTheThreePointStrategy.MOD_ID, "longnudiwei"));
    //注意下一行代码的component是为了给技能添加冷却时间
    public static final Item LIUBEIASKILL = register(new LiuBeiASkill( new Item.Settings().registryKey(LIUBEIASKILL_KEY).component(RtTPSComponents.COOLDOWN_TYPE,LiuBeiASkill.COOLDOWN)), LIUBEIASKILL_KEY);
    public static Item register(Item item, RegistryKey<Item> registryKey) {
    // Register the item.
        Item registeredItem = Registry.register(Registries.ITEM, registryKey.getValue(), item);
     // Return the registered item!
        return registeredItem;
    }


    /*public static void registerToVanillaItemGroups() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> {
            content.add(FEILONGDUOFENG);
            content.add(HUTOUZHANJINQIANG);
        });
    }*/
    //注册技能
    public static void registerToSkillGroups() {
        Registry.register(Registries.ITEM_GROUP, SKILL_GROUP_KEY, SKILL_GROUP);
        ItemGroupEvents.modifyEntriesEvent(SKILL_GROUP_KEY).register(itemGroup -> {
            itemGroup.add(ModItems.YINFENGLAIXIANG);
            itemGroup.add(ModItems.TIEJITACHUAN);
            itemGroup.add(ModItems.LIUBEIASKILL);
        });
    }
    //注册武器
    public static void registerToRtTPSGroups() {
        Registry.register(Registries.ITEM_GROUP, RTTPS_ITEM_GROUP_KEY, RTTPS_GROUP);
        ItemGroupEvents.modifyEntriesEvent(RTTPS_ITEM_GROUP_KEY).register(itemGroup -> {
            itemGroup.add(ModItems.FEILONGDUOFENG);
            itemGroup.add(ModItems.HUTOUZHANJINQIANG);
            itemGroup.add(ModItems.SHENWEIHUTOUZHANJINQIANG);
        });
    }
    public static void initialize() {
        registerToSkillGroups();
        registerToRtTPSGroups();
        //registerToVanillaItemGroups();
    }
}
