package com.ardublock.translator.block;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.exception.BlockException;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class KeyboardPress extends TranslatorBlock
{
	public KeyboardPress(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
	}

	@Override
	public String toCode() throws SocketNullException, SubroutineNotDeclaredException
	{
		
		TranslatorBlock tb = this.getRequiredTranslatorBlockAtSocket(0);

		
		tb = this.getRequiredTranslatorBlockAtSocket(0);
		String ret = "pinMode(2,INPUT_PULLUP);"
				+ "if(digitalRead(2)==LOW){"
				+ "Keyboard.press(" + tb.toCode() + ");\n}";
		
		translator.addSetupCommand("Keyboard.begin();");
		translator.addHeaderFile("Keyboard.h");
		return ret;
	}
}
