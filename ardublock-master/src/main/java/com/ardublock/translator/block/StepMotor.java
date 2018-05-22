package com.ardublock.translator.block;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class StepMotor extends TranslatorBlock
{
	public static final String ARDUBLOCK_DIGITAL_WRITE_DEFINE = "void __StepMotor(int MotorStep,int MotorSpeed,int pinNumberA, int pinNumberB,int pinNumberC,int pinNumberD)\n"+
"{\n"
+ "pinMode(pinNumberA, OUTPUT);\n"
+ "pinMode(pinNumberB, OUTPUT);\n"
+ "pinMode(pinNumberC, OUTPUT);\n"
+ "pinMode(pinNumberD, OUTPUT);\n"
+ "for(int i=0;i<MotorStep;i++){\n"
+ "digitalWrite(pinNumberA, HIGH);\n"
+ "digitalWrite(pinNumberB, LOW);\n"
+ "digitalWrite(pinNumberC, LOW);\n"
+ "digitalWrite(pinNumberD, LOW);\n"
+ "delay(MotorSpeed);\n"
+ "digitalWrite(pinNumberA, LOW);\n"
+ "digitalWrite(pinNumberB, HIGH);\n"
+ "delay(MotorSpeed);\n"
+ "digitalWrite(pinNumberB, LOW);\n"
+ "digitalWrite(pinNumberC, HIGH);\n"
+ "delay(MotorSpeed);\n"
+ "digitalWrite(pinNumberC, LOW);\n"
+ "digitalWrite(pinNumberD, HIGH);\n"
+ "delay(MotorSpeed);\n"
+ "}\n"
+ "digitalWrite(pinNumberD, LOW);\n"
+ "}\n";
	
	
	public StepMotor(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
	}

	@Override
	public String toCode() throws SocketNullException, SubroutineNotDeclaredException
	{
		TranslatorBlock translatorBlock = this.getRequiredTranslatorBlockAtSocket(0);
		
			translator.addDefinitionCommand(ARDUBLOCK_DIGITAL_WRITE_DEFINE);
			String ret = "__StepMotor(";
			
			ret = ret + translatorBlock.toCode();
			ret = ret + ", ";
			translatorBlock = this.getRequiredTranslatorBlockAtSocket(1);
			ret = ret + translatorBlock.toCode();
			ret = ret + ", ";
			translatorBlock = this.getRequiredTranslatorBlockAtSocket(2);
			ret = ret + translatorBlock.toCode();
			ret = ret + ", ";
			translatorBlock = this.getRequiredTranslatorBlockAtSocket(3);
			ret = ret + translatorBlock.toCode();
			ret = ret + ", ";
			translatorBlock = this.getRequiredTranslatorBlockAtSocket(4);
			ret = ret + translatorBlock.toCode();
			ret = ret + ", ";
			translatorBlock = this.getRequiredTranslatorBlockAtSocket(5);
			ret = ret + translatorBlock.toCode();
			ret = ret + ");\n";
			return ret;
		
		
	}

}
