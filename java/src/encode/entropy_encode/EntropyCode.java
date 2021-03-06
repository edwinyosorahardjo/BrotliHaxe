// Generated by Haxe 3.4.0
package encode.entropy_encode;

import haxe.root.*;

@SuppressWarnings(value={"rawtypes", "unchecked"})
public class EntropyCode extends haxe.lang.HxObject
{
	public EntropyCode(haxe.lang.EmptyObject empty)
	{
	}
	
	
	public EntropyCode(int kSize)
	{
		//line 11 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\EntropyCode.hx"
		encode.entropy_encode.EntropyCode.__hx_ctor_encode_entropy_encode_EntropyCode(this, kSize);
	}
	
	
	public static void __hx_ctor_encode_entropy_encode_EntropyCode(encode.entropy_encode.EntropyCode __hx_this, int kSize)
	{
		//line 24 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\EntropyCode.hx"
		__hx_this.symbols_ = haxe.root.FunctionMalloc.mallocUInt(4);
		//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\EntropyCode.hx"
		__hx_this.depth_ = haxe.root.FunctionMalloc.mallocUInt(kSize);
		//line 14 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\EntropyCode.hx"
		__hx_this.bits_ = haxe.root.FunctionMalloc.mallocUInt(kSize);
	}
	
	
	public int[] depth_;
	
	public int[] bits_;
	
	public int count_;
	
	public int[] symbols_;
	
	@Override public double __hx_setField_f(java.lang.String field, double value, boolean handleProperties)
	{
		//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\EntropyCode.hx"
		{
			//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\EntropyCode.hx"
			boolean __temp_executeDef1 = true;
			//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\EntropyCode.hx"
			switch (field.hashCode())
			{
				case -1354575568:
				{
					//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\EntropyCode.hx"
					if (field.equals("count_")) 
					{
						//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\EntropyCode.hx"
						__temp_executeDef1 = false;
						//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\EntropyCode.hx"
						this.count_ = ((int) (value) );
						//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\EntropyCode.hx"
						return value;
					}
					
					//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\EntropyCode.hx"
					break;
				}
				
				
			}
			
			//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\EntropyCode.hx"
			if (__temp_executeDef1) 
			{
				//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\EntropyCode.hx"
				return super.__hx_setField_f(field, value, handleProperties);
			}
			else
			{
				//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\EntropyCode.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public java.lang.Object __hx_setField(java.lang.String field, java.lang.Object value, boolean handleProperties)
	{
		//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\EntropyCode.hx"
		{
			//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\EntropyCode.hx"
			boolean __temp_executeDef1 = true;
			//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\EntropyCode.hx"
			switch (field.hashCode())
			{
				case 1787985380:
				{
					//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\EntropyCode.hx"
					if (field.equals("symbols_")) 
					{
						//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\EntropyCode.hx"
						__temp_executeDef1 = false;
						//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\EntropyCode.hx"
						this.symbols_ = ((int[]) (value) );
						//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\EntropyCode.hx"
						return value;
					}
					
					//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\EntropyCode.hx"
					break;
				}
				
				
				case -1335325188:
				{
					//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\EntropyCode.hx"
					if (field.equals("depth_")) 
					{
						//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\EntropyCode.hx"
						__temp_executeDef1 = false;
						//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\EntropyCode.hx"
						this.depth_ = ((int[]) (value) );
						//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\EntropyCode.hx"
						return value;
					}
					
					//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\EntropyCode.hx"
					break;
				}
				
				
				case -1354575568:
				{
					//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\EntropyCode.hx"
					if (field.equals("count_")) 
					{
						//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\EntropyCode.hx"
						__temp_executeDef1 = false;
						//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\EntropyCode.hx"
						this.count_ = ((int) (haxe.lang.Runtime.toInt(value)) );
						//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\EntropyCode.hx"
						return value;
					}
					
					//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\EntropyCode.hx"
					break;
				}
				
				
				case 93748249:
				{
					//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\EntropyCode.hx"
					if (field.equals("bits_")) 
					{
						//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\EntropyCode.hx"
						__temp_executeDef1 = false;
						//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\EntropyCode.hx"
						this.bits_ = ((int[]) (value) );
						//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\EntropyCode.hx"
						return value;
					}
					
					//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\EntropyCode.hx"
					break;
				}
				
				
			}
			
			//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\EntropyCode.hx"
			if (__temp_executeDef1) 
			{
				//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\EntropyCode.hx"
				return super.__hx_setField(field, value, handleProperties);
			}
			else
			{
				//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\EntropyCode.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public java.lang.Object __hx_getField(java.lang.String field, boolean throwErrors, boolean isCheck, boolean handleProperties)
	{
		//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\EntropyCode.hx"
		{
			//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\EntropyCode.hx"
			boolean __temp_executeDef1 = true;
			//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\EntropyCode.hx"
			switch (field.hashCode())
			{
				case 1787985380:
				{
					//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\EntropyCode.hx"
					if (field.equals("symbols_")) 
					{
						//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\EntropyCode.hx"
						__temp_executeDef1 = false;
						//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\EntropyCode.hx"
						return this.symbols_;
					}
					
					//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\EntropyCode.hx"
					break;
				}
				
				
				case -1335325188:
				{
					//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\EntropyCode.hx"
					if (field.equals("depth_")) 
					{
						//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\EntropyCode.hx"
						__temp_executeDef1 = false;
						//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\EntropyCode.hx"
						return this.depth_;
					}
					
					//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\EntropyCode.hx"
					break;
				}
				
				
				case -1354575568:
				{
					//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\EntropyCode.hx"
					if (field.equals("count_")) 
					{
						//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\EntropyCode.hx"
						__temp_executeDef1 = false;
						//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\EntropyCode.hx"
						return this.count_;
					}
					
					//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\EntropyCode.hx"
					break;
				}
				
				
				case 93748249:
				{
					//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\EntropyCode.hx"
					if (field.equals("bits_")) 
					{
						//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\EntropyCode.hx"
						__temp_executeDef1 = false;
						//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\EntropyCode.hx"
						return this.bits_;
					}
					
					//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\EntropyCode.hx"
					break;
				}
				
				
			}
			
			//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\EntropyCode.hx"
			if (__temp_executeDef1) 
			{
				//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\EntropyCode.hx"
				return super.__hx_getField(field, throwErrors, isCheck, handleProperties);
			}
			else
			{
				//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\EntropyCode.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public double __hx_getField_f(java.lang.String field, boolean throwErrors, boolean handleProperties)
	{
		//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\EntropyCode.hx"
		{
			//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\EntropyCode.hx"
			boolean __temp_executeDef1 = true;
			//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\EntropyCode.hx"
			switch (field.hashCode())
			{
				case -1354575568:
				{
					//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\EntropyCode.hx"
					if (field.equals("count_")) 
					{
						//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\EntropyCode.hx"
						__temp_executeDef1 = false;
						//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\EntropyCode.hx"
						return ((double) (this.count_) );
					}
					
					//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\EntropyCode.hx"
					break;
				}
				
				
			}
			
			//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\EntropyCode.hx"
			if (__temp_executeDef1) 
			{
				//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\EntropyCode.hx"
				return super.__hx_getField_f(field, throwErrors, handleProperties);
			}
			else
			{
				//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\EntropyCode.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public void __hx_getFields(haxe.root.Array<java.lang.String> baseArr)
	{
		//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\EntropyCode.hx"
		baseArr.push("symbols_");
		//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\EntropyCode.hx"
		baseArr.push("count_");
		//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\EntropyCode.hx"
		baseArr.push("bits_");
		//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\EntropyCode.hx"
		baseArr.push("depth_");
		//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\EntropyCode.hx"
		super.__hx_getFields(baseArr);
	}
	
	
}


