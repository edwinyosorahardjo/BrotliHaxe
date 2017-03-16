// Generated by Haxe 3.4.0

#pragma warning disable 109, 114, 219, 429, 168, 162
namespace haxe.lang {
	public sealed class FieldHashConflict {
		
		public FieldHashConflict(int hash, string name, object @value, global::haxe.lang.FieldHashConflict next) {
			this.hash = hash;
			this.name = name;
			this.@value = @value;
			this.next = next;
		}
		
		
		public readonly int hash;
		
		public readonly string name;
		
		public object @value;
		
		public global::haxe.lang.FieldHashConflict next;
		
	}
}



#pragma warning disable 109, 114, 219, 429, 168, 162
namespace haxe.lang {
	public sealed class FieldLookup {
		
		#pragma warning disable 628
		static FieldLookup() {
			global::haxe.lang.FieldLookup.length = ( global::haxe.lang.FieldLookup.fieldIds as global::System.Array ).Length;
		}
		
		
		public FieldLookup() {
		}
		
		
		protected static int[] fieldIds = new int[]{98, 105, 21968, 22841, 25294, 1266403, 4150146, 4745537, 4849249, 4945120, 5144726, 5243965, 5393365, 5442204, 5594513, 5594516, 5741474, 10319920, 11327097, 14955568, 23497926, 30362364, 35939030, 41127190, 42740551, 46374763, 52596211, 57476627, 62867362, 67859554, 67859985, 76061764, 87367608, 89861228, 90195613, 90195614, 90195659, 101615875, 108828507, 113006163, 117794952, 125264668, 127579321, 127579341, 137889424, 142301684, 146166351, 149162755, 151148891, 155924891, 173235979, 182695950, 183570271, 186833699, 192230170, 194189137, 204352542, 204497292, 204992800, 210480505, 226931207, 230081986, 243225909, 254611835, 274734998, 275554163, 282430831, 283120498, 286079859, 286868578, 287012064, 288167040, 302804836, 302979532, 306268135, 315031597, 320835200, 322068116, 323217485, 328878574, 330992538, 332919650, 351394276, 359333139, 364256911, 373422960, 379416331, 382782953, 388680308, 390300609, 391845250, 401849689, 403139749, 403139750, 403139753, 406749710, 407283053, 408331976, 422681360, 439261615, 449540197, 449540217, 452737314, 459921894, 468567317, 480633553, 480756972, 493819893, 495353696, 497938428, 501039929, 502309127, 506245857, 510872209, 511010969, 518477611, 520590566, 523201357, 537950791, 547883970, 562771638, 589325724, 593813019, 607184738, 613400968, 613638327, 614743843, 622111570, 623548900, 626464112, 634585579, 644524681, 645969938, 654394182, 660749808, 666449347, 675059700, 685312172, 691108279, 692063088, 693975859, 695309786, 695309787, 695309788, 695309789, 695309790, 695309791, 695309792, 695309793, 695309794, 713460152, 725622765, 725817104, 725817105, 743635343, 746008189, 748309603, 754430243, 770104548, 783735186, 786269185, 789723607, 793152251, 793286896, 812293353, 815032112, 821059803, 824412946, 826870028, 831562591, 834172156, 834174833, 848580487, 855943833, 870035731, 880923708, 893009402, 894756598, 914388854, 922671056, 928091019, 936476748, 946786476, 953005556, 953792829, 958206052, 960383740, 961126132, 981779505, 988174900, 991996278, 995782645, 1000423964, 1009583766, 1017272109, 1017903906, 1038431785, 1044314085, 1056398940, 1058556349, 1064962957, 1067353468, 1067357253, 1071652316, 1073261442, 1077161946, 1092025094, 1092618700, 1095153638, 1103411471, 1103412149, 1103412813, 1103632842, 1113577955, 1113806382, 1125591926, 1128071231, 1130349238, 1130993268, 1135318098, 1139455590, 1145832639, 1146110508, 1146992036, 1164511439, 1167196336, 1167273324, 1169404244, 1169404245, 1169404290, 1171019533, 1181037546, 1201193224, 1202720490, 1204816148, 1213612268, 1214305123, 1221903417, 1224789183, 1224901875, 1225695065, 1226642473, 1227192201, 1228056441, 1236167740, 1238832007, 1246202602, 1247172262, 1247577163, 1247875546, 1250764039, 1256528074, 1257939113, 1263960794, 1274418078, 1280549057, 1280845662, 1281239699, 1282943179, 1282994352, 1285881495, 1287611624, 1290819452, 1291436593, 1291834546, 1308676315, 1309131464, 1313416798, 1313416818, 1322780398, 1327133892, 1338359406, 1348037855, 1351924992, 1352786672, 1358280002, 1360649653, 1370130130, 1372404981, 1381630732, 1383129149, 1389717187, 1395555037, 1398464674, 1411243328, 1418202869, 1431819701, 1436822557, 1438772882, 1447110455, 1451606466, 1453603254, 1464990208, 1474051423, 1477705569, 1487452686, 1490504312, 1490863419, 1491609114, 1506867806, 1511295011, 1522515086, 1525593974, 1532710347, 1535697261, 1537812987, 1546852840, 1547539107, 1555261035, 1561111191, 1571710708, 1572402806, 1572466393, 1579213401, 1585320842, 1589344843, 1598111973, 1606060382, 1608401838, 1608401840, 1608401841, 1614780307, 1620824029, 1621420777, 1623148745, 1632261568, 1633548583, 1638974175, 1639293562, 1642336535, 1648581351, 1658629475, 1659886955, 1669782719, 1677147340, 1682427764, 1684565497, 1685626577, 1687786263, 1696609403, 1698677367, 1703400886, 1704893984, 1705629508, 1711396826, 1716883657, 1719859607, 1728038601, 1728038602, 1738768695, 1752889312, 1763375486, 1768617329, 1783290959, 1809325428, 1811518261, 1817375453, 1830310359, 1832984000, 1837691388, 1838079732, 1850903718, 1854114270, 1856599795, 1858910450, 1860022104, 1915412854, 1916009602, 1918313688, 1923993874, 1934413114, 1941325953, 1953090167, 1973282887, 1981972957, 1991781798, 2004716271, 2005494788, 2012313602, 2022294396, 2025055113, 2046146991, 2048392659, 2054707467, 2082663554, 2084740880, 2089175046, 2095474079, 2107178752, 2122333237, 2127021138};
		
		protected static string[] fields = new string[]{"b", "i", "br", "f_", "q_", "next_off", "Set", "__a", "arr", "cb_", "get", "idx", "len", "map", "pop", "pos", "set", "first", "num_direct_distance_codes", "histograms_", "space", "BrotliMemOutputFunction", "dist_cache_", "num_literal_htrees", "flags", "readAll", "mask_", "getEnumConstructs", "compress", "start", "state", "remove", "filter", "insert_length", "prev_byte1", "prev_byte2", "prev_byte_", "enable_transforms", "repeat", "GetBrotliStorage", "cmd_prefix_", "dist_context_offset", "length_", "lengths", "context_modes_off", "resize", "tail_size_", "command_histograms", "context_map_table", "WriteBrotliData", "length_prefix", "table", "min_block_size_", "block_type_rb", "DistanceContext", "literal_cost_mask_", "num_commands_", "ringbuffer_end", "ringbuffer_off", "block_len_trees", "getString", "distance_context_map", "readBytes", "range_idx", "kDataSize", "dist_context_map", "last_flush_pos_", "merge_last_count_", "max_block_types_", "GetCommandCost", "num_blocks_", "stream", "block_lengths_", "methodName", "dist_rb_idx", "num_dist_htrees", "num_types", "FindLongestMatch", "SortHuffmanTree", "iterator", "data_off", "literal_cost_", "htrees_decoded", "lastIndexOf", "prev_code_len", "copy_length", "total_count_", "trivial_literal_context", "nbits", "Store", "context_index", "distance_histograms", "Command0", "Command1", "Command4", "num_block_types", "hasNext", "dist_extra_", "distance_split", "ringbuffer_", "type_", "types", "reverse", "input_end", "input_", "suffix", "nOccupied", "getBytes", "meta_block_remaining_len", "ringbuffer_end_off", "insert", "hashers_", "loop_counter", "num_block_types_", "htree_index", "copy_dst_off", "length", "BuildAndStoreEntropyCodes", "last_insert_len_", "block_type_trees", "dist_context_map_slice_off", "cost_combo", "ringbuffer_mask", "code_length_code_lengths", "input_block_size", "BrotliSetCustomDictionary", "context_offset", "kUseDictionary", "symbols_", "buffer_off", "type_bits", "literal_htree_index", "type_code", "dist_context_map_slice", "ringbuffer_size", "SetFromLiteralCosts", "BrotliFileInputFunction", "finish_", "distance_code", "max_distance", "insert_code", "hash_h1", "hash_h2", "hash_h3", "hash_h4", "hash_h5", "hash_h6", "hash_h7", "hash_h8", "hash_h9", "block_types_", "htrees", "Add1", "Add2", "context_map_slice_off", "buf_ptr_", "AddHistogram", "buf_off", "cmd_buffer_size_", "prefix", "prev_byte2_", "hgroup", "block_split_code_", "insert_len_", "max_backward_distance_", "Init", "kBucketBits", "enable_dictionary", "context_map", "buffer_", "valid", "value", "cost_dist_", "bits_", "Next", "num_dict_matches_", "Push", "charCodeAt", "Read", "cachedIndex", "FindAllMatches", "last_histogram_ix_", "toString", "hash_type_", "nbytes", "Remove", "literal_context_map", "HistogramPairComparator", "HistogramTypeInt", "cmd_extra_", "simple_code_or_skip", "num_distance_codes", "custom_dict_size", "kBucketSize", "GetLiteralCosts", "DistanceCode", "dist_rb", "last_processed_pos_", "block_len_", "_eof", "tmp_bytes_read_", "splice", "split_", "exists", "entropy_ix_", "FinishBlock", "bits", "buf_", "WriteMetaBlockInternal", "comp", "copy", "cost", "window_bits_", "WarmupHashHashLongestMatchQuickly", "date", "eos_", "length_bits", "max_backward_distance", "custom_dict_off", "cmd_code", "length_code", "quality", "block_type", "is_metadata", "is_uncompressed", "ringbuffer", "transform", "idx1", "idx2", "idx_", "alphabet_size", "join", "kBlockBits", "len_", "concat", "mask", "mode", "AddSymbol", "buffer_size_", "next", "num_", "literal_costs_", "length_depths", "enumConstructor", "max_run_length_prefix", "writeByte", "min_cost_cmd_", "codes", "pos_", "push", "bubbleUp", "literal_split", "position", "index_right_or_value_", "target_block_size_", "size", "sort", "swap", "quicksort", "count_", "commands_", "GetStartPos", "context_map_off", "tell", "alphabet_size_", "length_nextra", "HuffmanTree3", "val_", "vals", "kBlockMask", "storage_", "last_byte_", "write", "buffer", "spliceVoid", "num_literals_", "PrependCustomDictionary", "sub_state", "window_bits", "writeBytes", "bit_pos_", "kBlockSize", "cachedKey", "getEnumName", "bit_cost_", "data_", "createEnumIndex", "createEnum", "htree_command", "length_extra", "num_contexts_", "block_type_rb_index", "kNumLastDistancesToCheck", "literal_histograms", "bit_end_pos_", "bubbleDown", "distance_cache", "copy_dst", "copy_src", "block_ix_", "decompress", "length_and_code", "buckets_", "concatNative", "Clear", "nBuckets", "curr_histogram_ix_", "className", "code_lengths_off", "compressArray", "SetFromCommands", "decompressArray", "split_threshold_", "params_", "copy_src_off", "index_left_", "enable_context_modeling", "BuildAndStoreBlockSwitchEntropyCodes", "BackwardMatch0", "BackwardMatch2", "BackwardMatch3", "offset", "__unsafe_get", "__unsafe_set", "indexOf", "CopyInputToRingBuffer", "repeat_code_len", "BrotliMemInputFunction", "lookup", "last_entropy_", "fileName", "dist_context_map_off", "last_byte_bits_", "Write", "block_size_", "second", "StoreSymbol", "GetMinCostCmd", "cost_cmd_", "code_lengths", "cost_diff", "num_dict_lookups_", "context_modes", "toDynamic", "distance_postfix_bits", "greedy_block_split", "WarmupHashHashLongestMatch", "context_lookup_offset1", "context_lookup_offset2", "copy_code", "input_pos_", "readByte", "allEnums", "depths_", "dist_prefix_", "distance", "htrees_off", "customParams", "distance_postfix_mask", "depth_", "copy_len_", "partially_written", "saved_dist_cache_", "context_mode", "lgblock", "symbol", "__get", "__set", "block_length", "buf_ptr_off", "storage_size_", "lgwin", "kBucketSweep", "BrotliFileOutputFunction", "lineNumber", "command_split", "WriteTail", "custom_dict", "htree_command_off", "upperBound", "unshift", "Reset", "_keys", "enumParameters", "shift", "StoreSymbolWithContext", "num_htrees", "context_map_slice", "dist_htree_index", "type_depths", "slice"};
		
		protected static int length;
		
		public static void addFields(int[] nids, string[] nfields) {
			unchecked {
				int[] cids = global::haxe.lang.FieldLookup.fieldIds;
				string[] cfields = global::haxe.lang.FieldLookup.fields;
				int nlen = ( nids as global::System.Array ).Length;
				int clen = global::haxe.lang.FieldLookup.length;
				if (( ( nfields as global::System.Array ).Length != nlen )) {
					throw global::haxe.lang.HaxeException.wrap(global::haxe.lang.Runtime.concat(global::haxe.lang.Runtime.concat(global::haxe.lang.Runtime.concat("Different fields length: ", global::haxe.lang.Runtime.toString(nlen)), " and "), global::haxe.lang.Runtime.toString(( nfields as global::System.Array ).Length)));
				}
				
				bool needsChange = false;
				{
					uint _g_idx = default(uint);
					int[] _g_arr = nids;
					_g_idx = ((uint) (0) );
					while (((bool) (( _g_idx < ( _g_arr as global::System.Array ).Length )) )) {
						if (( global::haxe.lang.FieldLookup.findHash(((int) (_g_arr[((int) (_g_idx++) )]) ), cids, clen) < 0 )) {
							needsChange = true;
							break;
						}
						
					}
					
				}
				
				if (needsChange) {
					lock(typeof(global::haxe.lang.FieldLookup)){
						int[] ansIds = new int[( clen + nlen )];
						string[] ansFields = new string[( clen + nlen )];
						int ci = 0;
						int ni = 0;
						int ansi = 0;
						while (true) {
							if ( ! ((( (( ci < clen )) ? (( ni < nlen )) : (false) ))) ) {
								break;
							}
							
							if (( cids[ci] < nids[ni] )) {
								ansIds[ansi] = cids[ci];
								ansFields[ansi] = cfields[ci];
								ci = ( ci + 1 );
							}
							else {
								ansIds[ansi] = nids[ni];
								ansFields[ansi] = nfields[ni];
								ni = ( ni + 1 );
							}
							
							ansi = ( ansi + 1 );
						}
						
						if (( ci < clen )) {
							global::System.Array.Copy(((global::System.Array) (cids) ), ((int) (ci) ), ((global::System.Array) (ansIds) ), ((int) (ansi) ), ((int) (( clen - ci )) ));
							global::System.Array.Copy(((global::System.Array) (cfields) ), ((int) (ci) ), ((global::System.Array) (ansFields) ), ((int) (ansi) ), ((int) (( clen - ci )) ));
							ansi = ( ansi + (( clen - ci )) );
						}
						
						if (( ni < nlen )) {
							global::System.Array.Copy(((global::System.Array) (nids) ), ((int) (ni) ), ((global::System.Array) (ansIds) ), ((int) (ansi) ), ((int) (( nlen - ni )) ));
							global::System.Array.Copy(((global::System.Array) (nfields) ), ((int) (ni) ), ((global::System.Array) (ansFields) ), ((int) (ansi) ), ((int) (( nlen - ni )) ));
							ansi = ( ansi + (( nlen - ni )) );
						}
						
						global::haxe.lang.FieldLookup.fieldIds = ansIds;
						global::haxe.lang.FieldLookup.fields = ansFields;
						global::haxe.lang.FieldLookup.length = ansi;
					}
					;
				}
				
			}
		}
		
		
		public static int doHash(string s) {
			unchecked {
				int acc = 0;
				{
					int _g1 = 0;
					int _g = s.Length;
					while (( _g1 < _g )) {
						acc = ( ( ( 223 * (( acc >> 1 )) ) + ((int) (s[_g1++]) ) ) << 1 );
					}
					
				}
				
				return ((int) (( ((uint) (acc) ) >> 1 )) );
			}
		}
		
		
		public static string lookupHash(int key) {
			unchecked {
				int[] ids = global::haxe.lang.FieldLookup.fieldIds;
				int min = 0;
				int max = global::haxe.lang.FieldLookup.length;
				while (( min < max )) {
					int mid = ( min + ( (( max - min )) / 2 ) );
					int imid = ids[mid];
					if (( key < imid )) {
						max = mid;
					}
					else if (( key > imid )) {
						min = ( mid + 1 );
					}
					else {
						return global::haxe.lang.FieldLookup.fields[mid];
					}
					
				}
				
				throw global::haxe.lang.HaxeException.wrap(global::haxe.lang.Runtime.concat("Field not found for hash ", global::haxe.lang.Runtime.toString(key)));
			}
		}
		
		
		public static int hash(string s) {
			unchecked {
				if (string.Equals(s, null)) {
					return 0;
				}
				
				int acc = 0;
				{
					int _g1 = 0;
					int _g = s.Length;
					while (( _g1 < _g )) {
						acc = ( ( ( 223 * (( acc >> 1 )) ) + ((int) (s[_g1++]) ) ) << 1 );
					}
					
				}
				
				int key = ((int) (( ((uint) (acc) ) >> 1 )) );
				int[] ids = global::haxe.lang.FieldLookup.fieldIds;
				string[] fld = global::haxe.lang.FieldLookup.fields;
				int min = 0;
				int max = global::haxe.lang.FieldLookup.length;
				int len = global::haxe.lang.FieldLookup.length;
				while (( min < max )) {
					int mid = ((int) (( min + ( ((double) ((( max - min ))) ) / 2 ) )) );
					int imid = ids[mid];
					if (( key < imid )) {
						max = mid;
					}
					else if (( key > imid )) {
						min = ( mid + 1 );
					}
					else {
						if ( ! (string.Equals(fld[mid], s)) ) {
							return  ~ (key) ;
						}
						
						return key;
					}
					
				}
				
				lock(typeof(global::haxe.lang.FieldLookup)){
					if (( len != global::haxe.lang.FieldLookup.length )) {
						return global::haxe.lang.FieldLookup.hash(s);
					}
					
					global::haxe.lang.FieldLookup.insert<int>(ref global::haxe.lang.FieldLookup.fieldIds, ((int) (global::haxe.lang.FieldLookup.length) ), ((int) (min) ), ((int) (key) ));
					global::haxe.lang.FieldLookup.insert<string>(ref global::haxe.lang.FieldLookup.fields, ((int) (global::haxe.lang.FieldLookup.length) ), ((int) (min) ), ((string) (s) ));
					 ++ global::haxe.lang.FieldLookup.length;
				}
				;
				return key;
			}
		}
		
		
		public static int findHash(int hash, int[] hashs, int length) {
			unchecked {
				int min = 0;
				int max = length;
				while (( min < max )) {
					int mid = ( (( max + min )) / 2 );
					int imid = hashs[mid];
					if (( hash < imid )) {
						max = mid;
					}
					else if (( hash > imid )) {
						min = ( mid + 1 );
					}
					else {
						return mid;
					}
					
				}
				
				return  ~ (min) ;
			}
		}
		
		
		public static void @remove<T>(T[] a, int length, int pos) {
			unchecked {
				global::System.Array.Copy(((global::System.Array) (a) ), ((int) (( pos + 1 )) ), ((global::System.Array) (a) ), ((int) (pos) ), ((int) (( ( length - pos ) - 1 )) ));
				a[( length - 1 )] = default(T);
			}
		}
		
		
		public static void insert<T>(ref T[] a, int length, int pos, T x) {
			unchecked {
				int capacity = ( a as global::System.Array ).Length;
				if (( pos == length )) {
					if (( capacity == length )) {
						T[] newarr = new T[( (( length << 1 )) + 1 )];
						( a as global::System.Array ).CopyTo(((global::System.Array) (newarr) ), ((int) (0) ));
						a = ((T[]) (newarr) );
					}
					
				}
				else if (( pos == 0 )) {
					if (( capacity == length )) {
						T[] newarr1 = new T[( (( length << 1 )) + 1 )];
						global::System.Array.Copy(((global::System.Array) (a) ), ((int) (0) ), ((global::System.Array) (newarr1) ), ((int) (1) ), ((int) (length) ));
						a = ((T[]) (newarr1) );
					}
					else {
						global::System.Array.Copy(((global::System.Array) (a) ), ((int) (0) ), ((global::System.Array) (a) ), ((int) (1) ), ((int) (length) ));
					}
					
				}
				else if (( capacity == length )) {
					T[] newarr2 = new T[( (( length << 1 )) + 1 )];
					global::System.Array.Copy(((global::System.Array) (a) ), ((int) (0) ), ((global::System.Array) (newarr2) ), ((int) (0) ), ((int) (pos) ));
					global::System.Array.Copy(((global::System.Array) (a) ), ((int) (pos) ), ((global::System.Array) (newarr2) ), ((int) (( pos + 1 )) ), ((int) (( length - pos )) ));
					a = ((T[]) (newarr2) );
				}
				else {
					global::System.Array.Copy(((global::System.Array) (a) ), ((int) (pos) ), ((global::System.Array) (a) ), ((int) (( pos + 1 )) ), ((int) (( length - pos )) ));
					global::System.Array.Copy(((global::System.Array) (a) ), ((int) (0) ), ((global::System.Array) (a) ), ((int) (0) ), ((int) (pos) ));
				}
				
				a[pos] = x;
			}
		}
		
		
		public static global::haxe.lang.FieldHashConflict getHashConflict(global::haxe.lang.FieldHashConflict head, int hash, string name) {
			while (( head != null )) {
				if (( ( head.hash == hash ) && string.Equals(head.name, name) )) {
					return head;
				}
				
				head = head.next;
			}
			
			return null;
		}
		
		
		public static void setHashConflict(ref global::haxe.lang.FieldHashConflict head, int hash, string name, object @value) {
			global::haxe.lang.FieldHashConflict node = head;
			while (( node != null )) {
				if (( ( node.hash == hash ) && string.Equals(node.name, name) )) {
					node.@value = @value;
					return;
				}
				
				node = ((global::haxe.lang.FieldHashConflict) (node.next) );
			}
			
			head = ((global::haxe.lang.FieldHashConflict) (new global::haxe.lang.FieldHashConflict(hash, name, @value, ((global::haxe.lang.FieldHashConflict) (head) ))) );
		}
		
		
		public static bool deleteHashConflict(ref global::haxe.lang.FieldHashConflict head, int hash, string name) {
			if (( head == null )) {
				return false;
			}
			
			if (( ( head.hash == hash ) && string.Equals(head.name, name) )) {
				head = ((global::haxe.lang.FieldHashConflict) (head.next) );
				return true;
			}
			
			global::haxe.lang.FieldHashConflict prev = head;
			global::haxe.lang.FieldHashConflict node = head.next;
			while (( node != null )) {
				if (( ( node.hash == hash ) && string.Equals(node.name, name) )) {
					prev.next = node.next;
					return true;
				}
				
				node = node.next;
			}
			
			return false;
		}
		
		
		public static void addHashConflictNames(global::haxe.lang.FieldHashConflict head, global::Array<object> arr) {
			while (( head != null )) {
				arr.push(head.name);
				head = head.next;
			}
			
		}
		
		
	}
}


