// Generated by Haxe 3.4.0
package encode.entropy_encode;

import haxe.root.*;

@SuppressWarnings(value={"rawtypes", "unchecked"})
public class HuffmanTree extends haxe.lang.HxObject
{
	public HuffmanTree(haxe.lang.EmptyObject empty)
	{
	}
	
	
	public HuffmanTree()
	{
		//line 18 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\HuffmanTree.hx"
		encode.entropy_encode.HuffmanTree.__hx_ctor_encode_entropy_encode_HuffmanTree(this);
	}
	
	
	public static void __hx_ctor_encode_entropy_encode_HuffmanTree(encode.entropy_encode.HuffmanTree __hx_this)
	{
	}
	
	
	public void HuffmanTree3(int count, int left, int right)
	{
		//line 11 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\HuffmanTree.hx"
		this.total_count_ = count;
		//line 12 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\HuffmanTree.hx"
		this.index_left_ = left;
		//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\HuffmanTree.hx"
		this.index_right_or_value_ = right;
	}
	
	
	public int total_count_;
	
	public int index_left_;
	
	public int index_right_or_value_;
	
	@Override public double __hx_setField_f(java.lang.String field, double value, boolean handleProperties)
	{
		//line 7 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\HuffmanTree.hx"
		{
			//line 7 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\HuffmanTree.hx"
			boolean __temp_executeDef1 = true;
			//line 7 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\HuffmanTree.hx"
			switch (field.hashCode())
			{
				case -186770662:
				{
					//line 7 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\HuffmanTree.hx"
					if (field.equals("index_right_or_value_")) 
					{
						//line 7 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\HuffmanTree.hx"
						__temp_executeDef1 = false;
						//line 7 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\HuffmanTree.hx"
						this.index_right_or_value_ = ((int) (value) );
						//line 7 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\HuffmanTree.hx"
						return value;
					}
					
					//line 7 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\HuffmanTree.hx"
					break;
				}
				
				
				case 244285067:
				{
					//line 7 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\HuffmanTree.hx"
					if (field.equals("total_count_")) 
					{
						//line 7 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\HuffmanTree.hx"
						__temp_executeDef1 = false;
						//line 7 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\HuffmanTree.hx"
						this.total_count_ = ((int) (value) );
						//line 7 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\HuffmanTree.hx"
						return value;
					}
					
					//line 7 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\HuffmanTree.hx"
					break;
				}
				
				
				case 1679263627:
				{
					//line 7 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\HuffmanTree.hx"
					if (field.equals("index_left_")) 
					{
						//line 7 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\HuffmanTree.hx"
						__temp_executeDef1 = false;
						//line 7 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\HuffmanTree.hx"
						this.index_left_ = ((int) (value) );
						//line 7 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\HuffmanTree.hx"
						return value;
					}
					
					//line 7 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\HuffmanTree.hx"
					break;
				}
				
				
			}
			
			//line 7 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\HuffmanTree.hx"
			if (__temp_executeDef1) 
			{
				//line 7 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\HuffmanTree.hx"
				return super.__hx_setField_f(field, value, handleProperties);
			}
			else
			{
				//line 7 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\HuffmanTree.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public java.lang.Object __hx_setField(java.lang.String field, java.lang.Object value, boolean handleProperties)
	{
		//line 7 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\HuffmanTree.hx"
		{
			//line 7 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\HuffmanTree.hx"
			boolean __temp_executeDef1 = true;
			//line 7 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\HuffmanTree.hx"
			switch (field.hashCode())
			{
				case -186770662:
				{
					//line 7 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\HuffmanTree.hx"
					if (field.equals("index_right_or_value_")) 
					{
						//line 7 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\HuffmanTree.hx"
						__temp_executeDef1 = false;
						//line 7 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\HuffmanTree.hx"
						this.index_right_or_value_ = ((int) (haxe.lang.Runtime.toInt(value)) );
						//line 7 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\HuffmanTree.hx"
						return value;
					}
					
					//line 7 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\HuffmanTree.hx"
					break;
				}
				
				
				case 244285067:
				{
					//line 7 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\HuffmanTree.hx"
					if (field.equals("total_count_")) 
					{
						//line 7 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\HuffmanTree.hx"
						__temp_executeDef1 = false;
						//line 7 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\HuffmanTree.hx"
						this.total_count_ = ((int) (haxe.lang.Runtime.toInt(value)) );
						//line 7 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\HuffmanTree.hx"
						return value;
					}
					
					//line 7 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\HuffmanTree.hx"
					break;
				}
				
				
				case 1679263627:
				{
					//line 7 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\HuffmanTree.hx"
					if (field.equals("index_left_")) 
					{
						//line 7 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\HuffmanTree.hx"
						__temp_executeDef1 = false;
						//line 7 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\HuffmanTree.hx"
						this.index_left_ = ((int) (haxe.lang.Runtime.toInt(value)) );
						//line 7 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\HuffmanTree.hx"
						return value;
					}
					
					//line 7 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\HuffmanTree.hx"
					break;
				}
				
				
			}
			
			//line 7 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\HuffmanTree.hx"
			if (__temp_executeDef1) 
			{
				//line 7 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\HuffmanTree.hx"
				return super.__hx_setField(field, value, handleProperties);
			}
			else
			{
				//line 7 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\HuffmanTree.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public java.lang.Object __hx_getField(java.lang.String field, boolean throwErrors, boolean isCheck, boolean handleProperties)
	{
		//line 7 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\HuffmanTree.hx"
		{
			//line 7 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\HuffmanTree.hx"
			boolean __temp_executeDef1 = true;
			//line 7 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\HuffmanTree.hx"
			switch (field.hashCode())
			{
				case -186770662:
				{
					//line 7 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\HuffmanTree.hx"
					if (field.equals("index_right_or_value_")) 
					{
						//line 7 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\HuffmanTree.hx"
						__temp_executeDef1 = false;
						//line 7 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\HuffmanTree.hx"
						return this.index_right_or_value_;
					}
					
					//line 7 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\HuffmanTree.hx"
					break;
				}
				
				
				case -1515572024:
				{
					//line 7 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\HuffmanTree.hx"
					if (field.equals("HuffmanTree3")) 
					{
						//line 7 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\HuffmanTree.hx"
						__temp_executeDef1 = false;
						//line 7 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\HuffmanTree.hx"
						return ((haxe.lang.Function) (new haxe.lang.Closure(this, "HuffmanTree3")) );
					}
					
					//line 7 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\HuffmanTree.hx"
					break;
				}
				
				
				case 1679263627:
				{
					//line 7 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\HuffmanTree.hx"
					if (field.equals("index_left_")) 
					{
						//line 7 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\HuffmanTree.hx"
						__temp_executeDef1 = false;
						//line 7 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\HuffmanTree.hx"
						return this.index_left_;
					}
					
					//line 7 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\HuffmanTree.hx"
					break;
				}
				
				
				case 244285067:
				{
					//line 7 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\HuffmanTree.hx"
					if (field.equals("total_count_")) 
					{
						//line 7 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\HuffmanTree.hx"
						__temp_executeDef1 = false;
						//line 7 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\HuffmanTree.hx"
						return this.total_count_;
					}
					
					//line 7 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\HuffmanTree.hx"
					break;
				}
				
				
			}
			
			//line 7 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\HuffmanTree.hx"
			if (__temp_executeDef1) 
			{
				//line 7 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\HuffmanTree.hx"
				return super.__hx_getField(field, throwErrors, isCheck, handleProperties);
			}
			else
			{
				//line 7 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\HuffmanTree.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public double __hx_getField_f(java.lang.String field, boolean throwErrors, boolean handleProperties)
	{
		//line 7 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\HuffmanTree.hx"
		{
			//line 7 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\HuffmanTree.hx"
			boolean __temp_executeDef1 = true;
			//line 7 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\HuffmanTree.hx"
			switch (field.hashCode())
			{
				case -186770662:
				{
					//line 7 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\HuffmanTree.hx"
					if (field.equals("index_right_or_value_")) 
					{
						//line 7 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\HuffmanTree.hx"
						__temp_executeDef1 = false;
						//line 7 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\HuffmanTree.hx"
						return ((double) (this.index_right_or_value_) );
					}
					
					//line 7 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\HuffmanTree.hx"
					break;
				}
				
				
				case 244285067:
				{
					//line 7 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\HuffmanTree.hx"
					if (field.equals("total_count_")) 
					{
						//line 7 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\HuffmanTree.hx"
						__temp_executeDef1 = false;
						//line 7 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\HuffmanTree.hx"
						return ((double) (this.total_count_) );
					}
					
					//line 7 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\HuffmanTree.hx"
					break;
				}
				
				
				case 1679263627:
				{
					//line 7 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\HuffmanTree.hx"
					if (field.equals("index_left_")) 
					{
						//line 7 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\HuffmanTree.hx"
						__temp_executeDef1 = false;
						//line 7 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\HuffmanTree.hx"
						return ((double) (this.index_left_) );
					}
					
					//line 7 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\HuffmanTree.hx"
					break;
				}
				
				
			}
			
			//line 7 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\HuffmanTree.hx"
			if (__temp_executeDef1) 
			{
				//line 7 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\HuffmanTree.hx"
				return super.__hx_getField_f(field, throwErrors, handleProperties);
			}
			else
			{
				//line 7 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\HuffmanTree.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public java.lang.Object __hx_invokeField(java.lang.String field, haxe.root.Array dynargs)
	{
		//line 7 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\HuffmanTree.hx"
		{
			//line 7 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\HuffmanTree.hx"
			boolean __temp_executeDef1 = true;
			//line 7 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\HuffmanTree.hx"
			switch (field.hashCode())
			{
				case -1515572024:
				{
					//line 7 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\HuffmanTree.hx"
					if (field.equals("HuffmanTree3")) 
					{
						//line 7 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\HuffmanTree.hx"
						__temp_executeDef1 = false;
						//line 7 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\HuffmanTree.hx"
						this.HuffmanTree3(((int) (haxe.lang.Runtime.toInt(dynargs.__get(0))) ), ((int) (haxe.lang.Runtime.toInt(dynargs.__get(1))) ), ((int) (haxe.lang.Runtime.toInt(dynargs.__get(2))) ));
					}
					
					//line 7 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\HuffmanTree.hx"
					break;
				}
				
				
			}
			
			//line 7 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\HuffmanTree.hx"
			if (__temp_executeDef1) 
			{
				//line 7 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\HuffmanTree.hx"
				return super.__hx_invokeField(field, dynargs);
			}
			
		}
		
		//line 7 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\HuffmanTree.hx"
		return null;
	}
	
	
	@Override public void __hx_getFields(haxe.root.Array<java.lang.String> baseArr)
	{
		//line 7 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\HuffmanTree.hx"
		baseArr.push("index_right_or_value_");
		//line 7 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\HuffmanTree.hx"
		baseArr.push("index_left_");
		//line 7 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\HuffmanTree.hx"
		baseArr.push("total_count_");
		//line 7 "C:\\Users\\Dominik\\Brotli\\src\\encode\\entropy_encode\\HuffmanTree.hx"
		super.__hx_getFields(baseArr);
	}
	
	
}


