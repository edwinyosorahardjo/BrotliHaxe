// Generated by Haxe 3.4.0
package encode.block_splitter;

import haxe.root.*;

@SuppressWarnings(value={"rawtypes", "unchecked"})
public class BlockSplitIterator extends haxe.lang.HxObject
{
	public BlockSplitIterator(haxe.lang.EmptyObject empty)
	{
	}
	
	
	public BlockSplitIterator(encode.metablock.BlockSplit split)
	{
		//line 11 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
		encode.block_splitter.BlockSplitIterator.__hx_ctor_encode_block_splitter_BlockSplitIterator(this, split);
	}
	
	
	public static void __hx_ctor_encode_block_splitter_BlockSplitIterator(encode.block_splitter.BlockSplitIterator __hx_this, encode.metablock.BlockSplit split)
	{
		//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
		__hx_this.split_ = split;
		//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
		__hx_this.idx_ = 0;
		//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
		__hx_this.type_ = 0;
		//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
		__hx_this.length_ = 0;
		//line 14 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
		if (( split.lengths.length != 0 )) 
		{
			//line 15 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
			__hx_this.length_ = ((int) (haxe.lang.Runtime.toInt(split.lengths.__get(0))) );
		}
		
	}
	
	
	public void Next()
	{
		//line 20 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
		if (( this.length_ == 0 )) 
		{
			//line 21 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
			 ++ this.idx_;
			//line 22 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
			this.type_ = ((int) (haxe.lang.Runtime.toInt(this.split_.types.__get(this.idx_))) );
			//line 23 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
			this.length_ = ((int) (haxe.lang.Runtime.toInt(this.split_.lengths.__get(this.idx_))) );
		}
		
		//line 25 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
		 -- this.length_;
	}
	
	
	public encode.metablock.BlockSplit split_;
	
	public int idx_;
	
	public int type_;
	
	public int length_;
	
	@Override public double __hx_setField_f(java.lang.String field, double value, boolean handleProperties)
	{
		//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
		{
			//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
			boolean __temp_executeDef1 = true;
			//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
			switch (field.hashCode())
			{
				case 62464569:
				{
					//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
					if (field.equals("length_")) 
					{
						//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
						__temp_executeDef1 = false;
						//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
						this.length_ = ((int) (value) );
						//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
						return value;
					}
					
					//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
					break;
				}
				
				
				case 3227970:
				{
					//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
					if (field.equals("idx_")) 
					{
						//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
						__temp_executeDef1 = false;
						//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
						this.idx_ = ((int) (value) );
						//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
						return value;
					}
					
					//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
					break;
				}
				
				
				case 110844005:
				{
					//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
					if (field.equals("type_")) 
					{
						//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
						__temp_executeDef1 = false;
						//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
						this.type_ = ((int) (value) );
						//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
						return value;
					}
					
					//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
					break;
				}
				
				
			}
			
			//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
			if (__temp_executeDef1) 
			{
				//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
				return super.__hx_setField_f(field, value, handleProperties);
			}
			else
			{
				//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public java.lang.Object __hx_setField(java.lang.String field, java.lang.Object value, boolean handleProperties)
	{
		//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
		{
			//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
			boolean __temp_executeDef1 = true;
			//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
			switch (field.hashCode())
			{
				case 62464569:
				{
					//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
					if (field.equals("length_")) 
					{
						//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
						__temp_executeDef1 = false;
						//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
						this.length_ = ((int) (haxe.lang.Runtime.toInt(value)) );
						//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
						return value;
					}
					
					//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
					break;
				}
				
				
				case -895858555:
				{
					//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
					if (field.equals("split_")) 
					{
						//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
						__temp_executeDef1 = false;
						//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
						this.split_ = ((encode.metablock.BlockSplit) (value) );
						//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
						return value;
					}
					
					//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
					break;
				}
				
				
				case 110844005:
				{
					//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
					if (field.equals("type_")) 
					{
						//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
						__temp_executeDef1 = false;
						//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
						this.type_ = ((int) (haxe.lang.Runtime.toInt(value)) );
						//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
						return value;
					}
					
					//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
					break;
				}
				
				
				case 3227970:
				{
					//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
					if (field.equals("idx_")) 
					{
						//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
						__temp_executeDef1 = false;
						//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
						this.idx_ = ((int) (haxe.lang.Runtime.toInt(value)) );
						//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
						return value;
					}
					
					//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
					break;
				}
				
				
			}
			
			//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
			if (__temp_executeDef1) 
			{
				//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
				return super.__hx_setField(field, value, handleProperties);
			}
			else
			{
				//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public java.lang.Object __hx_getField(java.lang.String field, boolean throwErrors, boolean isCheck, boolean handleProperties)
	{
		//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
		{
			//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
			boolean __temp_executeDef1 = true;
			//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
			switch (field.hashCode())
			{
				case 62464569:
				{
					//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
					if (field.equals("length_")) 
					{
						//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
						__temp_executeDef1 = false;
						//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
						return this.length_;
					}
					
					//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
					break;
				}
				
				
				case 2424595:
				{
					//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
					if (field.equals("Next")) 
					{
						//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
						__temp_executeDef1 = false;
						//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
						return ((haxe.lang.Function) (new haxe.lang.Closure(this, "Next")) );
					}
					
					//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
					break;
				}
				
				
				case 110844005:
				{
					//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
					if (field.equals("type_")) 
					{
						//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
						__temp_executeDef1 = false;
						//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
						return this.type_;
					}
					
					//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
					break;
				}
				
				
				case -895858555:
				{
					//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
					if (field.equals("split_")) 
					{
						//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
						__temp_executeDef1 = false;
						//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
						return this.split_;
					}
					
					//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
					break;
				}
				
				
				case 3227970:
				{
					//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
					if (field.equals("idx_")) 
					{
						//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
						__temp_executeDef1 = false;
						//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
						return this.idx_;
					}
					
					//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
					break;
				}
				
				
			}
			
			//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
			if (__temp_executeDef1) 
			{
				//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
				return super.__hx_getField(field, throwErrors, isCheck, handleProperties);
			}
			else
			{
				//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public double __hx_getField_f(java.lang.String field, boolean throwErrors, boolean handleProperties)
	{
		//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
		{
			//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
			boolean __temp_executeDef1 = true;
			//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
			switch (field.hashCode())
			{
				case 62464569:
				{
					//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
					if (field.equals("length_")) 
					{
						//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
						__temp_executeDef1 = false;
						//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
						return ((double) (this.length_) );
					}
					
					//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
					break;
				}
				
				
				case 3227970:
				{
					//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
					if (field.equals("idx_")) 
					{
						//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
						__temp_executeDef1 = false;
						//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
						return ((double) (this.idx_) );
					}
					
					//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
					break;
				}
				
				
				case 110844005:
				{
					//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
					if (field.equals("type_")) 
					{
						//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
						__temp_executeDef1 = false;
						//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
						return ((double) (this.type_) );
					}
					
					//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
					break;
				}
				
				
			}
			
			//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
			if (__temp_executeDef1) 
			{
				//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
				return super.__hx_getField_f(field, throwErrors, handleProperties);
			}
			else
			{
				//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public java.lang.Object __hx_invokeField(java.lang.String field, haxe.root.Array dynargs)
	{
		//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
		{
			//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
			boolean __temp_executeDef1 = true;
			//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
			switch (field.hashCode())
			{
				case 2424595:
				{
					//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
					if (field.equals("Next")) 
					{
						//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
						__temp_executeDef1 = false;
						//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
						this.Next();
					}
					
					//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
					break;
				}
				
				
			}
			
			//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
			if (__temp_executeDef1) 
			{
				//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
				return super.__hx_invokeField(field, dynargs);
			}
			
		}
		
		//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
		return null;
	}
	
	
	@Override public void __hx_getFields(haxe.root.Array<java.lang.String> baseArr)
	{
		//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
		baseArr.push("length_");
		//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
		baseArr.push("type_");
		//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
		baseArr.push("idx_");
		//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
		baseArr.push("split_");
		//line 8 "C:\\Users\\Dominik\\Brotli\\src\\encode\\block_splitter\\BlockSplitIterator.hx"
		super.__hx_getFields(baseArr);
	}
	
	
}


