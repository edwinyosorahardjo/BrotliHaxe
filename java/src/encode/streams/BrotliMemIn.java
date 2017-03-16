// Generated by Haxe 3.4.0
package encode.streams;

import haxe.root.*;

@SuppressWarnings(value={"rawtypes", "unchecked"})
public class BrotliMemIn extends haxe.lang.HxObject
{
	public BrotliMemIn(haxe.lang.EmptyObject empty)
	{
	}
	
	
	public BrotliMemIn(haxe.root.Array<java.lang.Object> buf, int len)
	{
		//line 11 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
		encode.streams.BrotliMemIn.__hx_ctor_encode_streams_BrotliMemIn(this, buf, len);
	}
	
	
	public static void __hx_ctor_encode_streams_BrotliMemIn(encode.streams.BrotliMemIn __hx_this, haxe.root.Array<java.lang.Object> buf, int len)
	{
		//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
		__hx_this.buf_ = buf;
		//line 14 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
		__hx_this.len_ = len;
		//line 15 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
		__hx_this.pos_ = 0;
	}
	
	
	public int position()
	{
		//line 18 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
		return this.pos_;
	}
	
	
	public haxe.root.Array<java.lang.Object> buf_;
	
	public int len_;
	
	public int pos_;
	
	public void Reset(haxe.root.Array<java.lang.Object> buf, int len)
	{
		//line 24 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
		this.buf_ = buf;
		//line 25 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
		this.len_ = len;
		//line 26 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
		this.pos_ = 0;
	}
	
	
	public int[] Read(int n, haxe.root.Array<java.lang.Object> output)
	{
		//line 30 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
		if (( this.pos_ == this.len_ )) 
		{
			//line 31 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
			return null;
		}
		
		//line 33 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
		if (( n > ( this.len_ - this.pos_ ) )) 
		{
			//line 34 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
			n = ( this.len_ - this.pos_ );
		}
		
		//line 35 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
		int[] this1 = new int[n];
		//line 35 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
		int[] p = ((int[]) (this1) );
		//line 36 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
		haxe.root.DefaultFunctions.memcpyVectorArray(p, 0, this.buf_, this.pos_, n);
		//line 37 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
		this.pos_ += n;
		//line 38 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
		output.__set(0, n);
		//line 39 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
		return p;
	}
	
	
	@Override public double __hx_setField_f(java.lang.String field, double value, boolean handleProperties)
	{
		//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
		{
			//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
			boolean __temp_executeDef1 = true;
			//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
			switch (field.hashCode())
			{
				case 3446923:
				{
					//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
					if (field.equals("pos_")) 
					{
						//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
						__temp_executeDef1 = false;
						//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
						this.pos_ = ((int) (value) );
						//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
						return value;
					}
					
					//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
					break;
				}
				
				
				case 3317994:
				{
					//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
					if (field.equals("len_")) 
					{
						//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
						__temp_executeDef1 = false;
						//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
						this.len_ = ((int) (value) );
						//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
						return value;
					}
					
					//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
					break;
				}
				
				
			}
			
			//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
			if (__temp_executeDef1) 
			{
				//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
				return super.__hx_setField_f(field, value, handleProperties);
			}
			else
			{
				//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public java.lang.Object __hx_setField(java.lang.String field, java.lang.Object value, boolean handleProperties)
	{
		//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
		{
			//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
			boolean __temp_executeDef1 = true;
			//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
			switch (field.hashCode())
			{
				case 3446923:
				{
					//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
					if (field.equals("pos_")) 
					{
						//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
						__temp_executeDef1 = false;
						//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
						this.pos_ = ((int) (haxe.lang.Runtime.toInt(value)) );
						//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
						return value;
					}
					
					//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
					break;
				}
				
				
				case 3035212:
				{
					//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
					if (field.equals("buf_")) 
					{
						//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
						__temp_executeDef1 = false;
						//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
						this.buf_ = ((haxe.root.Array<java.lang.Object>) (value) );
						//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
						return value;
					}
					
					//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
					break;
				}
				
				
				case 3317994:
				{
					//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
					if (field.equals("len_")) 
					{
						//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
						__temp_executeDef1 = false;
						//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
						this.len_ = ((int) (haxe.lang.Runtime.toInt(value)) );
						//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
						return value;
					}
					
					//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
					break;
				}
				
				
			}
			
			//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
			if (__temp_executeDef1) 
			{
				//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
				return super.__hx_setField(field, value, handleProperties);
			}
			else
			{
				//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public java.lang.Object __hx_getField(java.lang.String field, boolean throwErrors, boolean isCheck, boolean handleProperties)
	{
		//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
		{
			//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
			boolean __temp_executeDef1 = true;
			//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
			switch (field.hashCode())
			{
				case 2543030:
				{
					//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
					if (field.equals("Read")) 
					{
						//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
						__temp_executeDef1 = false;
						//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
						return ((haxe.lang.Function) (new haxe.lang.Closure(this, "Read")) );
					}
					
					//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
					break;
				}
				
				
				case 747804969:
				{
					//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
					if (field.equals("position")) 
					{
						//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
						__temp_executeDef1 = false;
						//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
						return ((haxe.lang.Function) (new haxe.lang.Closure(this, "position")) );
					}
					
					//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
					break;
				}
				
				
				case 78851375:
				{
					//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
					if (field.equals("Reset")) 
					{
						//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
						__temp_executeDef1 = false;
						//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
						return ((haxe.lang.Function) (new haxe.lang.Closure(this, "Reset")) );
					}
					
					//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
					break;
				}
				
				
				case 3035212:
				{
					//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
					if (field.equals("buf_")) 
					{
						//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
						__temp_executeDef1 = false;
						//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
						return this.buf_;
					}
					
					//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
					break;
				}
				
				
				case 3446923:
				{
					//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
					if (field.equals("pos_")) 
					{
						//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
						__temp_executeDef1 = false;
						//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
						return this.pos_;
					}
					
					//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
					break;
				}
				
				
				case 3317994:
				{
					//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
					if (field.equals("len_")) 
					{
						//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
						__temp_executeDef1 = false;
						//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
						return this.len_;
					}
					
					//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
					break;
				}
				
				
			}
			
			//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
			if (__temp_executeDef1) 
			{
				//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
				return super.__hx_getField(field, throwErrors, isCheck, handleProperties);
			}
			else
			{
				//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public double __hx_getField_f(java.lang.String field, boolean throwErrors, boolean handleProperties)
	{
		//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
		{
			//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
			boolean __temp_executeDef1 = true;
			//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
			switch (field.hashCode())
			{
				case 3446923:
				{
					//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
					if (field.equals("pos_")) 
					{
						//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
						__temp_executeDef1 = false;
						//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
						return ((double) (this.pos_) );
					}
					
					//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
					break;
				}
				
				
				case 3317994:
				{
					//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
					if (field.equals("len_")) 
					{
						//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
						__temp_executeDef1 = false;
						//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
						return ((double) (this.len_) );
					}
					
					//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
					break;
				}
				
				
			}
			
			//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
			if (__temp_executeDef1) 
			{
				//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
				return super.__hx_getField_f(field, throwErrors, handleProperties);
			}
			else
			{
				//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public java.lang.Object __hx_invokeField(java.lang.String field, haxe.root.Array dynargs)
	{
		//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
		{
			//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
			boolean __temp_executeDef1 = true;
			//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
			switch (field.hashCode())
			{
				case 2543030:
				{
					//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
					if (field.equals("Read")) 
					{
						//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
						__temp_executeDef1 = false;
						//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
						return this.Read(((int) (haxe.lang.Runtime.toInt(dynargs.__get(0))) ), ((haxe.root.Array<java.lang.Object>) (dynargs.__get(1)) ));
					}
					
					//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
					break;
				}
				
				
				case 747804969:
				{
					//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
					if (field.equals("position")) 
					{
						//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
						__temp_executeDef1 = false;
						//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
						return this.position();
					}
					
					//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
					break;
				}
				
				
				case 78851375:
				{
					//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
					if (field.equals("Reset")) 
					{
						//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
						__temp_executeDef1 = false;
						//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
						this.Reset(((haxe.root.Array<java.lang.Object>) (dynargs.__get(0)) ), ((int) (haxe.lang.Runtime.toInt(dynargs.__get(1))) ));
					}
					
					//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
					break;
				}
				
				
			}
			
			//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
			if (__temp_executeDef1) 
			{
				//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
				return super.__hx_invokeField(field, dynargs);
			}
			
		}
		
		//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
		return null;
	}
	
	
	@Override public void __hx_getFields(haxe.root.Array<java.lang.String> baseArr)
	{
		//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
		baseArr.push("pos_");
		//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
		baseArr.push("len_");
		//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
		baseArr.push("buf_");
		//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\streams\\BrotliMemIn.hx"
		super.__hx_getFields(baseArr);
	}
	
	
}


