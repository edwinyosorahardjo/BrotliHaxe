// Generated by Haxe 3.4.0

#pragma warning disable 109, 114, 219, 429, 168, 162
namespace decode {
	public class State : global::haxe.lang.HxObject {
		
		public State(global::haxe.lang.EmptyObject empty) {
		}
		
		
		public State() {
			global::decode.State.__hx_ctor_decode_State(this);
		}
		
		
		public static void __hx_ctor_decode_State(global::decode.State __hx_this) {
		}
		
		
		public static void BrotliStateInit(global::decode.state.BrotliState s) {
			unchecked {
				s.state = ((int) (0) );
				((int[]) (s.sub_state) )[0] = ((int) (50) );
				((int[]) (s.sub_state) )[1] = ((int) (50) );
				s.block_type_trees = null;
				s.block_len_trees = null;
				s.ringbuffer = null;
				s.context_map = null;
				s.context_modes = null;
				s.dist_context_map = null;
				s.context_map_slice = null;
				s.context_map_slice_off = 0;
				s.dist_context_map_slice = null;
				s.dist_context_map_slice_off = 0;
				{
					int _g = 0;
					while (( _g < 3 )) {
						int i = _g++;
						((global::decode.huffman.HuffmanTreeGroup[]) (s.hgroup) )[i].codes = null;
						((global::decode.huffman.HuffmanTreeGroup[]) (s.hgroup) )[i].htrees = null;
					}
					
				}
				
				s.code_lengths = null;
				s.context_map_table = null;
				s.custom_dict = null;
				s.custom_dict_size = 0;
			}
		}
		
		
	}
}


