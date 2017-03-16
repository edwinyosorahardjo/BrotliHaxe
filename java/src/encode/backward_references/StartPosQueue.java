// Generated by Haxe 3.4.0
package encode.backward_references;

import haxe.root.*;

@SuppressWarnings(value={"rawtypes", "unchecked"})
public class StartPosQueue extends haxe.lang.HxObject
{
	public StartPosQueue(haxe.lang.EmptyObject empty)
	{
	}
	
	
	public StartPosQueue(int bits)
	{
		//line 22 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
		encode.backward_references.StartPosQueue.__hx_ctor_encode_backward_references_StartPosQueue(this, bits);
	}
	
	
	public static void __hx_ctor_encode_backward_references_StartPosQueue(encode.backward_references.StartPosQueue __hx_this, int bits)
	{
		//line 24 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
		__hx_this.mask_ = ( (( 1 << bits )) - 1 );
		//line 24 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
		__hx_this.q_ = haxe.root.FunctionMalloc.malloc2__encode_backward_references_Pair(encode.backward_references.Pair.class, ( 1 << bits ));
		//line 24 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
		__hx_this.idx_ = 0;
	}
	
	
	public void Clear()
	{
		//line 27 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
		this.idx_ = 0;
	}
	
	
	public void Push(int pos, double costdiff)
	{
		//line 31 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
		((encode.backward_references.Pair[]) (this.q_) )[( this.idx_ & this.mask_ )] = new encode.backward_references.Pair(pos, costdiff);
		//line 33 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
		int i = this.idx_;
		//line 34 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
		while (( ( i > 0 ) && ( i > ( this.idx_ - this.mask_ ) ) ))
		{
			//line 35 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
			if (( ((encode.backward_references.Pair[]) (this.q_) )[( i & this.mask_ )].second > ((encode.backward_references.Pair[]) (this.q_) )[( ( i - 1 ) & this.mask_ )].second )) 
			{
				//line 36 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
				int t1 = ((encode.backward_references.Pair[]) (this.q_) )[( i & this.mask_ )].first;
				//line 37 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
				double t2 = ((encode.backward_references.Pair[]) (this.q_) )[( i & this.mask_ )].second;
				//line 38 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
				((encode.backward_references.Pair[]) (this.q_) )[( i & this.mask_ )].first = ((encode.backward_references.Pair[]) (this.q_) )[( ( i - 1 ) & this.mask_ )].first;
				//line 39 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
				((encode.backward_references.Pair[]) (this.q_) )[( i & this.mask_ )].second = ((encode.backward_references.Pair[]) (this.q_) )[( ( i - 1 ) & this.mask_ )].second;
				//line 40 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
				((encode.backward_references.Pair[]) (this.q_) )[( ( i - 1 ) & this.mask_ )].first = t1;
				//line 41 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
				((encode.backward_references.Pair[]) (this.q_) )[( ( i - 1 ) & this.mask_ )].second = t2;
			}
			
			//line 43 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
			 -- i;
		}
		
		//line 45 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
		 ++ this.idx_;
	}
	
	
	public int size()
	{
		//line 48 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
		return ((int) (java.lang.Math.min(((double) (this.idx_) ), ((double) (( this.mask_ + 1 )) ))) );
	}
	
	
	public int GetStartPos(int k)
	{
		//line 51 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
		return ((encode.backward_references.Pair[]) (this.q_) )[( ( ( this.idx_ - k ) - 1 ) & this.mask_ )].first;
	}
	
	
	public int mask_;
	
	public encode.backward_references.Pair[] q_;
	
	public int idx_;
	
	@Override public double __hx_setField_f(java.lang.String field, double value, boolean handleProperties)
	{
		//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
		{
			//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
			boolean __temp_executeDef1 = true;
			//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
			switch (field.hashCode())
			{
				case 3227970:
				{
					//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
					if (field.equals("idx_")) 
					{
						//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
						__temp_executeDef1 = false;
						//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
						this.idx_ = ((int) (value) );
						//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
						return value;
					}
					
					//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
					break;
				}
				
				
				case 103667443:
				{
					//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
					if (field.equals("mask_")) 
					{
						//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
						__temp_executeDef1 = false;
						//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
						this.mask_ = ((int) (value) );
						//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
						return value;
					}
					
					//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
					break;
				}
				
				
			}
			
			//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
			if (__temp_executeDef1) 
			{
				//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
				return super.__hx_setField_f(field, value, handleProperties);
			}
			else
			{
				//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public java.lang.Object __hx_setField(java.lang.String field, java.lang.Object value, boolean handleProperties)
	{
		//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
		{
			//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
			boolean __temp_executeDef1 = true;
			//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
			switch (field.hashCode())
			{
				case 3227970:
				{
					//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
					if (field.equals("idx_")) 
					{
						//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
						__temp_executeDef1 = false;
						//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
						this.idx_ = ((int) (haxe.lang.Runtime.toInt(value)) );
						//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
						return value;
					}
					
					//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
					break;
				}
				
				
				case 103667443:
				{
					//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
					if (field.equals("mask_")) 
					{
						//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
						__temp_executeDef1 = false;
						//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
						this.mask_ = ((int) (haxe.lang.Runtime.toInt(value)) );
						//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
						return value;
					}
					
					//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
					break;
				}
				
				
				case 3598:
				{
					//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
					if (field.equals("q_")) 
					{
						//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
						__temp_executeDef1 = false;
						//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
						this.q_ = ((encode.backward_references.Pair[]) (value) );
						//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
						return value;
					}
					
					//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
					break;
				}
				
				
			}
			
			//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
			if (__temp_executeDef1) 
			{
				//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
				return super.__hx_setField(field, value, handleProperties);
			}
			else
			{
				//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public java.lang.Object __hx_getField(java.lang.String field, boolean throwErrors, boolean isCheck, boolean handleProperties)
	{
		//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
		{
			//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
			boolean __temp_executeDef1 = true;
			//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
			switch (field.hashCode())
			{
				case 3227970:
				{
					//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
					if (field.equals("idx_")) 
					{
						//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
						__temp_executeDef1 = false;
						//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
						return this.idx_;
					}
					
					//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
					break;
				}
				
				
				case 65193517:
				{
					//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
					if (field.equals("Clear")) 
					{
						//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
						__temp_executeDef1 = false;
						//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
						return ((haxe.lang.Function) (new haxe.lang.Closure(this, "Clear")) );
					}
					
					//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
					break;
				}
				
				
				case 3598:
				{
					//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
					if (field.equals("q_")) 
					{
						//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
						__temp_executeDef1 = false;
						//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
						return this.q_;
					}
					
					//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
					break;
				}
				
				
				case 2499386:
				{
					//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
					if (field.equals("Push")) 
					{
						//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
						__temp_executeDef1 = false;
						//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
						return ((haxe.lang.Function) (new haxe.lang.Closure(this, "Push")) );
					}
					
					//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
					break;
				}
				
				
				case 103667443:
				{
					//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
					if (field.equals("mask_")) 
					{
						//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
						__temp_executeDef1 = false;
						//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
						return this.mask_;
					}
					
					//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
					break;
				}
				
				
				case 3530753:
				{
					//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
					if (field.equals("size")) 
					{
						//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
						__temp_executeDef1 = false;
						//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
						return ((haxe.lang.Function) (new haxe.lang.Closure(this, "size")) );
					}
					
					//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
					break;
				}
				
				
				case 767584232:
				{
					//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
					if (field.equals("GetStartPos")) 
					{
						//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
						__temp_executeDef1 = false;
						//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
						return ((haxe.lang.Function) (new haxe.lang.Closure(this, "GetStartPos")) );
					}
					
					//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
					break;
				}
				
				
			}
			
			//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
			if (__temp_executeDef1) 
			{
				//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
				return super.__hx_getField(field, throwErrors, isCheck, handleProperties);
			}
			else
			{
				//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public double __hx_getField_f(java.lang.String field, boolean throwErrors, boolean handleProperties)
	{
		//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
		{
			//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
			boolean __temp_executeDef1 = true;
			//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
			switch (field.hashCode())
			{
				case 3227970:
				{
					//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
					if (field.equals("idx_")) 
					{
						//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
						__temp_executeDef1 = false;
						//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
						return ((double) (this.idx_) );
					}
					
					//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
					break;
				}
				
				
				case 103667443:
				{
					//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
					if (field.equals("mask_")) 
					{
						//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
						__temp_executeDef1 = false;
						//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
						return ((double) (this.mask_) );
					}
					
					//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
					break;
				}
				
				
			}
			
			//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
			if (__temp_executeDef1) 
			{
				//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
				return super.__hx_getField_f(field, throwErrors, handleProperties);
			}
			else
			{
				//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public java.lang.Object __hx_invokeField(java.lang.String field, haxe.root.Array dynargs)
	{
		//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
		{
			//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
			boolean __temp_executeDef1 = true;
			//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
			switch (field.hashCode())
			{
				case 767584232:
				{
					//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
					if (field.equals("GetStartPos")) 
					{
						//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
						__temp_executeDef1 = false;
						//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
						return this.GetStartPos(((int) (haxe.lang.Runtime.toInt(dynargs.__get(0))) ));
					}
					
					//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
					break;
				}
				
				
				case 65193517:
				{
					//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
					if (field.equals("Clear")) 
					{
						//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
						__temp_executeDef1 = false;
						//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
						this.Clear();
					}
					
					//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
					break;
				}
				
				
				case 3530753:
				{
					//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
					if (field.equals("size")) 
					{
						//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
						__temp_executeDef1 = false;
						//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
						return this.size();
					}
					
					//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
					break;
				}
				
				
				case 2499386:
				{
					//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
					if (field.equals("Push")) 
					{
						//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
						__temp_executeDef1 = false;
						//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
						this.Push(((int) (haxe.lang.Runtime.toInt(dynargs.__get(0))) ), ((double) (haxe.lang.Runtime.toDouble(dynargs.__get(1))) ));
					}
					
					//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
					break;
				}
				
				
			}
			
			//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
			if (__temp_executeDef1) 
			{
				//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
				return super.__hx_invokeField(field, dynargs);
			}
			
		}
		
		//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
		return null;
	}
	
	
	@Override public void __hx_getFields(haxe.root.Array<java.lang.String> baseArr)
	{
		//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
		baseArr.push("idx_");
		//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
		baseArr.push("q_");
		//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
		baseArr.push("mask_");
		//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\StartPosQueue.hx"
		super.__hx_getFields(baseArr);
	}
	
	
}


