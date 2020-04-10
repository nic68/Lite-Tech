
package net.litetech.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ArmorItem;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.Entity;

import net.litetech.LiteTechElements;

@LiteTechElements.ModElement.Tag
public class CopperArmorItem extends LiteTechElements.ModElement {
	@ObjectHolder("litetech:copperarmorhelmet")
	public static final Item helmet = null;
	@ObjectHolder("litetech:copperarmorbody")
	public static final Item body = null;
	@ObjectHolder("litetech:copperarmorlegs")
	public static final Item legs = null;
	@ObjectHolder("litetech:copperarmorboots")
	public static final Item boots = null;
	public CopperArmorItem(LiteTechElements instance) {
		super(instance, 29);
	}

	@Override
	public void initElements() {
		IArmorMaterial armormaterial = new IArmorMaterial() {
			public int getDurability(EquipmentSlotType slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 11;
			}

			public int getDamageReductionAmount(EquipmentSlotType slot) {
				return new int[]{1, 4, 4, 1}[slot.getIndex()];
			}

			public int getEnchantability() {
				return 6;
			}

			public net.minecraft.util.SoundEvent getSoundEvent() {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}

			@OnlyIn(Dist.CLIENT)
			public String getName() {
				return "copperarmor";
			}

			public float getToughness() {
				return 0f;
			}
		};
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroup.COMBAT)) {
			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "litetech:textures/models/armor/copper_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}
		}.setRegistryName("copperarmorhelmet"));
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroup.COMBAT)) {
			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "litetech:textures/models/armor/copper_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}
		}.setRegistryName("copperarmorbody"));
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroup.COMBAT)) {
			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "litetech:textures/models/armor/copper_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}
		}.setRegistryName("copperarmorlegs"));
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroup.COMBAT)) {
			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "litetech:textures/models/armor/copper_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}
		}.setRegistryName("copperarmorboots"));
	}
}
