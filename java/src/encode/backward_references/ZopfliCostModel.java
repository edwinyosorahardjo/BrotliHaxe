// Generated by Haxe 3.4.0
package encode.backward_references;

import haxe.root.*;

@SuppressWarnings(value={"rawtypes", "unchecked"})
public class ZopfliCostModel extends haxe.lang.HxObject
{
	public ZopfliCostModel(haxe.lang.EmptyObject empty)
	{
	}
	
	
	public ZopfliCostModel()
	{
		//line 144 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
		encode.backward_references.ZopfliCostModel.__hx_ctor_encode_backward_references_ZopfliCostModel(this);
	}
	
	
	public static void __hx_ctor_encode_backward_references_ZopfliCostModel(encode.backward_references.ZopfliCostModel __hx_this)
	{
	}
	
	
	public void SetFromCommands(int num_bytes, int position, int[] ringbuffer, int ringbuffer_mask, haxe.root.Array<encode.command.Command> commands, int num_commands, int last_insert_len)
	{
		//line 22 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
		int[] histogram_literal = haxe.root.FunctionMalloc.mallocInt(256);
		//line 23 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
		int[] histogram_cmd = haxe.root.FunctionMalloc.mallocInt(704);
		//line 24 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
		int[] histogram_dist = haxe.root.FunctionMalloc.mallocInt(520);
		//line 26 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
		int pos = ( position - last_insert_len );
		//line 27 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
		{
			//line 27 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
			int _g1 = 0;
			//line 27 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
			while (( _g1 < num_commands ))
			{
				//line 27 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
				int i = _g1++;
				//line 28 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
				int inslength = commands.__get(i).insert_len_;
				//line 29 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
				int copylength = commands.__get(i).copy_len_;
				//line 30 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
				int distcode = ((int) (haxe.lang.Runtime.toInt(commands.__get(i).dist_prefix_.__get(0))) );
				//line 31 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
				int cmdcode = ((int) (haxe.lang.Runtime.toInt(commands.__get(i).cmd_prefix_.__get(0))) );
				//line 33 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
				((int[]) (histogram_cmd) )[cmdcode] = ( ((int) (((int[]) (histogram_cmd) )[cmdcode]) ) + 1 );
				//line 34 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
				if (( cmdcode >= 128 )) 
				{
					//line 34 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
					((int[]) (histogram_dist) )[distcode] = ( ((int) (((int[]) (histogram_dist) )[distcode]) ) + 1 );
				}
				
				//line 36 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
				{
					//line 36 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
					int _g3 = 0;
					//line 36 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
					while (( _g3 < inslength ))
					{
						//line 36 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
						int j = _g3++;
						//line 37 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
						{
							//line 37 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
							int _g4 = ((int) (((int[]) (ringbuffer) )[( ( pos + j ) & ringbuffer_mask )]) );
							//line 37 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
							((int[]) (histogram_literal) )[_g4] = ( ((int) (((int[]) (histogram_literal) )[_g4]) ) + 1 );
						}
						
					}
					
				}
				
				//line 40 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
				pos += ( inslength + copylength );
			}
			
		}
		
		//line 43 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
		haxe.root.Array<double[]> cost_literal_ = new haxe.root.Array<double[]>();
		//line 44 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
		this.Set(histogram_literal, cost_literal_);
		//line 45 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
		double[] cost_literal = cost_literal_.__get(0);
		//line 46 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
		haxe.root.Array<double[]> cost_cmd = new haxe.root.Array<double[]>(new double[][]{this.cost_cmd_});
		//line 47 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
		this.Set(histogram_cmd, cost_cmd);
		//line 48 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
		this.cost_cmd_ = cost_cmd.__get(0);
		//line 49 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
		haxe.root.Array<double[]> cost_dist = new haxe.root.Array<double[]>(new double[][]{this.cost_dist_});
		//line 50 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
		this.Set(histogram_dist, cost_dist);
		//line 51 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
		this.cost_dist_ = cost_dist.__get(0);
		//line 53 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
		this.min_cost_cmd_ = encode.Backward_references.kInfinity;
		//line 54 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
		{
			//line 54 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
			int _g = 0;
			//line 54 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
			while (( _g < 704 ))
			{
				//line 54 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
				int i1 = _g++;
				//line 55 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
				this.min_cost_cmd_ = java.lang.Math.min(this.min_cost_cmd_, ((double[]) (this.cost_cmd_) )[i1]);
			}
			
		}
		
		//line 58 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
		double[] this1 = new double[( num_bytes + 1 )];
		//line 58 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
		this.literal_costs_ = ((double[]) (this1) );
		//line 59 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
		((double[]) (this.literal_costs_) )[0] = 0.0;
		//line 60 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
		{
			//line 60 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
			int _g11 = 0;
			//line 60 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
			while (( _g11 < num_bytes ))
			{
				//line 60 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
				int i2 = _g11++;
				//line 61 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
				((double[]) (this.literal_costs_) )[( i2 + 1 )] = ( ((double[]) (this.literal_costs_) )[i2] + ((double) (((double[]) (cost_literal) )[((int) (((int[]) (ringbuffer) )[( ( position + i2 ) & ringbuffer_mask )]) )]) ) );
			}
			
		}
		
	}
	
	
	public void SetFromLiteralCosts(int num_bytes, int position, double[] literal_cost, int literal_cost_mask)
	{
		//line 70 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
		this.literal_costs_ = haxe.root.FunctionMalloc.mallocFloat(( num_bytes + 1 ));
		//line 71 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
		((double[]) (this.literal_costs_) )[0] = 0.0;
		//line 72 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
		if (( literal_cost != null )) 
		{
			//line 73 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
			int _g1 = 0;
			//line 73 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
			while (( _g1 < num_bytes ))
			{
				//line 73 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
				int i = _g1++;
				//line 74 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
				((double[]) (this.literal_costs_) )[( i + 1 )] = ( ((double[]) (this.literal_costs_) )[i] + ((double) (((double[]) (literal_cost) )[( ( position + i ) & literal_cost_mask )]) ) );
			}
			
		}
		else
		{
			//line 78 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
			int _g11 = 1;
			//line 78 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
			int _g = ( num_bytes + 1 );
			//line 78 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
			while (( _g11 < _g ))
			{
				//line 78 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
				int i1 = _g11++;
				//line 79 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
				((double[]) (this.literal_costs_) )[i1] = ( i1 * 5.4 );
			}
			
		}
		
		//line 82 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
		double[] this1 = new double[704];
		//line 82 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
		this.cost_cmd_ = ((double[]) (this1) );
		//line 83 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
		double[] this2 = new double[520];
		//line 83 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
		this.cost_dist_ = ((double[]) (this2) );
		//line 84 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
		{
			//line 84 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
			int _g2 = 0;
			//line 84 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
			while (( _g2 < 704 ))
			{
				//line 84 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
				int i2 = _g2++;
				//line 85 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
				((double[]) (this.cost_cmd_) )[i2] = encode.Fast_log.FastLog2(( 11 + i2 ));
			}
			
		}
		
		//line 87 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
		{
			//line 87 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
			int _g3 = 0;
			//line 87 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
			while (( _g3 < 520 ))
			{
				//line 87 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
				int i3 = _g3++;
				//line 88 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
				((double[]) (this.cost_dist_) )[i3] = encode.Fast_log.FastLog2(( 20 + i3 ));
			}
			
		}
		
		//line 90 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
		this.min_cost_cmd_ = encode.Fast_log.FastLog2(11);
	}
	
	
	public double GetCommandCost(int dist_code, int length_code, int insert_length)
	{
		//line 95 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
		int inscode = encode.Command_functions.GetInsertLengthCode(insert_length);
		//line 96 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
		int copycode = encode.Command_functions.GetCopyLengthCode(length_code);
		//line 97 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
		int cmdcode = encode.Command_functions.CombineLengthCodes(inscode, copycode, dist_code);
		//line 98 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
		int insnumextra = ((int) (haxe.lang.Runtime.toInt(encode.Command_functions.insextra.__get(inscode))) );
		//line 99 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
		int copynumextra = ((int) (haxe.lang.Runtime.toInt(encode.Command_functions.copyextra.__get(copycode))) );
		//line 100 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
		haxe.root.Array<java.lang.Object> dist_symbol = new haxe.root.Array<java.lang.Object>();
		//line 101 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
		haxe.root.Array<java.lang.Object> distextra = new haxe.root.Array<java.lang.Object>();
		//line 102 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
		encode.Command_functions.GetDistCode(dist_code, dist_symbol, distextra);
		//line 103 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
		int distnumextra = ((int) (( ((int) (haxe.lang.Runtime.toInt(distextra.__get(0))) ) >>> 24 )) );
		//line 105 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
		double result = 0.0;
		//line 105 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
		int _int = ((int) (( ((int) (( ((int) (insnumextra) ) + ((int) (copynumextra) ) )) ) + ((int) (distnumextra) ) )) );
		//line 105 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
		if (( _int < 0 )) 
		{
			//line 105 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
			result = ( 4294967296.0 + _int );
		}
		else
		{
			//line 105 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
			result = ( _int + 0.0 );
		}
		
		//line 106 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
		result += ((double[]) (this.cost_cmd_) )[cmdcode];
		//line 107 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
		boolean aNeg = ( ((int) (cmdcode) ) < 0 );
		//line 107 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
		if (( (( aNeg != false )) ? (aNeg) : (( ((int) (cmdcode) ) >= ((int) (128) ) )) )) 
		{
			//line 107 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
			result += ((double[]) (this.cost_dist_) )[((int) (haxe.lang.Runtime.toInt(dist_symbol.__get(0))) )];
		}
		
		//line 108 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
		return result;
	}
	
	
	public double GetLiteralCosts(int from, int to)
	{
		//line 112 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
		return ( ((double[]) (this.literal_costs_) )[to] - ((double[]) (this.literal_costs_) )[from] );
	}
	
	
	public double GetMinCostCmd()
	{
		//line 116 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
		return this.min_cost_cmd_;
	}
	
	
	public void Set(int[] histogram, haxe.root.Array<double[]> cost)
	{
		//line 120 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
		double[] this1 = new double[((int[]) (histogram) ).length];
		//line 120 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
		cost.__set(0, ((double[]) (this1) ));
		//line 121 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
		int sum = 0;
		//line 122 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
		{
			//line 122 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
			int _g1 = 0;
			//line 122 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
			int _g = ((int[]) (histogram) ).length;
			//line 122 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
			while (( _g1 < _g ))
			{
				//line 122 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
				int i = _g1++;
				//line 123 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
				sum += ((int) (((int[]) (histogram) )[i]) );
			}
			
		}
		
		//line 125 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
		double log2sum = encode.Fast_log.FastLog2(sum);
		//line 126 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
		{
			//line 126 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
			int _g11 = 0;
			//line 126 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
			int _g2 = ((int[]) (histogram) ).length;
			//line 126 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
			while (( _g11 < _g2 ))
			{
				//line 126 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
				int i1 = _g11++;
				//line 127 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
				if (( ((int) (((int[]) (histogram) )[i1]) ) == 0 )) 
				{
					//line 128 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
					((double[]) (cost.__get(0)) )[i1] = ( log2sum + 2 );
					//line 129 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
					continue;
				}
				
				//line 133 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
				{
					//line 133 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
					double val = ( log2sum - encode.Fast_log.FastLog2(((int) (((int[]) (histogram) )[i1]) )) );
					//line 133 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
					((double[]) (cost.__get(0)) )[i1] = val;
				}
				
				//line 136 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
				if (( ((double) (((double[]) (cost.__get(0)) )[i1]) ) < 1 )) 
				{
					//line 136 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
					((double[]) (cost.__get(0)) )[i1] = ((double) (1) );
				}
				
			}
			
		}
		
	}
	
	
	public double[] cost_cmd_;
	
	public double[] cost_dist_;
	
	public double[] literal_costs_;
	
	public double min_cost_cmd_;
	
	@Override public double __hx_setField_f(java.lang.String field, double value, boolean handleProperties)
	{
		//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
		{
			//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
			boolean __temp_executeDef1 = true;
			//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
			switch (field.hashCode())
			{
				case 1192094186:
				{
					//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
					if (field.equals("min_cost_cmd_")) 
					{
						//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
						__temp_executeDef1 = false;
						//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
						this.min_cost_cmd_ = ((double) (value) );
						//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
						return value;
					}
					
					//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
					break;
				}
				
				
			}
			
			//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
			if (__temp_executeDef1) 
			{
				//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
				return super.__hx_setField_f(field, value, handleProperties);
			}
			else
			{
				//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public java.lang.Object __hx_setField(java.lang.String field, java.lang.Object value, boolean handleProperties)
	{
		//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
		{
			//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
			boolean __temp_executeDef1 = true;
			//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
			switch (field.hashCode())
			{
				case 1192094186:
				{
					//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
					if (field.equals("min_cost_cmd_")) 
					{
						//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
						__temp_executeDef1 = false;
						//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
						this.min_cost_cmd_ = ((double) (haxe.lang.Runtime.toDouble(value)) );
						//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
						return value;
					}
					
					//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
					break;
				}
				
				
				case -270432361:
				{
					//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
					if (field.equals("cost_cmd_")) 
					{
						//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
						__temp_executeDef1 = false;
						//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
						this.cost_cmd_ = ((double[]) (value) );
						//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
						return value;
					}
					
					//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
					break;
				}
				
				
				case 1918601321:
				{
					//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
					if (field.equals("literal_costs_")) 
					{
						//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
						__temp_executeDef1 = false;
						//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
						this.literal_costs_ = ((double[]) (value) );
						//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
						return value;
					}
					
					//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
					break;
				}
				
				
				case 207350919:
				{
					//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
					if (field.equals("cost_dist_")) 
					{
						//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
						__temp_executeDef1 = false;
						//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
						this.cost_dist_ = ((double[]) (value) );
						//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
						return value;
					}
					
					//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
					break;
				}
				
				
			}
			
			//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
			if (__temp_executeDef1) 
			{
				//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
				return super.__hx_setField(field, value, handleProperties);
			}
			else
			{
				//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public java.lang.Object __hx_getField(java.lang.String field, boolean throwErrors, boolean isCheck, boolean handleProperties)
	{
		//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
		{
			//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
			boolean __temp_executeDef1 = true;
			//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
			switch (field.hashCode())
			{
				case 1192094186:
				{
					//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
					if (field.equals("min_cost_cmd_")) 
					{
						//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
						__temp_executeDef1 = false;
						//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
						return this.min_cost_cmd_;
					}
					
					//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
					break;
				}
				
				
				case -1487306316:
				{
					//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
					if (field.equals("SetFromCommands")) 
					{
						//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
						__temp_executeDef1 = false;
						//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
						return ((haxe.lang.Function) (new haxe.lang.Closure(this, "SetFromCommands")) );
					}
					
					//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
					break;
				}
				
				
				case 1918601321:
				{
					//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
					if (field.equals("literal_costs_")) 
					{
						//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
						__temp_executeDef1 = false;
						//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
						return this.literal_costs_;
					}
					
					//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
					break;
				}
				
				
				case -1949020157:
				{
					//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
					if (field.equals("SetFromLiteralCosts")) 
					{
						//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
						__temp_executeDef1 = false;
						//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
						return ((haxe.lang.Function) (new haxe.lang.Closure(this, "SetFromLiteralCosts")) );
					}
					
					//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
					break;
				}
				
				
				case 207350919:
				{
					//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
					if (field.equals("cost_dist_")) 
					{
						//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
						__temp_executeDef1 = false;
						//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
						return this.cost_dist_;
					}
					
					//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
					break;
				}
				
				
				case 1190951074:
				{
					//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
					if (field.equals("GetCommandCost")) 
					{
						//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
						__temp_executeDef1 = false;
						//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
						return ((haxe.lang.Function) (new haxe.lang.Closure(this, "GetCommandCost")) );
					}
					
					//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
					break;
				}
				
				
				case -270432361:
				{
					//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
					if (field.equals("cost_cmd_")) 
					{
						//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
						__temp_executeDef1 = false;
						//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
						return this.cost_cmd_;
					}
					
					//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
					break;
				}
				
				
				case -1338140371:
				{
					//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
					if (field.equals("GetLiteralCosts")) 
					{
						//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
						__temp_executeDef1 = false;
						//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
						return ((haxe.lang.Function) (new haxe.lang.Closure(this, "GetLiteralCosts")) );
					}
					
					//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
					break;
				}
				
				
				case 83010:
				{
					//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
					if (field.equals("Set")) 
					{
						//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
						__temp_executeDef1 = false;
						//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
						return ((haxe.lang.Function) (new haxe.lang.Closure(this, "Set")) );
					}
					
					//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
					break;
				}
				
				
				case 808297297:
				{
					//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
					if (field.equals("GetMinCostCmd")) 
					{
						//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
						__temp_executeDef1 = false;
						//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
						return ((haxe.lang.Function) (new haxe.lang.Closure(this, "GetMinCostCmd")) );
					}
					
					//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
					break;
				}
				
				
			}
			
			//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
			if (__temp_executeDef1) 
			{
				//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
				return super.__hx_getField(field, throwErrors, isCheck, handleProperties);
			}
			else
			{
				//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public double __hx_getField_f(java.lang.String field, boolean throwErrors, boolean handleProperties)
	{
		//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
		{
			//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
			boolean __temp_executeDef1 = true;
			//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
			switch (field.hashCode())
			{
				case 1192094186:
				{
					//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
					if (field.equals("min_cost_cmd_")) 
					{
						//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
						__temp_executeDef1 = false;
						//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
						return this.min_cost_cmd_;
					}
					
					//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
					break;
				}
				
				
			}
			
			//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
			if (__temp_executeDef1) 
			{
				//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
				return super.__hx_getField_f(field, throwErrors, handleProperties);
			}
			else
			{
				//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public java.lang.Object __hx_invokeField(java.lang.String field, haxe.root.Array dynargs)
	{
		//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
		{
			//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
			boolean __temp_executeDef1 = true;
			//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
			switch (field.hashCode())
			{
				case 83010:
				{
					//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
					if (field.equals("Set")) 
					{
						//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
						__temp_executeDef1 = false;
						//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
						this.Set(((int[]) (dynargs.__get(0)) ), ((haxe.root.Array<double[]>) (dynargs.__get(1)) ));
					}
					
					//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
					break;
				}
				
				
				case -1487306316:
				{
					//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
					if (field.equals("SetFromCommands")) 
					{
						//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
						__temp_executeDef1 = false;
						//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
						this.SetFromCommands(((int) (haxe.lang.Runtime.toInt(dynargs.__get(0))) ), ((int) (haxe.lang.Runtime.toInt(dynargs.__get(1))) ), ((int[]) (dynargs.__get(2)) ), ((int) (haxe.lang.Runtime.toInt(dynargs.__get(3))) ), ((haxe.root.Array<encode.command.Command>) (dynargs.__get(4)) ), ((int) (haxe.lang.Runtime.toInt(dynargs.__get(5))) ), ((int) (haxe.lang.Runtime.toInt(dynargs.__get(6))) ));
					}
					
					//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
					break;
				}
				
				
				case 808297297:
				{
					//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
					if (field.equals("GetMinCostCmd")) 
					{
						//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
						__temp_executeDef1 = false;
						//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
						return this.GetMinCostCmd();
					}
					
					//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
					break;
				}
				
				
				case -1949020157:
				{
					//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
					if (field.equals("SetFromLiteralCosts")) 
					{
						//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
						__temp_executeDef1 = false;
						//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
						this.SetFromLiteralCosts(((int) (haxe.lang.Runtime.toInt(dynargs.__get(0))) ), ((int) (haxe.lang.Runtime.toInt(dynargs.__get(1))) ), ((double[]) (dynargs.__get(2)) ), ((int) (haxe.lang.Runtime.toInt(dynargs.__get(3))) ));
					}
					
					//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
					break;
				}
				
				
				case -1338140371:
				{
					//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
					if (field.equals("GetLiteralCosts")) 
					{
						//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
						__temp_executeDef1 = false;
						//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
						return this.GetLiteralCosts(((int) (haxe.lang.Runtime.toInt(dynargs.__get(0))) ), ((int) (haxe.lang.Runtime.toInt(dynargs.__get(1))) ));
					}
					
					//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
					break;
				}
				
				
				case 1190951074:
				{
					//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
					if (field.equals("GetCommandCost")) 
					{
						//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
						__temp_executeDef1 = false;
						//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
						return this.GetCommandCost(((int) (haxe.lang.Runtime.toInt(dynargs.__get(0))) ), ((int) (haxe.lang.Runtime.toInt(dynargs.__get(1))) ), ((int) (haxe.lang.Runtime.toInt(dynargs.__get(2))) ));
					}
					
					//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
					break;
				}
				
				
			}
			
			//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
			if (__temp_executeDef1) 
			{
				//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
				return super.__hx_invokeField(field, dynargs);
			}
			
		}
		
		//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
		return null;
	}
	
	
	@Override public void __hx_getFields(haxe.root.Array<java.lang.String> baseArr)
	{
		//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
		baseArr.push("min_cost_cmd_");
		//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
		baseArr.push("literal_costs_");
		//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
		baseArr.push("cost_dist_");
		//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
		baseArr.push("cost_cmd_");
		//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\backward_references\\ZopfliCostModel.hx"
		super.__hx_getFields(baseArr);
	}
	
	
}


