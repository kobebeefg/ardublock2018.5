package com.ardublock.translator.block;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class LCD_I2C_Sainsmart_20by4_Block extends TranslatorBlock {
	
	public LCD_I2C_Sainsmart_20by4_Block(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
	}

	//@Override
	public String toCode() throws SocketNullException, SubroutineNotDeclaredException
	{
		
		TranslatorBlock tb = this.getRequiredTranslatorBlockAtSocket(1);
		String lineNo = tb.toCode();
		tb = this.getRequiredTranslatorBlockAtSocket(2);
		String charNo = tb.toCode();
		tb = this.getRequiredTranslatorBlockAtSocket(3);
		String I2C_addr = tb.toCode();
		
		String ret = "";
		
		tb = this.getRequiredTranslatorBlockAtSocket(0, "Keyboard.print" + ".print( ", " );\n");
		ret += tb.toCode();
		//Deal with line and character positioning
		translator.addHeaderFile("Keyboard.h");
		translator.addDefinitionCommand(             "// These core libraries allow a 32u4 based boards or Due and Zero board to appear as a native Mouse and/or Keyboard to a connected computer.");
		translator.addSetupCommand("Keyboard.begin();");
		
		return ret;
	}
	
}