// Generated by Haxe 3.4.0

#pragma warning disable 109, 114, 219, 429, 168, 162
namespace encode.encode {
	public class BrotliCompressor : global::haxe.lang.HxObject {
		
		public BrotliCompressor(global::haxe.lang.EmptyObject empty) {
		}
		
		
		public BrotliCompressor(global::encode.encode.BrotliParams @params) {
			global::encode.encode.BrotliCompressor.__hx_ctor_encode_encode_BrotliCompressor(this, @params);
		}
		
		
		public static void __hx_ctor_encode_encode_BrotliCompressor(global::encode.encode.BrotliCompressor __hx_this, global::encode.encode.BrotliParams @params) {
			unchecked {
				{
					int[] this1 = null;
					this1 = new int[4];
					__hx_this.saved_dist_cache_ = ((int[]) (this1) );
				}
				
				{
					int[] this1 = null;
					this1 = new int[4];
					__hx_this.dist_cache_ = ((int[]) (this1) );
				}
				
				__hx_this.params_ = @params;
				__hx_this.hashers_ = new global::encode.hash.Hashers();
				__hx_this.input_pos_ = 0;
				__hx_this.num_commands_ = 0;
				__hx_this.num_literals_ = 0;
				__hx_this.last_insert_len_ = 0;
				__hx_this.last_flush_pos_ = 0;
				__hx_this.last_processed_pos_ = 0;
				__hx_this.prev_byte_ = ((uint) (0) );
				__hx_this.prev_byte2_ = ((uint) (0) );
				__hx_this.storage_size_ = 0;
				double tmp = global::System.Math.Max(((double) (1) ), ((double) (__hx_this.params_.quality) ));
				__hx_this.params_.quality = ((int) (tmp) );
				if (( __hx_this.params_.lgwin < global::encode.Encode.kMinWindowBits )) {
					__hx_this.params_.lgwin = global::encode.Encode.kMinWindowBits;
				}
				else if (( __hx_this.params_.lgwin > global::encode.Encode.kMaxWindowBits )) {
					__hx_this.params_.lgwin = global::encode.Encode.kMaxWindowBits;
				}
				
				if (( __hx_this.params_.lgblock == 0 )) {
					__hx_this.params_.lgblock = ( (( __hx_this.params_.quality < global::encode.Encode.kMinQualityForBlockSplit )) ? (14) : (16) );
					if (( ( __hx_this.params_.quality >= 9 ) && ( __hx_this.params_.lgwin > __hx_this.params_.lgblock ) )) {
						double tmp1 = global::System.Math.Min(((double) (21) ), ((double) (__hx_this.params_.lgwin) ));
						__hx_this.params_.lgblock = ((int) (tmp1) );
					}
					
				}
				else {
					double tmp2 = global::System.Math.Min(((double) (global::encode.Encode.kMaxInputBlockBits) ), ((double) (global::System.Math.Max(((double) (global::encode.Encode.kMinInputBlockBits) ), ((double) (__hx_this.params_.lgblock) ))) ));
					__hx_this.params_.lgblock = ((int) (tmp2) );
				}
				
				__hx_this.max_backward_distance_ = ( (( 1 << __hx_this.params_.lgwin )) - 16 );
				__hx_this.ringbuffer_ = new global::encode.RingBuffer(((int) (global::System.Math.Max(((double) (( __hx_this.params_.lgwin + 1 )) ), ((double) (( __hx_this.params_.lgblock + 1 )) ))) ), __hx_this.params_.lgblock);
				if (( __hx_this.params_.quality > 9 )) {
					__hx_this.literal_cost_mask_ = ( (( 1 << __hx_this.params_.lgblock )) - 1 );
					__hx_this.literal_cost_ = global::FunctionMalloc.mallocFloat(( __hx_this.literal_cost_mask_ + 1 ));
				}
				
				__hx_this.cmd_buffer_size_ = ((int) (global::System.Math.Max(((double) (262144) ), ((double) (( 1 << __hx_this.params_.lgblock )) ))) );
				__hx_this.commands_ = new global::Array<object>();
				if (( __hx_this.params_.lgwin == 16 )) {
					__hx_this.last_byte_ = ((uint) (0) );
					__hx_this.last_byte_bits_ = ((uint) (1) );
				}
				else if (( __hx_this.params_.lgwin == 17 )) {
					__hx_this.last_byte_ = ((uint) (1) );
					__hx_this.last_byte_bits_ = ((uint) (7) );
				}
				else {
					__hx_this.last_byte_ = ((uint) (( ( ( __hx_this.params_.lgwin - 17 ) << 1 ) | 1 )) );
					__hx_this.last_byte_bits_ = ((uint) (4) );
				}
				
				((int[]) (__hx_this.dist_cache_) )[0] = 4;
				((int[]) (__hx_this.dist_cache_) )[1] = 11;
				((int[]) (__hx_this.dist_cache_) )[2] = 15;
				((int[]) (__hx_this.dist_cache_) )[3] = 16;
				global::DefaultFunctions.memcpy_Int(__hx_this.saved_dist_cache_, 0, __hx_this.dist_cache_, 0, ( ((int[]) (__hx_this.dist_cache_) ) as global::System.Array ).Length);
				__hx_this.hash_type_ = ((int) (global::System.Math.Min(((double) (9) ), ((double) (__hx_this.params_.quality) ))) );
				__hx_this.hashers_.Init(__hx_this.hash_type_);
			}
		}
		
		
		public virtual uint[] GetBrotliStorage(int size) {
			if (( this.storage_size_ < size )) {
				this.storage_ = global::FunctionMalloc.mallocUInt(size);
				this.storage_size_ = size;
			}
			
			return this.storage_;
		}
		
		
		public virtual int input_block_size() {
			unchecked {
				return ( 1 << this.params_.lgblock );
			}
		}
		
		
		public global::encode.encode.BrotliParams params_;
		
		public int max_backward_distance_;
		
		public global::encode.hash.Hashers hashers_;
		
		public int hash_type_;
		
		public int input_pos_;
		
		public global::encode.RingBuffer ringbuffer_;
		
		public double[] literal_cost_;
		
		public int literal_cost_mask_;
		
		public int cmd_buffer_size_;
		
		public global::Array<object> commands_;
		
		public int num_commands_;
		
		public int num_literals_;
		
		public int last_insert_len_;
		
		public int last_flush_pos_;
		
		public int last_processed_pos_;
		
		public int[] dist_cache_;
		
		public int[] saved_dist_cache_;
		
		public uint last_byte_;
		
		public uint last_byte_bits_;
		
		public uint prev_byte_;
		
		public uint prev_byte2_;
		
		public int storage_size_;
		
		public uint[] storage_;
		
		public virtual void CopyInputToRingBuffer(int input_size, uint[] input_buffer) {
			unchecked {
				this.ringbuffer_.Write(input_buffer, input_size);
				this.input_pos_ += input_size;
				int pos = this.ringbuffer_.position();
				if (( pos <= this.ringbuffer_.mask() )) {
					global::DefaultFunctions.memset_UInt(this.ringbuffer_.start(), pos, ((uint) (0) ), 3);
				}
				
			}
		}
		
		
		public virtual void BrotliSetCustomDictionary(int size, uint[] dict) {
			unchecked {
				this.CopyInputToRingBuffer(size, dict);
				this.last_flush_pos_ = size;
				this.last_processed_pos_ = size;
				if (( size > 0 )) {
					this.prev_byte_ = ((uint) (((uint[]) (dict) )[( size - 1 )]) );
				}
				
				if (( size > 1 )) {
					this.prev_byte2_ = ((uint) (((uint[]) (dict) )[( size - 2 )]) );
				}
				
				this.hashers_.PrependCustomDictionary(this.hash_type_, size, dict);
			}
		}
		
		
		public virtual bool WriteBrotliData(bool is_last, bool force_flush, global::Array<int> out_size, global::Array<object> output) {
			unchecked {
				int bytes = ( this.input_pos_ - this.last_processed_pos_ );
				uint[] data = this.ringbuffer_.start();
				int mask = this.ringbuffer_.mask();
				if (( bytes > this.input_block_size() )) {
					return false;
				}
				
				bool utf8_mode = ( ( this.params_.quality >= 9 ) && global::encode.Encode.IsMostlyUTF8(data, ( this.last_processed_pos_ & mask ), bytes, global::encode.Encode.kMinUTF8Ratio) );
				if (( this.literal_cost_ != null )) {
					if (utf8_mode) {
						global::encode.Literal_cost.EstimateBitCostsForLiteralsUTF8(this.last_processed_pos_, bytes, mask, this.literal_cost_mask_, data, this.literal_cost_);
					}
					else {
						global::encode.Literal_cost.EstimateBitCostsForLiterals(this.last_processed_pos_, bytes, mask, this.literal_cost_mask_, data, this.literal_cost_);
					}
					
				}
				
				global::Array<int> last_insert_len = new global::Array<int>(new int[]{this.last_insert_len_});
				global::Array<int> num_commands = new global::Array<int>(new int[]{this.num_commands_});
				global::Array<int> num_literals = new global::Array<int>(new int[]{this.num_literals_});
				global::encode.Backward_references.CreateBackwardReferences(bytes, this.last_processed_pos_, data, mask, this.literal_cost_, this.literal_cost_mask_, this.max_backward_distance_, this.params_.quality, this.hashers_, this.hash_type_, this.dist_cache_, last_insert_len, this.commands_, num_commands[0], num_commands, num_literals);
				this.last_insert_len_ = last_insert_len[0];
				this.num_commands_ = num_commands[0];
				this.num_literals_ = num_literals[0];
				int max_length = ((int) (global::System.Math.Min(((double) (( mask + 1 )) ), ((double) (( 1 << global::encode.Encode.kMaxInputBlockBits )) ))) );
				if (( ( ( (  ! (is_last)  &&  ! (force_flush)  ) && (( ( this.params_.quality >= global::encode.Encode.kMinQualityForBlockSplit ) || ( ( this.num_literals_ + this.num_commands_ ) < 12287 ) )) ) && ( ( this.num_commands_ + (( this.input_block_size() >> 1 )) ) < this.cmd_buffer_size_ ) ) && ( ( this.input_pos_ + this.input_block_size() ) <= ( this.last_flush_pos_ + max_length ) ) )) {
					this.last_processed_pos_ = this.input_pos_;
					out_size[0] = 0;
					return true;
				}
				
				if (( this.last_insert_len_ > 0 )) {
					global::encode.command.Command command = new global::encode.command.Command();
					command.Command1(this.last_insert_len_);
					this.commands_[this.num_commands_++] = command;
					this.num_literals_ += this.last_insert_len_;
					this.last_insert_len_ = 0;
				}
				
				return this.WriteMetaBlockInternal(is_last, utf8_mode, out_size, output);
			}
		}
		
		
		public virtual bool WriteMetaBlockInternal(bool is_last, bool utf8_mode, global::Array<int> out_size, global::Array<object> output) {
			unchecked {
				int bytes = ( this.input_pos_ - this.last_flush_pos_ );
				uint[] data = this.ringbuffer_.start();
				int mask = this.ringbuffer_.mask();
				uint[] storage = this.GetBrotliStorage(( ( 2 * bytes ) + 500 ));
				((uint[]) (storage) )[0] = this.last_byte_;
				global::Array<int> storage_ix = new global::Array<int>(new int[]{((int) (this.last_byte_bits_) )});
				bool uncompressed = false;
				if (( this.num_commands_ < ( (( bytes >> 8 )) + 2 ) )) {
					if (( this.num_literals_ > ( 0.99 * bytes ) )) {
						int[] literal_histo = global::FunctionMalloc.mallocInt(256);
						double kBitCostThreshold = ( ( bytes * 7.92 ) / 13 );
						int i = this.last_flush_pos_;
						while (( i < this.input_pos_ )) {
							{
								uint _g = ((uint) (((uint[]) (data) )[( i & mask )]) );
								((int[]) (literal_histo) )[((int) (_g) )] = ( ((int) (((int[]) (literal_histo) )[((int) (_g) )]) ) + 1 );
							}
							
							i += 13;
						}
						
						if (( global::encode.Bit_cost.BitsEntropy(literal_histo, 0, 256) > kBitCostThreshold )) {
							uncompressed = true;
						}
						
					}
					
				}
				
				if (( bytes == 0 )) {
					if ( ! (global::encode.Brotli_bit_stream.StoreCompressedMetaBlockHeader(is_last, 0, storage_ix, storage)) ) {
						return false;
					}
					
					storage_ix[0] = ( ( storage_ix[0] + 7 ) & -8 );
				}
				else if (uncompressed) {
					global::DefaultFunctions.memcpy_Int(this.dist_cache_, 0, this.saved_dist_cache_, 0, ( ((int[]) (this.dist_cache_) ) as global::System.Array ).Length);
					if ( ! (global::encode.Brotli_bit_stream.StoreUncompressedMetaBlock(is_last, data, this.last_flush_pos_, mask, bytes, storage_ix, storage, 0)) ) {
						return false;
					}
					
				}
				else {
					int num_direct_distance_codes = 0;
					int distance_postfix_bits = 0;
					if (( ( this.params_.quality > 9 ) && ( this.params_.mode == ((int) (2) ) ) )) {
						num_direct_distance_codes = 12;
						distance_postfix_bits = 1;
						global::encode.Encode.RecomputeDistancePrefixes(this.commands_, this.num_commands_, 12, 1);
					}
					
					if (( this.params_.quality < global::encode.Encode.kMinQualityForBlockSplit )) {
						if ( ! (global::encode.Brotli_bit_stream.StoreMetaBlockTrivial(data, this.last_flush_pos_, bytes, mask, is_last, this.commands_, this.num_commands_, storage_ix, storage, 0)) ) {
							return false;
						}
						
					}
					else {
						global::encode.metablock.MetaBlockSplit mb = new global::encode.metablock.MetaBlockSplit();
						global::Array<int> literal_context_mode = new global::Array<int>(new int[]{( (utf8_mode) ? (2) : (3) )});
						if (( this.params_.quality <= 9 )) {
							global::Array<int> num_literal_contexts = new global::Array<int>(new int[]{1});
							global::Array<object> literal_context_map = new global::Array<object>(new object[]{new global::Array<int>(new int[]{-1})});
							global::encode.Encode.DecideOverLiteralContextModeling(data, this.last_flush_pos_, bytes, mask, this.params_.quality, literal_context_mode, num_literal_contexts, literal_context_map);
							if (( ((global::Array<int>) (global::Array<object>.__hx_cast<int>(((global::Array) (literal_context_map[0]) ))) )[0] == -1 )) {
								global::encode.Metablock.BuildMetaBlockGreedy(data, this.last_flush_pos_, mask, this.commands_, this.num_commands_, mb);
							}
							else {
								global::encode.Metablock.BuildMetaBlockGreedyWithContexts(data, this.last_flush_pos_, mask, this.prev_byte_, this.prev_byte2_, literal_context_mode[0], num_literal_contexts[0], ((global::Array<int>) (global::Array<object>.__hx_cast<int>(((global::Array) (literal_context_map[0]) ))) ), this.commands_, this.num_commands_, mb);
							}
							
						}
						else {
							global::encode.Metablock.BuildMetaBlock(data, this.last_flush_pos_, mask, this.prev_byte_, this.prev_byte2_, this.commands_, this.num_commands_, literal_context_mode[0], mb);
						}
						
						if (( this.params_.quality >= global::encode.Encode.kMinQualityForOptimizeHistograms )) {
							global::encode.Metablock.OptimizeHistograms(num_direct_distance_codes, distance_postfix_bits, mb);
						}
						
						if ( ! (global::encode.Brotli_bit_stream.StoreMetaBlock(data, this.last_flush_pos_, bytes, mask, this.prev_byte_, this.prev_byte2_, is_last, num_direct_distance_codes, distance_postfix_bits, literal_context_mode[0], this.commands_, this.num_commands_, mb, storage_ix, storage)) ) {
							return false;
						}
						
					}
					
					if (( ( bytes + 4 ) < ( storage_ix[0] >> 3 ) )) {
						global::DefaultFunctions.memcpy_Int(this.dist_cache_, 0, this.saved_dist_cache_, 0, ( ((int[]) (this.dist_cache_) ) as global::System.Array ).Length);
						((uint[]) (storage) )[0] = this.last_byte_;
						storage_ix[0] = ((int) (this.last_byte_bits_) );
						if ( ! (global::encode.Brotli_bit_stream.StoreUncompressedMetaBlock(is_last, data, this.last_flush_pos_, mask, bytes, storage_ix, storage, 0)) ) {
							return false;
						}
						
					}
					
				}
				
				this.last_byte_ = ((uint) (((uint[]) (storage) )[( storage_ix[0] >> 3 )]) );
				this.last_byte_bits_ = ((uint) (( storage_ix[0] & 7 )) );
				this.last_flush_pos_ = this.input_pos_;
				this.last_processed_pos_ = this.input_pos_;
				this.prev_byte_ = ((uint[]) (data) )[( ( this.last_flush_pos_ - 1 ) & mask )];
				this.prev_byte2_ = ((uint[]) (data) )[( ( this.last_flush_pos_ - 2 ) & mask )];
				this.num_commands_ = 0;
				this.num_literals_ = 0;
				global::DefaultFunctions.memcpy_Int(this.saved_dist_cache_, 0, this.dist_cache_, 0, ( ((int[]) (this.dist_cache_) ) as global::System.Array ).Length);
				output[0] = storage;
				out_size[0] = ( storage_ix[0] >> 3 );
				return true;
			}
		}
		
		
		public override double __hx_setField_f(string field, int hash, double @value, bool handleProperties) {
			unchecked {
				switch (hash) {
					case 1934413114:
					{
						this.storage_size_ = ((int) (@value) );
						return @value;
					}
					
					
					case 786269185:
					{
						this.prev_byte2_ = ((uint) (@value) );
						return @value;
					}
					
					
					case 90195659:
					{
						this.prev_byte_ = ((uint) (@value) );
						return @value;
					}
					
					
					case 1659886955:
					{
						this.last_byte_bits_ = ((uint) (@value) );
						return @value;
					}
					
					
					case 1338359406:
					{
						this.last_byte_ = ((uint) (@value) );
						return @value;
					}
					
					
					case 1044314085:
					{
						this.last_processed_pos_ = ((int) (@value) );
						return @value;
					}
					
					
					case 282430831:
					{
						this.last_flush_pos_ = ((int) (@value) );
						return @value;
					}
					
					
					case 537950791:
					{
						this.last_insert_len_ = ((int) (@value) );
						return @value;
					}
					
					
					case 1358280002:
					{
						this.num_literals_ = ((int) (@value) );
						return @value;
					}
					
					
					case 204352542:
					{
						this.num_commands_ = ((int) (@value) );
						return @value;
					}
					
					
					case 770104548:
					{
						this.cmd_buffer_size_ = ((int) (@value) );
						return @value;
					}
					
					
					case 194189137:
					{
						this.literal_cost_mask_ = ((int) (@value) );
						return @value;
					}
					
					
					case 1752889312:
					{
						this.input_pos_ = ((int) (@value) );
						return @value;
					}
					
					
					case 953005556:
					{
						this.hash_type_ = ((int) (@value) );
						return @value;
					}
					
					
					case 812293353:
					{
						this.max_backward_distance_ = ((int) (@value) );
						return @value;
					}
					
					
					default:
					{
						return base.__hx_setField_f(field, hash, @value, handleProperties);
					}
					
				}
				
			}
		}
		
		
		public override object __hx_setField(string field, int hash, object @value, bool handleProperties) {
			unchecked {
				switch (hash) {
					case 1327133892:
					{
						this.storage_ = ((uint[]) (@value) );
						return @value;
					}
					
					
					case 1934413114:
					{
						this.storage_size_ = ((int) (global::haxe.lang.Runtime.toInt(@value)) );
						return @value;
					}
					
					
					case 786269185:
					{
						this.prev_byte2_ = ((uint) (global::haxe.lang.Runtime.toInt(@value)) );
						return @value;
					}
					
					
					case 90195659:
					{
						this.prev_byte_ = ((uint) (global::haxe.lang.Runtime.toInt(@value)) );
						return @value;
					}
					
					
					case 1659886955:
					{
						this.last_byte_bits_ = ((uint) (global::haxe.lang.Runtime.toInt(@value)) );
						return @value;
					}
					
					
					case 1338359406:
					{
						this.last_byte_ = ((uint) (global::haxe.lang.Runtime.toInt(@value)) );
						return @value;
					}
					
					
					case 1854114270:
					{
						this.saved_dist_cache_ = ((int[]) (@value) );
						return @value;
					}
					
					
					case 35939030:
					{
						this.dist_cache_ = ((int[]) (@value) );
						return @value;
					}
					
					
					case 1044314085:
					{
						this.last_processed_pos_ = ((int) (global::haxe.lang.Runtime.toInt(@value)) );
						return @value;
					}
					
					
					case 282430831:
					{
						this.last_flush_pos_ = ((int) (global::haxe.lang.Runtime.toInt(@value)) );
						return @value;
					}
					
					
					case 537950791:
					{
						this.last_insert_len_ = ((int) (global::haxe.lang.Runtime.toInt(@value)) );
						return @value;
					}
					
					
					case 1358280002:
					{
						this.num_literals_ = ((int) (global::haxe.lang.Runtime.toInt(@value)) );
						return @value;
					}
					
					
					case 204352542:
					{
						this.num_commands_ = ((int) (global::haxe.lang.Runtime.toInt(@value)) );
						return @value;
					}
					
					
					case 1285881495:
					{
						this.commands_ = ((global::Array<object>) (global::Array<object>.__hx_cast<object>(((global::Array) (@value) ))) );
						return @value;
					}
					
					
					case 770104548:
					{
						this.cmd_buffer_size_ = ((int) (global::haxe.lang.Runtime.toInt(@value)) );
						return @value;
					}
					
					
					case 194189137:
					{
						this.literal_cost_mask_ = ((int) (global::haxe.lang.Runtime.toInt(@value)) );
						return @value;
					}
					
					
					case 332919650:
					{
						this.literal_cost_ = ((double[]) (@value) );
						return @value;
					}
					
					
					case 439261615:
					{
						this.ringbuffer_ = ((global::encode.RingBuffer) (@value) );
						return @value;
					}
					
					
					case 1752889312:
					{
						this.input_pos_ = ((int) (global::haxe.lang.Runtime.toInt(@value)) );
						return @value;
					}
					
					
					case 953005556:
					{
						this.hash_type_ = ((int) (global::haxe.lang.Runtime.toInt(@value)) );
						return @value;
					}
					
					
					case 502309127:
					{
						this.hashers_ = ((global::encode.hash.Hashers) (@value) );
						return @value;
					}
					
					
					case 812293353:
					{
						this.max_backward_distance_ = ((int) (global::haxe.lang.Runtime.toInt(@value)) );
						return @value;
					}
					
					
					case 1579213401:
					{
						this.params_ = ((global::encode.encode.BrotliParams) (@value) );
						return @value;
					}
					
					
					default:
					{
						return base.__hx_setField(field, hash, @value, handleProperties);
					}
					
				}
				
			}
		}
		
		
		public override object __hx_getField(string field, int hash, bool throwErrors, bool isCheck, bool handleProperties) {
			unchecked {
				switch (hash) {
					case 1095153638:
					{
						return ((global::haxe.lang.Function) (new global::haxe.lang.Closure(this, "WriteMetaBlockInternal", 1095153638)) );
					}
					
					
					case 155924891:
					{
						return ((global::haxe.lang.Function) (new global::haxe.lang.Closure(this, "WriteBrotliData", 155924891)) );
					}
					
					
					case 613638327:
					{
						return ((global::haxe.lang.Function) (new global::haxe.lang.Closure(this, "BrotliSetCustomDictionary", 613638327)) );
					}
					
					
					case 1632261568:
					{
						return ((global::haxe.lang.Function) (new global::haxe.lang.Closure(this, "CopyInputToRingBuffer", 1632261568)) );
					}
					
					
					case 1327133892:
					{
						return this.storage_;
					}
					
					
					case 1934413114:
					{
						return this.storage_size_;
					}
					
					
					case 786269185:
					{
						return this.prev_byte2_;
					}
					
					
					case 90195659:
					{
						return this.prev_byte_;
					}
					
					
					case 1659886955:
					{
						return this.last_byte_bits_;
					}
					
					
					case 1338359406:
					{
						return this.last_byte_;
					}
					
					
					case 1854114270:
					{
						return this.saved_dist_cache_;
					}
					
					
					case 35939030:
					{
						return this.dist_cache_;
					}
					
					
					case 1044314085:
					{
						return this.last_processed_pos_;
					}
					
					
					case 282430831:
					{
						return this.last_flush_pos_;
					}
					
					
					case 537950791:
					{
						return this.last_insert_len_;
					}
					
					
					case 1358280002:
					{
						return this.num_literals_;
					}
					
					
					case 204352542:
					{
						return this.num_commands_;
					}
					
					
					case 1285881495:
					{
						return this.commands_;
					}
					
					
					case 770104548:
					{
						return this.cmd_buffer_size_;
					}
					
					
					case 194189137:
					{
						return this.literal_cost_mask_;
					}
					
					
					case 332919650:
					{
						return this.literal_cost_;
					}
					
					
					case 439261615:
					{
						return this.ringbuffer_;
					}
					
					
					case 1752889312:
					{
						return this.input_pos_;
					}
					
					
					case 953005556:
					{
						return this.hash_type_;
					}
					
					
					case 502309127:
					{
						return this.hashers_;
					}
					
					
					case 812293353:
					{
						return this.max_backward_distance_;
					}
					
					
					case 1579213401:
					{
						return this.params_;
					}
					
					
					case 613400968:
					{
						return ((global::haxe.lang.Function) (new global::haxe.lang.Closure(this, "input_block_size", 613400968)) );
					}
					
					
					case 113006163:
					{
						return ((global::haxe.lang.Function) (new global::haxe.lang.Closure(this, "GetBrotliStorage", 113006163)) );
					}
					
					
					default:
					{
						return base.__hx_getField(field, hash, throwErrors, isCheck, handleProperties);
					}
					
				}
				
			}
		}
		
		
		public override double __hx_getField_f(string field, int hash, bool throwErrors, bool handleProperties) {
			unchecked {
				switch (hash) {
					case 1934413114:
					{
						return ((double) (this.storage_size_) );
					}
					
					
					case 786269185:
					{
						return ((double) (this.prev_byte2_) );
					}
					
					
					case 90195659:
					{
						return ((double) (this.prev_byte_) );
					}
					
					
					case 1659886955:
					{
						return ((double) (this.last_byte_bits_) );
					}
					
					
					case 1338359406:
					{
						return ((double) (this.last_byte_) );
					}
					
					
					case 1044314085:
					{
						return ((double) (this.last_processed_pos_) );
					}
					
					
					case 282430831:
					{
						return ((double) (this.last_flush_pos_) );
					}
					
					
					case 537950791:
					{
						return ((double) (this.last_insert_len_) );
					}
					
					
					case 1358280002:
					{
						return ((double) (this.num_literals_) );
					}
					
					
					case 204352542:
					{
						return ((double) (this.num_commands_) );
					}
					
					
					case 770104548:
					{
						return ((double) (this.cmd_buffer_size_) );
					}
					
					
					case 194189137:
					{
						return ((double) (this.literal_cost_mask_) );
					}
					
					
					case 1752889312:
					{
						return ((double) (this.input_pos_) );
					}
					
					
					case 953005556:
					{
						return ((double) (this.hash_type_) );
					}
					
					
					case 812293353:
					{
						return ((double) (this.max_backward_distance_) );
					}
					
					
					default:
					{
						return base.__hx_getField_f(field, hash, throwErrors, handleProperties);
					}
					
				}
				
			}
		}
		
		
		public override object __hx_invokeField(string field, int hash, global::Array dynargs) {
			unchecked {
				switch (hash) {
					case 1095153638:
					{
						return this.WriteMetaBlockInternal(global::haxe.lang.Runtime.toBool(dynargs[0]), global::haxe.lang.Runtime.toBool(dynargs[1]), ((global::Array<int>) (global::Array<object>.__hx_cast<int>(((global::Array) (dynargs[2]) ))) ), ((global::Array<object>) (global::Array<object>.__hx_cast<object>(((global::Array) (dynargs[3]) ))) ));
					}
					
					
					case 155924891:
					{
						return this.WriteBrotliData(global::haxe.lang.Runtime.toBool(dynargs[0]), global::haxe.lang.Runtime.toBool(dynargs[1]), ((global::Array<int>) (global::Array<object>.__hx_cast<int>(((global::Array) (dynargs[2]) ))) ), ((global::Array<object>) (global::Array<object>.__hx_cast<object>(((global::Array) (dynargs[3]) ))) ));
					}
					
					
					case 613638327:
					{
						this.BrotliSetCustomDictionary(((int) (global::haxe.lang.Runtime.toInt(dynargs[0])) ), ((uint[]) (dynargs[1]) ));
						break;
					}
					
					
					case 1632261568:
					{
						this.CopyInputToRingBuffer(((int) (global::haxe.lang.Runtime.toInt(dynargs[0])) ), ((uint[]) (dynargs[1]) ));
						break;
					}
					
					
					case 613400968:
					{
						return this.input_block_size();
					}
					
					
					case 113006163:
					{
						return this.GetBrotliStorage(((int) (global::haxe.lang.Runtime.toInt(dynargs[0])) ));
					}
					
					
					default:
					{
						return base.__hx_invokeField(field, hash, dynargs);
					}
					
				}
				
				return null;
			}
		}
		
		
		public override void __hx_getFields(global::Array<object> baseArr) {
			baseArr.push("storage_");
			baseArr.push("storage_size_");
			baseArr.push("prev_byte2_");
			baseArr.push("prev_byte_");
			baseArr.push("last_byte_bits_");
			baseArr.push("last_byte_");
			baseArr.push("saved_dist_cache_");
			baseArr.push("dist_cache_");
			baseArr.push("last_processed_pos_");
			baseArr.push("last_flush_pos_");
			baseArr.push("last_insert_len_");
			baseArr.push("num_literals_");
			baseArr.push("num_commands_");
			baseArr.push("commands_");
			baseArr.push("cmd_buffer_size_");
			baseArr.push("literal_cost_mask_");
			baseArr.push("literal_cost_");
			baseArr.push("ringbuffer_");
			baseArr.push("input_pos_");
			baseArr.push("hash_type_");
			baseArr.push("hashers_");
			baseArr.push("max_backward_distance_");
			baseArr.push("params_");
			base.__hx_getFields(baseArr);
		}
		
		
	}
}


