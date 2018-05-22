package com.ardublock.translator.block;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.exception.BlockException;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class KeyboardReleaseAll extends TranslatorBlock
{
	public KeyboardReleaseAll(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
	}

	@Override
	public String toCode() throws SocketNullException, SubroutineNotDeclaredException
	{
		
	
		String ret =  "Keyboard.releaseAll();\n";
		
		translator.addSetupCommand("Keyboard.begin();");
		translator.addHeaderFile("Keyboard.h");
		return ret;
	}
}
