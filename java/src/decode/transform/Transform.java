// Generated by Haxe 3.4.0
package decode.transform;

import haxe.root.*;

@SuppressWarnings(value={"rawtypes", "unchecked"})
public class Transform extends haxe.lang.HxObject
{
	public Transform(haxe.lang.EmptyObject empty)
	{
	}
	
	
	public Transform(java.lang.String prefix, int transform, java.lang.String suffix)
	{
		//line 13 "C:\\Users\\Dominik\\Brotli\\src\\decode\\transform\\Transform.hx"
		decode.transform.Transform.__hx_ctor_decode_transform_Transform(this, prefix, transform, suffix);
	}
	
	
	public static void __hx_ctor_decode_transform_Transform(decode.transform.Transform __hx_this, java.lang.String prefix, int transform, java.lang.String suffix)
	{
		//line 15 "C:\\Users\\Dominik\\Brotli\\src\\decode\\transform\\Transform.hx"
		__hx_this.prefix = new haxe.root.Array<java.lang.Object>();
		//line 16 "C:\\Users\\Dominik\\Brotli\\src\\decode\\transform\\Transform.hx"
		{
			//line 16 "C:\\Users\\Dominik\\Brotli\\src\\decode\\transform\\Transform.hx"
			int _g1 = 0;
			//line 16 "C:\\Users\\Dominik\\Brotli\\src\\decode\\transform\\Transform.hx"
			int _g = prefix.length();
			//line 16 "C:\\Users\\Dominik\\Brotli\\src\\decode\\transform\\Transform.hx"
			while (( _g1 < _g ))
			{
				//line 16 "C:\\Users\\Dominik\\Brotli\\src\\decode\\transform\\Transform.hx"
				int i = _g1++;
				//line 17 "C:\\Users\\Dominik\\Brotli\\src\\decode\\transform\\Transform.hx"
				__hx_this.prefix.__set(i, haxe.lang.StringExt.charCodeAt(prefix, i));
			}
			
		}
		
		//line 18 "C:\\Users\\Dominik\\Brotli\\src\\decode\\transform\\Transform.hx"
		__hx_this.transform = transform;
		//line 19 "C:\\Users\\Dominik\\Brotli\\src\\decode\\transform\\Transform.hx"
		__hx_this.suffix = new haxe.root.Array<java.lang.Object>();
		//line 20 "C:\\Users\\Dominik\\Brotli\\src\\decode\\transform\\Transform.hx"
		{
			//line 20 "C:\\Users\\Dominik\\Brotli\\src\\decode\\transform\\Transform.hx"
			int _g11 = 0;
			//line 20 "C:\\Users\\Dominik\\Brotli\\src\\decode\\transform\\Transform.hx"
			int _g2 = suffix.length();
			//line 20 "C:\\Users\\Dominik\\Brotli\\src\\decode\\transform\\Transform.hx"
			while (( _g11 < _g2 ))
			{
				//line 20 "C:\\Users\\Dominik\\Brotli\\src\\decode\\transform\\Transform.hx"
				int i1 = _g11++;
				//line 21 "C:\\Users\\Dominik\\Brotli\\src\\decode\\transform\\Transform.hx"
				__hx_this.suffix.__set(i1, haxe.lang.StringExt.charCodeAt(suffix, i1));
			}
			
		}
		
	}
	
	
	public haxe.root.Array<java.lang.Object> prefix;
	
	public int transform;
	
	public haxe.root.Array<java.lang.Object> suffix;
	
	@Override public double __hx_setField_f(java.lang.String field, double value, boolean handleProperties)
	{
		//line 7 "C:\\Users\\Dominik\\Brotli\\src\\decode\\transform\\Transform.hx"
		{
			//line 7 "C:\\Users\\Dominik\\Brotli\\src\\decode\\transform\\Transform.hx"
			boolean __temp_executeDef1 = true;
			//line 7 "C:\\Users\\Dominik\\Brotli\\src\\decode\\transform\\Transform.hx"
			switch (field.hashCode())
			{
				case 1052666732:
				{
					//line 7 "C:\\Users\\Dominik\\Brotli\\src\\decode\\transform\\Transform.hx"
					if (field.equals("transform")) 
					{
						//line 7 "C:\\Users\\Dominik\\Brotli\\src\\decode\\transform\\Transform.hx"
						__temp_executeDef1 = false;
						//line 7 "C:\\Users\\Dominik\\Brotli\\src\\decode\\transform\\Transform.hx"
						this.transform = ((int) (value) );
						//line 7 "C:\\Users\\Dominik\\Brotli\\src\\decode\\transform\\Transform.hx"
						return value;
					}
					
					//line 7 "C:\\Users\\Dominik\\Brotli\\src\\decode\\transform\\Transform.hx"
					break;
				}
				
				
			}
			
			//line 7 "C:\\Users\\Dominik\\Brotli\\src\\decode\\transform\\Transform.hx"
			if (__temp_executeDef1) 
			{
				//line 7 "C:\\Users\\Dominik\\Brotli\\src\\decode\\transform\\Transform.hx"
				return super.__hx_setField_f(field, value, handleProperties);
			}
			else
			{
				//line 7 "C:\\Users\\Dominik\\Brotli\\src\\decode\\transform\\Transform.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public java.lang.Object __hx_setField(java.lang.String field, java.lang.Object value, boolean handleProperties)
	{
		//line 7 "C:\\Users\\Dominik\\Brotli\\src\\decode\\transform\\Transform.hx"
		{
			//line 7 "C:\\Users\\Dominik\\Brotli\\src\\decode\\transform\\Transform.hx"
			boolean __temp_executeDef1 = true;
			//line 7 "C:\\Users\\Dominik\\Brotli\\src\\decode\\transform\\Transform.hx"
			switch (field.hashCode())
			{
				case -891422895:
				{
					//line 7 "C:\\Users\\Dominik\\Brotli\\src\\decode\\transform\\Transform.hx"
					if (field.equals("suffix")) 
					{
						//line 7 "C:\\Users\\Dominik\\Brotli\\src\\decode\\transform\\Transform.hx"
						__temp_executeDef1 = false;
						//line 7 "C:\\Users\\Dominik\\Brotli\\src\\decode\\transform\\Transform.hx"
						this.suffix = ((haxe.root.Array<java.lang.Object>) (value) );
						//line 7 "C:\\Users\\Dominik\\Brotli\\src\\decode\\transform\\Transform.hx"
						return value;
					}
					
					//line 7 "C:\\Users\\Dominik\\Brotli\\src\\decode\\transform\\Transform.hx"
					break;
				}
				
				
				case -980110702:
				{
					//line 7 "C:\\Users\\Dominik\\Brotli\\src\\decode\\transform\\Transform.hx"
					if (field.equals("prefix")) 
					{
						//line 7 "C:\\Users\\Dominik\\Brotli\\src\\decode\\transform\\Transform.hx"
						__temp_executeDef1 = false;
						//line 7 "C:\\Users\\Dominik\\Brotli\\src\\decode\\transform\\Transform.hx"
						this.prefix = ((haxe.root.Array<java.lang.Object>) (value) );
						//line 7 "C:\\Users\\Dominik\\Brotli\\src\\decode\\transform\\Transform.hx"
						return value;
					}
					
					//line 7 "C:\\Users\\Dominik\\Brotli\\src\\decode\\transform\\Transform.hx"
					break;
				}
				
				
				case 1052666732:
				{
					//line 7 "C:\\Users\\Dominik\\Brotli\\src\\decode\\transform\\Transform.hx"
					if (field.equals("transform")) 
					{
						//line 7 "C:\\Users\\Dominik\\Brotli\\src\\decode\\transform\\Transform.hx"
						__temp_executeDef1 = false;
						//line 7 "C:\\Users\\Dominik\\Brotli\\src\\decode\\transform\\Transform.hx"
						this.transform = ((int) (haxe.lang.Runtime.toInt(value)) );
						//line 7 "C:\\Users\\Dominik\\Brotli\\src\\decode\\transform\\Transform.hx"
						return value;
					}
					
					//line 7 "C:\\Users\\Dominik\\Brotli\\src\\decode\\transform\\Transform.hx"
					break;
				}
				
				
			}
			
			//line 7 "C:\\Users\\Dominik\\Brotli\\src\\decode\\transform\\Transform.hx"
			if (__temp_executeDef1) 
			{
				//line 7 "C:\\Users\\Dominik\\Brotli\\src\\decode\\transform\\Transform.hx"
				return super.__hx_setField(field, value, handleProperties);
			}
			else
			{
				//line 7 "C:\\Users\\Dominik\\Brotli\\src\\decode\\transform\\Transform.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public java.lang.Object __hx_getField(java.lang.String field, boolean throwErrors, boolean isCheck, boolean handleProperties)
	{
		//line 7 "C:\\Users\\Dominik\\Brotli\\src\\decode\\transform\\Transform.hx"
		{
			//line 7 "C:\\Users\\Dominik\\Brotli\\src\\decode\\transform\\Transform.hx"
			boolean __temp_executeDef1 = true;
			//line 7 "C:\\Users\\Dominik\\Brotli\\src\\decode\\transform\\Transform.hx"
			switch (field.hashCode())
			{
				case -891422895:
				{
					//line 7 "C:\\Users\\Dominik\\Brotli\\src\\decode\\transform\\Transform.hx"
					if (field.equals("suffix")) 
					{
						//line 7 "C:\\Users\\Dominik\\Brotli\\src\\decode\\transform\\Transform.hx"
						__temp_executeDef1 = false;
						//line 7 "C:\\Users\\Dominik\\Brotli\\src\\decode\\transform\\Transform.hx"
						return this.suffix;
					}
					
					//line 7 "C:\\Users\\Dominik\\Brotli\\src\\decode\\transform\\Transform.hx"
					break;
				}
				
				
				case -980110702:
				{
					//line 7 "C:\\Users\\Dominik\\Brotli\\src\\decode\\transform\\Transform.hx"
					if (field.equals("prefix")) 
					{
						//line 7 "C:\\Users\\Dominik\\Brotli\\src\\decode\\transform\\Transform.hx"
						__temp_executeDef1 = false;
						//line 7 "C:\\Users\\Dominik\\Brotli\\src\\decode\\transform\\Transform.hx"
						return this.prefix;
					}
					
					//line 7 "C:\\Users\\Dominik\\Brotli\\src\\decode\\transform\\Transform.hx"
					break;
				}
				
				
				case 1052666732:
				{
					//line 7 "C:\\Users\\Dominik\\Brotli\\src\\decode\\transform\\Transform.hx"
					if (field.equals("transform")) 
					{
						//line 7 "C:\\Users\\Dominik\\Brotli\\src\\decode\\transform\\Transform.hx"
						__temp_executeDef1 = false;
						//line 7 "C:\\Users\\Dominik\\Brotli\\src\\decode\\transform\\Transform.hx"
						return this.transform;
					}
					
					//line 7 "C:\\Users\\Dominik\\Brotli\\src\\decode\\transform\\Transform.hx"
					break;
				}
				
				
			}
			
			//line 7 "C:\\Users\\Dominik\\Brotli\\src\\decode\\transform\\Transform.hx"
			if (__temp_executeDef1) 
			{
				//line 7 "C:\\Users\\Dominik\\Brotli\\src\\decode\\transform\\Transform.hx"
				return super.__hx_getField(field, throwErrors, isCheck, handleProperties);
			}
			else
			{
				//line 7 "C:\\Users\\Dominik\\Brotli\\src\\decode\\transform\\Transform.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public double __hx_getField_f(java.lang.String field, boolean throwErrors, boolean handleProperties)
	{
		//line 7 "C:\\Users\\Dominik\\Brotli\\src\\decode\\transform\\Transform.hx"
		{
			//line 7 "C:\\Users\\Dominik\\Brotli\\src\\decode\\transform\\Transform.hx"
			boolean __temp_executeDef1 = true;
			//line 7 "C:\\Users\\Dominik\\Brotli\\src\\decode\\transform\\Transform.hx"
			switch (field.hashCode())
			{
				case 1052666732:
				{
					//line 7 "C:\\Users\\Dominik\\Brotli\\src\\decode\\transform\\Transform.hx"
					if (field.equals("transform")) 
					{
						//line 7 "C:\\Users\\Dominik\\Brotli\\src\\decode\\transform\\Transform.hx"
						__temp_executeDef1 = false;
						//line 7 "C:\\Users\\Dominik\\Brotli\\src\\decode\\transform\\Transform.hx"
						return ((double) (this.transform) );
					}
					
					//line 7 "C:\\Users\\Dominik\\Brotli\\src\\decode\\transform\\Transform.hx"
					break;
				}
				
				
			}
			
			//line 7 "C:\\Users\\Dominik\\Brotli\\src\\decode\\transform\\Transform.hx"
			if (__temp_executeDef1) 
			{
				//line 7 "C:\\Users\\Dominik\\Brotli\\src\\decode\\transform\\Transform.hx"
				return super.__hx_getField_f(field, throwErrors, handleProperties);
			}
			else
			{
				//line 7 "C:\\Users\\Dominik\\Brotli\\src\\decode\\transform\\Transform.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public void __hx_getFields(haxe.root.Array<java.lang.String> baseArr)
	{
		//line 7 "C:\\Users\\Dominik\\Brotli\\src\\decode\\transform\\Transform.hx"
		baseArr.push("suffix");
		//line 7 "C:\\Users\\Dominik\\Brotli\\src\\decode\\transform\\Transform.hx"
		baseArr.push("transform");
		//line 7 "C:\\Users\\Dominik\\Brotli\\src\\decode\\transform\\Transform.hx"
		baseArr.push("prefix");
		//line 7 "C:\\Users\\Dominik\\Brotli\\src\\decode\\transform\\Transform.hx"
		super.__hx_getFields(baseArr);
	}
	
	
}


