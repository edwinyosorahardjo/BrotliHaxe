// Generated by Haxe 3.4.0
package haxe.java.io;

import haxe.root.*;

@SuppressWarnings(value={"rawtypes", "unchecked"})
public class NativeOutput extends haxe.io.Output
{
	public NativeOutput(haxe.lang.EmptyObject empty)
	{
		//line 30 "C:\\HaxeToolkit\\haxe\\std\\java\\io\\NativeOutput.hx"
		super(((haxe.lang.EmptyObject) (haxe.lang.EmptyObject.EMPTY) ));
	}
	
	
	public NativeOutput(java.io.OutputStream stream)
	{
		//line 33 "C:\\HaxeToolkit\\haxe\\std\\java\\io\\NativeOutput.hx"
		haxe.java.io.NativeOutput.__hx_ctor_haxe_java_io_NativeOutput(this, stream);
	}
	
	
	public static void __hx_ctor_haxe_java_io_NativeOutput(haxe.java.io.NativeOutput __hx_this, java.io.OutputStream stream)
	{
		//line 35 "C:\\HaxeToolkit\\haxe\\std\\java\\io\\NativeOutput.hx"
		__hx_this.stream = stream;
	}
	
	
	public java.io.OutputStream stream;
	
	@Override public java.lang.Object __hx_setField(java.lang.String field, java.lang.Object value, boolean handleProperties)
	{
		//line 30 "C:\\HaxeToolkit\\haxe\\std\\java\\io\\NativeOutput.hx"
		{
			//line 30 "C:\\HaxeToolkit\\haxe\\std\\java\\io\\NativeOutput.hx"
			boolean __temp_executeDef1 = true;
			//line 30 "C:\\HaxeToolkit\\haxe\\std\\java\\io\\NativeOutput.hx"
			switch (field.hashCode())
			{
				case -891990144:
				{
					//line 30 "C:\\HaxeToolkit\\haxe\\std\\java\\io\\NativeOutput.hx"
					if (field.equals("stream")) 
					{
						//line 30 "C:\\HaxeToolkit\\haxe\\std\\java\\io\\NativeOutput.hx"
						__temp_executeDef1 = false;
						//line 30 "C:\\HaxeToolkit\\haxe\\std\\java\\io\\NativeOutput.hx"
						this.stream = ((java.io.OutputStream) (value) );
						//line 30 "C:\\HaxeToolkit\\haxe\\std\\java\\io\\NativeOutput.hx"
						return value;
					}
					
					//line 30 "C:\\HaxeToolkit\\haxe\\std\\java\\io\\NativeOutput.hx"
					break;
				}
				
				
			}
			
			//line 30 "C:\\HaxeToolkit\\haxe\\std\\java\\io\\NativeOutput.hx"
			if (__temp_executeDef1) 
			{
				//line 30 "C:\\HaxeToolkit\\haxe\\std\\java\\io\\NativeOutput.hx"
				return super.__hx_setField(field, value, handleProperties);
			}
			else
			{
				//line 30 "C:\\HaxeToolkit\\haxe\\std\\java\\io\\NativeOutput.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public java.lang.Object __hx_getField(java.lang.String field, boolean throwErrors, boolean isCheck, boolean handleProperties)
	{
		//line 30 "C:\\HaxeToolkit\\haxe\\std\\java\\io\\NativeOutput.hx"
		{
			//line 30 "C:\\HaxeToolkit\\haxe\\std\\java\\io\\NativeOutput.hx"
			boolean __temp_executeDef1 = true;
			//line 30 "C:\\HaxeToolkit\\haxe\\std\\java\\io\\NativeOutput.hx"
			switch (field.hashCode())
			{
				case -891990144:
				{
					//line 30 "C:\\HaxeToolkit\\haxe\\std\\java\\io\\NativeOutput.hx"
					if (field.equals("stream")) 
					{
						//line 30 "C:\\HaxeToolkit\\haxe\\std\\java\\io\\NativeOutput.hx"
						__temp_executeDef1 = false;
						//line 30 "C:\\HaxeToolkit\\haxe\\std\\java\\io\\NativeOutput.hx"
						return this.stream;
					}
					
					//line 30 "C:\\HaxeToolkit\\haxe\\std\\java\\io\\NativeOutput.hx"
					break;
				}
				
				
			}
			
			//line 30 "C:\\HaxeToolkit\\haxe\\std\\java\\io\\NativeOutput.hx"
			if (__temp_executeDef1) 
			{
				//line 30 "C:\\HaxeToolkit\\haxe\\std\\java\\io\\NativeOutput.hx"
				return super.__hx_getField(field, throwErrors, isCheck, handleProperties);
			}
			else
			{
				//line 30 "C:\\HaxeToolkit\\haxe\\std\\java\\io\\NativeOutput.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public void __hx_getFields(haxe.root.Array<java.lang.String> baseArr)
	{
		//line 30 "C:\\HaxeToolkit\\haxe\\std\\java\\io\\NativeOutput.hx"
		baseArr.push("stream");
		//line 30 "C:\\HaxeToolkit\\haxe\\std\\java\\io\\NativeOutput.hx"
		super.__hx_getFields(baseArr);
	}
	
	
}


