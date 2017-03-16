// Generated by Haxe 3.4.0
package encode;

import haxe.root.*;

@SuppressWarnings(value={"rawtypes", "unchecked"})
public class Cluster extends haxe.lang.HxObject
{
	public Cluster(haxe.lang.EmptyObject empty)
	{
	}
	
	
	public Cluster()
	{
		//line 281 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
		encode.Cluster.__hx_ctor_encode_Cluster(this);
	}
	
	
	public static void __hx_ctor_encode_Cluster(encode.Cluster __hx_this)
	{
	}
	
	
	public static int HistogramPairComparator(encode.cluster.HistogramPair p1, encode.cluster.HistogramPair p2)
	{
		//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
		if (( p1.cost_diff != p2.cost_diff )) 
		{
			//line 20 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
			if (( p1.cost_diff > p2.cost_diff )) 
			{
				//line 20 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
				return 1;
			}
			else
			{
				//line 20 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
				return -1;
			}
			
		}
		
		//line 22 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
		if (( java.lang.Math.abs(((double) (( p1.idx1 - p1.idx2 )) )) > java.lang.Math.abs(((double) (( p2.idx1 - p2.idx2 )) )) )) 
		{
			//line 22 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
			return 1;
		}
		else
		{
			//line 22 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
			return -1;
		}
		
	}
	
	
	public static double ClusterCostDiff(int size_a, int size_b)
	{
		//line 27 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
		int size_c = ( size_a + size_b );
		//line 28 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
		return ( ( ( size_a * encode.Fast_log.FastLog2(size_a) ) + ( size_b * encode.Fast_log.FastLog2(size_b) ) ) - ( size_c * encode.Fast_log.FastLog2(size_c) ) );
	}
	
	
	public static void CompareAndPushToHeap(haxe.root.Array<encode.histogram.Histogram> out, int[] cluster_size, int idx1, int idx2, encode.BinaryHeap<encode.cluster.HistogramPair> pairs)
	{
		//line 38 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
		if (( idx1 == idx2 )) 
		{
			//line 39 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
			return ;
		}
		
		//line 41 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
		if (( idx2 < idx1 )) 
		{
			//line 42 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
			int t = idx2;
			//line 43 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
			idx2 = idx1;
			//line 44 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
			idx1 = t;
		}
		
		//line 46 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
		boolean store_pair = false;
		//line 47 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
		encode.cluster.HistogramPair p = new encode.cluster.HistogramPair();
		//line 48 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
		p.idx1 = idx1;
		//line 49 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
		p.idx2 = idx2;
		//line 50 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
		p.valid = true;
		//line 51 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
		p.cost_diff = ( 0.5 * encode.Cluster.ClusterCostDiff(((int) (((int[]) (cluster_size) )[idx1]) ), ((int) (((int[]) (cluster_size) )[idx2]) )) );
		//line 53 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
		p.cost_diff = ( (p.cost_diff -= out.__get(idx1).bit_cost_) - out.__get(idx2).bit_cost_ );
		//line 55 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
		if (( out.__get(idx1).total_count_ == 0 )) 
		{
			//line 56 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
			p.cost_combo = out.__get(idx2).bit_cost_;
			//line 57 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
			store_pair = true;
		}
		else
		{
			//line 58 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
			if (( out.__get(idx2).total_count_ == 0 )) 
			{
				//line 59 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
				p.cost_combo = out.__get(idx1).bit_cost_;
				//line 60 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
				store_pair = true;
			}
			else
			{
				//line 62 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
				double threshold = ( (( pairs.size() == 0 )) ? (1e99) : (java.lang.Math.max(0.0, ((double) (haxe.lang.Runtime.toDouble(haxe.lang.Runtime.getField(pairs.arr.__get(0), "cost_diff", true))) ))) );
				//line 64 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
				encode.histogram.Histogram combo = new encode.histogram.Histogram(((int) (((int[]) (out.__get(idx1).data_) ).length) ));
				//line 65 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
				combo.bit_cost_ = out.__get(idx1).bit_cost_;
				//line 66 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
				{
					//line 66 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
					int _g1 = 0;
					//line 66 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
					int _g = ((int[]) (out.__get(idx1).data_) ).length;
					//line 66 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
					while (( _g1 < _g ))
					{
						//line 66 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
						int a = _g1++;
						//line 67 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
						((int[]) (combo.data_) )[a] = ((int[]) (out.__get(idx1).data_) )[a];
					}
					
				}
				
				//line 68 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
				combo.kDataSize = out.__get(idx1).kDataSize;
				//line 69 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
				combo.total_count_ = out.__get(idx1).total_count_;
				//line 70 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
				combo.AddHistogram(out.__get(idx2));
				//line 71 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
				double cost_combo = encode.Bit_cost.PopulationCost(combo);
				//line 72 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
				if (( cost_combo < ( threshold - p.cost_diff ) )) 
				{
					//line 73 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
					p.cost_combo = cost_combo;
					//line 74 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
					store_pair = true;
				}
				
			}
			
		}
		
		//line 77 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
		if (store_pair) 
		{
			//line 78 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
			p.cost_diff += p.cost_combo;
			//line 79 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
			pairs.push(p);
		}
		
	}
	
	
	public static void HistogramCombine(haxe.root.Array<encode.histogram.Histogram> out, int[] cluster_size, int[] symbols, int symbols_off, int symbols_size, int max_clusters)
	{
		//line 91 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
		double cost_diff_threshold = 0.0;
		//line 92 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
		int min_cluster_size = 1;
		//line 93 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
		haxe.root.Array<java.lang.Object> all_symbols = new haxe.root.Array<java.lang.Object>();
		//line 94 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
		haxe.root.Array<java.lang.Object> clusters = new haxe.root.Array<java.lang.Object>();
		//line 95 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
		{
			//line 95 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
			int _g1 = 0;
			//line 95 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
			while (( _g1 < symbols_size ))
			{
				//line 95 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
				int i = _g1++;
				//line 96 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
				if (( all_symbols.indexOf(((int) (((int[]) (symbols) )[( symbols_off + i )]) ), null) == -1 )) 
				{
					//line 97 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
					if (( all_symbols.indexOf(((int) (((int[]) (symbols) )[( symbols_off + i )]) ), null) == -1 )) 
					{
						//line 98 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
						all_symbols.push(((int) (((int[]) (symbols) )[( symbols_off + i )]) ));
					}
					
					//line 99 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
					clusters.push(((int) (((int[]) (symbols) )[( symbols_off + i )]) ));
				}
				
			}
			
		}
		
		//line 104 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
		encode.BinaryHeap<encode.cluster.HistogramPair> pairs = new encode.BinaryHeap<encode.cluster.HistogramPair>();
		//line 105 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
		{
			//line 105 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
			int _g11 = 0;
			//line 105 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
			int _g = clusters.length;
			//line 105 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
			while (( _g11 < _g ))
			{
				//line 105 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
				int idx1 = _g11++;
				//line 106 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
				{
					//line 106 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
					int _g3 = ( idx1 + 1 );
					//line 106 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
					int _g2 = clusters.length;
					//line 106 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
					while (( _g3 < _g2 ))
					{
						//line 106 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
						int idx2 = _g3++;
						//line 107 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
						encode.Cluster.CompareAndPushToHeap(out, cluster_size, ((int) (haxe.lang.Runtime.toInt(clusters.__get(idx1))) ), ((int) (haxe.lang.Runtime.toInt(clusters.__get(idx2))) ), pairs);
					}
					
				}
				
			}
			
		}
		
		//line 112 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
		while (( clusters.length > min_cluster_size ))
		{
			//line 113 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
			if (( haxe.lang.Runtime.compare(haxe.lang.Runtime.getField(pairs.arr.__get(0), "cost_diff", true), cost_diff_threshold) >= 0 )) 
			{
				//line 114 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
				cost_diff_threshold = 1e99;
				//line 115 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
				min_cluster_size = max_clusters;
				//line 116 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
				continue;
			}
			
			//line 119 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
			int best_idx1 = ((int) (haxe.lang.Runtime.toInt(haxe.lang.Runtime.getField(pairs.arr.__get(0), "idx1", true))) );
			//line 120 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
			int best_idx2 = ((int) (haxe.lang.Runtime.toInt(haxe.lang.Runtime.getField(pairs.arr.__get(0), "idx2", true))) );
			//line 121 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
			out.__get(best_idx1).AddHistogram(out.__get(best_idx2));
			//line 122 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
			out.__get(best_idx1).bit_cost_ = ((double) (haxe.lang.Runtime.toDouble(haxe.lang.Runtime.getField(pairs.arr.__get(0), "cost_combo", true))) );
			//line 123 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
			((int[]) (cluster_size) )[best_idx1] = ( ((int) (((int[]) (cluster_size) )[best_idx1]) ) + ((int) (((int[]) (cluster_size) )[best_idx2]) ) );
			//line 124 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
			{
				//line 124 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
				int _g12 = 0;
				//line 124 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
				while (( _g12 < symbols_size ))
				{
					//line 124 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
					int i1 = _g12++;
					//line 125 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
					if (( ((int) (((int[]) (symbols) )[( symbols_off + i1 )]) ) == best_idx2 )) 
					{
						//line 126 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
						((int[]) (symbols) )[( symbols_off + i1 )] = best_idx1;
					}
					
				}
				
			}
			
			//line 129 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
			{
				//line 129 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
				int _g13 = 0;
				//line 129 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
				int _g4 = clusters.length;
				//line 129 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
				while (( _g13 < _g4 ))
				{
					//line 129 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
					int i2 = _g13++;
					//line 130 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
					if (( ((int) (haxe.lang.Runtime.toInt(clusters.__get(i2))) ) >= best_idx2 )) 
					{
						//line 131 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
						clusters.__set(i2, ((int) (haxe.lang.Runtime.toInt(clusters.__get(( i2 + 1 )))) ));
					}
					
				}
				
			}
			
			//line 134 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
			clusters.pop();
			//line 136 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
			{
				//line 136 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
				int _g14 = 0;
				//line 136 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
				int _g5 = pairs.size();
				//line 136 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
				while (( _g14 < _g5 ))
				{
					//line 136 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
					int i3 = _g14++;
					//line 137 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
					encode.cluster.HistogramPair p = ((encode.cluster.HistogramPair) (pairs.arr.__get(i3)) );
					//line 138 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
					if (( ( ( ( p.idx1 == best_idx1 ) || ( p.idx2 == best_idx1 ) ) || ( p.idx1 == best_idx2 ) ) || ( p.idx2 == best_idx2 ) )) 
					{
						//line 140 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
						p.valid = false;
					}
					
				}
				
			}
			
			//line 144 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
			while (( ( pairs.size() != 0 ) && ( ! (haxe.lang.Runtime.toBool(haxe.lang.Runtime.getField(pairs.arr.__get(0), "valid", true))) ) ))
			{
				//line 146 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
				pairs.pop();
			}
			
			//line 149 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
			{
				//line 149 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
				int _g15 = 0;
				//line 149 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
				int _g6 = clusters.length;
				//line 149 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
				while (( _g15 < _g6 ))
				{
					//line 149 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
					int i4 = _g15++;
					//line 150 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
					encode.Cluster.CompareAndPushToHeap(out, cluster_size, best_idx1, ((int) (haxe.lang.Runtime.toInt(clusters.__get(i4))) ), pairs);
				}
				
			}
			
		}
		
	}
	
	
	public static double HistogramBitCostDistance(encode.histogram.Histogram histogram, encode.histogram.Histogram candidate)
	{
		//line 161 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
		if (( histogram.total_count_ == 0 )) 
		{
			//line 162 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
			return 0.0;
		}
		
		//line 164 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
		encode.histogram.Histogram tmp = new encode.histogram.Histogram(((int) (((int[]) (histogram.data_) ).length) ));
		//line 165 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
		tmp.bit_cost_ = histogram.bit_cost_;
		//line 166 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
		{
			//line 166 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
			int _g1 = 0;
			//line 166 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
			int _g = ((int[]) (histogram.data_) ).length;
			//line 166 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
			while (( _g1 < _g ))
			{
				//line 166 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
				int a = _g1++;
				//line 167 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
				((int[]) (tmp.data_) )[a] = ((int[]) (histogram.data_) )[a];
			}
			
		}
		
		//line 168 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
		tmp.kDataSize = histogram.kDataSize;
		//line 169 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
		tmp.total_count_ = histogram.total_count_;
		//line 170 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
		tmp.AddHistogram(candidate);
		//line 171 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
		return ( encode.Bit_cost.PopulationCost(tmp) - candidate.bit_cost_ );
	}
	
	
	public static void HistogramRemap(haxe.root.Array<encode.histogram.Histogram> input, int in_size, haxe.root.Array<encode.histogram.Histogram> output, int[] symbols)
	{
		//line 178 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
		haxe.root.Array<java.lang.Object> all_symbols = new haxe.root.Array<java.lang.Object>();
		//line 179 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
		{
			//line 179 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
			int _g1 = 0;
			//line 179 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
			while (( _g1 < in_size ))
			{
				//line 179 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
				int i = _g1++;
				//line 180 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
				if (( all_symbols.indexOf(((int) (((int[]) (symbols) )[i]) ), null) == -1 )) 
				{
					//line 181 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
					all_symbols.push(((int) (((int[]) (symbols) )[i]) ));
				}
				
			}
			
		}
		
		//line 183 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
		{
			//line 183 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
			int _g11 = 0;
			//line 183 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
			while (( _g11 < in_size ))
			{
				//line 183 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
				int i1 = _g11++;
				//line 184 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
				int best_out = ( (( i1 == 0 )) ? (((int) (((int[]) (symbols) )[0]) )) : (((int) (((int[]) (symbols) )[( i1 - 1 )]) )) );
				//line 185 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
				double best_bits = encode.Cluster.HistogramBitCostDistance(input.__get(i1), output.__get(best_out));
				//line 187 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
				{
					//line 187 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
					int _g3 = 0;
					//line 187 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
					int _g2 = all_symbols.length;
					//line 187 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
					while (( _g3 < _g2 ))
					{
						//line 187 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
						int k = _g3++;
						//line 188 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
						double cur_bits = encode.Cluster.HistogramBitCostDistance(input.__get(i1), output.__get(((int) (haxe.lang.Runtime.toInt(all_symbols.__get(k))) )));
						//line 189 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
						if (( cur_bits < best_bits )) 
						{
							//line 190 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
							best_bits = cur_bits;
							//line 191 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
							best_out = ((int) (haxe.lang.Runtime.toInt(all_symbols.__get(k))) );
						}
						
					}
					
				}
				
				//line 194 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
				((int[]) (symbols) )[i1] = best_out;
			}
			
		}
		
		//line 199 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
		{
			//line 199 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
			int _g12 = 0;
			//line 199 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
			int _g = all_symbols.length;
			//line 199 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
			while (( _g12 < _g ))
			{
				//line 199 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
				int k1 = _g12++;
				//line 200 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
				output.__get(((int) (haxe.lang.Runtime.toInt(all_symbols.__get(k1))) )).Clear();
			}
			
		}
		
		//line 202 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
		{
			//line 202 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
			int _g13 = 0;
			//line 202 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
			while (( _g13 < in_size ))
			{
				//line 202 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
				int i2 = _g13++;
				//line 203 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
				output.__get(((int) (((int[]) (symbols) )[i2]) )).AddHistogram(input.__get(i2));
			}
			
		}
		
	}
	
	
	public static void HistogramReindex(haxe.root.Array<encode.histogram.Histogram> out, int[] symbols)
	{
		//line 209 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
		haxe.root.Array<encode.histogram.Histogram> tmp = new haxe.root.Array<encode.histogram.Histogram>();
		//line 210 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
		{
			//line 210 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
			int _g1 = 0;
			//line 210 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
			int _g = out.length;
			//line 210 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
			while (( _g1 < _g ))
			{
				//line 210 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
				int i = _g1++;
				//line 211 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
				tmp.__set(i, new encode.histogram.Histogram(((int) (((int[]) (out.__get(i).data_) ).length) )));
				//line 212 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
				tmp.__get(i).bit_cost_ = out.__get(i).bit_cost_;
				//line 213 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
				{
					//line 213 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
					int _g3 = 0;
					//line 213 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
					int _g2 = ((int[]) (out.__get(i).data_) ).length;
					//line 213 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
					while (( _g3 < _g2 ))
					{
						//line 213 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
						int a = _g3++;
						//line 214 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
						((int[]) (tmp.__get(i).data_) )[a] = ((int[]) (out.__get(i).data_) )[a];
					}
					
				}
				
				//line 215 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
				tmp.__get(i).kDataSize = out.__get(i).kDataSize;
				//line 216 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
				tmp.__get(i).total_count_ = out.__get(i).total_count_;
			}
			
		}
		
		//line 218 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
		haxe.ds.IntMap<java.lang.Object> new_index = new haxe.ds.IntMap<java.lang.Object>();
		//line 219 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
		int next_index = 0;
		//line 220 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
		{
			//line 220 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
			int _g11 = 0;
			//line 220 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
			int _g4 = ((int[]) (symbols) ).length;
			//line 220 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
			while (( _g11 < _g4 ))
			{
				//line 220 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
				int i1 = _g11++;
				//line 221 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
				if (( new_index.exists(((int) (((int[]) (symbols) )[i1]) )) == false )) 
				{
					//line 222 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
					new_index.set(((int) (((int[]) (symbols) )[i1]) ), next_index);
					//line 223 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
					out.__get(next_index).bit_cost_ = tmp.__get(((int) (((int[]) (symbols) )[i1]) )).bit_cost_;
					//line 224 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
					{
						//line 224 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
						int _g31 = 0;
						//line 224 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
						int _g21 = ((int[]) (tmp.__get(((int) (((int[]) (symbols) )[i1]) )).data_) ).length;
						//line 224 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
						while (( _g31 < _g21 ))
						{
							//line 224 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
							int a1 = _g31++;
							//line 225 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
							((int[]) (out.__get(next_index).data_) )[a1] = ((int[]) (tmp.__get(((int) (((int[]) (symbols) )[i1]) )).data_) )[a1];
						}
						
					}
					
					//line 226 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
					out.__get(next_index).kDataSize = tmp.__get(((int) (((int[]) (symbols) )[i1]) )).kDataSize;
					//line 227 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
					out.__get(next_index).total_count_ = tmp.__get(((int) (((int[]) (symbols) )[i1]) )).total_count_;
					//line 228 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
					 ++ next_index;
				}
				
			}
			
		}
		
		//line 231 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
		while (( out.length > next_index ))
		{
			//line 231 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
			out.pop();
		}
		
		//line 232 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
		{
			//line 232 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
			int _g12 = 0;
			//line 232 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
			int _g5 = ((int[]) (symbols) ).length;
			//line 232 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
			while (( _g12 < _g5 ))
			{
				//line 232 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
				int i2 = _g12++;
				//line 233 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
				((int[]) (symbols) )[i2] = ((int) (haxe.lang.Runtime.toInt(new_index.get(((int) (((int[]) (symbols) )[i2]) )))) );
			}
			
		}
		
	}
	
	
	public static void ClusterHistograms(haxe.root.Array<encode.histogram.Histogram> input, int num_contexts, int num_blocks, int max_histograms, haxe.root.Array<encode.histogram.Histogram> output, int outputInt, int[] histogram_symbols)
	{
		//line 243 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
		int in_size = ( num_contexts * num_blocks );
		//line 244 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
		int[] this1 = new int[in_size];
		//line 244 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
		int[] cluster_size = ((int[]) (this1) );
		//line 245 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
		haxe.root.DefaultFunctions.memset_Int(cluster_size, 0, 1, in_size);
		//line 246 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
		while (( output.length > in_size ))
		{
			//line 246 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
			output.pop();
		}
		
		//line 247 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
		{
			//line 247 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
			int _g1 = 0;
			//line 247 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
			while (( _g1 < in_size ))
			{
				//line 247 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
				int i = _g1++;
				//line 248 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
				output.__set(i, new encode.histogram.Histogram(((int) (outputInt) )));
			}
			
		}
		
		//line 250 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
		{
			//line 250 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
			int _g11 = 0;
			//line 250 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
			while (( _g11 < in_size ))
			{
				//line 250 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
				int i1 = _g11++;
				//line 251 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
				{
					//line 251 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
					int _g3 = 0;
					//line 251 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
					int _g2 = ((int[]) (input.__get(i1).data_) ).length;
					//line 251 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
					while (( _g3 < _g2 ))
					{
						//line 251 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
						int a = _g3++;
						//line 252 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
						((int[]) (output.__get(i1).data_) )[a] = ((int[]) (input.__get(i1).data_) )[a];
					}
					
				}
				
				//line 253 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
				output.__get(i1).kDataSize = input.__get(i1).kDataSize;
				//line 254 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
				output.__get(i1).total_count_ = input.__get(i1).total_count_;
				//line 255 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
				output.__get(i1).bit_cost_ = encode.Bit_cost.PopulationCost(input.__get(i1));
				//line 256 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
				((int[]) (histogram_symbols) )[i1] = i1;
			}
			
		}
		
		//line 260 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
		int i2 = 0;
		//line 261 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
		while (( i2 < in_size ))
		{
			//line 262 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
			int num_to_combine = ((int) (java.lang.Math.min(((double) (( in_size - i2 )) ), ((double) (64) ))) );
			//line 263 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
			encode.Cluster.HistogramCombine(output, cluster_size, histogram_symbols, i2, num_to_combine, max_histograms);
			//line 266 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
			i2 += 64;
		}
		
		//line 270 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
		encode.Cluster.HistogramCombine(output, cluster_size, histogram_symbols, 0, in_size, max_histograms);
		//line 275 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
		encode.Cluster.HistogramRemap(input, in_size, output, histogram_symbols);
		//line 278 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Cluster.hx"
		encode.Cluster.HistogramReindex(output, histogram_symbols);
	}
	
	
}


