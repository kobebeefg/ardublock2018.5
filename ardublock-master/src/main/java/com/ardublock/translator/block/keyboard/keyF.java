package com.ardublock.translator.block.keyboard;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;

public class keyF extends TranslatorBlock
{

	public keyF(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label) {
		super(blockId, translator, codePrefix, codeSuffix, label);
	}

	@Override
	public String toCode() throws SocketNullException {
		return codePrefix + "70" + codeSuffix;
	}

}
